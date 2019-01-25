package com.example.wwq.wxcode.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 
* <p>Title: WxCheck</p>  
* <p>Description: 微信基本配置的服务器验证工具</p>  
* @author hys  
* @date 2018年10月11日
 */
public class WxCheckUtil {
	private static final String token = "wwq8888";
	
	public static boolean checkSignature(String signature, String timestamp,String nonce) {
		
        // 将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);

        // 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
            System.out.println("tmpStr:"+tmpStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }
	
	/**
	 * 
	 * <p>Title: byteToStr</p>  
	 * <p>Description: 将字节数组转为十六进制字符串</p>  
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            strDigest.append(byteToHexStr(byteArray[i]));
        }
        return strDigest.toString();
    }
	
	/**
	 * 
	 * <p>Title: byteToHexStr</p>  
	 * <p>Description: 将字节转换为十六进制字符串</p>  
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

}
