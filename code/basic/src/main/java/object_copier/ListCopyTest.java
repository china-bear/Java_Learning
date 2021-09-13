package object_copier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListCopyTest {

    public static void main(String[] args) {
        /**
         * 1. The Constructor Way
         * Syntax:  List<T> copy = new ArrayList<>([to_be_copied_list]);
         * Output:  [1, 2, 3]
         */

        List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> copy1 = new ArrayList<>(list);
        System.out.println(copy1.toString());

       /**
        * 2. The List addAll()
        * Syntax:  [dest_list].addAll([source_list]);
        * Output:  [1, 2, 3]
        */

        List<Integer> copy2 = new ArrayList<>();
        copy2.addAll(list);
        System.out.println(copy2.toString());

        /**
         * 3. Collections.copy([dest_list], [source_list]);
         * Syntax:  List<T> copy = new ArrayList<>([to_be_copied_list]);
         * Output:  [1, 2, 3, 7, 8]
         */

        List<Integer> source = Arrays.asList(1,2,3);
        List<Integer> dest = Arrays.asList(4,5,6,7,8);
        Collections.copy(dest, source);
        System.out.println(dest.toString());


        /**
         * 4. The Java 8 Stream
         * Syntax:  list.stream()[.method()].collect(Collectors.toList());
         * Output:  [1, 2, 3]
         */

        List<Integer> copy4 = list.stream().collect(Collectors.toList());
        System.out.println(copy4.toString());

        /**
         * 5. The Java 10 List copyOf()
         * Syntax:  List<T> copy = List.copyOf(list);
         * Output:  [1, 2, 3]
         */

        //List<Integer> copy5 = List.copyOf(list);
    }


}
