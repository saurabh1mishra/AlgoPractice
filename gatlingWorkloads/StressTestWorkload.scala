package com.olx.performancetesting.workloads

import com.olx.performancetesting.Config
import io.gatling.core.Predef
import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder

object StressTestWorkload extends CloseWorkload {

  val config = Config.instance.workloads.stress

  val settings = incrementConcurrentUsers(config.concurrentUsersIncrement)
    .times(config.iterations)
    .eachLevelLasting(config.iterationInterval)
    .separatedByRampsLasting(config.incrementDuration)
    .startingFrom(config.concurrentUsersIncrement)

  def getScenarioSettings(scenarioName: String): Predef.IncreasingConcurrentUsersProfile ={
    print("StressTestWorkload")
    val totalConcurrentIncrementUsers = config.concurrentUsersIncrement
    val scenarioLoadPercentage = config.requestLoadDistribution.get(scenarioName).getOrElse(totalConcurrentIncrementUsers)
    val scenarioSpecificConcurrentIncrementUsers = (totalConcurrentIncrementUsers * scenarioLoadPercentage /100)
    return incrementConcurrentUsers(scenarioSpecificConcurrentIncrementUsers)
      .times(config.iterations)
      .eachLevelLasting(config.iterationInterval)
      .separatedByRampsLasting(config.incrementDuration)
      .startingFrom(scenarioSpecificConcurrentIncrementUsers)
  }


}
