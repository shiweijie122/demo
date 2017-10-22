package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) 
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名:");
		String className=in.nextLine();
		System.out.print("输入方法名:");
		String methodName=in.nextLine();
		
		//动态加载类
		Class cls = Class.forName(className);
		//动态查找无参数方法信息
		Method method=cls.getMethod(methodName);
		//动态创建对象
		Object obj = cls.newInstance();
		
		//动态执行方法: 执行无参数方法 
		Object val = method.invoke(obj);
		System.out.println("返回值:"+val);
	}
}









