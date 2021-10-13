package ll;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 延迟加载实现一: 给实例变量加上volatile 关键字修饰
 * https://www.hcyhj.cn/2018/11/21/delay-load/index.html
 */

public class DoubleCheckDelayLoad {

    public static final Logger LOGGER = getLogger(DoubleCheckDelayLoad.class);

    private DoubleCheckDelayLoad() {
        LOGGER.info("DoubleCheckDelayLoad created");
    }

    private static volatile Heavy instance;         //volatile 内存屏障执行代码会禁止指令重排 防止有可能出现可能进行指令重排 导致instance不一致的问题

    public static Heavy getInstance() {
        if (instance == null) {                     //第一次检查
            synchronized (Heavy.class){
                if (instance == null) {             //第一次检查
                    instance = new Heavy();         //创建实例
                }
            }
        }
        return instance;
    }
}
