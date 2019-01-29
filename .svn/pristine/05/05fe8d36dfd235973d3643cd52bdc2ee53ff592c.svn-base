package com.design.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.zxlhdata.framework.auth.util.LicenseUtil;

public class ConvertArrayListUtil extends ArrayList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int requetsListSize(HttpServletRequest request,String appEntityStr) {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean gflag = false;
		Enumeration rnames = request.getParameterNames();
		int maxIndex = -1;
		// 获取数值最大下标 -start
		for (Enumeration e = rnames; e.hasMoreElements();) {
			String thisName = e.nextElement().toString();
			String thisValue = request.getParameter(thisName);
			System.out.println(thisName + "-------" + thisValue);
			if (thisName.indexOf(appEntityStr) != -1) {
				//获取中括号里的数字
				Matcher m = Pattern.compile("\\[([^\\[\\]]+)\\]").matcher(
						thisName);
				int currIndex = 0;
				while (m.find()) {
					String zifu = m.group(1);
					//此处需要将字符转换数字，进行出错抓获，非数字转换自动忽略转换错误
					try {
						currIndex = Integer.parseInt(zifu);
						if (currIndex >= maxIndex) {
							maxIndex = currIndex;
						}
					} catch (Exception e1) {
						// e1.printStackTrace();
					}
				}
			}
		}
		if (maxIndex > -1) {
			// /设置是否获取到对象长度
			maxIndex = maxIndex + 1;
		}
		/*** 获取最大下标结束 ***/
		return maxIndex;
	}
	
	
	public static List requets2List(HttpServletRequest request,
			Class entityClass, String appEntityStr, String notNullFieldName) throws Exception {
		try {
			////LicenseUtil.valid(ParameterUtil.ATC_K,30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List retlist = new ArrayList();
		boolean gflag = false;
		Enumeration rnames = request.getParameterNames();
		int maxIndex = -1;
		boolean isHuoquOobjLength = false;
		// 获取数值最大下标 -start
		for (Enumeration e = rnames; e.hasMoreElements();) {
			String thisName = e.nextElement().toString();
			String thisValue = request.getParameter(thisName);
			System.out.println(thisName + "-------" + thisValue);
			if (thisName.indexOf(appEntityStr) != -1) {
				//获取中括号里的数字
				Matcher m = Pattern.compile("\\[([^\\[\\]]+)\\]").matcher(
						thisName);
				int currIndex = 0;
				while (m.find()) {
					String zifu = m.group(1);
					//此处需要将字符转换数字，进行出错抓获，非数字转换自动忽略转换错误
					try {
						currIndex = Integer.parseInt(zifu);
						if (currIndex >= maxIndex) {
							maxIndex = currIndex;
						}
					} catch (Exception e1) {
						// e1.printStackTrace();
					}
				}
			}
		}
		/*** 获取最大下标结束 ***/

		int xunhuanLegth = 10000;
		/*** 当最大下标还是-1时，还是循环10000次 ****/
		if (maxIndex > -1) {
			// /设置是否获取到对象长度
			isHuoquOobjLength = true;
			xunhuanLegth = maxIndex + 1;
		}

		String notNullFieldNames[] = notNullFieldName.split("\\,");
		for (int i = 0; i < xunhuanLegth; i++) {
			int saf = 0;
			Field[] f = entityClass.getDeclaredFields();
			try {
				Object objbus = Class.forName(entityClass.getName())
						.newInstance();
				ReflectHelper reflectHelper = new ReflectHelper(objbus);
				for (int j = 0; j < f.length; j++) {
					String fueldName = f[j].getName();

					String fueldValue = request.getParameter(appEntityStr + "["
							+ i + "]." + fueldName)
							+ "";

					for (int i2 = 0; i2 < notNullFieldNames.length; i2++) {

						if (notNullFieldNames[i2].equals(fueldName)) {
							if (fueldValue == null || "".equals(fueldValue)
									|| "null".equals(fueldValue)) {
								// gflag = true;
								// break;
								saf++;
							}
						}
						if (fueldValue != null && !"".equals(fueldValue)
								&& !"null".equals(fueldValue)) {
							gflag = false;
							if (f[j].getType() == String.class) {
								reflectHelper.setMethodValue(fueldName,
										fueldValue);
							} else if (f[j].getType() == Date.class) {
								SimpleDateFormat sdf = null;
								if (fueldValue.length() > 10) {
									sdf = new SimpleDateFormat(
											"yyyy-MM-dd HH:mm:ss");
								} else {
									sdf = new SimpleDateFormat("yyyy-MM-dd");
								}
								Date date = sdf.parse(fueldValue);
								reflectHelper.setMethodValue(fueldName, date);

							} else if (f[j].getType() == BigDecimal.class) {
								reflectHelper.setMethodValue(fueldName,
										new BigDecimal(fueldValue));

							} else if (f[j].getType() == Integer.class) {
								reflectHelper.setMethodValue(fueldName,
										new Integer(fueldValue));

							}
						}
					}
				}
				// if (gflag){
				// break;
				// }

				if (saf == notNullFieldNames.length) {
					// 获取到对象个数的时候，直接以个数总长进行判断是否循环，如果是10000次，最少循环500次
					if (isHuoquOobjLength || i < 500) {
						continue;
					} else {
						break;
					}
				}
				retlist.add(objbus);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return retlist;
	}

	

	public static List requets2List(HttpServletRequest request,String appEntityStr,String notNullFieldName,String[] f) {
		List retlist = new ArrayList();
		
		boolean gflag = false;
		Enumeration rnames = request.getParameterNames();
		int maxIndex = -1;
		boolean isHuoquOobjLength = false;
		// 获取数值最大下标 -start
		for (Enumeration e = rnames; e.hasMoreElements();) {
			String thisName = e.nextElement().toString();
			String thisValue = request.getParameter(thisName);
			System.out.println(thisName + "-------" + thisValue);
			if (thisName.indexOf(appEntityStr) != -1) {
				//获取中括号里的数字
				Matcher m = Pattern.compile("\\[([^\\[\\]]+)\\]").matcher(
						thisName);
				int currIndex = 0;
				while (m.find()) {
					String zifu = m.group(1);
					//此处需要将字符转换数字，进行出错抓获，非数字转换自动忽略转换错误
					try {
						currIndex = Integer.parseInt(zifu);
						if (currIndex >= maxIndex) {
							maxIndex = currIndex;
						}
					} catch (Exception e1) {
						// e1.printStackTrace();
					}
				}
			}
		}
		/*** 获取最大下标结束 ***/

		int xunhuanLegth = 10000;
		/*** 当最大下标还是-1时，还是循环10000次 ****/
		if (maxIndex > -1) {
			// /设置是否获取到对象长度
			isHuoquOobjLength = true;
			xunhuanLegth = maxIndex + 1;
		}

		String notNullFieldNames[] = notNullFieldName.split("\\,");
		for (int i = 0; i < xunhuanLegth; i++) {
			int saf = 0;
			Map m=new HashMap();
			for (int j = 0; j < f.length; j++) {
				String fueldName = f[j];
				Object fueldValue = request.getParameter(appEntityStr + "["+ i + "]." + fueldName)+ "";
				m.put(fueldName, fueldValue);
				if((fueldValue==null||"".equals(fueldValue))&&notNullFieldName.equals(fueldName)){
					saf++;
				}
			}
			
			if (saf == notNullFieldNames.length) {
					break;
			}
			retlist.add(m);
		}
		return retlist;
	}
}
