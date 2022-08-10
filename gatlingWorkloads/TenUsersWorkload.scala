package com.olx.performancetesting.workloads

import java.util.concurrent.TimeUnit

import io.gatling.core.Predef._

import scala.concurrent.duration.{FiniteDuration, SECONDS}

object TenUsersWorkload extends OpenWorkload {

  val settings = atOnceUsers(10)

  val settings2 = constantUsersPerSec(15) during( new FiniteDuration(10, TimeUnit.MINUTES) )

}
