package strt_to_Int;

import java.math.BigInteger;
        import java.nio.charset.StandardCharsets;

public class StrToInt3 {

    /**
     * 将字符串编码为整数（UTF-8编码）
     * UTF-8编码（通用方案） 这是最完整的方法，可以处理所有Unicode字符
     */
    public static BigInteger stringToBigInteger(String str) {
        // 将字符串转换为UTF-8字节数组
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        // 将字节数组转换为大整数
        return new BigInteger(1, bytes);  // 1表示正数
    }

    /**
     * 将整数解码回字符串（UTF-8编码）
     */
    public static String bigIntegerToString(BigInteger num) {
        // 将大整数转换为字节数组
        byte[] bytes = num.toByteArray();

        // 处理可能的符号位
        // BigInteger.toByteArray()可能会添加一个额外的符号位字节
        int start = 0;
        if (bytes.length > 0 && bytes[0] == 0) {
            start = 1;  // 跳过符号位
        }

        // 复制有效字节
        byte[] actualBytes = new byte[bytes.length - start];
        System.arraycopy(bytes, start, actualBytes, 0, actualBytes.length);

        // 将字节数组转换为字符串
        return new String(actualBytes, StandardCharsets.UTF_8);
    }

    /**
     * 优化版本：使用长度前缀
     */
    public static BigInteger stringToBigIntegerWithLength(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        // 创建新数组：长度(4字节) + 数据
        byte[] result = new byte[bytes.length + 4];

        // 写入长度（大端序）
        int length = bytes.length;
        result[0] = (byte) ((length >> 24) & 0xFF);
        result[1] = (byte) ((length >> 16) & 0xFF);
        result[2] = (byte) ((length >> 8) & 0xFF);
        result[3] = (byte) (length & 0xFF);

        // 写入数据
        System.arraycopy(bytes, 0, result, 4, bytes.length);

        return new BigInteger(1, result);
    }

    public static String bigIntegerToStringWithLength(BigInteger num) {
        byte[] allBytes = num.toByteArray();

        // 处理符号位
        int start = 0;
        if (allBytes.length > 0 && allBytes[0] == 0) {
            start = 1;
        }

        byte[] bytes = new byte[allBytes.length - start];
        System.arraycopy(allBytes, start, bytes, 0, bytes.length);

        // 读取长度
        int length = ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                (bytes[3] & 0xFF);

        // 读取数据
        byte[] data = new byte[length];
        System.arraycopy(bytes, 4, data, 0, length);

        return new String(data, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        // 测试各种字符串
        String[] testCases = {
                "Hello",
                "世界",
                "Hello, 世界! 👋",
                "123456",
                "特殊字符: !@#$%^&*()",
                "",
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"  // 长字符串
        };

        for (String original : testCases) {
            System.out.println("\n=== 测试字符串: " +
                    (original.length() > 20 ? original.substring(0, 20) + "..." : original) +
                    " ===");

            try {
                // 方法1：基础方法
                BigInteger encoded1 = stringToBigInteger(original);
                String decoded1 = bigIntegerToString(encoded1);
                System.out.println("方法1 - 成功: " + original.equals(decoded1));

                // 方法2：带长度的方法
                BigInteger encoded2 = stringToBigIntegerWithLength(original);
                String decoded2 = bigIntegerToStringWithLength(encoded2);
                System.out.println("方法2 - 成功: " + original.equals(decoded2));

            } catch (Exception e) {
                System.out.println("错误: " + e.getMessage());
            }
        }
    }
}
