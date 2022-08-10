package com.olx.performancetesting.workloads

import com.olx.performancetesting.Config
import com.olx.performancetesting.workloads.StressTestWorkload.config
import io.gatling.core.Predef
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

//object ThrottleWorkload extends CloseWorkload {
//
//  val config = Config.instance.workloads.throttleRPS
//
////  val settings = incrementConcurrentUsers(config.concurrentUsersIncrement)
////    .times(config.iterations)
////    .eachLevelLasting(config.iterationInterval)
////    .separatedByRampsLasting(config.incrementDuration)
////    .startingFrom(config.concurrentUsersIncrement)
//
//
//  val settings = constantConcurrentUsers(40) during (config.duration)
//
//  def getScenarioSettings(scenarioName: String): Predef.IncreasingConcurrentUsersProfile ={
//    val totalConcurrentIncrementUsers = config.concurrentUsersIncrement
//    val scenarioLoadPercentage = config.requestLoadDistribution.get(scenarioName).get
//    val scenarioSpecificConcurrentIncrementUsers = (totalConcurrentIncrementUsers * scenarioLoadPercentage /100)
//    return incrementConcurrentUsers(scenarioSpecificConcurrentIncrementUsers)
//      .times(config.iterations)
//      .eachLevelLasting(config.iterationInterval)
//      .separatedByRampsLasting(config.incrementDuration)
//      .startingFrom(scenarioSpecificConcurrentIncrementUsers).
//  }
//}
