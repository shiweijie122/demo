package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算合同签订提醒日: 
 */
public class CalendarDemo06 {

	public static void main(String[] args)
		throws Exception {
		//Calendar API
		// getInstance()
		// get() 获取时间分量
		// set() 设置(修改)时间分量
		// add() 增加/减少时间分量
		// setTime() 将date转换cal
		// getTime() 将cal转换为Date
	
	//业务规则:
		// 劳动合同提醒规则:
		// 合同到期的的前一个月为签订截止日期
		// 在截止日期前两周作为签订提醒日
		// 如果是周末,顺延到工作日
	
	//业务分析:
		//1. 输入合同签订日期Date和年限
		//2. Date 日期转换为Cal
		//3. Cal是合同签订日期
		//4. 计算劳动合同到期日
		//   cal.add(年, 年限)
		//5. 计算劳动合同续签日截止日
		//   cal.add(月, -1)
		//6. 计算签订提醒日 (2周前)
		//	 cal.add(周, -2) 或 cal.(天, -14)
		//7. 检查星期时间分量
		//   cal.get(DAY_OF_WEEK) 
		//   1: cal.add(天,1);
		//   7: cal.add(天,2);
		//8. 显示时间
		//    Date date=cal.getTime();
		//    fmt.format(date) 

	//业务实现:
		//1. 输入合同签订日期Date和年限
		Scanner in=new Scanner(System.in);
		System.out.print("输入签订日期:");
		String sign = in.nextLine();
		System.out.print("输入年限:");
		String years = in.nextLine();
		SimpleDateFormat fmt=
			new SimpleDateFormat(
			"yyyy-MM-dd");
		Date date=fmt.parse(sign);
		//将字符串年数转换为整数
		int y = Integer.parseInt(years);
		System.out.println(date);
		System.out.println(y);
		//2. Date 日期转换为Cal
		Calendar cal=Calendar.getInstance();
		cal.setTime(date); 
		//3. Cal是合同签订日期
		//4. 计算劳动合同到期日
		//   cal.add(年, 年限)
		cal.add(Calendar.YEAR, y); 
		//5. 计算劳动合同续签日截止日
		//   cal.add(月, -1)
		cal.add(Calendar.MONTH, -1);  
		//6. 计算签订提醒日 (2周前)
		//	 cal.add(周, -2) 或 cal.(天, -14)
		cal.add(Calendar.WEEK_OF_YEAR, -2); 
		//7. 检查星期时间分量
		//   cal.get(DAY_OF_WEEK) 
		//   1: cal.add(天,1);
		//   7: cal.add(天,2);
		int day=cal.get(Calendar.DAY_OF_WEEK);
		if(day==Calendar.SUNDAY){//周日
			cal.add(Calendar.DATE, 1);
		}
		if(day==Calendar.SATURDAY){//周六
			cal.add(Calendar.DATE, 2);
		}
		//8. 显示时间
		//    Date date=cal.getTime();
		//    fmt.format(date) 
		Date d = cal.getTime();
		String s = fmt.format(d);
		System.out.println(s); 
	}

}





