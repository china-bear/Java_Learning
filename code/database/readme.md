# 打包
mvn clean  package -DskipTests -Pdatabase


# 运行   不带MANIFEST文件的jar包
java -classpath  target\database-1.1-jar-with-dependencies.jar  com.chinabear.jdbc.MysqlDemo
java -classpath ..\database\src\main\libs\mysql-connector-java-5.1.49.jar;target\database-1.1.jar com.chinabear.jdbc.MysqlDemo

java -classpath ..\database\src\main\libs\mysql-connector-java-5.1.49.jar;target\database-1.1.jar com.chinabear.jdbc.MysqlClassDemo
java -classpath  target\database-1.1-jar-with-dependencies.jar  com.chinabear.jdbc.MysqlClassDruidDemo


#jar命令打包与java执行jar包
https://segmentfault.com/a/1190000012019605
#maven内置变量
https://www.jianshu.com/p/ded7dfa2c3d8

