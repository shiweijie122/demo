package day03;

import java.util.Date;
/**
 * Date API 
 */
public class DateDemo01 {
	public static void main(String[] args) {
		//创建Date对象: 默认封装的是当前系统时间
		Date date = new Date();
		//提示: date重写了toString
		System.out.println(date);
		//获取当前时间毫秒数的方法
		long now = date.getTime();
		System.out.println(now);
		//如何将date时间转换为毫秒数?
		
		//利用setTime改变时间
		
		//案例:计算3天以后是哪一天?
		//思路: 1. 获取当前时间毫秒数
		//      2. 增加3天的毫秒数 
		//         1000L*60*60*24*3 
		//      3. 将毫秒数装入到date
		//      4. 输出Date得到3天以后是哪一天
		long n = System.currentTimeMillis();
		n += 1000L*60*60*24*3;
		System.out.println(n);
		Date d = new Date();
		//修改date的时间, 到n指定的毫秒数
		d.setTime(n);
		//输出3天以后的时间
		System.out.println(d);
	}
}






