#!/usr/bin/env bash
docker-compose pull
docker-compose down
docker-compose up -d

#删除不用的镜像
docker rmi $(docker images | grep "none" | awk '{print $3}')