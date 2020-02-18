package cn.featherfly.common.algorithm;

import java.security.MessageDigest;

/**
 * MD加密组件
 *
 * @author zhongj
 */
public abstract class MD5 extends Algorithm{

	/**
	 * MD5加密
	 *
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 *
	 * @throws Exception
	 */
	public static byte[] encode(byte[] data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 执行消息摘要
		return md.digest(data);
	}
	/**
	 * MD5加密
	 *
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 *
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 执行消息摘要
		return toHexString(md.digest(data.getBytes(ENCODING)));
	}
}
