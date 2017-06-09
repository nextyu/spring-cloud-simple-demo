### 配置中心

多环境不同配置文件的控制

- application.yml 默认配置文件,默认启用的是开发环境配置文件
    ```
       spring:
         profiles:
           active: dev 
    ```
- application-dev.yml 开发环境配置文件
- application-test.yml 测试环境配置文件
- application-prod.yml 生产环境配置文件


只需要在执行命令中加入参数即可

如下就是启用了开发环境的配置文件

```
java -jar xxx.jar --spring.profiles.active=prod
```

http://localhost:8888/