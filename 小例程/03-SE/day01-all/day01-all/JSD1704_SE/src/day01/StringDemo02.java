package day01;
/**
 * "字符串对象"是不可以改变的！ 
 */
public class StringDemo02 {
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = s1;
		s1 = s1 + "DEF";
		System.out.println(s1); //ABCDEF
		System.out.println(s2); //ABC
	}

}
