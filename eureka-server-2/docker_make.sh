#!/usr/bin/env bash
sudo docker build -t registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_eureka_2:latest .
sudo docker push registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_eureka_2:latest
image_tag=`date +%Y%m%d` #_%H%M
echo "当前时间：$image_tag"
sudo docker tag registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_eureka_2:latest registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_eureka_2:v${image_tag}
sudo docker push registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_eureka_2:v${image_tag}
sudo docker rmi registry.cn-shanghai.aliyuncs.com/list_of_eureka/service_eureka_2:v${image_tag}