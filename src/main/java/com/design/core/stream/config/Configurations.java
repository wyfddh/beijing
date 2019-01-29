package com.design.core.stream.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.design.utils.FileUtils;

/**
 * read the configurations from file `config.properties`.
 */
public class Configurations {
	static final String CONFIG_FILE = "design-sysConfig.properties";
	private static Properties properties = null;
	private static final String REPOSITORY = System.getProperty(
			"java.io.tmpdir", File.separator + "tmp" + File.separator
					+ "upload-repository");

	static {
		try {
			new Configurations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Configurations() throws Exception {
		init();
		System.out.println("[NOTICE] File Repository Path ≥≥≥ " + getFileRepository());
	}

	void init() {
		try {
			ClassLoader loader = Configurations.class.getClassLoader();
			InputStream in = loader.getResourceAsStream(CONFIG_FILE);
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			System.err.println("reading `" + CONFIG_FILE + "` error!" + e);
		}
	}

	public static String getConfig(String key) {
		return getConfig(key, null);
	}

	public static String getConfig(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static int getConfig(String key, int defaultValue) {
		String val = getConfig(key);
		int setting = 0;
		try {
			setting = Integer.parseInt(val);
		} catch (NumberFormatException e) {
			setting = defaultValue;
		}
		return setting;
	}

	public static String getFileRepository() throws Exception {
		String val = getConfig("STREAM_FILE_REPOSITORY");
		String valtemp ="temp";
		FileUtils.makeDir(val, valtemp);
		if (val == null || val.isEmpty())
			val = REPOSITORY;
		return val+"/"+valtemp+"/";
	}

	public static String getCrossServer() {
		return getConfig("STREAM_CROSS_SERVER");
	}
	
	public static String getCrossOrigins() {
		return getConfig("STREAM_CROSS_ORIGIN");
	}
	
	public static boolean getBoolean(String key) {
		return Boolean.parseBoolean(getConfig(key));
	}
	
	public static boolean isDeleteFinished() {
		return getBoolean("STREAM_DELETE_FINISH");
	}
	
	public static boolean isCrossed() {
		return getBoolean("STREAM_IS_CROSS");
	}
}
