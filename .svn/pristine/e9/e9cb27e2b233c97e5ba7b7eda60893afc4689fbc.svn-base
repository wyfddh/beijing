/** 
 * <pre>项目名称:mip 
 * 文件名称:NumberFormatTest.java 
 * 包名:unitTest 
 * 创建日期:2017年2月24日下午8:41:36 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */
package unitTest;

/**
 * <pre>
 * 项目名称：mip    
 * 类名称：NumberFormatTest    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月24日 下午8:41:36    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月24日 下午8:41:36    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
public class NumberFormatTest {

	static String[] units = { "", "十", "百", "千", "万", "十", "百", "千", "亿", "十亿", "百亿", "千亿", "万亿" };
	static char[] numArray = { ' ', '一', '二', '三', '四', '五', '六', '七', '八', '九' };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 4511;
		String numStr = foematInteger(num);
		System.out.println("num= " + num + ", convert result: " + numStr);
	}

	private static String foematInteger(int num) {
		char[] val = String.valueOf(num).toCharArray();
		int len = val.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					// not need process if the last digital bits is 0
					continue;
				} else {
					// no unit for 0
					sb.append(numArray[n]);
				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		return sb.toString();
	}

}
