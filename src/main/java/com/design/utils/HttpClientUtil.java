package com.design.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

/**
 * 分装一个http请求的工具类
 * 
 */
public class HttpClientUtil {
	
	
	/**
	 * POST方式调用
	 * 
	 * @param url
	 * @param params
	 *            参数为NameValuePair键值对对象
	 * @return 响应字符串
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static String executeByPOST(String url) {
		String output="",output_="";
		try {
			URL targetUrl = new URL(url);

			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl
					.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type",
					"application/json");

			String input = "{\"id\":1,\"firstName\":\"Liam\",\"age\":22,\"lastName\":\"Marco\"}";

			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			
			System.out.println("Output from Server:  \n");
			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
				output_=output_+output;
			}

			httpConnection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return output_;

	}

	/**
	 * Get方式请求
	 * 
	 * @param url
	 *            带参数占位符的URL，例：http://ip/User/user/center.aspx?_action=
	 *            GetSimpleUserInfo&codes={0}&email={1}
	 * @param params
	 *            参数值数组，需要与url中占位符顺序对应
	 * @return 响应字符串
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static String executeByGET(String url, Object[] params) {
		String output="",output_="";
		try {
			String messages = MessageFormat.format(url, params);
			URL restServiceURL = new URL(messages);

			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL
					.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException(
						"HTTP GET Request Failed with Error code : "
								+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			
			System.out.println("Output from Server:  \n");

			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
				output_=output_+output;
			}

			httpConnection.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return output_;
	}

	/**
	 * @param url
	 * @return
	 */
	public static String executeByGET(String url) {
		String output="",output_="";
		try {
			URL restServiceURL = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL
					.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException(
						"HTTP GET Request Failed with Error code : "
								+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream()), "UTF-8"));

			
			System.out.println("Output from Server:  \n");

			while ((output = responseBuffer.readLine()) != null) {
				output_=output_+output;
			}
			httpConnection.disconnect();
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return output_;
	}

}
