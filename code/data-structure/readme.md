## 打包
mvn clean  package -DskipTests -Pdata-structure

## 运行

### 布隆过滤器
java -classpath  target\data-structure-1.1-jar-with-dependencies.jar  demo.BloomFilter.MyBloomFilter

### 红黑树
java -classpath  target\data-structure-1.1.jar  demo.Tree.RedBlackTree.RBTreeDemo



##
- [数据结构可视化](https://www.cs.usfca.edu/~galles/visualization/Algorithms.html)