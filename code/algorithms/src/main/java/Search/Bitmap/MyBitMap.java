package Search.Bitmap;

/**
 * https://www.jianshu.com/p/6082a2f7df8e   BitMap
 * https://juejin.cn/post/6844903769201704973  漫画：什么是Bitmap算法
 *
 */
public class MyBitMap {

    //保存数据的
    private byte[] bits;

    //能够存储多少数据
    private int capacity;


    public MyBitMap(int capacity){
        this.capacity = capacity;

        //1bit能存储8个数据，那么capacity数据需要多少个bit呢，capacity/8+1,右移3位相当于除以8
        bits = new byte[(capacity >>3 )+1];
    }

    public void add(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
        bits[arrayIndex] |= 1 << position;
    }

    public boolean contain(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bits[arrayIndex] & (1 << position)) !=0;
    }

    public void clear(int num){
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        bits[arrayIndex] &= ~(1 << position);

    }

    public static void main(String[] args) {
        MyBitMap mybitmap = new MyBitMap(100);
        mybitmap.add(7);
        System.out.println("插入7成功");

        boolean isexsit = mybitmap.contain(7);
        System.out.println("7是否存在:"+isexsit);

        mybitmap.clear(7);
        isexsit = mybitmap.contain(7);
        System.out.println("7是否存在:"+isexsit);
    }
}
