package day03;

import java.text.SimpleDateFormat;
import java.util.Date;
/** 日期的格式化输出 */
public class DateFormatDemo {
	public static void main(String[] args) {
		//创建date对象,默认是当前时间
		Date date = new Date();
		//创建fmt对象
		SimpleDateFormat fmt = 
			new SimpleDateFormat();
		//调用format方法将date中的时间信息
		//格式化为人类习惯的日期: 年月日字符串
		String str=fmt.format(date);
		System.out.println(str);
		System.out.println(date);
		
 	}
}



