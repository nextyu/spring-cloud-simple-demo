### 用户服务

http://localhost:7777/

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