package callback;

public class MyCallBackInterfaceImpl implements MyCallBackInterface {

    @Override
    public void processResponse() {
        System.out.println("[CallBack]:处理响应");
    }
}
