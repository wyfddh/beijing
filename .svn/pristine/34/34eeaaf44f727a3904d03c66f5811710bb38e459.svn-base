/** 
 * <pre>项目名称:mip 
 * 文件名称:ValueComparator.java 
 * 包名:unitTest 
 * 创建日期:2017年2月24日下午4:15:19 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package unitTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/** 
 * <pre>项目名称：mip    
 * 类名称：ValueComparator    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月24日 下午4:15:19    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月24日 下午4:15:19    
 * 修改备注：       
 * @version </pre>    
 */
public class ValueComparator implements Comparator<Long> {

	Map<String, Long> base;
		    public ValueComparator(Map<String, Long> map) {
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
		    public static void main(String[] args) {
		        Map<String, Long> map = new HashMap<String, Long>();
		        map.put("a", (long) 123456);
		        map.put("b", (long) 123455467);
		        map.put("c", (long) 1234562178);
		        map.put("d", (long) 123456789);
		        ValueComparator bvc = new ValueComparator(map);
		        TreeMap<Long, Double> sorted_map = new TreeMap<Long, Double>(bvc);
		        System.out.println("unsorted map: " + map);
//		        sorted_map.putAll(map);
		        System.out.println("results: " + sorted_map);
		        Map<String, Long> sorted_map2 = sortByValues(map);
		        System.out.println("results2: " + sorted_map2);
		    }  
		    
		    
}
