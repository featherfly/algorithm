
package cn.featherfly.common.algorithm;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * <p>
 * 加解密算法
 * </p>
 *
 * @author 钟冀
 */
public abstract class Algorithm {

//	private static final Logger LOGGER = LoggerFactory.getLogger(Algorithm.class);

	static {
		// 添加BouncyCastle实现
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * 字符编码
	 */
	public final static String ENCODING = "UTF-8";

	/**
	 * <p>
	 * 转换为16进制的字符串
	 * </p>
	 * @param bytes 字节数组
	 * @return 16进制的字符串
	 */
	public static String toHexString(byte bytes[]) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bytes.length; j++) {
            sb.append(Integer.toHexString((int)((bytes[j]>>4)&0x0f)));
            sb.append(Integer.toHexString((int)(bytes[j]&0x0f)));
        }
        return sb.toString();
    }
}
