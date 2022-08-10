package com.olx.performancetesting.workloads


import com.olx.performancetesting.Config
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}

import scala.collection.mutable.ListBuffer

object WorkloadHelper {


  def setUpWorkload(scns: ScenarioBuilder*): List[PopulationBuilder] = {
    val populationBuilders: ListBuffer[PopulationBuilder] = new ListBuffer[PopulationBuilder]()
    for (scn <- scns) {
      var populationBuilder = Config.instance.workloads.current.map(_.toLowerCase) match {
        case Some("spike") => scn.inject(SpikeTestWorkload.settings)
        case Some("stress") => scn.inject(StressTestWorkload.getScenarioSettings(scn.name))
        case Some("stresswiththrottle") => scn.inject(StressTestWorkload.getScenarioSettings(scn.name)).throttle(ThrottleWorkload.getThrottleSettings(scn.name)
        )
        case _ => scn.inject(TenUsersWorkload.settings)
      }
      populationBuilders += populationBuilder
    }
    return populationBuilders.toList
  }

}
