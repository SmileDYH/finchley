### 基于Spring Cloud(2020.0.2版本 和 Finchley版本)搭建微服务项目
**为构建微服务下的链路追踪（Sleuth+Zipkin）**

pom文件：
Finchley版本切2020.0.2版本，只需要替换父pom的一些配置，
只不过2020.0.x版本有些组件就不能用了(子模块标有Finchley版 专用)，详见[结束的Netflix 项目以及替代方案]
**父模块的好处之一也在这里，想更换框架版本，直接改父pom文件就行；当然如果框架组件都被改变那就只能重构了。**

用到的组件：
1、服务注册和发现
Eureka(eureka-server,eureka-client)

2、服务与服务的通讯是基于http restful的。
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。
① Ribbon(ribbon+rest)
ribbon是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。Feign默认集成了ribbon。
② Feign
Feign是一个声明式的伪Http客户端。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
1)Feign 采用的是基于接口的注解
2)Feign 整合了ribbon，具有负载均衡的能力
3)整合了Hystrix，具有熔断的能力

3、微服务下的链路追踪（Sleuth+Zipkin）
个人理解：前者管追踪，记录下一次请求整体的调用过程；后者管记录（且提供可视化），通过日志等方式记录下整个过程。
① Sleuth
Sleuth是Spring Cloud的组件，为Spring Cloud实现了一种分布式追踪解决方案；
兼容Zipkin，HTrace和 ELK（Elasticsearch 、Logstash、 Kibana）基于日志的追踪系统。
② Zipkin
Zipkin是一个分布式系统的APM工具（Application Performance Management），基于Google Dapper 实现。
它帮助收集解决微服务架构中延迟问题所需的时间数据，并管理这些数据。和Sleuth结合可以提供可视化Web界面分析调用链路耗时情况。
**启动（jar包启动）：**
启动Zipkin命令：
java -jar zipkin-server-2.12.2-exec.jar
**访问地址：**
http://localhost:9411/zipkin/

模块：
父级模块 finchley(就一个pom文件[父级pom,主要springboot、springcloud、jdk8依赖等]，其他模块都依赖这个pom)
服务注册模块 eureka-server
服务提供者模块 eureka-client(可更改端口号多次启动，形成多服务，来测试负载均衡)
负载均衡客户端模块 service-ribbon
服务消费者模块 service-feign


结束的Netflix 项目以及替代方案：
随着Netflix项目进入维护模式，Spring Cloud对一直以来严重依赖的Netflix OSS 套件进行了大换血,包括Hystrix,Ribbon,Zuul,Archaius等。
**自2020.0.0版本开始，Netflix仅保留了Netflix-Eureka(Server/Client)组件（Feign依旧是可以使用的，OpenFiegn）**


参考：https://forezp.blog.csdn.net/article/details/70148833
     https://blog.csdn.net/weixin_44058082/article/details/112984830(结束的Netflix 项目以及替代方案)
     https://blog.csdn.net/pengjunlee/article/details/87797969

