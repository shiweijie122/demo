package day03;

import java.util.Calendar;
/**
 * 测试时间分量加法 
 */
public class CalendarDemo04 {
	public static void main(String[] args) {
		//系统当前时间
		Calendar cal=Calendar.getInstance();
		//在当前时间基础上增加3个月
		cal.add(Calendar.MONTH, 3);
		//显示增加的结果
		System.out.println(cal.getTime()); 
	}
}





