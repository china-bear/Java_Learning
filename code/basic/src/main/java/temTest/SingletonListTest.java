package temTest;

import java.util.*;

public class SingletonListTest {

    public static void main(String[] args) {

        // create an array of string objs
        String initList[] = { "One", "Two", "Four", "One",};

        // create one list
        List list = new ArrayList(Arrays.asList(initList));

        list.add("Five");

        System.out.println("List value before: "+list);

        // create singleton list ,singletonList can hold instance of any object
        // Use singleton when code expects a read-only list, but you only want to pass one element in it. singletonList is (thread-)safe and fast.

        list = Collections.singletonList(list);
        System.out.println("List value after: "+list);

        list = Collections.singletonList("OnlyOneElement");
        //list.add("five"); //throws UnsupportedOperationException
        System.out.println("List value after: "+list);

    }
}