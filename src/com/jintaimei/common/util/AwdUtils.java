package com.jintaimei.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author raymondwu
 *
 */
public class AwdUtils {

	/**
	 * 
	 * @return 返回一个UUID
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 根据时间和转换格式,返回一个字符串的日期;
	 * @param date
	 * @param parrten
	 * @return
	 */
	public static String getDateToString (Date date,String parrten) {
		SimpleDateFormat sd = new SimpleDateFormat(parrten);
		try {
			return sd.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[]  aa){
		System.out.println(getUUID());
	}
	
}
