package strt_to_Int;

import java.util.Base64;
import java.math.BigInteger;

public class StrToInt2 {

    /**
     * 将字符串转换为大整数（ASCII编码）
     * 这种方法适用于纯ASCII字符串，不支持中文：
     */
    public static BigInteger stringToInt(String str) {
        // 检查是否为纯ASCII
        for (char c : str.toCharArray()) {
            if (c > 127) {
                throw new IllegalArgumentException("仅支持ASCII字符: " + c);
            }
        }

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 每个字符用8位表示
            result = result.shiftLeft(8).or(BigInteger.valueOf(c));
        }
        return result;
    }

    /**
     * 将大整数转换回字符串
     */
    public static String intToString(BigInteger num) {
        StringBuilder result = new StringBuilder();

        while (num.compareTo(BigInteger.ZERO) > 0) {
            // 获取最低8位
            int charCode = num.and(BigInteger.valueOf(0xFF)).intValue();
            result.insert(0, (char) charCode);

            // 右移8位
            num = num.shiftRight(8);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String original = "Hello123";
        System.out.println("原始字符串: " + original);

        BigInteger encoded = stringToInt(original);
        System.out.println("编码为整数: " + encoded);

        String decoded = intToString(encoded);
        System.out.println("解码后字符串: " + decoded);
        System.out.println("是否相等: " + original.equals(decoded));
    }
}
