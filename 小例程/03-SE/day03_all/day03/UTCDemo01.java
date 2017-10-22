package day03;

import java.util.Date;

/**
 * 认识一下 系统时间毫秒数 
 */
public class UTCDemo01 {
	public static void main(String[] args) {
		//1970元旦到现在累计的毫秒数
		long utc = System.currentTimeMillis();
		System.out.println(utc);
		//利用系统时间计算出当前的年份时间
		long year = 
			utc/1000/60/60/24/365 + 1970;
		System.out.println(year);
		//java.util.Date
		Date date = new Date(utc);
		int y = date.getYear()+1900;
		System.out.println(y); 
	}
}





