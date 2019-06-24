
package cn.featherfly.common.algorithm;

import java.security.Provider;
import java.security.Security;

/**
 * <p>
 * 加解密算法
 * </p>
 *
 * @author zhongj
 */
public abstract class Algorithm {

//	private static final Logger LOGGER = LoggerFactory.getLogger(Algorithm.class);

	static {
		// 添加BouncyCastle实现
        try {
            // 使用反射可以处理没有添加BouncyCastleProvider实现JAR包时，这里出错的问题
            Provider provider = (Provider) Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider").newInstance();
            Security.addProvider(provider);
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e) {            
        }
//		Security.addProvider(new BouncyCastleProvider());
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
