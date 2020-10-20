package Samples.List.LinkedList;

import java.util.LinkedList;

/**
 *   利用LinkedList来模拟栈
 *   栈的特点：先进后出
 * Created by bear on 2020/9/1
 */
public class MyStack {

    private final LinkedList<String> linkList = new LinkedList<String>();

    // 压栈
    public void push(String str){
        linkList.addFirst(str);
    }

    // 出栈
    public String pop(){
        return linkList.removeFirst();
    }

    // 查看
    public String peek(){
        return linkList.peek();
    }

    // 判断是否为空
    public boolean isEmpty(){
        return linkList.isEmpty();
    }

    public static void main(String[] args) {
        // 测试栈
        MyStack stack = new MyStack();
        stack.push("我是第1个进去的");
        stack.push("我是第2个进去的");
        stack.push("我是第3个进去的");
        stack.push("我是第4个进去的");
        stack.push("我是第5个进去的");
        // 取出
        while (!stack.isEmpty()){
            String pop = stack.pop();
            System.out.println(pop);
        }

    }
}
