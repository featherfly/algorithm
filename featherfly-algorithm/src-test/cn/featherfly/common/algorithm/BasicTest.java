
package cn.featherfly.common.algorithm;

import static org.testng.Assert.*;

import java.security.KeyPair;

import org.testng.annotations.Test;


/**
 * <p>
 * Base64Test
 * </p>
 * 
 * @author 钟冀
 */
@Test
public class BasicTest {

	@Test
	public void testBase64() throws Exception {
		String src = "123";
		String target = "MTIz";
		assertEquals(Base64.encodeToString(src), target);
		assertEquals(Base64.decodeToString(target), src);
	}
	@Test
	public void testMD5() throws Exception {
		String src = "123";
		String target = "202cb962ac59075b964b07152d234b70";
		assertEquals(MD5.encode(src), target);
		assertEquals(MD5.encode(src).length(), 32);
	}
	@Test
	public void testSHA() throws Exception {
		String src = "123";
		String target = "40bd001563085fc35165329ea1ff5c5ecbdbbeef";
		assertEquals(SHA.encode(src), target);
		assertEquals(SHA.encode(src).length(), 40);
		
		target = "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3";
		assertEquals(SHA.encode256(src), target);
		assertEquals(SHA.encode256(src).length(), 64);
		
		target = "3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2";
		assertEquals(SHA.encode512(src), target);
		assertEquals(SHA.encode512(src).length(), 128);
	}
	
	@Test
	public void testDES() throws Exception {
		String src = "DES";
		byte[] key = DES.initKey();
		String target = DES.encryptToString(src, key);
		assertEquals(DES.decryptToString(target, key), src);
	}
	@Test
	public void testAES() throws Exception {
		String src = "AES";
		byte[] key = AES.initKey();
		String target = AES.encryptToString(src, key);
		assertEquals(AES.decryptToString(target, key), src);
	}
	@Test
	public void testRSA() throws Exception {
		String src = "RSA";				
		KeyPair kp =  RSA.initKeyPair();
		byte[] privateKey = kp.getPrivate().getEncoded();
		byte[] publicKey = kp.getPublic().getEncoded();
		byte[] srcBytes = src.getBytes(RSA.ENCODING);
		
//		System.out.println("private : " + Base64.encodeToString(kp.getPrivate().getEncoded()));
//		System.out.println("public : " + Base64.encodeToString(kp.getPublic().getEncoded()));
		
		String target = RSA.encryptByPrivateKeyToString(src, privateKey);
		byte[] targetBytes = RSA.encryptByPrivateKey(srcBytes, privateKey);
		//System.out.println("private key encrypt, public key decrypt");
		
		assertEquals(RSA.decryptByPublicKeyToString(target, publicKey), src);
		assertEquals(RSA.decryptByPublicKey(targetBytes, publicKey), srcBytes);
		
//		System.out.println("public key encrypt, private key decrypt");
		
		target = RSA.encryptByPublicKeyToString(src, publicKey);
		targetBytes = RSA.encryptByPublicKey(srcBytes, publicKey);
		
		assertEquals(RSA.decryptByPrivateKeyToString(target, privateKey), src);
		assertEquals(RSA.decryptByPrivateKey(targetBytes, privateKey), srcBytes);
		
				
		byte[] sign = RSA.sign(srcBytes, privateKey);
		
		assertTrue(RSA.verify(srcBytes, publicKey, sign));
			
	}
	
	
}
