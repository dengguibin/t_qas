package com.upath.plat.common.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
/**
 * 使用BeanUtils Date 类型的转换的问题
 * @author Administrator
 *
 */
@SuppressWarnings({ "rawtypes"})
public class DateConvert implements Converter {

	private static final Logger log = Logger.getLogger(DateConvert.class);
	
    public Object convert(Class type, Object inValue) {
    	if(inValue != null){
    		if(inValue instanceof String){
    			String str = (String)inValue;
    			 try {
					Date date =   DateUtils.parseDate(str, new String[] {
								"yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd HH:mm", "yyyy-MM-dd"});
					if(type.equals(java.util.Date.class) == true){
						return date;
					}else if(type.equals(java.sql.Date.class) == true){
						return new java.sql.Date(date.getTime());
					}
				} catch (ParseException e) {
					log.error(e);
				}
    		}
    	}
    	//如果是其它的类型进行自己返回
        return inValue;
    }

}