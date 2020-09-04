#!/usr/bin/env bash
#将最新的镜像删除
sudo docker rmi registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:latest

sudo docker build -t registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:latest .
sudo docker push registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:latest
image_tag=`date +%Y%m%d` #_%H%M
echo "当前时间：$image_tag"
sudo docker tag registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:latest registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:v${image_tag}
sudo docker push registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:v${image_tag}
sudo docker rmi registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_provider_user:v${image_tag}
#删除带none的镜像
docker rmi $(docker images | grep "none" | awk '{print $3}')