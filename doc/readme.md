
## eureka api 文档
    https://github.com/Netflix/eureka/wiki/Eureka-REST-operations
    https://docs.spring.io/spring-cloud-netflix/docs/2.2.5.RELEASE/reference/html/#service-discovery-eureka-clients
    https://docs.spring.io/

##eureka 服务端
    1.服务端依赖配置
    2.启动过程
       2.1 初始化当前服务实例信息
       2.2 初始化jersey(相当于spring-mvc)
       2.3 初台化eureka集群节点注册器
       2.4 启动节点同步定时任务
       2.5 启动剔除无效服务实例任务
        
    3.注册信息同步到其它节点
        假如eureka server有三个节点，A,B,C;
        服务X向A注册，当A收到X注册信息后，将把X注册信息同步给B,C
        
##eureka 客户端
    1.客户端依赖配置
    2.启动过程
        2.1 初始化当前服务实例信息
        2.2 创建服务发现客户端
        2.3 向某个eureka注册当前服务信息
        2.4 启动心跳定时任务
        2.5 启动服务列表刷新定时任务
        
## ribbon 