package com.deceen.data.poi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date formate(String d){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");//小写的mm表示的是分钟  
		Date date = null;;
		try {
			date = sdf.parse(d);
			
//			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");  
//			java.util.Date date1 = new java.util.Date();  
//			String str= sdf.format(date);  
			
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return date;
	}
	
	public static int getTimeDifference(String data){
        if (data == null || data.length()<4) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        //得到当前的年份
        String cYear = sdf.format(new Date()).substring(0,4);
        String cMouth = sdf.format(new Date()).substring(4,6);
        //得到传入参数年份
        String d_Year = data .substring(0,4);
        String d_Mouth = data .substring(4,6);
        int time = Integer.parseInt(cYear) - Integer.parseInt(d_Year);
        if ((Integer.parseInt(cMouth) - Integer.parseInt(d_Mouth))<0) {
            time=time-1;
        }else if ((Integer.parseInt(cMouth) - Integer.parseInt(d_Mouth))==0) {
            time = Integer.parseInt(cYear) - Integer.parseInt(d_Year);
        }else if ((Integer.parseInt(cMouth) - Integer.parseInt(d_Mouth))>0) {
            time = Integer.parseInt(cYear) - Integer.parseInt(d_Year);
        }
        return time;
    }
}
