### 用户服务

- http://localhost:7777/
- http://localhost:7777/swagger-ui.html

```
docker run -p 7777:7777 order-service

java -jar user-service.jar --server.port=9998
```

如下配置，启用了config-repo的cloud-config-dev.yml配置文件
```
spring:
  application:
    name: user-service
  cloud:
    config:
      fail-fast: true
      discovery:
        enabled: true
        service-id: config
      name: cloud-config
      profile: dev
```