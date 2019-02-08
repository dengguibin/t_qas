package com.deceen.mty.utils;

import java.io.File;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author YYH
 * 2017年11月10日
 */
public class YyhUtil {
	
	/**yyyy-MM-dd*/
	public static final String DATE = "yyyy-MM-dd";
	/**yyyy/MM/dd*/
	public static final String DATE2 = "yyyy/MM/dd";
	/**HH-mm-ss*/
	public static final String TIME = "HH-mm-ss";
	/**yyyy-MM-dd-HH-mm-ss*/
	public static final String DATETIME = "yyyy-MM-dd-HH-mm-ss";
	
/*	@Test
	public void test01() {
		String html = YyhUtil.ftlToHtml("tqas/analy/analy.ftl", YyhUtil.TIME, "Test");
		System.out.println(html);
		String str = yyhMkdirs("E:/YYH/freemarker/htmlfile/", "a");
		System.out.println(str);
	}*/
							//E:/Analys/analy/pages/  //2017/12/15    //task00/obj
	public static String mkdirs(String root,String date,String taskAndObj) {
		String pathname =date+ "/" + taskAndObj;//2017/12/15/task00/obj
		File file = new File(root + pathname);//E:/Analys/analy/pages/2017/12/15/task00/obj
		if (!file.exists()) {
			file.mkdirs();
		}
		return pathname + "/";//2017/12/15/task00/obj/
	}
	
	public static String changeDate(String date) {
		return date.replace("-", "/");
	}
	
	/*public static void main(String[] args) {
		System.out.println(YyhUtil.getNowTime("aa:"+changeDate(DateUtil.getNowDate(DATE2))));//2017/12/15
		}*/
	
	/**
	 * 传入  demo/index.ftl
	 * 输出  yyyy-MM-dd-index.html
	 * @param ftl
	 * @return html
	 */
	//tqas/analy/171211/indexDetail.ftl  //10-57-47(时分秒)  //""
	public static String ftlToHtml(String ftl, String now, String suffix,int mark) {
		
		if (StringUtils.isNotEmpty(ftl)) {
			int beginIndex = ftl.lastIndexOf("/")+1;
			int endIndex = ftl.lastIndexOf(".");
			String fileName = ftl.substring(beginIndex, endIndex);
			if(mark==1000000000){
				return now + "-" + fileName + suffix + ".html";//10-57-47-analyGeneral.html  //10-57-47-indexDetail.html
			}else{
				return now + "-" + fileName + suffix+mark + ".html";
			}  //10-57-47-itemAnalyTest1.html
		}
		return null;
	}

	/**
	 * 根据指定格式返回当前时、分、秒
	 * @param date
	 * @return
	 */
	public static String getNowTime(String date) {
		String now = "";
		if (DATE.equalsIgnoreCase(date)) {
			now = DateUtil.getNowDate(DATE);
		} else if (TIME.equalsIgnoreCase(date)) {
			now = DateUtil.getNowDate(TIME);
		} else if (DATETIME.equalsIgnoreCase(date)) {
			now = DateUtil.getNowDate(DATETIME).replace(" ", "-").replace(":", "-");
		}
		return now;
	}
	
/*	public static void main(String[] args) {
		System.out.println(YyhUtil.getNowTime(TIME));//10-57-47(时分秒)
	}*/

	/** 
     * 对象属性转换为字段  例如：userName to user_name 
     * @param property 字段名 
     * @return 
     */  
    public static String propertyToField(String property) {  
        if (null == property) {  
            return "";  
        }  
        char[] chars = property.toCharArray();  
        StringBuffer sb = new StringBuffer();  
        for (char c : chars) {  
            if (CharUtils.isAsciiAlphaUpper(c)) {  
                sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));  
            } else {  
                sb.append(c);  
            }  
        }  
        return sb.toString();  
    }  
  
    /** 
     * 字段转换成对象属性 例如：user_name to userName 
     * @param field 
     * @return 
     */  
    public static String fieldToProperty(String field) {  
        if (null == field) {  
            return "";  
        }  
        char[] chars = field.toCharArray();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < chars.length; i++) {  
            char c = chars[i];  
            if (c == '_') {  
                int j = i + 1;  
                if (j < chars.length) {  
                    sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));  
                    i++;  
                }  
            } else {  
                sb.append(c);  
            }  
        }  
        return sb.toString();  
    }
    
}
