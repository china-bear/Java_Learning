package strt_to_Int;

import java.io.ByteArrayOutputStream;
        import java.util.zip.Deflater;
        import java.util.zip.Inflater;
        import java.math.BigInteger;
        import java.nio.charset.StandardCharsets;

public class StrToInt4 {

    /**
     * 压缩字符串
     */
    private static byte[] compress(String str) throws Exception {
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return outputStream.toByteArray();
    }

    /**
     * 解压字符串
     */
    private static String decompress(byte[] data) throws Exception {
        Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        return new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    /**
     * 字符串 -> 整数（压缩）
     */
    public static BigInteger stringToIntCompressed(String str) throws Exception {
        byte[] compressed = compress(str);
        return new BigInteger(1, compressed);
    }

    /**
     * 整数 -> 字符串（解压）
     */
    public static String intToStringCompressed(BigInteger num) throws Exception {
        byte[] bytes = num.toByteArray();
        // 处理符号位
        int start = (bytes.length > 0 && bytes[0] == 0) ? 1 : 0;
        byte[] data = new byte[bytes.length - start];
        System.arraycopy(bytes, start, data, 0, data.length);
        return decompress(data);
    }

    public static void main(String[] args) throws Exception {
        String original = "这是一个需要被编码为整数的字符串，它包含中文和英文。This is a string that needs to be encoded to an integer, containing both Chinese and English.";

        System.out.println("原始字符串长度: " + original.length() + " 字符");
        System.out.println("原始字节长度: " + original.getBytes(StandardCharsets.UTF_8).length + " 字节");

        BigInteger encoded = stringToIntCompressed(original);
        System.out.println("编码后整数: " + encoded);
        System.out.println("整数位数: " + encoded.bitLength() + " 位");

        String decoded = intToStringCompressed(encoded);
        System.out.println("解码后字符串长度: " + decoded.length() + " 字符");
        System.out.println("是否相等: " + original.equals(decoded));
    }
}