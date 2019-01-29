package com.tj720.admin.common.constant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 
 * @author zwp
 * @date 2017年6月20日 上午11:33:15
 */
public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);

	private static ResourceBundle resource = ResourceBundle.getBundle("config");
	
	private static Resource fileRource = new ClassPathResource("upload"); 
	
	/*public static void main(String args[]) { 
		String result = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileRource.getFile()));//构造一个BufferedReader类来读取文件
			String s = null;
			while((s = br.readLine())!=null){//使用readLine方法，一次读一行
			result = result + "\n" +s;
		}
		br.close();    
		}catch(Exception e){
		e.printStackTrace();
		}
	}*/
	
	public static String getValue(String key) {
		return resource.getString(key).trim();
	}
	
	/**
	 * 获取config.properties配置文件信息
	 * </p>
	 * @param key
	 * @return
	 */
	public static String getConfigValue(String key) {
		return resource.getString(key).trim();
	}
	
	/**
	 * 
	 * @Title: saveInputStreamToFile 
	 * @Description: 输入流拷贝到文件中
	 * @author sunlulu
	 * @param @param in
	 * @param @param destfilePath
	 * @return void  
	 * @throws
	 */
	public static void saveInputStreamToFile(InputStream in, String destfilePath) {
		try {
			byte[] gif = IOUtils.toByteArray(in);
			FileUtils.writeByteArrayToFile(new File(destfilePath), gif);
			IOUtils.closeQuietly(in);
			logger.info("save pic:" + destfilePath + " success");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * 复制文件或者目录,复制前后文件完全一样。
	 * 
	 * @param resFilePath 源文件路径
	 * @param destFolder 目标文件夹
	 * @IOException 当操作发生异常时抛出
	 */
	public static void copyFile(String resFilePath, String destFolder)
			throws IOException {
		File resFile = new File(resFilePath);
		File destFile = new File(destFolder);
		if (resFile.isDirectory()) {
			FileUtils.copyDirectoryToDirectory(resFile, destFile);
		} else if (resFile.isFile()) {
			FileUtils.copyFileToDirectory(resFile, destFile, true);
		}
	}

	/**
	 * 删除一个文件或者目录
	 * 
	 * @param targetPath文件或者目录路径
	 * @IOException 当操作发生异常时抛出
	 */
	public static void deleteFile(String targetPath) throws IOException {
		File targetFile = new File(targetPath);
		if (targetFile.isDirectory()) {
			FileUtils.deleteDirectory(targetFile);
		} else if (targetFile.isFile()) {
			targetFile.delete();
		}
	}

	/**
	 * 删除目录下的所有文件
	 * 
	 * @param targetPath目录路径或者文件
	 * @IOException 当操作发生异常时抛出
	 */
	public static void deleteFloderFile(String targetPath) throws IOException {
		File targetFile = new File(targetPath);
		if (targetFile.isDirectory()) {
			File[] files = targetFile.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					FileUtils.deleteDirectory(file);
				} else if (file.isFile()) {
					file.delete();
				}
			}
		} else if (targetFile.isFile()) {
			targetFile.delete();
		}
	}

	/**
	 * 移动文件或者目录,移动前后文件完全一样,如果目标文件夹不存在则创建。
	 * 
	 * @param resFilePath源文件路径
	 * @param destFolder目标文件夹
	 * @IOException 当操作发生异常时抛出
	 */
	public static void moveFile(String resFilePath, String destFolder)
			throws IOException {
		File resFile = new File(resFilePath);
		File destFile = new File(destFolder);
		if (resFile.isDirectory()) {
			FileUtils.moveDirectoryToDirectory(resFile, destFile, true);
		} else if (resFile.isFile()) {
			FileUtils.moveFileToDirectory(resFile, destFile, true);
		}
	}

	/**
	 * 移动某一文件或者目录下的某一文件，到另一目录中，并改名
	 * 
	 * @param resFilePath源文件路径或者目录
	 * @param destFilePath目标文件路径
	 * @IOException 当操作发生异常时抛出
	 */
	public static void moveModifyFile(String resFilePath, String destFilePath)
			throws IOException {
		File srcFile = new File(resFilePath);
		File destFile = new File(destFilePath);

		if (destFile.isFile()) {
			destFile.delete();
		}

		if (srcFile.isFile()) {
			FileUtils.moveFile(srcFile, destFile);
		} else if (srcFile.isDirectory()) {
			File[] files = srcFile.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					FileUtils.moveFile(file, destFile);
				}
			}
		}
	}

	/**
	 * 读取文件或者目录的大小
	 * 
	 * @param destFilePath目标文件或者文件夹
	 * @return 文件或者目录的大小，如果获取失败，则返回-1
	 */
	public static long genFileSize(String destFilePath) {
		File destFile = new File(destFilePath);
		if (destFile.isFile()) {
			return destFile.length();
		} else if (destFile.isDirectory()) {
			return FileUtils.sizeOfDirectory(destFile);
		}
		return -1L;
	}

	/**
	 * 判断一个文件是否存在
	 * 
	 * @param filePath文件路径
	 * @return 存在返回true，否则返回false
	 */
	public static boolean isExist(String filePath) {
		return new File(filePath).exists();
	}

	/**
	 * 本地某个目录下的文件列表（不递归）
	 * 
	 * @param folder ftp上的某个目录
	 * @param suffix文件的后缀名（比如.mov.xml)
	 * @return 文件名称列表
	 */
	public static String[] listFilebySuffix(String folder, String suffix) {
		IOFileFilter fileFilter1 = new SuffixFileFilter(suffix);
		IOFileFilter fileFilter2 = new NotFileFilter(
				DirectoryFileFilter.INSTANCE);
		FilenameFilter filenameFilter = new AndFileFilter(fileFilter1,
				fileFilter2);
		return new File(folder).list(filenameFilter);
	}

	/**
	 * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
	 * 
	 * @param res原字符串
	 * @param filePath文件路径
	 * @return 成功标记
	 */
	public static boolean string2File(String res, String filePath) {
		boolean flag = true;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			File destFile = new File(filePath);
			if (!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();
			bufferedReader = new BufferedReader(new StringReader(res));
			bufferedWriter = new BufferedWriter(new FileWriter(destFile, true)); // 追加
			char buf[] = new char[1024]; // 字符缓冲区
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/************************************图片路径前缀，兼容之前版本（1.0） begin ********************************************/
	
	/**
	 * 个人头像照路径
	 * @param personId
	 * @param suffix
	 * @return
	 */
	public static String gainPersonAvatarRelativePath(String personId,String suffix){
		return  "/files/person/" + personId +  "/avatar" + suffix;
	}
	
	/**
	 * 个人默认头像照路径
	 * @param personId
	 * @param suffix
	 * @return
	 */
	public static String gainDefaultPersonAvatarRelativePath(String imgName){
		return "/files/"  + "avatar/"  + imgName;
	}
	/**
	 * 个人学生证件照路径
	 * @param personId
	 * @param suffix
	 * @return
	 */
	public static String gainPersonCodeRelativePath(String personId,String suffix){
		return "/files/" + "person/" + personId +  "/code" + suffix;
	}
	/**
         * 任务图片路径
         * @param taskId
         * @param suffix
         * @param snum
         * @return
         */
        public static String gainTaskRelativePath(String taskId,String imgPre,String suffix,int snum){
                return "/files/task/"+taskId+"/"+imgPre+snum+suffix;
        }
        
        /**
         * 任务执行图片路径
         * @param taskId
         * @param suffix
         * @param snum
         * @return
         */
        public static String gainTaskExecuteRelativePath(String taskId,String suffix,int snum){
                return "/files/taskexecute/" + taskId + "/" + snum + suffix;
        }
	/**
	 * 获取上传路径（根目录）
	 * @return
	 */
	public static String getUploadPath(){
		try {
			return fileRource.getFile().getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
