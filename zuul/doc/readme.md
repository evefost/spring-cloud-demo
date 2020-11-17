## zuul 网关
    官方文档
    https://docs.spring.io/spring-cloud-netflix/docs/2.2.5.RELEASE/reference/html/#router-and-filter-zuul
### 注解EnableZuulServer 与EnableZuulProxy区别
    EnableZuulServer 使用的配置类为ZuulServerAutoConfiguration 仅支持静态代理配置，相当于ngix
    EnableZuulProxy 使用的配置类为ZuulProxyAutoConfiguration,继成ZuulServerAutoConfiguration
    不仅有EnableZuulServer的所有功能，还支持动态代理、ribbon、hystrix

### zuul 配置
    zuul 转发默认使用httpclient，也可选配置okhttp;下面两参数只有选httpclient才有效
    zuul.host.maxTotalConnections=200(httpclient连接池最大支持200连接)
    zuul.host.maxPerRouteConnections=20(每个域名或ip地址最大连接)   
    zuul.ribbonIsolationStrategy=SEMAPHORE
### zuul hystrix配置
