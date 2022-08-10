package com.olx.performancetesting.workloads

import com.olx.performancetesting.Config
import io.gatling.core.Predef._

object SpikeTestWorkload extends CloseWorkload {

  val config = Config.instance.workloads.spike

  val settings = (0 to config.iterations).flatMap(_ =>
    Seq(
      constantConcurrentUsers(config.baseConcurrentUsers) during (config.interval),
      rampConcurrentUsers(config.baseConcurrentUsers) to (config.baseConcurrentUsers * config.multiplier) during (config.duration)
    )
  )
}
