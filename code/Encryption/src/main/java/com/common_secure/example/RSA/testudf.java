package com.common_secure.example.RSA;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;

/**
 * 反作弊SDK 日志解密
 * @author Mr.Bear
 * @creat 2023-05-24
 */
public class testudf {
    private static final Logger LOGGER = LoggerFactory.getLogger(testudf.class);

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

            return cipher.doFinal(Base64.decodeBase64(data));

            //return cipher.doFinal(Base64.getDecoder().decode(data));
        }
        return new byte[0];
    }



    public static void main(String[] args) throws Throwable {
        String iv="0522304586294240";
        String key="rIZLLTfhwJ6FNPTyl2VlOA==";
        JSONObject jsonObj = null;
        byte[] data = new byte[0];
        try {
            File file = new File("E:\\flink\\sdklog");
            String jsonData = FileUtils.readFileToString(file);
            //对基本类型的解析
            jsonObj = new JSONObject(jsonData);

            if (jsonObj.has("body")) {
                try {
                    String encStr = jsonObj.getString("body");

                    try {
                        data = decrypt(iv, Base64.decodeBase64(key), encStr.getBytes());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(new String(data));
    }
}


