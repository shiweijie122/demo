package day01;
/**
 * 截取子字符串 
 */
public class SubstringDemo01 {
	public static void main(String[] args) {
		String str = 
				"http://tedu.cn/index.html";
		//       012345678901234567
		// host="tedu.cn" host: 主机
		// 从str字符串的7开始截取到14位置
		String host=str.substring(7,14);
		System.out.println(host);
		//按照长度截取子字符串：
		//从7位置开始连续截取4个字符
		String s = str.substring(7, 4+7);
		System.out.println(s);
		//从开始位置到结束全部截取下来
		String ss = str.substring(15);
		System.out.println(ss);
		
	}
}






