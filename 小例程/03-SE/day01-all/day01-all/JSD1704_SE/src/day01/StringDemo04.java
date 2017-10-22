package day01;
/**
 * 字符串中存储的是char类型数据
 * 每个数据的值是Unicode编码值
 */
public class StringDemo04 {
	public static void main(String[] args) {
		String s = "ABC中国田地";
		//          0123 4 5 6
		//length 方法返回字符串中字符的个数
		int n = s.length();
		System.out.println(n);//7
		//字符串中每个字符有位置索引，从0开始
		//字符串提供了API，可以获取对应位置
		//的字符数据
		// charAt(位置) 返回位置上的字符
		char c = s.charAt(5);
		//输出一个字符的Unicode编码值！
		System.out.println((int)c);//30000 
		
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			System.out.println((int)ch);
		}
	}
}






