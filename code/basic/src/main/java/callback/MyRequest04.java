package callback;

/**
 * https://juejin.cn/post/6844904066129084429
 * https://zhuanlan.zhihu.com/p/221949207  Lambda讲解与应用
 * Java 实现回调的四种写法：
 * 1 反射
 * 2 直接调用
 * 3 接口调用
 * 4 Lambda表达式
 */

public class MyRequest04 {

    // 4 Lambda表达式
    public void send(MyCallBackInterface myCallBackInterface) throws Exception {
        // 模拟等待响应
        Thread.sleep(3000);
        System.out.println("[Request]:收到响应");
        Thread.sleep(3000);
        myCallBackInterface.processResponse();
    }


    public static void main(String[] args) throws InterruptedException {
        MyRequest04 request = new MyRequest04();
        System.out.println("[Main]:我开个线程去异步发请求");

        new Thread(() -> {
            try {
                request.send(()-> System.out.println("[CallBack]:处理响应"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("[Main]:请求发完了，我去干点别的");
        Thread.sleep(10000);
    }
}