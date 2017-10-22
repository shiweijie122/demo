package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 从控制台输入时间, 将时间赋值到Calendar对象 
 */
public class CalendarDemo05 {
	public static void main(String[] args)
		throws Exception{
		//控制台输入 字符串 类型时间
		Scanner in=new Scanner(System.in);
		System.out.print("输入时间:");
		String str = in.nextLine();
		//将字符串类型时间解析为Date
		SimpleDateFormat fmt =
			new  SimpleDateFormat(
			"yyyy-M-d");
		Date date = fmt.parse(str);
		//将date时间转换到Calendar时间
		Calendar cal = Calendar.getInstance();
		//cal中的时间修改为date的时间
		cal.setTime(date);
		System.out.println(cal);
		

		
	}
}












