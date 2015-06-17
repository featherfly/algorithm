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
     * @return byte[] 编码数据
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
     * @return byte[] 编码数据
     * @throws Exception
     */
    public static byte[] encode(String data) throws Exception {
        return encode(data.getBytes(ENCODING));
    }

    /**
     * Base64编码
     *
     * @param data 待编码数据
     * @return String 编码数据
     * @throws Exception
     */
    public static String encodeToString(byte[] data) throws Exception {
        return new String(encode(data), ENCODING);
    }
    /**
     * Base64编码
     *
     * @param data 待编码数据
     * @return String 编码数据
     * @throws Exception
     */
    public static String encodeToString(String data) throws Exception {
        return encodeToString(data.getBytes(ENCODING));
    }

    /**
     * Base64解码
     *
     * @param data 待解码数据
     * @return byte[] 解码数据
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
     * @return byte[] 解码数据
     * @throws Exception
     */
    public static byte[] decode(String data) throws Exception {
        return decode(data.getBytes(ENCODING));
    }
    /**
     * Base64解码
     *
     * @param data 待解码数据
     * @return String 解码数据
     * @throws Exception
     */
    public static String decodeToString(byte[] data) throws Exception {
        return new String(decode(data), ENCODING);
    }
    /**
     * Base64解码
     *
     * @param data 待解码数据
     * @return String 解码数据
     * @throws Exception
     */
    public static String decodeToString(String data) throws Exception {
        return decodeToString(data.getBytes(ENCODING));
    }
}
