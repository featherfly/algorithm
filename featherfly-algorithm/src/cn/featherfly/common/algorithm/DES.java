package cn.featherfly.common.algorithm;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES安全编码组件
 *
 * @author 钟冀
 */
public abstract class DES extends Algorithm{

	/**
	 * 密钥算法 <br>
	 */
	public static final String KEY_ALGORITHM = "DES";

	/**
	 * 加密/解密算法 / 工作模式 / 填充方式
	 */
	public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5PADDING";

	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据
	 * @param key
	 *            密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 还原密钥
		Key k = toKey(key);
		// 实例化
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 初始化，设置为解密模式
		cipher.init(Cipher.DECRYPT_MODE, k);
		// 执行操作
		return cipher.doFinal(data);
	}
	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据
	 * @param key
	 *            密钥
	 * @return String 解密数据
	 * @throws Exception
	 */
	public static String decrypt(String data, byte[] key) throws Exception {
		return new String(decrypt(data.getBytes(ENCODING), key), ENCODING);
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 还原密钥
		Key k = toKey(key);
		// 实例化
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// 初始化，设置为加密模式
		cipher.init(Cipher.ENCRYPT_MODE, k);
		// 执行操作
		return cipher.doFinal(data);
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return String 加密数据
	 * @throws Exception
	 */
	public static String encrypt(String data, byte[] key) throws Exception {
		return new String(encrypt(data.getBytes(ENCODING), key), ENCODING);
	}

	/**
	 * 生成密钥 <br>
	 *
	 * @return byte[] 二进制密钥
	 * @throws Exception
	 */
	public static byte[] initKey(byte...seed) throws Exception {
		// 实例化密钥生成器
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		SecureRandom secureRandom = null;
        if (seed != null && seed.length > 0) {
            secureRandom = new SecureRandom(seed);
        } else {
            secureRandom = new SecureRandom();
        }
		// 初始化密钥生成器
//		kg.init(64);
		kg.init(secureRandom);
		// 生成秘密密钥
		SecretKey secretKey = kg.generateKey();
		// 获得密钥的二进制编码形式
		return secretKey.getEncoded();
	}

	// ********************************************************************
	//	private method
	// ********************************************************************

	/*
	 * 转换密钥
	 *
	 * @param key
	 *            二进制密钥
	 * @return Key 密钥
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		// 实例化DES密钥材料
		DESKeySpec dks = new DESKeySpec(key);
		// 实例化秘密密钥工厂
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(KEY_ALGORITHM);
		// 生成秘密密钥
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}
}
