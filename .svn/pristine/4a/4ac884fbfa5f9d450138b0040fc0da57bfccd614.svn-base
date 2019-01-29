/** 
 * <pre>项目名称:mip 
 * 文件名称:NumTrans.java 
 * 包名:unitTest 
 * 创建日期:2017年2月25日上午10:36:23 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package unitTest;

import java.util.Scanner; 

/** 
 * <pre>项目名称：mip    
 * 类名称：NumTrans    
 * 类描述：    
 * 创建人：Caomq caomqvip@sina.com
 * 创建时间：2017年2月25日 上午10:36:23    
 * 修改人：Caomq caomqvip@sina.com
 * 修改时间：2017年2月25日 上午10:36:23    
 * 修改备注：       
 * @version </pre>    
 */
public class NumTrans {
    private static Scanner sc ;  
    
    private static String input ;  
      
    private static String units[] = {"","十","百","千","万","十","百","千","亿"};  
      
    private static String nums[] = {"零","一","二","三","四","五","六","七","八","九","十"};  
      
    private static String result[] ;  
      
    public static void input() {  
        System.out.println("请输入一串数字：如123456，最多9位  ");  
        sc = new Scanner("200000");  
        input = sc.nextLine();  
    }  
      
    public static String get(String input) { 
        String out = "";  
        result = new String[input.length()];  
        for(int i=0;i<result.length;i++) {  
            result[i] = String.valueOf(input.charAt(i));  
        }  
        int back = 0;  
        for(int i=0;i<result.length;i++) {  
            if(!result[i].equals("0")) {  
                back = result.length-i-1;  
                out += nums[Integer.parseInt(result[i])];  
                out += units[back];  
            }else {  
                if(i==result.length-1) {  
                  
                }else {  
                    if(!result[i+1].equals("0")) {  
                        out += nums[0];  
                    }  
                }  
            }  
        }  
        return out;  
    }  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        input();  
        System.out.println(get(input));  
    }  
  
}
