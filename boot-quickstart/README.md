# boot-quickstart模块介绍
boot-quickstart实际开发中积累的一些使用方法,方便我们快速上手开发,下面对各个点进行介绍,所有点都是通过测试运行,没有错误!

# 涉及的功能点
1. properties文件kv注入到程序中使用,如ApplicationConfig,MainController里的Value注解.
2. AOP的使用,如ServiceAOP.
3. mybatis配置(这里与很多网上博客介绍不同,个人认为他们还是没有抛弃繁琐的配置,不够简洁).
4. MVC从dao到Controller的基本流程demo.
5. 数据源配置,druid配置(现在出了一个druid-starter,建议用!).
6. jsp配置
7. 内嵌tomcat的access.log日志配置
8. 本地开发热部署devtools的使用配置.
9. 统一日志框架logback配置和使用!
10. 单元测试,示例,包括,dao,service,controller层的单元测试案例.


# 生命周期管理
## 本地使用
- idea里面直接main启动。
- maven插件命令运行: `cd`到工程目录，`mvn spring-boot:run`,这是采用`spring-boot-maven-plugin`提供的插件运行!
## 打包成jar包运行
- `cd`到工程目录，
- `mvn clean package -Dmaven.test.skip=true`打包编译，
- `cd  tartget/`，`nohup sudo java -jar spring-helper.jar >/dev/null 2>&1 &`运行。

注: 这里可以覆盖`application.properties`中的设置!
eg: `sudo java -jar sms-mq-consumer.jar --spring.profiles.active=local --server.port=9191 > /dev/null 2>&1` ,覆盖以上两个属性!

可以做成启动脚本,如工程目录下的`run.sh`脚本.

## linux服务器下,设置服务运行
- 首先, 在pom.xml中添加Spring Boot的插件，设置executable
    ```
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <executable>true</executable>
            </configuration>
        </plugin>
    ```

- 创建软连接到`/etc/init.d/`目录下: `sudo ln -s /var/yourapp_path/yourapp.jar /etc/init.d/yourapp`
- 修改jar的执行权限: `chmod 744 app.jar`
- 配置启动参数, 文件名要与应用名一致

eg: jar包: appName.jar 启动配置文件: appName.conf
    ```
    JAVA_OPTS="-XX:MaxPermSize=128m -XX:+DisableExplicitGC -verbose:gc -XX:+PrintGCDateStamps -XX:+PrintGCDetails -Xloggc:./logs/gc.log"
    LOG_FOLDER="/home/q/www/sms.mq.consumer.qunar.com/logs"
    PID_FOLDER="/home/q/www/sms.mq.consumer.qunar.com"
    RUN_ARGS="--spring.profiles.active=local --server.port=9191"
    ```
注: 都要带引号! 其他一些配置可以参见boot官方文档!

- 控制应用:`/etc/init.d/yourapp start|stop|status|restart`
注: 通过`service yourapp start|stop`操作不成功!

- 设置快捷启动:
    ```
    alias consumer_start="cd /home/q/www/sms.mq.consumer.qunar.com; sudo /etc/init.d/sms-mq-consumer start"
    alias consumer_status="cd /home/q/www/sms.mq.consumer.qunar.com; sudo /etc/init.d/sms-mq-consumer status"
    alias consumer_stop="cd /home/q/www/sms.mq.consumer.qunar.com; sudo /etc/init.d/sms-mq-consumer stop"
    alias consumer_restart="cd /home/q/www/sms.mq.consumer.qunar.com; sudo /etc/init.d/sms-mq-consumer restart"
    ```


# 个性化
### IDEA设置spring-boot-devtools热部署
1. `settings - Compiler - Make project automatically` 打钩
2. `Shift+Ctrl+Alt+/`，选择Registry,进入对话框找到`compiler.automake.allow.when.app.running`

### spring-boot远程调试
1. `spring-boot-maven-plugin`中添加
    ```
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <fork>true</fork>
            <jvmArguments>
            -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
            </jvmArguments>
        </configuration>
    </plugin>
    ```

2. 在IDEA中开启远程debug: `Edit Configrations... - 点'+' - Remote `新建一个远程调试
并设置` Host, port, Name`
3. 点击Debug按钮开始远程调试.




