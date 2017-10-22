package cn.tedu.ttms.sys.utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;





/**
 * hash值计算共通类。
 * <p>
 * java.security.MessageDigest使用、文字列的hash值取得。<br>
 * 使用MD5、SHA1算法取得。<br>
 * <strong>使用例</strong><br>
 * <code><pre>  
 *    ・・・    
 *    // DB中登录的用户密码的hash值计算。     
 *    byte[] hash = HashUtil.hashMD5(userPassword); 
 *    ・・・  
 *  </pre></code>
 * </p>
 * 
 */
public class HashUtil {

//	/**
//	 * 使用指定的算法，文字列的hash值取得。
//	 * 
//	 * @param algorithm
//	 *            hash算法
//	 * @param str
//	 *            取得hash值的文字列
//	 * 
//	 * @return hash值
//	 * @throws NoSuchAlgorithmException
//	 *             hash算法不正确时抛出异常
//	 * @throws UnsupportedEncodingException 
//	 */
//
//	//algorithm:算法名称    str:是进行加密的字符串
//	public static byte[] hash(String algorithm, String str)
//			throws NoSuchAlgorithmException, UnsupportedEncodingException {
//
//		if (algorithm == null || str == null) {
//			return null;
//		}
//
//		//MessageDigest类为应用程序提供信息摘要算法的功能，如MD5或SHA算法
//		MessageDigest md = MessageDigest.getInstance(algorithm.toUpperCase());
//		//返回hash值
//		return md.digest(str.getBytes("UTF-8"));   
//	}
//
//	/**
//	 * 使用MD5算法文字列的hash值取得。
//	 * 
//	 * @param str
//	 *            取得hash值的文字列
//	 * @return hash值
//	 */
//	public static byte[] hashMD5(String str) {
//		try {
//			return hash(Constant.KEY_MD5, str);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	/**
//	 * 使用SHA1算法文字列的hash值取得。
//	 * 
//	 * @param str
//	 *            取得hash值的文字列
//	 * @return hash值
//	 */
//	public static byte[] hashSHA1(String str) {
//		try {
//			return hash("SHA1", str);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
	

	/**
	 * 使用MD5算法对字符串进行加密
	 * 
	 * @param str
	 *            取得hash值的文字列
	 * @return hash值
	 */
	public static String hashMD5Base64(String str) {
		byte[] md5=DigestUtils.md5(Constant.SALT+str);
		byte[] chs= Base64.encodeBase64(md5);
		return new String(chs);
	}

	/**
	 * 使用SHA1算法对字符串进行加密
	 * 
	 * @param str
	 *            取得hash值的文字列
	 * @return hash值
	 */
	public static String hashSHA1Base64(String str) {
		byte[] sha=DigestUtils.sha1(Constant.SALT+str);
		byte[] chs= Base64.encodeBase64(sha);
		return new String(chs);
	}
}
