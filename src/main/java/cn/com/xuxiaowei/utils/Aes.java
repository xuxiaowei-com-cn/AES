package cn.com.xuxiaowei.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES 对称性加密
 * <p>
 * 需要依赖 Apache Commons Codec
 * <p>
 * Apache Commons Codec 软件包包含各种格式的简单编码器和解码器，如Base64和Hexadecimal。
 * 除了这些广泛使用的编码器和解码器之外，编解码器包还维护一组语音编码实用程序。
 *
 * @author xuxiaowei
 * @see <a href="https://mvnrepository.com/artifact/commons-codec/commons-codec">Apache Commons Codec</a>
 * @since 0.0.1
 */
public class Aes {

    /**
     * 加密算法类型
     */
    static final String ALGORITHM_KEY = "AES";

    /**
     * 算法长度
     */
    private static final int KEY_SIZE = 128;

    /**
     * 使用 种子（密码）、模式 创建密码加密
     *
     * @param seed 种子（密码）
     * @param mode 模式，加密：{@link Cipher#ENCRYPT_MODE}，解密：{@link Cipher#DECRYPT_MODE}
     * @return 返回 密码加密
     * @throws NoSuchAlgorithmException 算法类型异常
     * @throws NoSuchPaddingException   算法填充异常
     * @throws InvalidKeyException      无效的密钥异常
     */
    public static Cipher cipher(String seed, int mode) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_KEY);
        byte[] seedBytes = seed.getBytes();
        keyGenerator.init(KEY_SIZE, new SecureRandom(seedBytes));
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encodedBytes = secretKey.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(encodedBytes, ALGORITHM_KEY);
        Cipher cipher = Cipher.getInstance(ALGORITHM_KEY);
        cipher.init(mode, secretKeySpec);
        return cipher;
    }

    /**
     * 使用 种子（密码）将内容 加密
     *
     * @param originalText 原文
     * @param seed         种子（密码）
     * @return 返回 加密结果
     * @throws NoSuchAlgorithmException  算法类型异常
     * @throws NoSuchPaddingException    算法填充异常
     * @throws InvalidKeyException       无效的密钥异常
     * @throws BadPaddingException       错误填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     */
    public static byte[] encrypt(byte[] originalText, String seed) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = cipher(seed, Cipher.ENCRYPT_MODE);
        return cipher.doFinal(originalText);
    }

    /**
     * 使用 种子（密码）将内容 加密
     *
     * @param originalText 原文
     * @param seed         种子（密码）
     * @return 返回 加密结果
     * @throws NoSuchAlgorithmException  算法类型异常
     * @throws NoSuchPaddingException    算法填充异常
     * @throws InvalidKeyException       无效的密钥异常
     * @throws BadPaddingException       错误填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     */
    public static byte[] encrypt(String originalText, String seed) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return encrypt(originalText.getBytes(), seed);
    }

    /**
     * 使用 种子（密码）将内容 加密
     *
     * @param originalText 原文
     * @param seed         种子（密码）
     * @return 返回 加密结果
     * @throws NoSuchAlgorithmException  算法类型异常
     * @throws NoSuchPaddingException    算法填充异常
     * @throws InvalidKeyException       无效的密钥异常
     * @throws BadPaddingException       错误填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     */
    public static String encryptStr(String originalText, String seed) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] encryptBytes = encrypt(originalText.getBytes(), seed);
        return Hex.encodeHexString(encryptBytes);
    }

    /**
     * 使用 种子（密码）将内容 解密
     *
     * @param cipherText 密文
     * @param seed       种子（密码）
     * @return 返回 解密原文
     * @throws NoSuchAlgorithmException  算法类型异常
     * @throws NoSuchPaddingException    算法填充异常
     * @throws InvalidKeyException       无效的密钥异常
     * @throws BadPaddingException       错误填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     */
    public static byte[] decrypt(byte[] cipherText, String seed) throws NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = cipher(seed, Cipher.DECRYPT_MODE);
        return cipher.doFinal(cipherText);
    }

    /**
     * 使用 种子（密码）将内容 解密
     *
     * @param cipherText 密文
     * @param seed       种子（密码）
     * @return 返回 解密原文
     * @throws NoSuchAlgorithmException  算法类型异常
     * @throws NoSuchPaddingException    算法填充异常
     * @throws InvalidKeyException       无效的密钥异常
     * @throws BadPaddingException       错误填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     * @throws DecoderException          解码器异常
     */
    public static byte[] decrypt(String cipherText, String seed) throws NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, DecoderException {
        byte[] contentBytes = Hex.decodeHex(cipherText);
        return decrypt(contentBytes, seed);
    }

    /**
     * 使用 种子（密码）将内容 解密
     *
     * @param cipherText 密文
     * @param seed       种子（密码）
     * @return 返回 解密原文
     * @throws NoSuchAlgorithmException  算法类型异常
     * @throws NoSuchPaddingException    算法填充异常
     * @throws InvalidKeyException       无效的密钥异常
     * @throws BadPaddingException       错误填充异常
     * @throws IllegalBlockSizeException 非法的块大小异常
     * @throws DecoderException          解码器异常
     */
    public static String decryptStr(String cipherText, String seed) throws NoSuchAlgorithmException, BadPaddingException,
            IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, DecoderException {
        byte[] decryptFrom = Hex.decodeHex(cipherText);
        byte[] decryptBytes = decrypt(decryptFrom, seed);
        return new String(decryptBytes);
    }

}
