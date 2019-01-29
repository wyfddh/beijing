package com.tj720.mip.utils;

import java.util.Date;

public class TimeShowUtil {
	
	/**
	 * 转换发布时间为字符串
	 * @param currentTime 当前时间
	 * @param publishTime 发布时间
	 * @return
	 */
	public static String plTime(Long currentTime, Long publishTime){
		Date currentDate = new Date(currentTime);//当前日期
		Date publishDate = new Date(publishTime);//发布日期
//		SimpleDateFormat sim1 = new SimpleDateFormat("yyyy");//年
		//获取日期的年
		int currentYear = DateUtil.getYear(currentDate);
		int publishedYear = DateUtil.getYear(publishDate);
		if (currentYear-publishedYear >= 1) {
			//发布一年前
//			String publishDateStr = sim1.format(publishDate);
			return publishedYear+"年";
		}else if (currentYear-publishedYear == 0) {
			//发布一年内
			//获取日期的月份
			int currentMonth = DateUtil.getMonth(currentDate);
			int publishMonth = DateUtil.getMonth(publishDate);
			if (currentMonth-publishMonth >= 1) {
				//不同月
				int month = currentMonth - publishMonth;
				return month+"月前";
			} else if (currentMonth-publishMonth == 0) {
				//发布于同一月内
				//获取日期的天
				int currentDay = DateUtil.getDay(currentDate);
				int publishDay = DateUtil.getDay(publishDate);
				if (currentDay-publishDay >= 1) {
					//不同天
					int day = currentDay-publishDay;
					return day + "天前";
				} else if(currentDay-publishDay == 0){
					//同一天
					//获取日期的小时
					int currentHour = DateUtil.getHour(currentDate);
					int publishHour = DateUtil.getHour(publishDate);
					if (currentHour - publishHour >= 1) {
						//不在一小时内
						int hour = currentHour - publishHour;
						return hour + "小时前";
					} else if (currentHour - publishHour == 0) {
						//一小时内
						//获取日期的分钟
						int currentMinite = DateUtil.getMinute(currentDate);
						int publishMinite = DateUtil.getMinute(publishDate);
						if (currentMinite - publishMinite >= 1) {
							//不在一分钟内
							int minite = currentMinite - publishMinite;
							return minite + "分钟前";
						} else if (currentMinite - publishMinite == 0) {
							//一分钟内
							return "刚刚";
						} else {
							return "您穿越了吧？";
						}
					} else {
						return "您穿越了吧？";
					}
				} else {
					return "您穿越了吧？";
				}
			} else {
				return "您穿越了吧？";
			}
		}else {
			return "您穿越了吧？";
		}
	}
	
	
	public static String tranMinSec(String args){
		int seconds = Integer.parseInt(args);
		int temp=0;
		StringBuffer sb=new StringBuffer();
		
		temp=seconds%3600/60;
		sb.append((temp<10)?"0"+temp+":":""+temp+":");

		temp=seconds%3600%60;
		sb.append((temp<10)?"0"+temp:""+temp);
		
		String str = sb.toString();
		
		return str;
	}
	
}
