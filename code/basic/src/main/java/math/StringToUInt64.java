package math;

import java.math.BigInteger;

public class StringToUInt64 {

    // UInt64最大值: 2^64 - 1 = 18446744073709551615
    private static final BigInteger MAX_UINT64 =
            BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE);

    /**
     * 将字符串转换为UInt64（返回BigInteger）
     */
    public static BigInteger stringToUInt64(String str) throws NumberFormatException {
        // 去除空白字符
        str = str.trim();

        // 检查空字符串
        if (str.isEmpty()) {
            throw new NumberFormatException("空字符串");
        }

        // 解析为BigInteger
        BigInteger value;
        try {
            value = new BigInteger(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("无效的数字格式: \"" + str + "\"");
        }

        // 检查范围 [0, 2^64-1]
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new NumberFormatException("负数无法表示为UInt64: " + value);
        }
        if (value.compareTo(MAX_UINT64) > 0) {
            throw new NumberFormatException("数值超出UInt64范围: " + value +
                    " (最大值: " + MAX_UINT64 + ")");
        }

        return value;
    }

    /**
     * 将字符串转换为UInt64，返回long（可能有符号溢出）
     */
    public static long stringToUInt64AsLong(String str) {
        BigInteger value = stringToUInt64(str);
        return value.longValue(); // 注意：可能返回负数
    }

    /**
     * 验证字符串是否是有效的UInt64
     */
    public static boolean isValidUInt64(String str) {
        try {
            stringToUInt64(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 支持不同进制的解析
     */
    public static BigInteger stringToUInt64(String str, int radix) {
        str = str.trim();

        // 检查空字符串
        if (str.isEmpty()) {
            throw new NumberFormatException("空字符串");
        }

        // 解析
        BigInteger value;
        try {
            value = new BigInteger(str, radix);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("无效的" + radix + "进制数字: \"" + str + "\"");
        }

        // 检查范围
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw new NumberFormatException("负数无法表示为UInt64: " + value);
        }
        if (value.compareTo(MAX_UINT64) > 0) {
            throw new NumberFormatException("数值超出UInt64范围: " + value +
                    " (最大值: " + MAX_UINT64 + ")");
        }

        return value;
    }

    public static void main(String[] args) {
        // 测试用例
        String[] testStrings = {
                "0",
                "123456789",
                "18446744073709551615", // 最大值
                "18446744073709551616", // 超出范围
                "-1",                   // 负数
                " 123 ",                // 带空格
                "12a34",                // 无效字符
                "0xFFFFFFFFFFFFFFFF",   // 十六进制
                "0b1111111111111111111111111111111111111111111111111111111111111111" // 二进制
        };

        for (String str : testStrings) {
            System.out.println("测试字符串: \"" + str + "\"");

            try {
                // 尝试十进制解析
                if (str.startsWith("0x") || str.startsWith("0b")) {
                    continue; // 跳过十六进制和二进制
                }

                BigInteger result = stringToUInt64(str);
                long asLong = stringToUInt64AsLong(str);

                System.out.println("  成功 -> BigInteger: " + result);
                System.out.println("        -> long值: " + asLong);
                System.out.println("        -> 有符号? " + (asLong < 0));

            } catch (NumberFormatException e) {
                System.out.println("  失败: " + e.getMessage());
            }

            System.out.println();
        }

        // 测试十六进制
        System.out.println("十六进制测试:");
        try {
            BigInteger hexResult = stringToUInt64("FFFFFFFFFFFFFFFF", 16);
            System.out.println("0xFFFFFFFFFFFFFFFF = " + hexResult);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}