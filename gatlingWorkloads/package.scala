package com.olx.performancetesting

import io.gatling.core.Predef._
import io.gatling.core.controller.inject.closed._
import io.gatling.core.controller.inject.open._
import io.gatling.core.controller.throttle._

package object workloads {

  type Open = OpenInjectionStep
  type Closed = ClosedInjectionStep
  type Throttle = ThrottleStep

  sealed trait Workload[T] {

    /* This is a safe casting of IncreasingConcurrentUsersProfile */
    implicit def concurrentIncreasingTestToClosedInjectionProfile(increasingConcurrentUsers: IncreasingConcurrentUsersProfile): Iterable[ClosedInjectionStep] =
      increasingConcurrentUsers.profile.asInstanceOf[ClosedInjectionProfile].steps

    /* This is a safe casting of IncreasingUsersPerSecProfile */
    implicit def incrementTestToOpenInjectionProfile(increasingUsersPerSec: IncreasingUsersPerSecProfile): Iterable[OpenInjectionStep] =
      increasingUsersPerSec.profile.asInstanceOf[OpenInjectionProfile].steps

    implicit def oneClosedStepToList(step: ClosedInjectionStep): Iterable[ClosedInjectionStep] = Seq(step)

    implicit def oneOpenStepToList(step: OpenInjectionStep): Iterable[OpenInjectionStep] = Seq(step)

    implicit def throttle(step: ThrottleStep*): Iterable[ThrottleStep] = step

//    implicit def throttleProfile(throttle: ThrottleStep): Iterable[ThrottleStep] =
//      increasingUsersPerSec.profile.asInstanceOf[OpenInjectionProfile].steps

    val settings: Iterable[T]
  }

  trait OpenWorkload extends Workload[Open]

  trait CloseWorkload extends Workload[Closed]

}
