package builder.bike;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new MobileBuilder());
        //让指挥者只会组装自行车
        Bike bike = director.construct();
        System.out.println(bike);

        //创建指挥者对象
        director = new Director(new OfoBuilder());
        //让指挥者只会组装自行车
        bike = director.construct();
        System.out.println(bike);
    }
}
