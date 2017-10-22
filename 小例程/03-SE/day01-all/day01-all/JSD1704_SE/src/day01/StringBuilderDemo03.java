package day01;
/**
 * String 的连接是利用StringBuilder实现的 
 */
public class StringBuilderDemo03 {
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = s1 + 123;
		//Java 在运行期间利用StringBuilder
		//的append方法实现字符串连接
		String s3 = new StringBuilder(s1)
				.append(123).toString();
		//多个字符串连接也是append
		String s4 = s1+123+456+"abc";
		//替换为：
		String s5 = new StringBuilder(s1)
				.append(123)
				.append(456)
				.append("abc")
				.toString();
		System.out.println(s4);
		System.out.println(s5);
	}
		
}





