package callback;

import java.util.ArrayList;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/30052334

*/


public class WordProcess {

    public List<String> wordList = loadList();

    public <T> T execute(WordProcessCallback callbackInterface) {
        // 可以执行一些execute的逻辑

        // 直接将相关词库的操作权都交给了 callbackInterface
        T result = (T) callbackInterface.process(wordList);
        return result;
    }

    // 加载词库到内存
    public List<String> loadList() {
        ArrayList<String> wordList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            wordList.add(Integer.toString(i));
        }
        return wordList;
    }

    public void printWord() {
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        WordProcess loadWord = new WordProcess();

        // 实现词库元素的删除
        loadWord.execute(new WordProcessCallback() {
            @Override
            public Object process(List param) {
                List<String> wordList = param;
                wordList.remove("1");
                return true;
            }
        });

        // 实现词库元素的添加
        loadWord.execute(new WordProcessCallback() {
            @Override
            public Object process(List param) {
                List<String> wordList = param;
                wordList.add("100");
                System.out.println(wordList);
                return true;
            }
        });

        loadWord.printWord();
    }
}
