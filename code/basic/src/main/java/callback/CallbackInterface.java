package callback;

import java.util.List;

// 定义一个泛形接口
public interface CallbackInterface<T> {
    T process(List<Object> param);
}
