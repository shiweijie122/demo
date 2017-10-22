package day01;

public class StringDemo01 {
	public static void main(String[] args) {
		/*
		 * 任何字符串字面量（直接量）
		 *  “ABC” 都是String类型的对象
		 */
		String s = "abc";
		//length长度
		int n = s.length();
		System.out.println(n);//3
		//在字符串字面量上可以调用任何
		//String提供的方法
		int m = "ABCD".length();
		System.out.println(m);//4
	}
}





