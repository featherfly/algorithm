package cn.featherfly.common.algorithm;

/**
 * Base64组件
 *
 * @author 钟冀
 */
public abstract class Base64 extends Algorithm{

	/**
	 * Base64编码
	 *
	 * @param data 待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static byte[] encode(byte[] data) throws Exception {
		// 执行编码
		return org.bouncycastle.util.encoders.Base64.encode(data);
	}

	/**
	 * Base64编码
	 *
	 * @param data 待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		return new String(encode(data.getBytes(ENCODING)), ENCODING);
	}

	/**
	 * Base64解码
	 *
	 * @param data 待解码数据
	 * @return String 解码数据
	 * @throws Exception
	 */
	public static byte[] decode(byte[] data) throws Exception {
		// 执行解码
		return org.bouncycastle.util.encoders.Base64.decode(data);
	}

	/**
	 * Base64解码
	 *
	 * @param data 待解码数据
	 * @return String 解码数据
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		return new String(decode(data.getBytes(ENCODING)), ENCODING);
	}
}
