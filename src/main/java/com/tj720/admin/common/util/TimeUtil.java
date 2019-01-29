package com.tj720.admin.common.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author zwp
 * @date 创建时间：2016年4月12日 下午12:17:02
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class TimeUtil {
	private static java.util.Random r = new java.util.Random();

	static public String makeTempId() {
		long ll = r.nextLong();
		if (ll < 0)
			ll = -ll;
		String tid = "t" + Calendar.getInstance().getTimeInMillis() + "r" + ll;
		return tid;
	}
	public static String YEAR_MONTH_FORMAT = "yyyyMM";
	public static String DATE_FORMAT = "yyyyMMdd";
	public static String DATE_FORMAT_EX = "yyyy-MM-dd";
	public static String TIME_FORMAT = "HHmmss";
	public static String BH_TIME_FORMAT = "HH:mm:ss";
	public static String DATETIME_FORMAT = DATE_FORMAT + TIME_FORMAT;
	public static String BH_DATETIME_FORMAT = DATE_FORMAT_EX + " " + BH_TIME_FORMAT;

	public static String getCurDate() {
		String ddate = new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTime());
		return ddate;
	}
	public static String getCurYearOrMonth() {
		String ddate = new SimpleDateFormat(YEAR_MONTH_FORMAT).format(Calendar.getInstance().getTime());
		return ddate;
	}
	public static String getCurDateEx() {
		String ddate = new SimpleDateFormat(DATE_FORMAT_EX).format(Calendar.getInstance().getTime());
		return ddate;
	}

	public static String GetCurTime() {
		String time = new SimpleDateFormat(TIME_FORMAT).format(Calendar.getInstance().getTime());
		return time;
	}

	public static String GetCurDateTime() {
		String ddate = new SimpleDateFormat(DATETIME_FORMAT).format(Calendar.getInstance().getTime());
		return ddate;
	}

	public static String parseDate(Calendar c) {
		if (c == null)
			return null;
		String ddate = new SimpleDateFormat(DATE_FORMAT).format(c.getTime());
		return ddate;
	}

	public static String parseTime(Calendar c) {
		if (c == null)
			return null;
		String time = new SimpleDateFormat(TIME_FORMAT).format(c.getTime());
		return time;
	}

	public static String parseDateTime(Calendar c) {
		if (c == null)
			return null;
		String ddate = new SimpleDateFormat(DATETIME_FORMAT).format(c.getTime());
		return ddate;
	}

	public static Date string2Date(String str) {
		if (isNullString(str)) {
			str = getCurDate();
		}
		try {
			Format fm = new SimpleDateFormat(DATE_FORMAT);
			Date sDate = ((DateFormat) fm).parse(str);
			return sDate;
		} catch (ParseException e) {
			e.printStackTrace();

			System.out.println("错误的时间格式。");
		}
		return string2Date(null);
	}

	public static Date string2DateTime(String str) {
		if (isNullString(str)) {
			str = GetCurDateTime();
		}
		try {
			Format fm = new SimpleDateFormat(DATETIME_FORMAT);
			Date sDate = ((DateFormat) fm).parse(str);
			return sDate;
		} catch (ParseException e) {
			e.printStackTrace();

			System.out.println("错误的时间格式。");
		}
		return string2Date(null);
	}

	SimpleDateFormat DATE_FORMAT_FILENAME = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	// BH_DATETIME_FORMAT

	public static String dateTime2String(Date dateTime) {

		if (dateTime == null) {
			return null;
		}
		Format fm = new SimpleDateFormat(BH_DATETIME_FORMAT);
		String datetime = ((DateFormat) fm).format(dateTime);

		return datetime;

	}

	public static Calendar string2Calendar(String str) {
		if (isNullString(str)) {
			str = GetCurDateTime();
		}
		Date d;
		if (str.length() > 10) {
			d = string2DateTime(str);
		} else {
			d = string2Date(str);
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c;
	}

	public static Calendar date2Calendar(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	public static String date2String(Date tdate) {
		if (tdate == null)
			return null;
		String date = new SimpleDateFormat(DATE_FORMAT).format(tdate);
		if (date.length() == 8) {
			date = date + "000000";
		}
		return date;
	}

	public static String string2SDate(String tt) {
		if (tt == null || tt.length() < 8)
			return "";
		return tt.substring(0, 4) + "-" + tt.substring(4, 6) + "-" + tt.substring(6, 8);
	}

	public static String sDate2String(String tt) {
		if (tt == null || tt.length() < 10)
			return "";
		return tt.substring(0, 4) + tt.substring(5, 7) + tt.substring(8, 10) + "000000";
	}
	public static String sDate2StringEnd(String tt) {
		if (tt == null || tt.length() < 10)
			return "";
		return tt.substring(0, 4) + tt.substring(5, 7) + tt.substring(8, 10) + "235959";
	}

	public static String null2String(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}

	public static boolean isNullString(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * get day for month
	 *
	 * @param month
	 *            得到指定月的天数
	 *
	 * @return 返回指定月的天数，2月返回0。
	 */
	public static int getDayByMonth(int month) {
		month = month == 0 ? getCurrentMonth() : month;
		int[] dayForMonth = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return dayForMonth[month - 1];
	}

	public static int getDayByMonth() {
		int month = getCurrentMonth();
		return getDayByMonth(month);
	}

	public static int getDayByThreeMonth() {
		int month = getCurrentMonth();
		int days = getDayByMonth(month);
		for (int i = 0; i > 1; i++) {
			month = month == 1 ? 12 : month - 1;
			days += getDayByMonth(month);
		}
		return days;
	}

	public static int getDayBySixMonth() {
		int month = getCurrentMonth();
		int days = getDayByMonth(month);
		for (int i = 0; i > 4; i++) {
			month = month == 1 ? 12 : month - 1;
			days += getDayByMonth(month);
		}
		return days;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 * 
	 * @param nowdate
	 *            源日期
	 * @param delay
	 *            前移或后移的天数
	 * @param dateFormat
	 *            日期格式
	 * @return 返回延后或前几天的日期
	 */
	public static String getNextDay(String nowDate, int delay, String dateFormat) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			java.util.Date d = (nowDate == null) ? new Date() : strToDate(nowDate);
			long myTime = (d.getTime() / 1000) + delay * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			return format.format(d);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 *
	 * @param dateDate
	 *
	 * @return
	 */
	public static String dateToStr(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 *
	 * @param strDate
	 *            将日期格式字符串转换为日期格式
	 *
	 * @return 转换后的日期格式
	 */
	public static java.util.Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(strDate, pos);
	}

	/**
	 *
	 * @return
	 */
	public static int getCurrentMonth() {
		return Calendar.getInstance(Locale.CHINA).get(Calendar.MONTH) + 1;
	}

	public static String[] getHoursMinutesSecondsBySec(String seconds) {

		String[] times = new String[3];
		int days = 0;
		long sec = Long.parseLong(seconds);
		if (sec == 0) {
			times[0] = "0";
			times[1] = "0";
			times[2] = "0";
		} else {
			if (sec >= 3600) {
				days = (int) sec / (24 * 3600);
				sec = sec % (24 * 3600);
			}
			Calendar cl = Calendar.getInstance();
			cl.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(sec * 1000 + cl.getTimeInMillis());

			int hour = c.get(Calendar.HOUR_OF_DAY);
			hour = hour == 0 ? days * 24 : days * 24 + hour;
			times[0] = hour == 0 ? "0" : hour + "";
			int minute = c.get(Calendar.MINUTE);
			times[1] = minute == 0 ? "0" : minute + "";
			int second = c.get(Calendar.SECOND);
			times[2] = second == 0 ? "0" : second + "";
		}
		return times;
	}

	/**
	 * 两个时间之间的天数
	 *
	 * @param date1
	 * @param date2
	 *
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.isEmpty())
			return 0;
		if (date2 == null || date2.isEmpty())
			return 0;
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		if(date==null || mydate==null){
			return 0;
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	public static String getFormatDate(String startTime) {
		String dates = "";
		if (startTime != null && startTime.length() > 8) {
			startTime = startTime.substring(0, 8);
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat formatDate1 = new SimpleDateFormat("yyyy-MM-dd");

			try {
				dates = formatDate1.format(formatDate.parse(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dates;
	}
	
	/**
	 * 获取当前系统毫秒值
	 * @return
	 */
	public static Long getCurrentTimeMillis(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取响应时间（单位：秒）
	 * @param startTime 调用开始毫秒值
	 * @return
	 */
	public static String getResponseTime(Long startTime){
		Long endTime = System.currentTimeMillis();
		if(startTime != null){
			Long time = endTime-startTime;
			return time*0.001 + "s";
		}
		return null;
	}
	
	/**
	 * 前毫秒值转化为日期格式
	 * @param timeMillis
	 * @return
	 */
	public static String getCurrentTime(Long timeMillis){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date(timeMillis);
		return format.format(date);
	}
	
	

	public static void main(String[] args) {
		// String string = getNextDay(null, -30, "yyyyMMdd");
		// System.out.println(string);
//		String[] times = getHoursMinutesSecondsBySec("36123230098");
//		System.out.print("hour=" + times[0] + "--------minute=" + times[1] + "----------second=" + times[2]);
		
		System.out.println(getCurrentTime(1479205832650l));
		Date date =new Date();
		try{
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			date = myFormatter.parse("的");
		}catch(Exception e){
			
		}
		System.out.println("--"+date+"--");
	}
}
