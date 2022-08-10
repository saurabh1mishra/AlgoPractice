# Performance Tool


This repo contains the performance/load test for the components.


## Getting Started

Clone it...

### Prerequisites
- Java 11

### Building
```
$ ./sbt clean compile universal:stage
```

### Running

To run the project locally, you need to execute the below command. There is a configuration file *application.conf* where there
are some configuration, e.g., environment, region, simulation or site code.

```
$ SIMULATION=PagesSimulation ./target/universal/stage/bin/performance-tool
```

## GitLab CI/CD Pipelines

We have a job that it runs only when you throw it from the GitLab Web UI. This Job deploys a Job in Openshift who be in charge of
running the load tests. So, at the moment of creating the pipeline, you must specify some required variables and another optional
variables.

Required:
* **SIMULATION** :
  * **Fury**: *fury-bundles*
  * **Tanak**: *tanak-navigation-tree-default*, *tanak-popular-categories-tree*, *tanak-site-configuration-search*, *tanak-site-configuration-landing*
  * **Bran Stark** : *bran-stark-record-search*, *bran-stark-history-for-user*, *bran-stark-history-for-session*

Optional:
* **ENV** : *stg* or *prd*. (Defaults to stg)
* **REGION** : *eu-west-1* or *ap-southeast-1*. (Defaults to ap-southeast-1)
* **SITE_CODE** : a valid site code. (Defaults to olxin)
* **SITE_HOST** : the corresponding site host to the given site code. (Defaults to api.olx.in)
* **PARALLELISM** : a number to specify how many pod replicas running in parallel. (Defaults to 1)
* **CURRENT_WORKLOAD** : *spike* or *stress*. (Defaults to stress)
* **BREAK_TEST**: stop, this parameter allows you to remove job and pods
* **IMAGE_TAG**: this parameter is for development
* **OPENSHIFT_HOSTNAME_STRATEGY**: *route* or *service*, by default uses the _route_ in local environment and _service_ in cloud

## Simulations

### Workloads

The workload is how the load for every simulation is going to behave
([more](https://gatling.io/2018/10/04/gatling-3-closed-workload-model-support/)).

An open system is a system that has no control over the number of concurrent users.
Users keep on arriving whatever the number of concurrent users inside the system.
At some point, if the system starts slowing down, users that are already in the system will take more time to complete their
journey while new users will keep on arriving.
Users will them pile up, maybe exponentially, causing your system to eventually crash.

Most public facing websites behave this way.

On the contrary, closed system implements some feedback and queueing system so when the system is at full capacity, arriving users
are pushed into a queue and can only enter the system when another user exits. large ticketing platforms behave this way.

In short:

* **open workload model:** you define the arrival rate of new virtual users; the number of concurrent users inside the system is a
consequence of the response times and the journey duration and you have no control over it.
* **closed workload model:** you define the number of concurrent users effectively inside the system; arrival rate is a
consequence and you have no control over it.

Currently there are 3 defined workloads:

* **Default**
* **Stress**
* **Spike**

#### Default

This a default workload only for test purpose. It's a fixed 10 concurrent users.

#### Stress

> Stress testing is testing that checks the upper limits of your system by testing it under extreme loads. The testing examines
how the system behaves under intense loads, and how it recovers when going back to normal usage.

```
    +
    |
    |
    |                                /¯¯¯¯¯¯¯
    |                               /
    |                              /
    |                      /¯¯¯¯¯¯¯
    |                     /
    |                    /
    |            /¯¯¯¯¯¯¯
    |           /
    |          /
    |  /<¯¯¯¯¯¯>¯
    | /
    |/   iteration interval
+----<-><------>---------------------------------------------+
    |increment
      duration
    +

```

Params:

* **STRESS_USERS_INCREMENT**
* **STRESS_INCREMENT_DURATION**
* **STRESS_ITERATION_INTERVAL**
* **STRESS_ITERATIONS**

#### Spike

> Spike testing is a type of stress test.  The object of this type of performance test is to verify a system's stability during
bursts of the concurrent user and or system activity to varying degrees of load over varying time periods.

```
   +
    |
    |
    |                  /                /
    |                 / |              / |
    |                /  |             /  |
    |               /   |            /   |
    |              /    |           /    |
    |             /     |          /     |
    |            /      |         /      |
    |           /       |        /       |
    |          /        |       /        |
    |  /¯¯¯¯¯¯¯          ¯¯¯¯¯¯¯         ¯¯¯¯¯¯¯
    | /
    |/
+--------------------------------------------------------
    |
   +

```

Params:

* **SPIKE_BASE_CONCURRENT_USERS**
* **SPIKE_DURATION**
* **SPIKE_INTERVAL**
* **SPIKE_MULTIPLIER**
* **SPIKE_ITERATIONS**

### Feeders

Feeders are a way to inject data from a data generator or an external source into the virtual users’ sessions.

Every time a virtual user reaches a step, it will pop a record out of the Feeder, which will be injected into the user’s Session.

### Scenarios

A scenario represents a typical user behavior. It’s a workflow that virtual users will follow.

## Built With
- [Gatling](https://gatling.io/docs/current/) - It's a highly capable load testing tool
