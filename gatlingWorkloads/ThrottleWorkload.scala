package com.olx.performancetesting.workloads

import com.olx.performancetesting.Config
import io.gatling.core.Predef._
import io.gatling.core.controller.throttle.ThrottleStep

object ThrottleWorkload  {

  val config = Config.instance.workloads.throttle

  def getThrottleSettings(scenarioName: String):  List[ThrottleStep] ={
    val rps = config.rpsDistribution.get(scenarioName).get
    val rpsThrottle: ThrottleStep= reachRps(rps).in(config.rampUpTime)
    val holdDuration: ThrottleStep = holdFor(config.duration)
    List(rpsThrottle, holdDuration)
  }

}
