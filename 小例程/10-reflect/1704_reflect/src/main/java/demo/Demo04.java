package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args)
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("类名:");
		String className=in.nextLine();
		
		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		
		Method[] methods=cls.getDeclaredMethods();
		
		for (Method method : methods) {
			//检查 method 是否声明了 @Test 
			Object ano=method.getAnnotation(Test.class);
			if(ano!=null){
				method.setAccessible(true);
				method.invoke(obj);
			}
		}
	}
}





