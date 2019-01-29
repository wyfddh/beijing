package com.tj720.mip.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {

	String url;
	int port;
	String userName;
	String passWord;

	public FtpUtil(String url, int port, String userName, String passWord) {
		super();
		this.url = url;
		this.port = port;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * ftp上传文件
	 * 
	 * @param url
	 *            ftp地址
	 * @param port
	 *            ftp端口
	 * @param userName
	 *            登录名
	 * @param passWord
	 *            密码
	 * @param path
	 *            ftp服务器文件存放路径
	 * @param fileName
	 *            上传之后文件名称
	 * @param file
	 *            文件流
	 * @return true 成功,false 失败
	 */
	public boolean uploadFtpFile(String path, String fileName, InputStream file) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);// 连接
			ftp.login(userName, passWord);// 登录
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			int replyCode = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				ftp.disconnect();
				return success;
			}
			// 创建文件夹
			String[] dirs = path.replace(File.separator, "/").split("/");
			if (dirs != null && dirs.length > 0)// 目录路径都为英文,故不需要转码
				for (String dir : dirs) {
					ftp.makeDirectory(dir);
					ftp.changeWorkingDirectory(dir);
				}
			ftp.storeFile(new String(fileName.getBytes("UTF-8"), "iso-8859-1"), file);
			file.close();
			ftp.logout();
			success = true;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}

	/**
	 * ftp删除文件
	 * 
	 * @param url
	 *            ftp地址
	 * @param port
	 *            ftp端口
	 * @param userName
	 *            登录名
	 * @param passWord
	 *            密码
	 * @param path
	 *            ftp服务器文件存放路径
	 * @return true 成功,false 失败
	 */
	public boolean delFtpFile(String path) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);// 连接
			ftp.login(userName, passWord);// 登录
			int replyCode = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				ftp.disconnect();
				return success;
			}
			String fileName = path.substring(path.lastIndexOf("/") + 1);
			ftp.changeWorkingDirectory(path.substring(0, path.lastIndexOf("/")));
			ftp.deleteFile(new String(fileName.getBytes("UTF-8"), "iso-8859-1"));
			ftp.logout();
			success = true;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}

	/**
	 * 从ftp服务器上下载文件流到outputStream中
	 * 
	 * @param path
	 *            ftp存放路径
	 * @param out
	 *            文件输出流
	 * @return true成功，false失败
	 */
	public boolean downFtpFile(String path, OutputStream out) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			ftp.setControlEncoding("UTF-8");
			ftp.connect(this.getUrl(), Integer.valueOf(port));// 连接
			ftp.login(userName, passWord);// 登录ftp
			int replyCode = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				ftp.disconnect();
				return success;
			}
			path = path.replace("\\", "/");
			String fileName = path.substring(path.lastIndexOf("/") + 1);
			ftp.changeWorkingDirectory(path.substring(0, path.lastIndexOf("/")));
			ftp.retrieveFile(new String(fileName.getBytes("UTF-8"), "iso-8859-1"), out);
			ftp.logout();
			success = true;
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}

	public void getFlow(String path, HttpServletResponse response) throws Exception {
		String dbpath = path;
		response.setContentType("image/jpeg;charset=utf-8");

		OutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
			downFtpFile(dbpath, outputStream);
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
