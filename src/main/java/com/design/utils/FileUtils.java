package com.design.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * 文件操作工具类
 * 
 * @author XXXX
 * 
 */
public class FileUtils {

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename) {
		return getExtend(filename, "");
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > 0) && (i < (filename.length() - 1))) {
				return (filename.substring(i + 1)).toLowerCase();
			}
		}
		return defExt.toLowerCase();
	}

	/**
	 * 获取文件名称[不含后缀名]
	 * 
	 * @param
	 * @return String
	 */
	public static String getFilePrefix(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex).replaceAll("\\s*", "");
	}

	/**
	 * 获取文件名称[不含后缀名] 不去掉文件目录的空格
	 * 
	 * @param
	 * @return String
	 */
	public static String getFilePrefix2(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex);
	}

	/**
	 * 文件复制 方法摘要：这里一句话描述方法的用途
	 * 
	 * @param
	 * @return void
	 */
	public static void copyFile(String inputFile, String outputFile)
			throws FileNotFoundException, IOException {
		File sFile = new File(inputFile);
		File tFile = new File(outputFile);
		if (!tFile.exists()) {
			tFile.createNewFile();

		}
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(tFile);
		int temp = 0;
		byte[] buf = new byte[10240];
		try {
			while ((temp = fis.read(buf)) != -1) {
				fos.write(buf, 0, temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param inputFile
	 * @param outputFolder
	 * @throws FileNotFoundException
	 */
	public static void copyFileToFolder(String inputFile, String outputFolder)
			throws FileNotFoundException, IOException {
		File sFile = new File(inputFile);
		File folder = new File(outputFolder);
		// outputFolder=outputFolder.replaceAll("\\", "/");
		if (!folder.exists()) {
			folder.mkdir();
		}
		File tFile = new File(outputFolder + "/" + sFile.getName());
		if (!tFile.exists()) {

			tFile.createNewFile();

		}
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(tFile);
		int temp = 0;
		byte[] buf = new byte[10240];
		try {
			while ((temp = fis.read(buf)) != -1) {
				fos.write(buf, 0, temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void copyFileToFolderAndChangeName(String inputFile, String outputFolder,String newName)
			throws FileNotFoundException, IOException {
		
		File sFile = new File(inputFile);
		File folder = new File(outputFolder);
		// outputFolder=outputFolder.replaceAll("\\", "/");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File tFile = new File(outputFolder + "/" + newName);
		if (!tFile.exists()) {

			tFile.createNewFile();

		}
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(tFile);
		int temp = 0;
		byte[] buf = new byte[10240];
		try {
			while ((temp = fis.read(buf)) != -1) {
				fos.write(buf, 0, temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断文件是否为图片<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isPicture(String filename) {
		// 文件名称为空的场合
		if (oConvertUtils.isEmpty(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		// String tmpName = getExtend(filename);
		String tmpName = filename;
		// 声明图片后缀名数组
		String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" },
				{ "gif", "2" }, { "jfif", "3" }, { "jpe", "4" },
				{ "jpeg", "5" }, { "jpg", "6" }, { "png", "7" },
				{ "tif", "8" }, { "tiff", "9" }, { "ico", "10" } };
		// 遍历名称数组
		for (int i = 0; i < imgeArray.length; i++) {
			// 判断单个类型文件的场合
			if (imgeArray[i][0].equals(tmpName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断文件是否为DWG<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isDwg(String filename) {
		// 文件名称为空的场合
		if (oConvertUtils.isEmpty(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		String tmpName = getExtend(filename);
		// 声明图片后缀名数组
		if (tmpName.equals("dwg")) {
			return true;
		}
		return false;
	}

	/**
	 * 删除指定的文件
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public static boolean delete(String strFileName) {
		File fileDelete = new File(strFileName);

		if (!fileDelete.exists() || !fileDelete.isFile()) {
			return false;
		}

		return fileDelete.delete();
	}
	
	
	public static boolean delAllFile(String path) {
	       boolean flag = false;
	       File file = new File(path);
	       if (!file.exists()) {
	         return flag;
	       }
	       if (!file.isDirectory()) {
	         return flag;
	       }
	       String[] tempList = file.list();
	       File temp = null;
	       for (int i = 0; i < tempList.length; i++) {
	          if (path.endsWith(File.separator)) {
	             temp = new File(path + tempList[i]);
	          } else {
	              temp = new File(path + File.separator + tempList[i]);
	          }
	          if (temp.isFile()) {
	             temp.delete();
	          }
	          if (temp.isDirectory()) {
	             delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
	             delFolder(path + "/" + tempList[i]);//再删除空文件夹
	             flag = true;
	          }
	       }
	       return flag;
	     }
	
	
	public static void delFolder(String folderPath) {
	     try {
	        delAllFile(folderPath); //删除完里面所有内容
	        String filePath = folderPath;
	        filePath = filePath.toString();
	        java.io.File myFilePath = new java.io.File(filePath);
	        myFilePath.delete(); //删除空文件夹
	     } catch (Exception e) {
	       e.printStackTrace(); 
	     }
	}
	

	/**
	 * 创建绝对路径(包含多级)
	 * 
	 * @param header
	 *            绝对路径的前半部分(已存在)
	 * @param tail
	 *            绝对路径的后半部分(第一个和最后一个字符不能是/，格式：123/258/456)
	 * @return 新创建的绝对路径
	 */
	public static String makeDir(String header, String tail) {
		String[] sub = tail.split("/");
		File dir = new File(header);
		for (int i = 0; i < sub.length; i++) {
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File dir2 = new File(dir + File.separator + sub[i]);
			if (!dir2.exists()) {
				dir2.mkdirs();
			}
			dir = dir2;
		}
		return dir.toString();
	}
	
	
	public static StringBuffer readTxtFile(File fileName) throws Exception {
		StringBuffer result=new StringBuffer();
		 try {   
	            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));   
	            String line = null;  
	            while ((line = br.readLine()) != null) {   
	            	result.append(line);   
	            }   
	            br.close();   
	        } catch (FileNotFoundException e) {
	        }catch (IOException e) {}   
		return result;
	}
	
	
	public static StringBuffer readTxtFileByUrl(String filePath) throws Exception {
		URL url = new URL("file:///"+filePath); 
	      //获得此 URL 的内容。 
	      Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()),"UTF-8"); 
	      int c; 
	      StringBuffer sa=new StringBuffer();
	      while ((c = reader.read()) != -1) {
	      	sa.append((char) c);
	      } 
	      reader.close(); 
	      //System.out.print(sa.toString()); 
			return sa;
		}


	public static StringBuffer tree(File f, String pId, StringBuffer treeJson) {
		String id = "";
		String str = "000";
		File[] childs = f.listFiles();// 返回一个抽象路径名数组，这些路径名表示此抽象路径名所表示目录中地文件   
if(childs!=null){
		for (int i = 0; i < childs.length; i++) {
			if (i > 999) {
				str = "";
			}
			if (i > 99) {
				str = "0";
			}
			if (i > 9) {
				str = "00";
			}
			id = pId + str + i;
			if (childs[i].isFile()) {
				treeJson.append("{id: \"" + id + "\", pId: \"" + pId
						+ "\", name: \"" + childs[i].getName()
						+ "\",open:true},");
			} else if (childs[i].isDirectory()) {
				treeJson.append("{id: \"" + id + "\", pId: \"" + pId
						+ "\", name: \"" + childs[i].getName()
						+ "\",open:true},");
				tree(childs[i], id, treeJson);
			}
		}
}
		// System.out.println(treeJson.toString());// 打印子文件地名字
		return treeJson;
	}
	
	public static void main(String[] args) throws IOException {
		File f = new File("E:/gitmain/minidao-github"); // 指定文件位置           
		System.out.println(f.getName());// 打印在这个文件下地文件夹;           
		StringBuffer treeJson=new StringBuffer();
		treeJson=tree(f, "0",treeJson);// 方法!进入子文件夹中 并打印子文件名    
        //System.out.print(treeJson.toString()); 
	}

}
