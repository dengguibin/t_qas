package com.upath.plat.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.cache.ICacheCode;
import com.upath.plat.common.exception.PlatformException;
@SuppressWarnings({"unchecked"})
public class DateUtil extends DateUtils {

	
	public static Date addWorkDays(Date date,int amount){
		if(date == null || amount < 0){
			throw new PlatformException("传入错误的参数 日期 "+date+"天数 ： "+amount);
		}
		List<ICacheCode> codes =  CacheManager.getInstance().getCodes("WORKDAYS");
		Calendar calendar = Calendar.getInstance();
			if(codes != null){
					calendar.setTime(date);
					int year = -1;
					String configs[] = null;
					for(int i = 0 ; i < amount ; i++){
						if(year != calendar.get(Calendar.YEAR)){
							year = 	calendar.get(Calendar.YEAR);
							ICacheCode cache = CacheManager.getInstance().getCode("WORKDAYS", year+"");
							if(cache == null){
								throw new PlatformException("无法找"+year+"年到工作日期配置信息");
							}
							String str = cache.getCname();
							configs = str.split(",");
							if(configs.length != 12){
								throw new PlatformException("节假日期配置错误");
							}
						}
						calendar.add(Calendar.DAY_OF_YEAR, 1);
						int month = calendar.get(Calendar.MONTH);
						int day = calendar.get(Calendar.DAY_OF_MONTH);
						//是配置的节假日期跳过再计算
						if( (Integer.valueOf(configs[month]) & (1 << (day - 1))) > 0){
							i--;
						}
						
					}
			}else{
				throw new PlatformException("无法找到工作日期配置信息");
			}
		return calendar.getTime();
	}
}
