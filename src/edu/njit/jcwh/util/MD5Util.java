package edu.njit.jcwh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Viking
 * Md5加密工具 用于机密存入数据库的密码
 *
 */
public class MD5Util {
	public static String md5Encode(String str) {

		StringBuffer buf = new StringBuffer();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			
			md5.update(str.getBytes());

			byte bytes[] = md5.digest();

			for (int i = 0; i < bytes.length; i++) {

				String s = Integer.toHexString(bytes[i] & 0xff);

				if (s.length() == 1) {

					buf.append("0");
				}
				buf.append(s);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}
	
	
}
