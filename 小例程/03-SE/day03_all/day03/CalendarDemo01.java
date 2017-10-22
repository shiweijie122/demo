package day03;

import java.util.Calendar;

/**
 * 使用 Calendar  
 */
public class CalendarDemo01 {
	public static void main(String[] args) {
		//利用getInstance方法创建Calendar的对象
		//这个对象实际上是 格里高里历(公元历法)
		Calendar cal=Calendar.getInstance();
		System.out.println(cal);
		//显示一个对象的类名
		//getClass()返回对象的类型,getName()
		//返回类型的名字,就是类名
		String name=cal.getClass().getName();
		System.out.println(name);
		
		//在Cal上获取时间分量
		//获取cal对象中的年份数:
		int year=cal.get(Calendar.YEAR);
		//因为默认的cal时间是当前时间
		//则cal中的年份数据是 2017 年
		System.out.println(year);
		//获取月份数: 一月份从0开始
		int month = cal.get(Calendar.MONTH);
		System.out.println(month); 
		//获取日数
		int day = cal.get(Calendar.DATE);
		System.out.println(day);
		//获取星期
		int d=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(d);
	}
}







