package day03;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * 从控制台输入时间字符串, 
 * 利用 SimpleDateFormat parse() 方法
 * 解析为Date时间 
 */
public class ParseDemo {
	public static void main(String[] args) 
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入时间:");
		String str = in.nextLine();
		
		//创建SimpleDateFormat, 指定解析日期的
		//格式: yyyy-M-d
		SimpleDateFormat fmt=
			new SimpleDateFormat(
			"yyyy-MM-dd HHmmss");
		//将人类输入的日期字符串, 解析为
		//Java系统时间date, 如果输入时间
		//不符合预定的规则yyyy-M-d 时候
		//将出现异常!! 民国21年 出现异常
		Date date=fmt.parse(str);
		System.out.println(date);
		//得到毫秒数
		System.out.println(date.getTime());
	}
}








