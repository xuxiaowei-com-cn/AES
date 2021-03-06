package cn.com.xuxiaowei.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * AES 对称加密 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class AesUtils {

    /**
     * 字符串加密与解密
     */
    @Test
    public void string() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, NoSuchPaddingException, DecoderException {

        String content = "Hello World";
        String seed = "xuxiaowei.com.cn";

        System.out.println("原文：" + content);
        System.out.println("种子（密码）：" + seed);

        String encryptStr = Aes.encryptStr(content, seed);
        System.out.println("加密结果：" + encryptStr);

        String decryptStr = Aes.decryptStr(encryptStr, seed);
        System.out.println("解密结果：" + decryptStr);
    }

    /**
     * 字节与字符串
     */
    @Test
    public void byteAndString() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, NoSuchPaddingException, DecoderException {
        String content = "Hello World";
        String seed = "xuxiaowei.com.cn";

        System.out.println("原文：" + content);
        System.out.println("种子（密码）：" + seed);

        byte[] encryptBytes = Aes.encrypt(content, seed);
        String encryptStr = Hex.encodeHexString(encryptBytes);
        System.out.println("加密结果：" + encryptStr);

        byte[] decryptBytes = Aes.decrypt(encryptStr, seed);
        System.out.println("解密结果：" + new String(decryptBytes));
    }

    /**
     * 字节
     */
    @Test
    public void bytes() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, NoSuchPaddingException, DecoderException {
        String content = "Hello World";
        String seed = "xuxiaowei.com.cn";

        System.out.println("原文：" + content);
        System.out.println("种子（密码）：" + seed);

        byte[] encryptBytes = Aes.encrypt(content, seed);
        String encryptStr = Hex.encodeHexString(encryptBytes);
        System.out.println("加密结果：" + encryptStr);

        byte[] contentBytes = Hex.decodeHex(encryptStr);
        byte[] decryptBytes = Aes.decrypt(contentBytes, seed);
        System.out.println("解密结果：" + new String(decryptBytes));
    }

}
