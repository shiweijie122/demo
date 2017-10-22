package day01;
/**
 * StringBuilder 内容可变的字符串 
 */
public class StringBuilderDemo01 {
	public static void main(String[] args) {
		StringBuilder buf = 
			new StringBuilder("ABCD");
		buf.reverse();
		System.out.println(buf); 
	}
}
