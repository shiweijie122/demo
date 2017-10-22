package day01;
/**
 * 去除字符串前后两端的空白
 */
public class TrimDemo01 {
	public static void main(String[] args) {
		//空白字符的编码 < 32
		System.out.println((int)'\t');
		System.out.println((int)'\n');
		System.out.println((int)'\r');
		System.out.println((int)' ');
		//包含空白的字符串
		String name="\t Tom and Jerry \r\n";
		//去除字符串两端的空白
		String str = name.trim();
		System.out.println(str);
		System.out.println(name);
	}
}






