package cn.featherfly.common.algorithm;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES安全编码组件
 * 
 * @author 钟冀
 */
public abstract class AES extends Algorithm{

	/**
	 * 密钥算法
	 */
	public static final String KEY_ALGORITHM = "AES";

	/**
	 * 加密/解密算法 / 工作模式 / 填充方式 
	 */
	public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	/**
	 * 解密
	 * 
	 * @param data 待解密数据
	 * @param key 密钥
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
	 *            待解密数据，使用encryptToString加密的字符串
	 * @param key
	 *            密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(String data, byte[] key) throws Exception {
		return decrypt(Base64.decode(data), key);
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
	public static String decryptToString(byte[] data, byte[] key) throws Exception {
		return new String(decrypt(data, key), ENCODING);
	}
	/**
	 * 解密
	 *
	 * @param data
	 *            待解密数据，使用encryptToString加密的字符串
	 * @param key
	 *            密钥
	 * @return String 解密数据
	 * @throws Exception
	 */
	public static String decryptToString(String data, byte[] key) throws Exception {		
		return decryptToString(Base64.decode(data), key);
	}

	/**
	 * 加密
	 * 
	 * @param data 待加密数据
	 * @param key 密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 还原密钥
		Key k = toKey(key);
		/*
		 * 实例化 
		 */
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
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(String data, byte[] key) throws Exception {
		return encrypt(data.getBytes(ENCODING), key);
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
	public static String encryptToString(byte[] data, byte[] key) throws Exception {		
		return Base64.encodeToString(encrypt(data, key));
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
	public static String encryptToString(String data, byte[] key) throws Exception {
		return encryptToString(data.getBytes(ENCODING), key);
	}
		
	/**
	 * 生成密钥 <br>
	 * 
	 * @return byte[] 二进制密钥
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception {
		// 实例化
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		// AES 要求密钥长度为 128位、192位或 256位
//		kg.init(256); 256为KEY没搞定
		kg.init(128);
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
	 * @param key 二进制密钥
	 * @return Key 密钥
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		// 实例化AES密钥材料
		SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
		return secretKey;
	}
}
