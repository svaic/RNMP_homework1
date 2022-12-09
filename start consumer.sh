#!/bin/sh
docker run -it --rm --network kafka_docker_example_net confluentinc/cp-kafka /bin/kafka-console-consumer --bootstrap-server kafka:9093 --include "result1|result2"