# Apache Ignite Market Orders Streaming Demo

The demo starts a simple application that simulates trading activities of a stock exchange. The application receives
executed
market deals in real-time from the
[PubNub Market Order Data Stream](https://www.pubnub.com/developers/realtime-data-streams/financial-securities-market-orders/)
and forwards the deals to a locally running Ignite cluster.

The demo is created for the Control
Center [written tutorial](https://www.gridgain.com/docs/tutorials/management-monitoring/overview)
and [instructor-led foundation course](https://www.gridgain.com/products/services/training/how-monitor-and-manage-apache-ignite-gridgain-control-center).

### Running with different Editions

The project has been setup using Maven profiles

1. GridGain Community Edition (default)
    - Select community-edition profile
2. GridGain Ultimate Edition
    - Select community-edition & ultimate-edition profiles
      ```shell
      mvn -D ultimate clean package
      ```
3. Apache Ignite
    - Select apache-ignite profile
      ```shell
      mvn -D ignite clean package
      ```

### GridGain Cluster

* Start
    ```shell
    docker-compose -f docker/ignite-cluster.yaml up -d --scale ignite-server-node=2
    ```
* Stop
    ```shell
    docker-compose -f docker/ignite-cluster.yaml down
    ```

### Streaming App

* Build
    ```shell
    mvn clean package
    ```
* Dockerize
    ```shell
    docker build -f docker/StreamingAppDockerfile -t ignite-streaming-app .
    ```
* Run
    ```shell
    docker-compose -f docker/ignite-streaming-app.yaml up -d
    ```
* Stop
    ```shell
    docker-compose -f docker/ignite-streaming-app.yaml down
    ```
