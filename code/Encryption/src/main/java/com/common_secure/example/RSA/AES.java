package com.common_secure.example.RSA;




import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

public class AES {

    /**
     * AES加密
     *
     * @param iv   偏移量
     * @param key  秘钥
     * @param data 加密前的数据
     * @return 加密后数据(Base64)
     */
/*    public static byte[] encrypt(String iv, byte[] key, byte[] data) throws Throwable {
        if (key == null || key.length == 0) {
            throw new NullPointerException("encrypt key is null!");
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        int blockSize = cipher.getBlockSize();
        int plaintextLength = data.length;
        if (plaintextLength % blockSize != 0) {
            plaintextLength = plaintextLength
                    + (blockSize - (plaintextLength % blockSize));
        }
        byte[] plaintext = new byte[plaintextLength];
        System.arraycopy(data, 0, plaintext, 0, data.length);
        SecretKeySpec keyspec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encrypted = cipher.doFinal(plaintext);
        return Base64.encode(encrypted, Base64.NO_WRAP);*/
//        return encrypted;
 //   }

    /**
     * AES解密
     *
     * @param iv   偏移量
     * @param key  秘钥
     * @param data 解密前的数据
     * @return 解密后数据
     *
     */
    public static byte[] decrypt(String iv, byte[] key, byte[] data) throws Throwable {
        if (key != null && key.length > 0 && data != null) {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            return cipher.doFinal(Base64.getDecoder().decode(data));
        }
        return new byte[0];
    }

    public static void main(String[] args) throws Throwable {
        String iv="0522304586294240";
        String key="rIZLLTfhwJ6FNPTyl2VlOA==";
        String encstr="cAkUIu3fWKbKnnIDvwSDgu2B5Kwi3j7i0IbJ5urUhKin1usdZjAgUL4IIkvxhYp0FiBQBH9vf8CfVindU5nWNTAyLuk6osaCk+O5KWGfEHwzn6U68wy8Bj5OzoQYHLwvGvPaJjHO5XHwPtuJTaohmYsGRWDlRjAymsUdUVFyTjC7++t1MjE4oZ3YRsN5Z6yvMU6mPQZhi11sxojRKRSKPKQRbJMf8/LXVLKY8VHkLLIryjUdLKvPaYuLYTKY79cyouBh+asyffqGbjQ5mwM8qNeVcv0sSlpVo/WodyQzw8c/P0arq3CyhkJ0dwLlZT4axSIqifxNer/LFkYKUINfrg==";

        byte[] data = decrypt(iv, Base64.getDecoder().decode(key), encstr.getBytes());
        System.out.println(new String(data));
    }
}
