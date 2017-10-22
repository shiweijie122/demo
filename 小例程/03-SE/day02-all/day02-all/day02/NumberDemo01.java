package day02;
/**
 * 包装类 
 */
public class NumberDemo01 {
	public static void main(String[] args) {
		Integer i=new Integer(10);
		Double d=new Double(3.1415926535897);
		System.out.println(i);//10
		System.out.println(d);//3.14...
		//在Number上定义的类型转换方法
		double x=i.doubleValue();
		System.out.println(x);
		float f = d.floatValue();
		System.out.println(f);
		//...
		
		
		
	}
}



