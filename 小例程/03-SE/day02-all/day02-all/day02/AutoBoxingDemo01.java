package day02;
/**
 * Java 5 提供了自动包装方法, 可以自动的将
 * 基本类型转换为包装类型对象  
 */
public class AutoBoxingDemo01 {

	public static void main(String[] args) {
		//自动包装原理: Java编译器进行代码
		//替换, 替换为相应的方法.
		Integer i = 10;
		//Integer i = Integer.valueOf(10);
		Double d = 3.4;
		//自动拆包
		int n = i;
		// n = i.intValue();
		double y = d;
		System.out.println(n);//10
		System.out.println(y);//3.4
	}
}




