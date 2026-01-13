package strt_to_Int;

import java.util.Base64;

public class StrToInt1 {

    /**
     * 将字符串编码为整数（通过Base64）
     * 这是最简单可靠的方法，可以处理任意字符串，包括中文和特殊字符
     */
    public static String encodeToInt(String str) {
        // 将字符串转换为Base64
        String base64 = Base64.getEncoder().encodeToString(str.getBytes());

        // 将Base64字符串转换为大整数
        StringBuilder binary = new StringBuilder();
        for (byte b : base64.getBytes()) {
            // 每个字符用8位表示，前面补0
            binary.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }

        // 转换为BigInteger
        return new java.math.BigInteger(binary.toString(), 2).toString();
    }

    /**
     * 将整数解码回原始字符串
     */

    public static String decodeFromInt(String intStr) {
        // 将字符串整数转换为BigInteger
        java.math.BigInteger bigInt = new java.math.BigInteger(intStr);

        // 转换为二进制字符串
        String binary = bigInt.toString(2);

        // 补全到8的倍数
        int padding = (8 - binary.length() % 8) % 8;
        // repeat 方法 JAVA11版本才支持
        // binary = "0".repeat(padding) + binary;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; ++i) {
            sb.append("0");
        }
        binary = sb.toString() + binary;
        // 将二进制转换为字节数组
        byte[] bytes = new byte[binary.length() / 8];
        for (int i = 0; i < bytes.length; i++) {
            String byteStr = binary.substring(i * 8, (i + 1) * 8);
            bytes[i] = (byte) Integer.parseInt(byteStr, 2);
        }

        // 将字节数组解码为Base64字符串
        String base64 = new String(bytes);

        // 解码Base64得到原始字符串
        return new String(Base64.getDecoder().decode(base64));
    }

    public static void main(String[] args) {
        String original = "Hello, 世界! 👋";
        System.out.println("原始字符串: " + original);

        String encoded = encodeToInt(original);
        System.out.println("编码为整数: " + encoded);
        System.out.println("整数长度: " + encoded.length() + " 位");

        String decoded = decodeFromInt(encoded);
        System.out.println("解码后字符串: " + decoded);
        System.out.println("是否相等: " + original.equals(decoded));
    }
}