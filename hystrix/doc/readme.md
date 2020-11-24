## 官方文档
https://github.com/Netflix/Hystrix/wiki/How-it-Works

### 超时配置 配置
####1.ribbonTimeout
    ribbonTimeout = (ribbonReadTimeout + ribbonConnectTimeout)
					* (maxAutoRetries + 1) * (maxAutoRetriesNextServer + 1);
    ribbon.ReadTimeout = 1000(默认）
    ribbon.ConnectTimeout = 1000(默认）
    ribbon.MaxAutoRetries = 0(默认）
    ribbon.MaxAutoRetriesNextServer = 1(默认）
    如上面的配置ribbonTimeout=（1000+1000)*(0+1)*(1+1)=4000
    上面是统一配置，如果指定某个服务超时配置如:test-api-server.ribbon.ReadTimeout=2010
    
####1.hystrixTimeout
    如果hystrixTimeout不配置,那么hystrixTimeout = ribbonTimeout
    全局默认配置
    hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds
    指定某个服务配置
    
    hystrixTimeout < ribbonTimeout  hystrix 超时时长应比  ribbon的要大
    上面是统一配置，如果指定某个服务超时配置如:hystrix.command.ds-cart-api.execution.isolation.thread.timeoutInMilliseconds=3010
    
## 隔离策略
    SEMAPHORE
    zuul.ribbonIsolationStrategy=SEMAPHORE(默认值)
    zuul.semaphore.maxSemaphores=100(默认)
    zuul.eureka.test-api-server.semaphore.maxSemaphores(按服务来配置)
    THREAD
    zuul.threadPool.useSeparateThreadPools=false(默认)
    
## HystrixCommandProperties 
    共同配置
    hystrix.command.default.circuitBreaker.enabled=true(默认)
    hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds=5000(默认）
    hystrix.command.default.metrics.rollingPercentile.enabled=true
    hystrix.command.default.metrics.rollingStats.timeInMilliseconds=10000
    hystrix.threadpool.default.coreSize=10(默认)
    hystrix.threadpool.default.maximumPoolSize=10(默认)
    hystrix.threadpool.default.keepAliveTime=1(分钟)
    hystrix.threadpool.default.maxQueueSize=-1(默认使用SynchronousQueue，只存一个值)
   
    数阀值配置
    hystrix.command.default.circuitBreaker.requestVolumeThreshold=20(默认)10s窗口错误量
    百分比值配置
    hystrix.command.default.circuitBreaker.errorThresholdPercentage=50(默认)10s窗口错误量
    
        
## 配置建议值
###网关的配置 
    通常配置
        hystrixTimeout<10s
        ribbonTimeout<8s
        如果hystrxy不配置hystrixTimeout=ribbonTimeout
    特殊配置
       如些特别耗时的操作如上传文件，导入导出大量数据，可选按接口或服务来配置
###服务之间的配置
    ribbonTimeout<3s
   
