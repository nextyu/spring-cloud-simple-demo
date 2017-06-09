
### 刷新配置
- 刷新单个服务 post 请求 http:/localhost:9999/refresh 
- 刷新多个服务 post 请求 http:/localhost:9999/bus/refresh 
- 刷新指定服务 post 请求 http:/localhost:9999/bus/refresh?destination=order-service:9999
                （刷新order-service服务中端口为9000的实例）
- 刷新指定服务 post 请求 http:/localhost:9999/bus/refresh?destination=order-service:**
                （刷新order-service服务中全部的实例）


### 参考资料
- [spring cloud 超时设置](https://www.javacodegeeks.com/2016/06/spring-cloud-zuul-support-configuring-timeouts.html)
- [理解 HTTP 幂等性](http://www.cnblogs.com/weidagang2046/archive/2011/06/04/idempotence.html)