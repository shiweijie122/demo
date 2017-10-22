package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 人生不过3万天
 */
public class DateFormatDemo02 {
	public static void main(String[] args) {
		//人生不过3万天
		long n = System.currentTimeMillis();
		//3万天以后
		n += 1000L*60*60*24*30000;
		Date date = new Date();
		date.setTime(n);
		//利用DateFormat输出时间
		SimpleDateFormat fmt=
			new SimpleDateFormat(
			"yyyy-M-d HH:mm:ss");
		String str = fmt.format(date);
		System.out.println(str); 
	}
}


