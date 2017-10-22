package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * JUnit 3 的原型
 * 动态执行一个类的全部以 test 为开头的方法
 */
public class Demo03 {
	public static void main(String[] args) 
		throws Exception{
		Scanner in=new Scanner(System.in);
		System.out.print("输入类名:");
		String className=in.nextLine();
		
		//动态加载类
		Class cls = Class.forName(className);
		//动态创建对象
		Object obj = cls.newInstance();
		//动态查找全部方法
		Method[] methods = 
				cls.getDeclaredMethods();
		//检查那个方法名是以test为开头的
		for (Method method : methods) {
			//动态获取方法名
			String name=method.getName();
			//检查方法名是否以 test 为开头的
			if(name.startsWith("test")){
				//method?
				method.setAccessible(true);
				method.invoke(obj);
			}
		}
	}
}








