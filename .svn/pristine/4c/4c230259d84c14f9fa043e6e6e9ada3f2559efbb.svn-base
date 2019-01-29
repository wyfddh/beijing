/** 
 * <pre>项目名称:mip 
 * 文件名称:MapValueComparator.java 
 * 包名:com.tj720.mip.utils 
 * 创建日期:2017年2月24日下午4:22:29 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.tj720.mip.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/** 
 * <pre>项目名称：mip    
 * 类名称：MapValueComparator    
 * 类描述：    给mip做排序 顺便 转换算法
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月24日 下午4:22:29    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月24日 下午4:22:29    
 * 修改备注：       
 * @version </pre>    
 */
public class MapValueComparator implements Comparator<Long> {
	Map<String, Long> base;
    public MapValueComparator(Map<String, Long> map) {
        this.base = map;
    }
    public int compare(Long a, Long b) {
        if (base.get(a).doubleValue() >= base.get(b).doubleValue()) {
            return -1;
        } else {
            return 1;
        }
    }
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(
    			            final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
    
    
    
    static String[] units = { "", "十", "百", "千", "万", "0万", "00万", "000万", "亿", "十亿", "百亿", "千亿", "万亿" };
	static char[] numArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * @param args
	 *//*
	public static void main(String[] args) {
		int num =150000;
		String numStr = foematInteger(num);
		System.out.println("num= " + num + ", convert result: " + numStr);
	}*/

	public static String foematInteger(int num) {
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
			break;
		}
		return sb.toString();
	}
	
	
	
	
	public static void main(String[] args) {
	   //接收输入的整数
		String str=String.valueOf(0);
		
		//把整数转化为字符串
		StringBuilder sb=new StringBuilder(str);
		
		for(int i=0;i<str.length();i++){
	   	if(i<2){
	   		sb.setCharAt(i, str.charAt(i));
	   	}else sb.setCharAt(i, '0');
	   }
	   String s=sb.toString();
	   int e=Integer.valueOf(s);
	   System.out.println("输入的整数为:"+s+"\t保留前两位为:");
	}

}
