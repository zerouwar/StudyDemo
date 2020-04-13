#!/usr/bin/env bash

ROOT_PATH=/usr/local/Cellar/kafka/2.1.1/libexec/

# start zk
eval "${ROOT_PATH}bin/zookeeper-server-start.sh ${ROOT_PATH}config/zookeeper.properties &"

eval "${ROOT_PATH}bin/kafka-server-start.sh ${ROOT_PATH}config/server-1.properties &"
eval "${ROOT_PATH}bin/kafka-server-start.sh ${ROOT_PATH}config/server-2.properties &"
eval "${ROOT_PATH}bin/kafka-server-start.sh ${ROOT_PATH}config/server-3.properties &"
