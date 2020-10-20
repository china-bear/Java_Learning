## 打包
mvn clean  package -DskipTests -Pdata-structure

## 运行

### 布隆过滤器
java -classpath  target\data-structure-1.1-jar-with-dependencies.jar  demo.BloomFilter.MyBloomFilter

### 红黑树
java -classpath  target\data-structure-1.1.jar  demo.Tree.RedBlackTree.RBTreeDemo

### 二分搜索树
java -classpath  target\data-structure-1.1.jar  demo.Tree.BinaryTree.MainClass


##
- [数据结构可视化](https://www.cs.usfca.edu/~galles/visualization/Algorithms.html)



内容：包含常见的数据结构
1、链表：
   单链表、双链表、循环链表、约瑟夫环
2、排序算法：8种常见排序：
   二叉排序树、冒泡、堆排序、插入排序、归并排序、快速排序、选择排序、希尔排序、基数排序
3、搜索算法：
   二分查找、斐波那契查找、插值查找
4、哈希表实现
5、二叉树：
   AVL树、二叉排序树、二叉树、赫夫曼树、赫夫曼编码、线索二叉树、顺序二叉树
6、图：
7、常见的10大算法：
   二分查找、马踏棋盘、Dijkstra、Prim、Kruskal、弗洛伊德算法、动态规划、贪婪算法、KMP、汉诺塔