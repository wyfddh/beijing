package com.tj720.mip.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class FFmpegUtils {
	public static String getDurationForFile(String path, String ffmpegInstallPath){
		List<String> cmds = new ArrayList<>();
		cmds.add(ffmpegInstallPath);
		/*cmds.add("-f");
		cmds.add("amr");
		cmds.add("ffmpeg");*/
		cmds.add("-i");
		cmds.add(path);
		
		return exec(cmds);
	}
	/**
	 * amr转MP3
	 * @param concatPath
	 * @param path
	 */
	public static String amrConvertMp3(String amrPath,String mp3Path, String ffmpegInstallPath) {
		List<String> cmds = new ArrayList<>();
		cmds.add(ffmpegInstallPath);
		cmds.add("-f");
		cmds.add("mp3");
		cmds.add("ffmpeg");
		cmds.add("-i");
		cmds.add(amrPath);
		cmds.add("-acodec");
		//'s32p|fltp|s16p'
		cmds.add("libmp3lame");
		cmds.add("-ac");
		cmds.add("2");
		cmds.add("-ar");
		//'44100|48000|32000|22050|24000|16000|11025|12000|8000',值越高音质越好
		cmds.add("12000");
		cmds.add("-ab");
		cmds.add("96");
		cmds.add("-y");
		cmds.add(mp3Path);
		
		return exec(cmds);
	}
	/**
	 * 音频拼接
	 * @param concatPath
	 * @param path
	 */
	public static String concatAudio(String concatPath,String path, String ffmpegInstallPath) {
		List<String> cmds = new ArrayList<>();
		cmds.add(ffmpegInstallPath);
		/*cmds.add("-f");
		cmds.add("amr");
		cmds.add("ffmpeg");*/
		cmds.add("-i");
		//cmds.add("\"concat:d:/mp3/a.mp3|d:/mp3/b.mp3\"");
		cmds.add(path);
		cmds.add("-acodec");
		cmds.add("copy");
		
		cmds.add(concatPath);
		return exec(cmds);
	}
	/**
	 * 音频合成
	 * @param concatPath
	 * @param backgroundPath
	 * @param composePath
	 * @return
	 */
	public static String composeAudio(String concatPath, String backgroundPath, String composePath, String ffmpegInstallPath) {
		int size = 2;
		List<String> cmds = new ArrayList<>();
		cmds.add(ffmpegInstallPath);
		/*cmds.add(composePath);
		cmds.add("-f");
		cmds.add("amr");*/
		//cmds.add("ffmpeg");
		cmds.add("-i");
		cmds.add(concatPath);
		cmds.add("-i");
		cmds.add(backgroundPath);
		cmds.add("-filter_complex");
		cmds.add("amix=inputs=" + size + ":duration=shortest:dropout_transition=1");
		/*cmds.add("-strict");
		cmds.add("-2");*/
		cmds.add("-ab"); 
		cmds.add("12.2k");
		cmds.add("-ar");
		cmds.add("8000");
		cmds.add("-ac");
		cmds.add("1");
		//cmds.add("--enable-muxer=mpeg");
		//cmds.add("-debug");
		cmds.add("-y");
		cmds.add(composePath);
		return exec(cmds);
	}
	
	/** 
     * 执行指令 
     * @param cmd 执行指令 
     * @param getter 指令返回处理接口，若为null则不处理输出 
     */  
    static public String exec(List<String> cmd){  
    	StringBuilder lineBuilder = new StringBuilder();
        try {  
            ProcessBuilder builder = new ProcessBuilder();    
            builder.command(cmd);  
            builder.redirectErrorStream(true);
            Process proc = builder.start();  
            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));  
            String line;  
            while ((line = stdout.readLine()) != null) {
               lineBuilder.append(line);
            }  
            proc.waitFor();     
            stdout.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return lineBuilder.toString();
    }
}
