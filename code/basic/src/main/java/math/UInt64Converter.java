package math;

import java.math.BigInteger;

class LongToUnsigned {
    private static final BigInteger TEN = BigInteger.valueOf(10);

    public static BigInteger toUnsignedBigInt(long l) {
        // 方法1：使用BigInteger的构造函数，通过字节数组
        byte[] bytes = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bytes[7 - i] = (byte) (l >>> (i * 8));
        }
        return new BigInteger(1, bytes); // 正数，无符号
    }

    // 方法2：使用位运算和条件判断
    public static BigInteger toUnsignedBigInt2(long l) {
        if (l >= 0) {
            return BigInteger.valueOf(l);
        } else {
            // 将低63位转换为正数，然后加上2^63，实际上就是无符号值
            // 注意：对于负数，无符号值是 2^64 + l，而 2^64 = 2^63 + 2^63
            // 我们可以这样计算：先得到低63位（即l & Long.MAX_VALUE），然后加上2^63
            return BigInteger.valueOf(l & Long.MAX_VALUE).add(BigInteger.ONE.shiftLeft(63));
        }
    }

    public static void main(String[] args) {
        long[] testValues = {0L, 100L, -8451083829094450504L, Long.MAX_VALUE, -1L, Long.MIN_VALUE};
        String[] testValues2 = {"-8451083829094450504", "9223372036854775808", "1000233691853141112" };
        for (long l : testValues) {
            System.out.println("有符号 long: " + l);
            System.out.println("转换为无符号 BigInteger (方法1): " + toUnsignedBigInt(l));
            System.out.println("转换为无符号 BigInteger (方法2): " + toUnsignedBigInt2(l));
            System.out.println("---");
        }

        System.out.println(Long.parseLong("-8451083829094450504"));
        System.out.println(BigInteger.valueOf(Long.parseLong("-8451083829094450504")));
        System.out.println(toUnsignedBigInt(Long.parseLong("-8451083829094450504")));

        System.out.println(TEN.pow(5));
    }
}