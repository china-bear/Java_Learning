dependencies 与 dependencyManagement 的区别
dependencies  引入依赖
即使子项目中不写 dependencies ，子项目仍然会从父项目中继承 dependencies 中的所有依赖项

dependencyManagement  声明依赖，并不引入依赖。
子项目默认不会继承父项目 dependencyManagement 中的依赖
只有在子项目中写了该依赖项，并且没有指定具体版本，才会从父项目中继承（version、exclusions、scope等读取自父pom）
子项目如果指定了依赖的具体版本号，会优先使用子项目中指定版本，不会继承父pom中申明的依赖
