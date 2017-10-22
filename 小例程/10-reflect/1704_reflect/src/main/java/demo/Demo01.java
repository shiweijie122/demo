package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException{
		//"动态"加载类
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名:");
		//在运行期间动态获得类名
		String className = in.nextLine();
		//在运行期间根据动态的类型动态的将
		//类加载到内存方法区中
		Class cls = Class.forName(className);
		//cls代表加载的结果
		System.out.println(cls);
		
		//利用反射API动态创建对象
		Object obj = cls.newInstance();
		System.out.println(obj); 
		
		//动态获取一个类中声明的全部方法信息
		Method[] methods =
				cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method); 
		}
		//动态获取某个方法
		//Method m = cls.getDeclaredMethod(
		//		方法名, 参数类型列表);
		// 数据的类型: int.class  double.class
		//       String.class
		//获取 add(int , int)
		Method m = cls.getDeclaredMethod(
				"add", int.class, int.class);
		System.out.println(m); 
	}
}






