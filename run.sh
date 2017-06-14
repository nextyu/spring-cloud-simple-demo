#!/usr/bin/env bash

set -e

# Build the project and docker images
#mvn clean install

# Export the active docker machine IP
export DOCKER_IP=$(docker-machine ip $(docker-machine active))

# docker-machine doesn't exist in Linux, assign default ip if it's not set
DOCKER_IP=${DOCKER_IP:-0.0.0.0}

# Remove existing containers
docker-compose stop
docker-compose rm -f

# Start the registry server first and wait for it to become available
docker-compose up -d registry-server

while [ -z ${REGISTRY_SERVER_READY} ]; do
  echo "Waiting for registry-server..."
  if [ "$(curl --silent $DOCKER_IP:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      REGISTRY_SERVER_READY=true;
  fi
  sleep 2
done

# Start the config server first and wait for it to become available
docker-compose up -d config-server

while [ -z ${CONFIG_SERVER_READY} ]; do
  echo "Waiting for registry-server..."
  if [ "$(curl --silent $DOCKER_IP:8888/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      CONFIG_SERVER_READY=true;
  fi
  sleep 2
done


# Start the other containers
docker-compose up -d

# Attach to the log output of the cluster
docker-compose logs