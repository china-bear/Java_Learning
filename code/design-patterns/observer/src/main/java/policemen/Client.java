package policemen;


/**
 * @version v1.0
 * @ClassName: Client
 * @Description:  警察抓小偷, 警察是观察者, 小偷是被观察者
 * @Author:
 */
public class Client {

    public static void main(String[] args) {
        //创建小偷对象
        Thief t = new Thief("隔壁老王");
        //创建警察对象
        Policemen p = new Policemen("神探柯南");
        //创建业主对象
        Owner o = new Owner("王百万");
        //让警察盯着小偷
        t.addObserver(p);
        //让业主盯小偷
        t.addObserver(o);
        //小偷偷东西
        t.steal();
    }
}
