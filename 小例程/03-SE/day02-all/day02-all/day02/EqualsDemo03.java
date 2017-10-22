package day02;
/**
 * == 只能用于比较变量是否相等
 * 比较对象必须使用 equals方法! 
 */
public class EqualsDemo03 {
	public static void main(String[] args) {
		int i = 5;
		int m = 5;
		String s1 = "ABC";
		String s2 = s1;
		String s3 = new String("ABC");
		System.out.println(i==m);//true
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//false
		System.out.println(s1.equals(s3));//true
	}

}
