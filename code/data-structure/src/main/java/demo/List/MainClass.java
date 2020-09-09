package demo.List;

/**
 * Created by bear on 2020/9/9
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        LinkedList<String> strList = new LinkedList<String>();
        strList.add("Rico");
        strList.add("Rico");
        strList.add("Livia");
        strList.add("TJU");
        strList.add("Livia");
        strList.add("NEU");
        strList.add("NEU");
        strList.add("Rico");
        strList.add("NEU");

        System.out.println("原链表：");
        strList.print();
        System.out.println();

        strList.remove();
        System.out.println("删除尾节点后的链表：");
        strList.print();

        System.out.println();

        strList.removeDuplicateNodes();
        System.out.println("删除重复点后的链表：");
        strList.print();
        System.out.println();

        System.out.println("打印倒数第K个节点：");
        System.out.println(strList.getEndK(2));
        System.out.println();

        strList.reverseLinkedList();
        System.out.println("反转链表：");
        strList.print();
        strList.reverseLinkedList();
        strList.print();
        System.out.println();

        System.out.println("倒序打印链表：");
        strList.reversePrint(strList.getHead());
        System.out.println();
        System.out.println();

        System.out.println("打印链表中间节点：");
        strList.printMiddleNodes();
        System.out.println();


        LinkedList<String> strList2 = new LinkedList<String>();
        strList2.add("书呆子");
        strList2.add(strList.getEndK(2));
        System.out.println("判断两链表是否相交：");
        strList.print();
        strList2.print();
        System.out.println(strList.size() + " : " + strList2.size());
        System.out.println("是否相交 : " + strList.isIntersect(strList2));
        System.out.println("交点是 ： " + strList.getIntersectionPoint(strList2));
        System.out.println();

        strList.deleteNodeWithoutHead(strList.getEndK(2));
        System.out.println("打印删除特定节点后的链表：");
        strList.print();
    }
}
