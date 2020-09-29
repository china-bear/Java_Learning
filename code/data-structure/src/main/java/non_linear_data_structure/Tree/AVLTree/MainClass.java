package non_linear_data_structure.Tree.AVLTree;

import java.util.ArrayList;

/**
 * Created by bear on 2020/9/8
 */
public class MainClass {

    public static void main(String[] args) {
            ArrayList<String> words = new ArrayList<>();
            FileOperation.readFile("E:\\CodeRepository\\Chinabear\\Java_Learning\\code\\data-structure\\src\\main\\java\\demo\\Tree\\AVLTree\\pride-and-prejudice.txt",words);
            System.out.println("Total words: " + words.size());
            AVLTree<String,Integer> wordsMap = new AVLTree();
            for (String word : words) {
                if(wordsMap.contains(word)){
                    wordsMap.set(word,wordsMap.get(word)+1);
                }else {
                    wordsMap.add(word,1);
                }
            }
            System.out.println("Total different words: " + wordsMap.getSize());
            System.out.println("Frequency of PRIDE "+wordsMap.get("pride"));
            System.out.println("Frequency of is "+wordsMap.get("is"));
        }
}
