package day01;
/**
 * Java 中字符常量池
 * Java字符串常量被缓存，替换为同一个字符串对象
 * 常量包括：字面量，常量，和字面量和常量连
 * 接的结果
 */
public class StringDemo03 {
	public static final String S = "ABC";
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		System.out.println(s1==s2);//true
		System.out.println(s1==S);//true
		//Java在运行期间动态创建新对象
		//动态创建的字符串对象不会利用常量池重用
		String s3 = new String("ABC");
		System.out.println(s1==s3);//false
		
		//Java 编译器会将 "A"+"BC" 优化为"ABC"
		String s4 = "A"+"BC";
		System.out.println(s1==s4);//true
		
	//面试题：
		String s5 = "A"+"B"+"C";
		//如上代码运行期间有几个字符串对象：
		//答案：1个 "ABC"
	
	//面试题：
		String s6 = "A"+"B"+"C"; //ABC
		String s7 = 'A'+"B"+"C"; //ABC
		String s8 = 'A'+'B'+"C"; //131C
		//如上代码运行期间有几个字符串对象：
		//答案：2个  "ABC" "131C"
	
	//面试题：
		String s9 = new String("ABC");
		//如上代码运行期间有几个字符串对象：
		//答案：2个  字面量 "ABC" 动态"ABC"
		
	//面试题：
		String s10 = new String("ABC");
		String s11 = new String("ABC");
		//如上代码运行期间有几个字符串对象：
		//答案：3个  字面量 "ABC" 2个动态"ABC"
	
	//面试题：
		String s12 = new String("A"+"BC");
		String s13 = new String("ABC");
		//如上代码运行期间有几个字符串对象：
		//答案：3个  字面量 "ABC" 2个动态"ABC"
		
	}
}





