package day02;

/**
 * 10进制字符串到基本类型数据(二进制)的转换方法
 */
public class ParseDoubleDemo {
	public static void main(String[] args) {
		//10进制字符串到基本类型数据(二进制)
		//的转换方法
		
		//Java内存中的基本类型都是2进制数据
		//人类能够处理的数据都是10进制字符串
		
		//包装类提供了将10进制字符串转换为2进制数据的方法:
		
		//int Integer.parseInt("10进制字符串");
		//double Double.parseDouble(
		//   "10进制小数字符串");
		
		int n = Integer.parseInt("45");
		double d = Double.parseDouble("3.14");
		System.out.println(n);
		System.out.println(d);
	}
}









