package ll;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 延迟加载实现二: 基于类初始化的解决方案
 * JVM的类初始化原理实现: 在执行类的初始化期间,JVM会去获取一个锁, 该锁可以同步多个线程对同一个类的初始化, 类只会被加载一次, 在加载完成之前对其他线程都是不可见的, 这样也能保证获取到的instance也是同一个
 * https://www.hcyhj.cn/2018/11/21/delay-load/index.html
 */
public class ClassInitDelayLoad {

    public static final Logger LOGGER = getLogger(ClassInitDelayLoad.class);

    private ClassInitDelayLoad() {
        LOGGER.info("ClassInitDelayLoad created");
    }

    private static class DelayLoadHolder {
        public static ClassInitDelayLoad instance = new ClassInitDelayLoad();
    }

    public static ClassInitDelayLoad getInstance() {
        return DelayLoadHolder.instance;
    }
}
