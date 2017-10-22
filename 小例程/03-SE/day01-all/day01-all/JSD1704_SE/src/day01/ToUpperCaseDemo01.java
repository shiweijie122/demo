package day01;
/**
 * 将字符串中的字符转换为大写字符 
 */
public class ToUpperCaseDemo01 {
	public static void main(String[] args) {
		String str = "Tom and Jerry";
		//将字符串转换为全部是大写字符
		//返回新字符串！
		str = str.toUpperCase();
		System.out.println(str); 
		
	//面试题：
		String name = "   Tom   ";
		name.trim();
		System.out.println(name);
		//如上代码的执行结果：
		//A.Tom  B.   Tom     C.编译错误 
		//D.运行异常
	}
}




