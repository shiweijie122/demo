package day03;

import java.util.Calendar;

/**
 * 利用set方法修改时间分量 
 */
public class CalendarDemo02 {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		//修改(设置)年份分量
		cal.set(Calendar.YEAR, 2008);
		//修改月份分量
		cal.set(Calendar.MONTH, 
				Calendar.AUGUST);//8月
		//修改日期分量
		cal.set(Calendar.DATE, 8);
		System.out.println(cal); 
		//将cal转换为Date输出
		System.out.println(cal.getTime()); 
	}
}





