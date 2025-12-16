package fileTest;

import org.apache.commons.codec.digest.MurmurHash3;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class HashGenerator {
    private static final ThreadLocal<Random> threadLocalRandom = ThreadLocal.withInitial(Random::new);

    public long getKeyHash(String layerName, String key) {
        StringBuilder sb = new StringBuilder();

        if (key != null && !key.isEmpty()) {
            sb.append(key);
        } else {
            // 生成32位随机数（等效于C++的std::mt19937生成范围）
            sb.append(threadLocalRandom.get().nextInt());
        }

        sb.append(layerName);
        String input = sb.toString();
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);

        // 使用Guava库的Murmur3_128Hash实现（需要添加Guava依赖）
        long[] hash = MurmurHash3.hash128(bytes);
        return hash[0];
    }

    public static void main(String[] args) {
        HashGenerator hashGenerator = new HashGenerator();

        System.out.println(hashGenerator.getKeyHash("96ec6be2409d8043695d1d1a4f7cb880","rg_new_candidates_exp"));
    }
}
