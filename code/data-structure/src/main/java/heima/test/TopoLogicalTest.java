package heima.test;

import heima.graph.Digraph;
import heima.graph.TopoLogical;
import heima.linear.Stack;

public class TopoLogicalTest {


    public static void main(String[] args) {

        //准备有向图
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0,2);
        digraph.addEdge(0,3);
        digraph.addEdge(2,4);
        digraph.addEdge(3,4);
        digraph.addEdge(4,5);
        digraph.addEdge(1,3);

        //通过TopoLogical对象堆有向图中的顶点进行排序
        TopoLogical topoLogical = new TopoLogical(digraph);

        //获取顶点的线性序列进行打印

        Stack<Integer> order = topoLogical.order();
        StringBuilder sb = new StringBuilder();
        for (Integer w : order) {
            sb.append(w+"->");
        }
        String str = sb.toString();
        int index = str.lastIndexOf("->");
        str = str.substring(0,index);
        System.out.println(str);
    }
}
