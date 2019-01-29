package com.tj720.admin.common.util;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 
 * @author zwp
 * @date 2017年6月20日 上午11:55:06
 */
public class CryptUtils {
	static final String algorithmStr = "AES/ECB/PKCS5Padding";
	public static final String CRYPT_PASSWORD_NO_LOGIN = "882F6147AFC1D200";
	public static String password = "03B2EC722BC3F652"; 
	public static String getAESPassword(){
		password = StringUtils.isEmpty(password) ? getMD5For16(System.currentTimeMillis() + "daydyauplcm!@") : password;
		return password;
	}
    private static byte[] encrypt(String content, String password) {
        try {
            byte[] keyStr = getKey(password);
            SecretKeySpec key = new SecretKeySpec(keyStr, "AES");
            Cipher cipher = Cipher.getInstance(algorithmStr);//algorithmStr          
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);//   ʼ  
            byte[] result = cipher.doFinal(byteContent);
            return result; //     
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
  
    private static byte[] decrypt(byte[] content, String password) {
        try {
            byte[] keyStr = getKey(password);
            SecretKeySpec key = new SecretKeySpec(keyStr, "AES");
            Cipher cipher = Cipher.getInstance(algorithmStr);//algorithmStr           
            cipher.init(Cipher.DECRYPT_MODE, key);//   ʼ  
            byte[] result = cipher.doFinal(content);
            return result; //     
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
     
    private static byte[] getKey(String password) {
        byte[] rByte = null;
        if (password!=null) {
            rByte = password.getBytes();
        }else{
            rByte = new byte[24];
        }
        return rByte;
    }
 
    /**
     * 将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
 
    /**
     * 将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null; 
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
     
    //注意: 这里的password(秘钥必须是16位的)
   
     
	
    /**
     *加密
     */
     public static String encode(String content){
    	 if(StringUtils.isEmpty(content)) return null;
    	 //加密之后的字节数组,转成16进制的字符串形式输出
    	 password = Utils.isEmpty(password) ? getMD5For16(System.currentTimeMillis() + "daydyauplcm!@") : password;
         return parseByte2HexStr(encrypt(content, password));
     }
     public static String encode(String content, String password) {
    	 if(Utils.isEmpty(content) || Utils.isEmpty(password)) return null;
    	 return parseByte2HexStr(encrypt(content, password));
     }       
     /**
     *解密
     */
     public static String decode(String content, String password){
    	 if(Utils.isEmpty(content) || Utils.isEmpty(password)) return null;
         //解密之前,先将输入的字符串按照16进制转成二进制的字节数组,作为待解密的内容输入
         byte[] b = decrypt(parseHexStr2Byte(content), password);
         return new String(b);
     }
     /**
      *解密
      */
      public static String decode(String content){
    	  if(Utils.isEmpty(content)) return null;
          //解密之前,先将输入的字符串按照16进制转成二进制的字节数组,作为待解密的内容输入
    	  password = Utils.isEmpty(password) ? getMD5For16(System.currentTimeMillis() + "daydyauplcm!@") : password;
          byte[] b = decrypt(parseHexStr2Byte(content), password);
          return new String(b);
      } 
      
    //把字符串加密后返回16位的md5
  	public static String getMD5For16(String str){
//  		String md5Str = MD5Util.getMD5(str);
//  		if(!Utils.isEmpty(md5Str)){
//  			return md5Str.substring(8, 24);
//  		}
  		return "5CF89590A2C6D615";
  	}
  	/** 指定加密算法为RSA */
    private static final String ALGORITHM = "RSA";
    static Key privateKey;
    /** 指定私钥存放文件 */
    private static String PRIVATE_KEY_FILE = "PrivateKey";
    /** 指定私钥存放文件 */
    private static String PUBLIC_KEY_FILE = "publicKey";
    
    public static Key getRsaPrivateKey() throws Exception{
    	Key privateKey = null;
    	ObjectInputStream ois = null;
        try {
            /** 将文件中的私钥对象读出 */
        	//String path = new File("").getAbsolutePath() + File.separator + "bin" + File.separator + PRIVATE_KEY_FILE;
        	Resource fileRource = new ClassPathResource(PRIVATE_KEY_FILE); 
        	String path = fileRource.getFile().getPath();
            ois = new ObjectInputStream(new FileInputStream(path));
            privateKey = (Key) ois.readObject();
        } catch (Exception e) {
            throw e;
        }
        finally{
        	if(ois != null)
        		ois.close();
        }
        return privateKey;
    }
    
    public static Key getRsaPublicKey() throws Exception{
    	Key publicKey = null;
    	ObjectInputStream ois = null;
        try {
            /** 将文件中的公钥对象读出 */
        	Resource fileRource = new ClassPathResource(PUBLIC_KEY_FILE); 
        	String path = fileRource.getFile().getPath();
            ois = new ObjectInputStream(new FileInputStream(path));
            publicKey = (Key) ois.readObject();
        } catch (Exception e) {
            throw e;
        }
        finally{
        	if(ois != null)
        		ois.close();
        }
        
        return publicKey;
    }
  	 /**
     * RSA解密算法
     * @param cryptograph    密文
     * @return
     * @throws Exception
     */
    public static String decrypt(String content) throws Exception {
    	if(Utils.isEmpty(content)) return null;
        if(privateKey == null){
        	privateKey = getRsaPrivateKey();
        }
        
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        /*BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        */
        byte[] b1 = Base64Utils.decode(content);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }
    
    /**
     * 加密方法
     * @param source 源数据
     * @return
     * @throws Exception
     */
	public static String encrypt(Key publicKey,String source) throws Exception {
        
    	/** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        //BASE64Encoder encoder = new BASE64Encoder();
       // return encoder.encode(b1);
        return null;
    }

}