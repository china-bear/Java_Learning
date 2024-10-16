package com.common_secure.secure;


import com.common_secure.common.SecureType;
import java.security.MessageDigest;

/**
 * SHA 单向加密
 */
public class SHASecure extends BaseSecure {

    @Override
    public byte[] encrypt(byte[] data) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(SecureType.SHA.getType());
        return messageDigest.digest(data);
    }

    @Override
    public byte[] decrypt(byte[] data) throws Exception {
        return null;
    }
}
