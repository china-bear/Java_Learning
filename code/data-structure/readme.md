# 打包
mvn clean  package -DskipTests -Pdata-structure

# 运行
java -classpath  target\data-structuPre-1.1-jar-with-dependencies  demo.MyBloomFilter