# QuickStart
	base-service，提供基础服务，包括路由，链路跟踪，配置中心等等
	msg-service 8084，消息处理，采用kafaka异步消费


	sleuth server:9001
	admin server :9002
	eureka server:9003
	cofig server :9004
	
	account-service:8080
	product-service:8081
	payment-service:8082
	order-service  :8083
	msg-service    :8084
	front-app      :8088

#banner 地址
  http://patorjk.com/software/taag/#p=display&f=Graffiti&t=kaisagroup%20plateform
  
#docker 命令
  mvn clean
  mvn package docker:build
  
  mvn clean package docker:build -e
  
  docker build -t kaisagroup_eureka:base -f /root/kaisagroup_plateform/base-service/eureka-server/src/main/docker/Dockerfile /root/kaisagroup_plateform/base-service/eureka-server

sudo docker images |grep kaisagroup
#git pull 分支名
 
 git reset --hard
 git pull origin master:master
 
#docker-compose 安装
1、安装python-pip
 
 yum -y install epel-release
 yum -y install python-pip
 
 2、安装docker-compose
 
 pip install docker-compose
 待安装完成后，执行查询版本的命令，即可安装docker-compose
 docker-compose version