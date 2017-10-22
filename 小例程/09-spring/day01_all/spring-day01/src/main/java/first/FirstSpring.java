package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {

	public static void main(String[] args) {
		String config = 
				"applicationContext.xml";
		/*
		 * ApplicationContext:是一个接口。
		 * ClassPathXmlApplicationContext是
		 * 一个实现了上述接口的具体类，该类
		 * 依据类路径去查找配置文件，然后启动
		 * spring容器。
		 */
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		//System.out.println(ac);
		
		/*
		 * 通过容器获得对象
		 * 	getBean方法：第一个参数是bean的id,
		 * 	第二个参数是该对象对应的Class对象。
		 */
		Apple a1 = ac.getBean(
				"a1",Apple.class);
		
		Date date1 = 
				ac.getBean("date1",
						Date.class);
		System.out.println(date1);
		
		Calendar cal1 = 
				ac.getBean("cal1",
						Calendar.class);
		System.out.println("cal1:" + cal1);
		
		Date time1 = 
				ac.getBean("time1",
						Date.class);
		System.out.println("time1:" + time1);
		
		
	}
	

}
