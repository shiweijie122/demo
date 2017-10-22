package day01;
/*
 * 检查一个字符串的开头和结尾
 */
public class StartsWithDemo01 {
	public static void main(String[] args) {
		String name = "王宝强";
		//检查name是否以 "王" 为开头
		boolean b = name.startsWith("王");
		System.out.println(b); //true
		
		String file = "摔跤吧，爸爸.avi";
		//检查file名字是否是以 .avi 为结尾
		b = file.endsWith(".avi");
		System.out.println(b); //true
		
	}

}
