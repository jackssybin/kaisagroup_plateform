# QuickStart

 #项目说明	
	base-service，提供基础服务，包括路由，链路跟踪，配置中心等等
	  admin-server :9002 监控服务
	  conf-client:9020 配置服务的客户端
	  conf-repo: 需要提供的配置文件
	  eureka-server:9003 注册发现服务
	  eureka-server-peer2:9013 注册发现服务做负载均衡用
	  oauth2-server:9006授权服务
	  sleuth-server:9001 日志链路追踪服务端
	  turbine-server:9007 断路器ribbon相关信息
	  zuul-server:9011 路由网关
	business-service 提供需要扩展的业务功能
	   kaisagroup_boot:8090 基础服务，与业务无关，提供的示例工程服务
	   mail-service:8026 邮件服务
	   msg-service:8081  消息服务，示例服务
	   user-service:8024 用户服务
	common-module: 基础服务，公共服务。项目所需的公共依赖信息
	mybatis-util:  mybatis生成代码依赖的基础服务
	sql：存放微服务中用到的基础数据库信息
	test-service:一些示例demo程序
	    msg-rabbitmq:rabbitmq演示程序
	    zipkin-testa:链路跟踪演示服务a  a调用-->b
	    zipKin-testb:链路跟踪演示服务b  
    docker-compose.yml: docker编排文件

#地址信息
  #docker容器管理
  http://47.92.105.79:9000/#/containers
  #断路监控管理
  http://localhost:9006/turbine.stream
  http://localhost:8024/hystrix
  #api向导
  http://localhost:8024/swagger-ui.html#/
  http://47.92.105.79:8024/swagger-ui.html#/

#banner 地址
  http://patorjk.com/software/taag/#p=display&f=Graffiti&t=kaisagroup%20plateform

#开发步骤:

#开发规则
 #创建rabbitmq Queue 
     规则：ks凯萨，mail-service服务名，sendMailQueue队列名字
 ks.mail-service.sendMailQueue
 #创建redis 
     规则: ks凯撒，mail-service服务名， 具体redis的键值
 ks.mail-service.
 
#oauth2授权过程
http://localhost:8000/oauth/authorize?client_id=webApp&redirect_uri=http://www.baidu.com&state=abc&scope=app&response_type=code


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
 
#待解决问题：
 #定时任务拆分
 ！！！
 #日志输出保存位置
 !!!!
