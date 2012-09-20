package edu.njit.jcwh.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
 * @author Viking
 *
 *���ڴ�������·ݵľ�̬������
 */
public class DateUtil {
	
	public static Date rollMonth(int month) {
		GregorianCalendar gc = new GregorianCalendar();
		if(gc.get(GregorianCalendar.MONTH)==0&&month<0){
			gc.roll(GregorianCalendar.YEAR, -1);//�����ǰ�·���1�� ����monthС��1 ��ô����һ��
		}
		if(gc.get(GregorianCalendar.MONTH)==11&&month>=1){
			gc.roll(GregorianCalendar.YEAR, 1);//�����ǰ�·���12�� ����month���ڵ���1 ��ô����һ��
		}
		gc.roll(GregorianCalendar.MONTH, month);//�����·�
		Date recent3M = gc.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		Date date = Timestamp.valueOf(df.format(recent3M));// ��ʽ����õ���ʱ�侫ȷ���� �Ա��ڴ���
		return date;
	}
}
