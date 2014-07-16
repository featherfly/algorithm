package cn.featherfly.common.algorithm;

import java.security.MessageDigest;


/**
 * <p>
 * SHA安全编码组件
 * </p>
 * 
 * @author 钟冀
 */
public abstract class SHA extends Algorithm {
	/**
	 * SHA-1加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encode(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA");
		// 执行消息摘要
		return md.digest(data);
	}
	/**
	 * SHA-1加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		return toHexString(encode(data.getBytes(ENCODING)));
	}


	/**
	 * SHA-256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encode256(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		// 执行消息摘要
		return md.digest(data);
	}
	
	/**
	 * SHA-256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encode256(String data) throws Exception {
		return toHexString(encode256(data.getBytes(ENCODING)));
	}

	/**
	 * SHA-384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encode384(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-384");

		// 执行消息摘要
		return md.digest(data);
	}
	/**
	 * SHA-384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encode384(String data) throws Exception {
		return toHexString(encode384(data.getBytes(ENCODING)));
	}

	/**
	 * SHA-512加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encode512(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		// 执行消息摘要
		return md.digest(data);
	}
	/**
	 * SHA-512加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encode512(String data) throws Exception {
		return toHexString(encode512(data.getBytes(ENCODING)));
	}
}
