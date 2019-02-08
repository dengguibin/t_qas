package com.deceen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CronUtil {

	public static String getCron(int type){
		String cron="";
		switch (type) {
		case 0:
			cron = "0 0 0 L * ?";		//	每月末执行一次
			break;
		case 1:
			cron = "0 0 0 ? * 1";		//	每周一执行一次
			break;
		case 2:
			cron = "0 0 0 * 3,9 ?";		//	每学期开学执行一次
			break;
		case 3:
			cron = "0 0 0 L 12 ?";		//	每年年底执行一次
			break;
		default:
			break;
		}
		return cron;
	}
	
	public static String getCron(String str) throws ParseException{
		Long l = Long.parseLong(str);
		SimpleDateFormat mat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String ss = mat.format(l);
		Date d = mat.parse(ss);
		return getCron(d);
	}
	
	public static String getCron(Date  date){  
		String dateFormat="ss mm HH dd MM ? yyyy";  
		return formatDateByPattern(date, dateFormat);  
	}

	public static String formatDateByPattern(Date date,String dateFormat){  
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);  
		String formatTimeStr = null;  
		if (date != null) {  
			formatTimeStr = sdf.format(date);  
		}  
		return formatTimeStr;  
	}
}
