# IntelliJ IDEA 远程调试

## 远程调试 Tomcat
### 准备工作

- 明确远程服务器的 IP 地址，比如我是：192.168.92.128
- 关掉服务器防火墙：`service iptables stop`

### 本地 Remote Server 配置

- 添加 Remote Server(打开工程，在菜单栏中选择“Run > Edit Configurations > 单击左上角的“+”号，在下拉菜单中选择Remote)，如下图
	- ![本地 Tomcat 配置](images/remote-debugging-1.jpg)
- 复制 Remote Server 自动生成的 JVM 参数，等下有用，如下图，比如我的是：`-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005`
- 如下图，在 Host 添加服务器的 IP 地址：192.168.92.128。
	- ![本地 Tomcat 配置](images/remote-debugging-2.jpg)
- 把刚刚复制参数加个前缀，变成：
	- Linux（有单引号）：`export JAVA_OPTS='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005'`
	- Windows（没有单引号）：`set JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005`


### 服务器 Tomcat 配置

- 以 Linux 环境为例
- Tomcat 安装在 /usr/program/tomcat7
- Tomcat 的执行程序：/usr/program/tomcat7/bin/catalina.sh
- 编辑 Tomcat 执行程序：`vim /usr/program/tomcat7/bin/catalina.sh`（Windows 是编辑：catalina.bat）
	- 在该文件的最上面，添加我们刚刚复制的那句话：`export JAVA_OPTS='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005'`。
	- 如果你的项目有特殊 JVM 参数，那你就把你的那部分参数和这部分参数合并在一起。
	- 如下图所示：
	- ![远程 Tomcat 配置](images/remote-debugging-3.jpg)

### 服务器 Jetty 配置

- 同样是 Linux 环境
- jetty 不像Tomcat那样需要安装，只要有jetty的jar包就可以启动我们想要启动的应用。
- 在启动应用的时候加入之前上边我们copy的`-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005`就可以了。
    - 就像这样：`java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar {your jetty path} {your port} --path {your war} 1>/dev/null 2>&1 &`


### 开始调试

- 启动服务器 Tomcat
- 启动本地 Remote Server
- 如果可以看到如下图效果，表示已经连接成功了，接下里就是跟往常一样，在本地代码上设置断点，然后你访问远程的地址，触发到该代码自动就会在本地停住。
	- ![开始调试](images/remote-debugging-4.jpg)
- 如下图，可以看到调试效果
	- ![开始调试](images/remote-debugging-5.jpg)

## 远程调试 Java代码

### 服务端使用JVM的 -Xdebug 启动参数说明
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5555 -jar remote-demo.jar

-Xdebug：JVM在DEBUG模式下工作；
-Xrunjdwp：JVM使用(java debug wire protocol)来运行调试环境
transport：监听Socket端口连接方式,常用的dt_socket表示使用socket连接.
server：=y表示当前是调试服务端，=n表示当前是调试客户端；
suspend：=n表示启动时不中断.
address：=5555表示本地监听5555端口。

###服务端以DEBUG模式启动了jar包之后,只需要在IDEA中做一些配置, 见上面TOMCAT本地 Remote Server 配置

###开始调试

## 远程调试Spark代码

###
./spark-submit --master yarn-client --driver-java-options "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5555" --class org.apache.spark.examples.SparkPi /home/user/bear/spark-examples-<version>.jar

## 远程调试MapReduce代码
