# QuickStart
	base-service，提供基础服务，包括路由，链路跟踪，配置中心等等
	
	sleuth server:9001
	admin server :9002
	eureka server:9003
	cofig server :9004
	zuul server :9005
	turbine server:9006
	
	account-service:8021
	msg-service    :8022
	front-app      :8023

#banner 地址
  http://patorjk.com/software/taag/#p=display&f=Graffiti&t=kaisagroup%20plateform

  
#地址信息
  容器管理：
  http://47.92.105.79:9000/#/containers
  
  断路监控管理
  http://localhost:9006/turbine.stream
  http://localhost:8024/hystrix
  
  
#api向导
	http://localhost:8024/swagger-ui.html#/
	http://47.92.105.79:8024/swagger-ui.html#/
#docker 命令
  mvn clean
  mvn package docker:build
  
  mvn clean package docker:build -e
  
  docker build -t kaisagroup_eureka:base -f /root/kaisagroup_plateform/base-service/eureka-server/src/main/docker/Dockerfile /root/kaisagroup_plateform/base-service/eureka-server

sudo docker images |grep kaisagroup

    #启动网关
sudo docker run -p 9011:9011 --name kaisgroup_zuul -d kaisagroup_zuul:latest
#git pull 分支名
 
 git reset --hard
 git pull origin master:master
  git pull origin dev
  git reset --hard &  git pull origin master:master
#docker-compose 安装
1、安装python-pip
 
 yum -y install epel-release
 yum -y install python-pip
 
 2、安装docker-compose
 
 pip install docker-compose
 待安装完成后，执行查询版本的命令，即可安装docker-compose
 docker-compose version
 
 
 
 
 #负载均衡
 当于Spring Cloud应用引入Ribbon和Eureka的时候，会触发Eureka中实现的Ribbon的自动化配置。
 
  serverList 的维护机制是由 DiscoveryEnabledNIWSServerList的实例维护，该类会将服务清单列表交给Eureka的服务治理机制来维护。
 
 IPing的实现由 NIWSDiscoveryPing 的实例维护，该类也将服务检查交给Eureka的服务治理机制来维护。
 
 默认情况下，用于获取实例请求的ServiceList接口实现是采用Spring Cloud Eureka中封装的DomainExtractingServerList.由于Spring Cloud Ribbon默认实现了区域亲和策略，所以我们可以通过Eureka实例的元数据配置来实现区域化的实例配置方案。
 
 比如 eureka.instance.metadataMap.zone=hangzhou. 通过zone参数来指定自己所在的区域。
 
 在Spring Cloud Ribbon 与 Spring Cloud Eureka结合工程中，我们可以通过参数配置方式来禁用Eureka对Ribbon服务实例的维护实现。
 
 ribbon.eureka.enabled=fa
 
 
 
 
 
 
 #定时任务拆分
 ！！！
 #日志输出保存位置
 !!!!
 #
 
 