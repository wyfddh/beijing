package com.tj720.mip.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.net.util.Base64;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.tj720.mip.model.PictureSearchConfig;

public class PictureSearchUtil {
    static int SSF_SIGNATURE_LEN = 32;
    static String SSF_CLIENT_API = "https://api.productai.cn";
    static String SSF_CLIENT_VERSION = "1";
    static String request_method="post";
    static String pai_user_id="1762";
    static String secret_key="6728cfe15947d2b5413b14e6ab115069";
    static String access_key_id="7dd823e4b75fcef0e07f78bc90c08b48";
    static String image_set_id="k8db5xq1";//"k1vl7dzw";
    static String service_id="jslhduud";//"lzsiqi6s";
    public static void setConfig(PictureSearchConfig searchConfig){
    	PictureSearchUtil.SSF_SIGNATURE_LEN=searchConfig.getSsfSignatureLen();
    	PictureSearchUtil.SSF_CLIENT_API=searchConfig.getSsfClientApi();
    	PictureSearchUtil.SSF_CLIENT_VERSION=searchConfig.getSsfClientVersion();
    	PictureSearchUtil.request_method=searchConfig.getRequestMethod();
    	PictureSearchUtil.pai_user_id=searchConfig.getPaiUserId();
    	PictureSearchUtil.secret_key=searchConfig.getSecretKey();
    	PictureSearchUtil.access_key_id=searchConfig.getAccessKeyId();
    	PictureSearchUtil.image_set_id=searchConfig.getImageSetId();
    	PictureSearchUtil.service_id=searchConfig.getServiceId();
    }
    public static boolean checkConfig(PictureSearchConfig searchConfig){
    	return PictureSearchUtil.SSF_SIGNATURE_LEN==searchConfig.getSsfSignatureLen()
    	    && PictureSearchUtil.SSF_CLIENT_API.equalsIgnoreCase(searchConfig.getSsfClientApi())
    	    && PictureSearchUtil.SSF_CLIENT_VERSION.equalsIgnoreCase(searchConfig.getSsfClientVersion())
    	    && PictureSearchUtil.request_method.equalsIgnoreCase(searchConfig.getRequestMethod())
    	    && PictureSearchUtil.pai_user_id.equalsIgnoreCase(searchConfig.getPaiUserId())
    	    && PictureSearchUtil.secret_key.equalsIgnoreCase(searchConfig.getSecretKey())
    	    && PictureSearchUtil.access_key_id.equalsIgnoreCase(searchConfig.getAccessKeyId())
    	    && PictureSearchUtil.image_set_id.equalsIgnoreCase(searchConfig.getImageSetId())
    	    && PictureSearchUtil.service_id.equalsIgnoreCase(searchConfig.getServiceId());
    }

    public static String short_uuid(int length) {
        char[] charset = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(charset[(int)(Math.random() * charset.length)]);
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> client_headers(String access_key_id) {
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-ca-accesskeyid", access_key_id);
        headers.put("x-ca-version", SSF_CLIENT_VERSION);
        headers.put("x-ca-timestamp", timestamp);
        headers.put("x-ca-signaturenonce", short_uuid(SSF_SIGNATURE_LEN));
        headers.put("x-ca-signature", "");
        headers.put("requestmethod", "POST");

        return headers;
    }

    public static Map<String, String> client_headers(String access_key_id, String method) {
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-ca-accesskeyid", access_key_id);
        headers.put("x-ca-version", SSF_CLIENT_VERSION);
        headers.put("x-ca-timestamp", timestamp);
        headers.put("x-ca-signaturenonce", short_uuid(SSF_SIGNATURE_LEN));
        headers.put("x-ca-signature", "");
        headers.put("requestmethod", method);

        return headers;
    }

    static boolean check_not_excluded(String key) {
        String[] excluded_keys = {"x-ca-signature"};

        for (int i = 0; i < excluded_keys.length; i++) {
            if (key.equals(excluded_keys[i])) {
                return false;
            }
        }
        return true;
    }

    static String join(ArrayList sort_value) {
        StringBuffer result = new StringBuffer();
        result.append(sort_value.get(0));
        for (int i = 1; i < sort_value.size(); i++) {
            result.append("&" + sort_value.get(i));
        }
        return result.toString();
    }

    public static String client_signature(Map<String, String> headers, Map<String, String> form, String secret_key) throws Exception {
        Map<String, String> calc_params = new HashMap<String, String>(headers);
        calc_params.putAll(form);

        Map<String, String> sorted_calc_params = new TreeMap<String, String>(calc_params);
        Set sorted_keys_set = sorted_calc_params.keySet();

        ArrayList sort_value = new ArrayList();

        Iterator it = sorted_keys_set.iterator();
        while (it.hasNext()) {
            Object key = it.next();
            if (check_not_excluded(""+key)) {
                sort_value.add(key + "=" + calc_params.get(key));
            }
        }

        String string_to_signature = join(sort_value);
        Mac mac = Mac.getInstance("HmacSHA1");
        byte[] keyBytes = secret_key.getBytes("UTF-8");
        SecretKey secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");
        mac.init(secretKey);
        byte[] textBytes = string_to_signature.getBytes("UTF-8");
        Base64 encoder = new Base64();
        String signature = encoder.encodeToString(mac.doFinal(textBytes));

        return signature;
    }


    static String toHex(byte[] byteArray) {
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  
        char[] resultCharArray =new char[byteArray.length * 2];  

        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];  
            resultCharArray[index++] = hexDigits[b& 0xf];  
        }
 
        return new String(resultCharArray);  
    }

    static void configureHttpClient(HttpClientBuilder clientBuilder) {  
        try  
        {  
            SSLContext ctx = SSLContext.getInstance("TLS");    
            X509TrustManager tm = new X509TrustManager()  
            {    
                public void checkClientTrusted(X509Certificate[] chain,  String authType) throws CertificateException   
                {}
                public void checkServerTrusted(X509Certificate[] chain,  String authType) throws CertificateException   
                {}
                public X509Certificate[] getAcceptedIssuers()   
                {    
                    return null;
                }    
            };    
            ctx.init(null, new TrustManager[]{tm}, null);    
            clientBuilder.setSSLContext(ctx);  
        }catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
    }
    
    
    
    
    @SuppressWarnings("deprecation")
	public static String submit_file_to_search(Map<String, String> form, Map<String, String> files) throws Exception {
        Map<String, String> post_form = new HashMap<String, String>();

        String loc = form.get("loc");
        if (loc != null) {
            post_form.put("loc", loc);
        }
        
        String count = form.get("count");
        if (count != null) {
            post_form.put("count", count);
        }
        
        Map<String, String> headers = client_headers(form.get("access_key_id"), form.get("request_method"));
        String signature = client_signature(headers, post_form, form.get("secret_key"));
        headers.put("x-ca-signature", signature);

        // get the MD5 of image and put into headers
        MessageDigest md = MessageDigest.getInstance("MD5");
        String files_search = files.get("search");

        int bufferSize = 256 * 1024;  
        FileInputStream fileInputStream = null;  
        DigestInputStream digestInputStream = null;  
        fileInputStream = new FileInputStream(files_search);  
        digestInputStream = new DigestInputStream(fileInputStream, md);  
        byte[] buffer = new byte[bufferSize];  
        while (digestInputStream.read(buffer) > 0);  
        md = digestInputStream.getMessageDigest();  
        byte[] mdBytes = md.digest();  

        headers.put("x-ca-file-md5", toHex(mdBytes));


        //reqeust:

        String response_content = null;
        
        HttpClientBuilder httpclient_builder = HttpClientBuilder.create();  
        configureHttpClient(httpclient_builder);  
        CloseableHttpClient httpclient = httpclient_builder.build(); 
        
        String post_url = SSF_CLIENT_API + "/" + form.get("service_type") + "/" + form.get("service_id") + "/";
        HttpPost httppost = new HttpPost(post_url);

        // set headers
        for (String key: headers.keySet()) {
            httppost.setHeader(key, headers.get(key));
        }
        
        MultipartEntity reqEntity = new MultipartEntity();
        
        //set files: upload the image
        FileBody bin = new FileBody(new File(files_search));
        reqEntity.addPart("search", bin);
        
        //set data
        for (String key: post_form.keySet()) {
            reqEntity.addPart(key, new StringBody(post_form.get(key)));  
        }
        
        httppost.setEntity(reqEntity);

        try {
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {   
                    response_content = EntityUtils.toString(entity, "UTF-8");  
                }
            } 
            finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
        finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }

       return response_content;
    }

    public static String submit_form_to_search(Map<String, String> form) throws Exception {
        Map<String, String> post_form = new HashMap<String, String>();

        String loc = form.get("loc");
        if (loc != null) {
                post_form.put("loc", loc);
        }

        String url = form.get("image_url");
        if (url != null) {
                post_form.put("url", url);
        }

        Map<String, String> headers = client_headers(form.get("access_key_id"), form.get("request_method"));
        String signature = client_signature(headers, post_form, form.get("secret_key"));
        headers.put("x-ca-signature", signature);

        
        //reqeust:

        String response_content = null;

        HttpClientBuilder httpclient_builder = HttpClientBuilder.create();  
        configureHttpClient(httpclient_builder);  
        CloseableHttpClient httpclient = httpclient_builder.build(); 
        
        String post_url = SSF_CLIENT_API + "/" + form.get("service_type") + "/" + form.get("service_id") + "/";
        HttpPost httppost = new HttpPost(post_url);

        // set headers
        for (String key: headers.keySet()) {
            httppost.setHeader(key, headers.get(key));
        }

        // set data
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        for (String key: post_form.keySet()) {
            formParams.add(new BasicNameValuePair(key, post_form.get(key)));  
        }
        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");  
        httppost.setEntity(uefEntity); 

        try {
            CloseableHttpResponse response = httpclient.execute(httppost);  
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {   
                    response_content = EntityUtils.toString(entity, "UTF-8");  
                } 
            }
            finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }

       return response_content;
    }

    public static String add_image_to_image_set(Map<String, String> form) throws Exception {
        String request_method = "post";
        String acces_key_id = form.get("access_key_id");
        String secret_key = form.get("secret_key");
        String service_type = "image_sets";
        String service_id = "_0000014";
        String image_url = form.get("image_url");
        String image_set_id = form.get("image_set_id");
        String pai_user_id = form.get("pai_user_id");
        
        String meta = "";
        if (form.get("meta") != null) {
            meta = form.get("meta");
        }

        Map<String, String> post_form = new HashMap<String, String>();
        post_form.put("image_url", image_url);
        post_form.put("meta", meta);
        String api_url = SSF_CLIENT_API + "/" + service_type + "/_0000014/" + image_set_id;
        Map<String, String> headers = client_headers(acces_key_id, request_method);
        String signature = client_signature(headers, post_form, secret_key);
        headers.put("x-ca-signature", signature);
        headers.put("pai_user_id", pai_user_id);

        //request:

        String response_content = null;

        HttpClientBuilder httpclient_builder = HttpClientBuilder.create();  
        configureHttpClient(httpclient_builder);  
        CloseableHttpClient httpclient = httpclient_builder.build(); 
        
        HttpPost httppost = new HttpPost(api_url);

        // set headers
        for (String key: headers.keySet()) {
            httppost.setHeader(key, headers.get(key));
        }

        // set data
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        for (String key: post_form.keySet()) {
            formParams.add(new BasicNameValuePair(key, post_form.get(key)));  
        }
        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");  
        httppost.setEntity(uefEntity); 

        try {  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {   
                    response_content = EntityUtils.toString(entity, "UTF-8");  
                } 
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }

        return response_content;
    }

	@SuppressWarnings("deprecation")
	public static String delete_image_by_file(String filename) throws Exception {
        String request_method = PictureSearchUtil.request_method;
        String access_key_id = PictureSearchUtil.access_key_id;
        String secret_key = PictureSearchUtil.secret_key;
        String service_type = "image_sets";
        String service_id = PictureSearchUtil.service_id;
        String image_set_id = PictureSearchUtil.image_set_id;
        String pai_user_id = PictureSearchUtil.pai_user_id;
        String file_path = filename;
        
        String api_url = SSF_CLIENT_API + "/" + service_type + "/_0000014/" + image_set_id;
        Map<String, String> headers = client_headers(access_key_id, request_method);
        String signature = client_signature(headers, new HashMap<String, String>(), secret_key);
        headers.put("x-ca-signature", signature);
        headers.put("pai_user_id", pai_user_id);
        
        // request:
        
        String response_content = null;
        
        HttpClientBuilder httpclient_builder = HttpClientBuilder.create();  
        configureHttpClient(httpclient_builder);  
        CloseableHttpClient httpclient = httpclient_builder.build(); 
          
        HttpPost httppost = new HttpPost(api_url);

        // set headers
        for (String key: headers.keySet()) {
            httppost.setHeader(key, headers.get(key));
        }
        
        MultipartEntity reqEntity = new MultipartEntity();
        
        //set files: upload the csv file
        FileBody bin = new FileBody(new File(file_path));
        reqEntity.addPart("urls_to_delete", bin);
        
        httppost.setEntity(reqEntity);
        
        try {
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {
                HttpEntity entity = response.getEntity();  
                if (entity != null) {   
                    response_content = EntityUtils.toString(entity, "UTF-8");  
                } 
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }

        return response_content; 
    }
    
    @SuppressWarnings("deprecation")
	public static String add_image_by_file(String filename) throws Exception {
        String request_method = PictureSearchUtil.request_method;
        String access_key_id = PictureSearchUtil.access_key_id;
        String secret_key = PictureSearchUtil.secret_key;
        String service_type = "image_sets";
        String service_id = PictureSearchUtil.service_id;
        String image_set_id = PictureSearchUtil.image_set_id;
        String pai_user_id = PictureSearchUtil.pai_user_id;
        String file_path = filename;
        
        String api_url = SSF_CLIENT_API + "/" + service_type + "/_0000014/" + image_set_id;
        Map<String, String> headers = client_headers(access_key_id, request_method);
        String signature = client_signature(headers, new HashMap<String, String>(), secret_key);
        headers.put("x-ca-signature", signature);
        headers.put("pai_user_id", pai_user_id);
        
        // request:
        
        String response_content = null;
        
        HttpClientBuilder httpclient_builder = HttpClientBuilder.create();  
        configureHttpClient(httpclient_builder);  
        CloseableHttpClient httpclient = httpclient_builder.build(); 
          
        HttpPost httppost = new HttpPost(api_url);

        // set headers
        for (String key: headers.keySet()) {
            httppost.setHeader(key, headers.get(key));
        }
        
        MultipartEntity reqEntity = new MultipartEntity();
        
        //set files: upload the csv file
        FileBody bin = new FileBody(new File(file_path));
        reqEntity.addPart("urls_to_add", bin);
        
        httppost.setEntity(reqEntity);
        
        try {
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {   
                    response_content = EntityUtils.toString(entity, "UTF-8");  
                } 
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }

        return response_content; 
    }
    public static String searchByUrl(String url) throws Exception{
        // use image URL to search
        Map<String, String> form = new HashMap<String, String>();
        form.put("request_method", PictureSearchUtil.request_method);                 // 默认 的请求方法 post
        form.put("service_type", "search");      // require: 你的服务类型 可在 我的服务-测试服务 页面中查看
        form.put("access_key_id", PictureSearchUtil.access_key_id);    // require: 你的用户配置 access_key_id
        form.put("secret_key", PictureSearchUtil.secret_key);          // require: 你的用户配置 secret_key
        form.put("service_id", PictureSearchUtil.service_id);          // require: 你的服务ID
        form.put("image_url", url);//"http://file.net.tj720.com/back/picture/640x426_9a3bcb2919474c19993e49958f7b9ec7.JPG");            // require: 你的测试图片链接地址
        //form.put("loc", "0-0-1-1");                         // option: (选填)图片标框的位置信息
        
        String response_content = submit_form_to_search(form);
//        System.out.println(response_content);
        return response_content;
    }
    public static String searchByFile(String filename) throws Exception{
        // use image URL to search
        Map<String, String> form = new HashMap<String, String>();
        Map<String, String> files = new HashMap<String, String>();
        form.put("request_method", PictureSearchUtil.request_method);                 // 默认 的请求方法 post
        form.put("service_type", "search");      // require: 你的服务类型 可在 我的服务-测试服务 页面中查看
        form.put("access_key_id", PictureSearchUtil.access_key_id);    // require: 你的用户配置 access_key_id
        form.put("secret_key", PictureSearchUtil.secret_key);          // require: 你的用户配置 secret_key
        form.put("service_id", PictureSearchUtil.service_id);          // require: 你的服务ID
        files.put("search", filename);   // require: 你的本地图片的路径
        //form.put("loc", "0-0-1-1");                         // option: (选填)图片标框的位置信息
        
        String response_content = submit_file_to_search(form, files);
//        System.out.println(response_content);
        return response_content;
    }
//    public static void reset throws Exception{
//        // use image URL to search
//        Map<String, String> form = new HashMap<String, String>();
//        form.put("request_method", PictureSearchUtil.request_method);                 // 默认 的请求方法 post
//        form.put("service_type", PictureSearchUtil.service_type);      // require: 你的服务类型 可在 我的服务-测试服务 页面中查看
//        form.put("access_key_id", PictureSearchUtil.access_key_id);    // require: 你的用户配置 access_key_id
//        form.put("secret_key", PictureSearchUtil.secret_key);          // require: 你的用户配置 secret_key
//        form.put("service_id", PictureSearchUtil.service_id);          // require: 你的服务ID
//        form.put("image_url", url);//"http://file.net.tj720.com/back/picture/640x426_9a3bcb2919474c19993e49958f7b9ec7.JPG");            // require: 你的测试图片链接地址
//        //form.put("loc", "0-0-1-1");                         // option: (选填)图片标框的位置信息
//        
//        String response_content = submit_form_to_search(form);
//        System.out.println(response_content);
//        return response_content;
//    }
    public static void main(String[] args) throws Exception {
        // please alter to your setting
        // 请配置你的服务配置
        
        // use image URL to search
        Map<String, String> form = new HashMap<String, String>();
        form.put("request_method", PictureSearchUtil.request_method);                 // 默认 的请求方法 post
        form.put("service_type", "search");      // require: 你的服务类型 可在 我的服务-测试服务 页面中查看
        form.put("access_key_id", PictureSearchUtil.access_key_id);    // require: 你的用户配置 access_key_id
        form.put("secret_key", PictureSearchUtil.secret_key);          // require: 你的用户配置 secret_key
        form.put("service_id", PictureSearchUtil.service_id);          // require: 你的服务ID
        form.put("image_url", "http://file.wwsdw.org/picture/shandongnew/37011221600011/00005421/thumb/640x426_3701122160001100005421-D-0001.jpg");            // require: 你的测试图片链接地址
        //form.put("loc", "0-0-1-1");                         // option: (选填)图片标框的位置信息
        
        String response_content = submit_form_to_search(form);
        System.out.println(response_content);

    /*    
        // upload image to search
        Map<String, String> form = new HashMap<String, String>();
        Map<String, String> files = new HashMap<String, String>();
        form.put("request_method", PictureSearchUtil.request_method);                 // 默认 的请求方法 post
        form.put("service_type", "search");      // require: 你的服务类型 可在 我的服务-测试服务 页面中查看
        form.put("access_key_id", PictureSearchUtil.access_key_id);    // require: 你的用户配置 access_key_id
        form.put("secret_key", PictureSearchUtil.secret_key);          // require: 你的用户配置 secret_key
        form.put("service_id", PictureSearchUtil.service_id);          // require: 你的服务ID
        files.put("search", "G:/A-0001.jpg");   // require: 你的本地图片的路径
        //form.put("loc", "0-0-1-1");                         // option: (选填)图片标框的位置信息
        //form.put("count", "1");                             // option: (选填) 设置总数限制

        String response_content = submit_file_to_search(form, files);
        System.out.println(response_content);
    */


    /*    
        // add a new image to image_set for search
        Map<String, String> form = new HashMap<String, String>();
        form.put("request_method", "post");                 // 默认 的请求方法 post
        form.put("access_key_id", "your_access_key_id");    // require: 你的用户配置 access_key_id
        form.put("secret_key", "your_secret_key");          // require: 你的用户配置 secret_key
        form.put("pai_user_id", "your_user_id");            // require: 你的用户ID
        form.put("image_set_id", "your_image_set_id");      // require: 你的数据集ID
        form.put("image_url", "your_image_url");            // require: 你的测试图片链接
        //form.put("meta", "your_message");                 // option: (选填)附加信息

        String response_content = add_image_to_image_set(form);
        System.out.println(response_content);
    */
    
    /*
        // delete some images
        Map<String, String> form = new HashMap<String, String>();
        form.put("access_key_id", "your_access_key_id");        // require: 你的用户配置 access_key_id
        form.put("secret_key", "your_secret_key");              // require: 你的用户配置 secret_key
        form.put("pai_user_id", "your_user_id");                // require: 你的用户ID
        form.put("image_set_id", "your_image_set_id");          // require: 你的数据集ID 
        form.put("file_path", "some_paths/your_csv_file.csv");  // require: 你的CSV文件的路径
        
        String response_content = delete_image_by_file(form);
        System.out.println(response_content);
    */

    /*
        // add some images
        Map<String, String> form = new HashMap<String, String>();
        form.put("access_key_id", "your_access_key_id");        // require: 你的用户配置 access_key_id
        form.put("secret_key", "your_secret_key");              // require: 你的用户配置 secret_key
        form.put("pai_user_id", "your_user_id");                // require: 你的用户ID
        form.put("image_set_id", "your_image_set_id");          // require: 你的数据集ID
        form.put("file_path", "some_paths/your_csv_file.csv");  // require: 你的CSV文件的路径
        
        String response_content = add_image_by_file(form);
        System.out.println(response_content);
    */
    }
}  
