package edu.njit.jcwh.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
 * @author Viking
 *
 *用于处理滚动月份的静态工具类
 */
public class DateUtil {
	
	public static Date rollMonth(int month) {
		GregorianCalendar gc = new GregorianCalendar();
		if(gc.get(GregorianCalendar.MONTH)==0&&month<0){
			gc.roll(GregorianCalendar.YEAR, -1);//如果当前月份是1月 而且month小于1 那么减少一年
		}
		if(gc.get(GregorianCalendar.MONTH)==11&&month>=1){
			gc.roll(GregorianCalendar.YEAR, 1);//如果当前月份是12月 而且month大于等于1 那么增加一年
		}
		gc.roll(GregorianCalendar.MONTH, month);//计算月份
		Date recent3M = gc.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		Date date = Timestamp.valueOf(df.format(recent3M));// 格式化后得到的时间精确到月 以便于处理
		return date;
	}
}
