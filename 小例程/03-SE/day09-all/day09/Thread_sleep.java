package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep阻塞
 * 
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 该方法可以阻塞运行该方法的线程指定毫秒,
 * 当超时后,线程会再次回到runnable状态等待
 * 再次分配CPU时间片运行.
 * 通常会使用sleep做定时周期性执行任务.
 * 
 * @author adminitartor
 *
 */
public class Thread_sleep {
	public static void main(String[] args) {
		/*
		 * 实现电子表功能
		 * 要求每秒钟在控制台输出一次当前
		 * 系统时间,格式如:15:21:35
		 */
		try {
			SimpleDateFormat sdf
				= new SimpleDateFormat("HH:mm:ss");
			while(true){
				Date date = new Date();
				System.out.println(sdf.format(date));
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}







