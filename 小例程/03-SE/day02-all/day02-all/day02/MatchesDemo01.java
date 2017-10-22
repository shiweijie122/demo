package day02;
/**
 * String matches 方法 
 * 	
 * 		被检查文本.matches(正则表达式)
 * 
 * 检查一个文本是否完全符合正式表达式规则
 */
public class MatchesDemo01 {
	public static void main(String[] args) {
		//Java 字符串中的特殊字符需要转义
		// \' \" \\ 回车 换行
		String regex = 
			"^(\\+86|0086)?\\s?\\d{11}$";
		System.out.println(regex); 
		String str = "0086 15601035818";
		//检查str是否全部符合regex的规则
		//就是检查电话号码是否符合规则
		boolean b=str.matches(regex);
		System.out.println(b); 
	}

}
