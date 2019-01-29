package com.tj720.mip.utils;

import java.io.File;
import java.util.ArrayList;

import com.iflytek.cloud.speech.Setting;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechEvent;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizeToUriListener;

public class KdxfUtil {
	private static final String APPID = "5a1392e7";
	private static KdxfUtil mObject = new KdxfUtil();
	public static String content = "科大讯飞成立于1999年，是中国领先的智能化语音技术提供商，其语音核心技术代表着世界领先水平。2008年科大讯飞在深圳证券交易所挂牌上市。 ";
	public static String pcnPath = "";
	public static String mp3Path = "";
	
	public static void main(String[] args) {
		
//		String pcm = "F:/xunfei/back/audio/1.pcm";
//		String mp3 = "F:/xunfei/back/audio/1.mp3";
//		speechSynthesis(content,pcm,mp3);
		speechSynthesis();
		
	}
	public static void  speechSynthesis() {
//		Setting.setShowLog(true);
		SpeechUtility.createUtility("appid=" + APPID);
		mObject.SynthesizeList(content,pcnPath);
//		mObject.pcmToMp3(pcnPath,mp3Path);
		
	}
	/**
	 * 合成
	 */
	private void SynthesizeList(String content,String pcmPath) {
		SpeechSynthesizer speechSynthesizer = SpeechSynthesizer.createSynthesizer();
		speechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// 设置发音人
		speechSynthesizer.setParameter(SpeechConstant. SPEED, "50" );// 设置语速
		speechSynthesizer.setParameter(SpeechConstant. VOLUME, "80" );// 设置音量，范围 0~100
		speechSynthesizer.synthesizeToUri(content.trim(), pcmPath,synthesizeToUriListener);// 设置合成音频保存位置（可自定义保存位置），默认不保存
	}
	
	/**
	 * 合成监听器
	 */
	SynthesizeToUriListener synthesizeToUriListener = new SynthesizeToUriListener() {
		public void onBufferProgress(int progress) {
			System.out.println("*************合成进度*************" + progress);
			if(progress==100){
				pcmToMp3(pcnPath,mp3Path);
			}
		}
		public void onSynthesizeCompleted(String uri, SpeechError error) {
			if (error == null) {
				System.out.println("*************合成成功*************");
				System.out.println("合成音频生成路径：" + uri);
			} else
				System.out.println("*************" + error.getErrorCode()
						+ "*************");
			waitupLoop();
		}
		@Override
		public void onEvent(int eventType, int arg1, int arg2, int arg3, Object obj1, Object obj2) {
			if( SpeechEvent.EVENT_TTS_BUFFER == eventType ){
				System.out.println( "onEvent: type="+eventType+", arg1="+arg1+", arg2="+arg2+", arg3="+arg3+", obj2="+(String)obj2 );
				ArrayList<?> bufs = null;
				if( obj1 instanceof ArrayList<?> ){
					bufs = (ArrayList<?>) obj1;
				}else{
					System.out.println( "onEvent error obj1 is not ArrayList !" );
				}
				
				if( null != bufs ){
					for( final Object obj : bufs ){
						if( obj instanceof byte[] ){
							final byte[] buf = (byte[]) obj;
							System.out.println( "onEvent buf length: "+buf.length );
						}else{
							System.out.println( "onEvent error element is not byte[] !" );
						}
					}
				}
			}
		}
	};
	private void waitupLoop(){
		synchronized(this){
			KdxfUtil.this.notify();
		}
	}
	private  void pcmToMp3(String pcm,String mp3) {
		Process p = null; 
		String path="F:/xunfei";
		File f = new File(path);
		if (!f.exists()) {
		}else {
			try {  
				p = Runtime.getRuntime().exec("cmd /c ffmpeg -y -f s16le -ar 8000 -ac 2 -i "+pcm+" -acodec libmp3lame "+mp3+"",null,  
						new File( "D:\\ffmpeg\\bin"));  
				p.waitFor();  
			} catch (Exception e) {  
				e.printStackTrace();  
			} 
		}
	}
}
