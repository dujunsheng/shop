package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	* 日期转换成字符串
	* @param date
	* @return str
	*/
	public static String date2Str(Date date) {	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   String str = format.format(date);
	   return str;
	}

	/**
	* 字符串转换成日期
	* @param str
	* @return date
	*/
	public static Date str2Date(String str) {	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Date date = null;
	   try {
	    date = format.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}

	/**
	 * 将日期加n个月
	 * @param date  原始日期
	 * @param months 要加的月份
	 * @return
	 */
	public static Date addMonths(Date date , int months) {
		Calendar c= Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		Date d=c.getTime();
		return d;
	}
	
}
