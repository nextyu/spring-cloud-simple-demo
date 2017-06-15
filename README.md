### 命令
```
docker-compose rm -vf
```

### 端口
- api-gateway 80
- registry-server 8761
- config-server 8888
- monitoring-server 6666
- user-service 7777
- order-service 9999
- user-consumer-ribbon 9991
- user-consumer-feign 9992


### 刷新配置
- 刷新单个服务 post 请求 http:/localhost:8888/refresh 
- 刷新多个服务 post 请求 http:/localhost:8888/bus/refresh 
- 刷新指定服务 post 请求 http:/localhost:8888/bus/refresh?destination=order-service:9999
                （刷新order-service服务中端口为9000的实例）
- 刷新指定服务 post 请求 http:/localhost:8888/bus/refresh?destination=order-service:**
                （刷新order-service服务中全部的实例）


### 参考资料
- [spring cloud 超时设置](https://www.javacodegeeks.com/2016/06/spring-cloud-zuul-support-configuring-timeouts.html)
- [理解 HTTP 幂等性](http://www.cnblogs.com/weidagang2046/archive/2011/06/04/idempotence.html)
- [消息总线](http://blog.didispace.com/springcloud7/)

- [MySQL container failing to run initialisation scripts in Docker Compose](https://stackoverflow.com/questions/36347845/mysql-container-failing-to-run-initialisation-scripts-in-docker-compose)