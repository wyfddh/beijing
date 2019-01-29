package com.tj720.mip.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author Administrator
 *
 */
public class FileUtil {
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
			targetFile.delete();
		} else if (targetFile.isFile()) {
			targetFile.delete();
		}
	}
}
