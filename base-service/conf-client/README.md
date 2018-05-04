#ReadMe
	1、config-client项目的pom中加入spring-boot-starter-actuator，依赖其监控机制，来刷新config-server中配置的变化，config-client客户端中增加@RefreshScope，来手动修正配置荐的变化。但不能有效的将config-server中变化的信息实时的更新到客户端，是个弊端。
	
	2、引入bus来修复上一阶段产生的不能实时更新消息的bug
	
	
	http://www.cnblogs.com/unqiang/p/5166770.html kafaka setup documents
	
	http://localhost:8888/{application}/{profile}/{label}
	http://localhost:8888/dmeo/development/trunk 
	 * 配置服务的路劲规则：
     * /{application}/{profile}[/{label}]
     * /{application}-{profile}.yml
     * /{label}/{application}-{profile}.yml
     * /{application}-{profile}.properties
     * /{label}/{application}-{profile}.properties
#刷新配置信息
    http://localhost:9004/refresh
    http://localhost:9004/restart
#访问配置信息
	打开网址访问：http://localhost:7020/hi，网页显示：

   
/****************************************************************************************
 * 配置服务的路劲规则：
 *
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 ****************************************************************************************/






/****************************************************************************************
 application.yml 涉及到的链接文件内容展示如下：

 修改内容前：
 http://git.oschina.net/ylimhhmily/OpenSource_CustomCircleLineProgressBar/blob/master/foobar-refresh.yml
 profile: profile-refresh

 修改内容后：
 http://git.oschina.net/ylimhhmily/OpenSource_CustomCircleLineProgressBar/blob/master/foobar-refresh.yml
 profile: profile-refresh-refresh
 ****************************************************************************************/






/****************************************************************************************
 一、配置刷新服务客户端Client应用入口（单点手动动态刷新配置服务客户端配置）：

 1、添加注解 RefreshScope，然后添加引用模块 spring-boot-starter-actuator 监控和管理生产环境的模块；
 2、编辑 application.yml 文件，添加相关客户端配置；
     spring:
     cloud:
     config:
     uri: http://localhost:8220
     profile: refresh
     label: master #当 ConfigServer 的后端存储的是 Git 的时候，默认就是 master

     application:
     name: foobar  #取 foobar-refresh.yml 这个文件的 application 名字，即为 foobar 名称
 3、启动 springms-config-server 模块服务，启动1个端口；
 4、启动 springms-config-client-refresh 模块服务，启动1个端口；
 5、在浏览器输入地址 http://localhost:8295/profile 正常情况下会输出远端服务的配置内容（内容为：profile: profile-refresh）；

 6、修改 http://git.oschina.net/ylimhhmily/OpenSource_CustomCircleLineProgressBar/blob/master/foobar-refresh.yml 内容，修改后为 profile: profile-refresh-refresh；
 7、打开windows命令窗口，执行命令： >curl.exe -X POST http://localhost:8295/refresh
 8、然后刷新 http://localhost:8295/profile 网页，正常情况下会输出远端服务的配置内容（内容为：profile: profile-refresh-refresh）；

 总结：这里通过执行刷新命令才得以将远端配置内容刷新到配置服务客户端。
 ****************************************************************************************/







    