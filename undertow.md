
#WorkerThread
##ioThread
##workerThread

# QueuedNioTcpServer 
    socket 接入处理
    收到接入事件调用
    判断接入是否超限
    初始化socket接入配置
    给当前socket绑定ioWorkerThread
    把当前socket 放入ioWorkerThread 对应的通道队列里
    通过ioThread 执行接入任务，实质是丢到idThread接入任务队列里
    计算打开连接数
    设置接入是否超限

## HttpOpenListener
    处理读写、空闲超时
    IdleTimeoutConduit
    ReadTimeoutStreamSourceConduit
    WriteTimeoutStreamSinkConduit
## HttpServerConnection
    对上面配置处理
    requestIdleTimeout

#Selector


