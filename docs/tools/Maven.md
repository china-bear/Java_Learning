dependencies 与 dependencyManagement 的区别
dependencies  引入依赖
即使子项目中不写 dependencies ，子项目仍然会从父项目中继承 dependencies 中的所有依赖项

dependencyManagement  声明依赖，并不引入依赖。
子项目默认不会继承父项目 dependencyManagement 中的依赖
只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承（version、exclusions、scope等读取自父pom）
子项目如果指定了依赖的具体版本号，会优先使用子项目中指定版本，不会继承父pom中申明的依赖




Maven的安装配置和Maven在Intellij idea中的使用配置
https://juejin.im/post/6844904096961396749

###  Include different properties files based on profile in Maven  
https://stackoverflow.com/questions/1149352/using-maven-for-multiple-deployment-environment-production-development
### Using Maven for multiple deployment environment (production/development)
https://notestack.io/public/include-different-properties-files-based-on-profile-in-maven/74f5e34b-3233-4c7b-b200-a08e5256002d

***
一定要确保IDEA Maven 用户配置文件settings.xml  和  命令行MVN 依赖settings.xml 一致（mvn -v 可以查看调用的MVN路径），要不引起本地仓库不一致情况 
将安装目录下的setting文件（Apache\maven\conf\settings.xml）复制一份至C:\Users\用户名.m2文件夹下（如果已经存在则覆盖）
***
