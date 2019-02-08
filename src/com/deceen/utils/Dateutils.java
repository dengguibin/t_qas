package com.deceen.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class Dateutils {
	
	/**
	 * 例：今天是2018年5月10号，获得字符串201805
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public static String dateMonthstring(Date date){
		SimpleDateFormat f=new SimpleDateFormat("yyyyMM");
		return f.format(date);
	}
	
	/**
	 * 例：今天是2018年5月10号，获得字符串201806
	 * 获得下个月的字符串
	 * @param monthAdds:希望往后推几个月，若值为3则得到201809
	 * @return 
	 * @author dengguibin
	 */
	public static String dateNextMonthstring(Date date,int monthAdds){
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(date);
	    calendar.add(calendar.MONTH,monthAdds);//把月份往后推一天
	    date=calendar.getTime(); 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
	    String dateString = formatter.format(date);
		return dateString;
	}
	
	
}
