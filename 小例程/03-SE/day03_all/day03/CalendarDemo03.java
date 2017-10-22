package day03;

import java.util.Calendar;

/**
 * 获取当前月中天数的最大值 
 */
public class CalendarDemo03 {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		//Actual: 实际上
		//Maximum 最大值
		//当使用DATE参数时候返回是当前月
		//中最大的天数
		cal.set(Calendar.MONTH,Calendar.JANUARY);
		int n = 
		 cal.getActualMaximum(Calendar.DATE);
		System.out.println(n);
		
		for(int m=Calendar.JANUARY; 
				m<=Calendar.DECEMBER; m++){
		//int m = 0~11;// Calendar.FEBRUARY;
			cal.set(Calendar.MONTH,m);
			n = 
			 cal.getActualMaximum(Calendar.DATE);
			System.out.println(n);
		}

	}
}





