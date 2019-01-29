package com.tj720.mip.utils;

import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * hibernate HQL WHERE语句工具类
 */
public class HqlWhere {
	
		//8小时时差转换
		static {
			TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
			TimeZone.setDefault(tz);
		}
	
	/**
	 * ^^^^^^
	 * 功能：用于模糊查询 格式为：如：1,2,3,4,5,6字符串的字段（匹配: "1," 和 ",1," 和 ",1" ）。
	 * @param conditionKey    条件字段名称
	 * @param conditionValue  条件值
	 * @param isAnd 前缀是否带 and
	 * @return
	 */
	public static String bindLikeAll_split(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		// 以某条件值为："1,"开头的
		conditionHql.append("(").append(conditionKey).append(" like ").append(
				"'").append(conditionValue).append(",%'");
		// 以某条件值为：包含",1,"
		conditionHql.append(" or ").append(conditionKey).append(" like ")
				.append("'%,").append(conditionValue).append(",%'");
		// 以",1"结尾的
		conditionHql.append(" or ").append(conditionKey).append(" like ")
				.append("'").append("%,").append(conditionValue).append("') ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于模糊查询（包括：前缀，中间，后缀）
	 * @param conditionKey
	 *            条件字段名称
	 * @param conditionValue
	 *            条件值
	 * @param isAnd
	 *            前缀需不需要带 and
	 * @return
	 */
	public static String bindLike_All(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		// 以某条件值为："1,"开头的
		conditionHql.append("(").append(conditionKey).append(" like ").append(
				"'").append(conditionValue).append("%'");
		// 以某条件值为：包含",1,"
		conditionHql.append(" or ").append(conditionKey).append(" like ")
				.append("'%").append(conditionValue).append("%'");
		// 以",1"结尾的
		conditionHql.append(" or ").append(conditionKey).append(" like ")
				.append("'").append("%").append(conditionValue).append("') ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于某字段"等于"某个值的查询条件
	 * 
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 * @return
	 */
	public static String bindEquals(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append("=").append("'").append(
				conditionValue).append("' ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于某字段"不等于"某个值的查询条件
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 * @return
	 */
	public static String bindNotEquals(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" <> ").append("'").append(
				conditionValue).append("' ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于模糊查询 前缀为某个值的条件
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 */
	public static String bindLike_prefix(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" like ").append("'").append(
				conditionValue).append("%' ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于模糊查询 后缀为某个值的条件
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 */
	public static String bindLike_suffix(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" like ").append("'").append(
				"%").append(conditionValue).append("' ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于模糊查询 包含某个值的条件
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 */
	public static String bindLike_include(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" like ").append("'").append(
				"%").append(conditionValue).append("%' ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于某字段"小于"某个值的查询条件
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 */
	public static String bind_LessThan(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" < ").append("'").append(
				conditionValue).append("' ");
		return conditionHql.toString();
	}

	/**
	 * ^^^^^^
	 * 功能：用于某字段"大于"某个值的查询条件
	 * @param conditionKey
	 * @param conditionValue
	 * @param isAnd
	 */
	public static String bind_Than(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" > ").append("'").append(
				conditionValue).append("' ");
		return conditionHql.toString();
	}

	
	/**
	 * <pre>bind_LessThan_Equal(用于某时间"小于并且等于"某个值的查询条件)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月6日 下午4:14:48    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月6日 下午4:14:48    
	 * 修改备注： 
	 * @param conditionKey
	 * @param conditionValue
	 * @param or_And
	 * @return</pre>
	 */
	public static String bind_LessThan_Equal(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" >= ").append("'").append(
				conditionValue).append("' ");
		return conditionHql.toString();
	}

	
	/**
	 * <pre>bind_Than_Equal(用于某时间"大于并且等于"某个值的查询条件)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月6日 下午4:14:36    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月6日 下午4:14:36    
	 * 修改备注： 
	 * @param conditionKey
	 * @param conditionValue
	 * @param or_And
	 * @return</pre>
	 */
	public static String bind_Than_Equal(String conditionKey,
			String conditionValue, String or_And) {
		// 查询条件
		StringBuilder conditionHql = new StringBuilder(" ");
		if (!or_And.equals("")) {
			conditionHql.append(or_And).append(" ");
		}
		conditionHql.append(conditionKey).append(" <= ").append("'").append(
				conditionValue).append("' ");
		return conditionHql.toString();
		
	}
//测试
	/*public static void main(String[] args) {
		// 查询条件
		StringBuilder strHql = new StringBuilder("from VirtualShowroom where 1=1 ");
		strHql.append(HqlWhere.bindLike_All("status", "1", "and"));
//        strHql.append(HqlWhere.bind_LessThan_Equal("creatTime", "2017-01-10", ""));
//        strHql.append(HqlWhere.bind_Than_Equal("creatTime", "2017-12-31", "and"));
        strHql.append(HqlWhere.bindEquals("lasetPersion", "曹梦奇", "and"));
//        strHql.append(HqlWhere.bindEquals("b.reader.meno", "shiRen", "and"));
//        strHql.append(HqlWhere.bindEquals("b.reader.name", "zsj", "and"));
//        strHql.append(HqlWhere.bindLikeAll_split("b.title", "1", "and"));
		System.out.println(strHql.toString());
		System.out.println(transform_date("2017-02-21"));
	}*/
	/**
	 * <pre>transform_date(字符串转为毫秒值)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月9日 下午7:17:35    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月9日 下午7:17:35    
	 * 修改备注： 
	 * @param time
	 * @return</pre>
	 */
	public static String transform_date(String time) {
		String newTime = "";
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sim.parse(time);
			long getTime = parse.getTime();
			newTime = String.valueOf(getTime / 1000);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newTime;
	}
	
	public static String transform_Date(String time) {
		String newTime = "";
		SimpleDateFormat sim = new SimpleDateFormat("HH:mm:ss");
		try {
			Date parse = sim.parse(time);
			long getTime = parse.getTime();
//			newTime = String.valueOf((getTime/1000) + 28800);//加8个小时时差
			newTime = String.valueOf((getTime/1000));//不加8个小时时差
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newTime;
	}
	
	
	/**
	 * <pre>new_date(当前时间转为字符串)   
	 * 创建人：Caomq caomqvip@sina.com
	 * 创建时间：2017年2月9日 下午7:17:51    
	 * 修改人：Caomq caomqvip@sina.com
	 * 修改时间：2017年2月9日 下午7:17:51    
	 * 修改备注： 
	 * @return</pre>
	 */
	public static String new_date() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String time = sim.format(date);
		return time;
	}
	public static Date date_Date(Long time){
		return null;
	}
	public static void main(String[] args) {
		String a = transform_Date("16:03:30");
		System.out.println(a);
	}
	
}
