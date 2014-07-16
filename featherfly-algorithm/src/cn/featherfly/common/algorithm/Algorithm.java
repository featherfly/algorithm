
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

	public static String toHexString(byte b[]) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < b.length; j++) {
            sb.append(Integer.toHexString((int)((b[j]>>4)&0x0f)));
            sb.append(Integer.toHexString((int)(b[j]&0x0f)));
        }
        return sb.toString();
    }
}
