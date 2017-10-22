package day02;
/**
 * Matches 方法默认按照从头到尾规则匹配 
 */
public class MatchesDemo03 {
	public static void main(String[] args) {
		String str = "12345678";
		//matches 方法在匹配时候, 自动按照
		//从头到尾的规则进行匹配, 相当于
		//自动添加了 ^ $, 也就是说在使用matches
		//方法时候 \d{6} 和 ^\d{6}$ 结果一样
		boolean b = str.matches("\\d{6}");
		System.out.println(b);//false 
	}
}




