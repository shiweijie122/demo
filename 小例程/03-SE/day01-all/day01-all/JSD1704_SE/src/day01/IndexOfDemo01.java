package day01;
/**
 * indexOf 检索字符中字符的位置
 */
public class IndexOfDemo01 {
	public static void main(String[] args) {
		String str = 
			"http://tedu.cn/index.html";
		//   01234567890123456
		//在字符串str中检索'/'所在的位置
		int n = str.indexOf('/');
		System.out.println(n);//5
		//在字符串str中检索"tedu"出现的位置
		int m = str.indexOf("tedu");
		System.out.println(m);//7
		//如果查找不到返回 -1
		n = str.indexOf("tom");
		System.out.println(n); //-1
		
		//从7位置开始检索 “/”的位置
		n = str.indexOf("/", 7);
		System.out.println(n);//14
	}
}






