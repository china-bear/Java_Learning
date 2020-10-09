mvn clean  package -DskipTests -Pbasic

java -classpath  target/basic-1.1.jar  utils.BashExecUtil

java -classpath  target/basic-1.1.jar http_request.HttpClient.HttpClient4Demo
java -classpath  target/basic-1.1-jar-with-dependencies.jar http_request.HttpClient.HttpClient4Demo
