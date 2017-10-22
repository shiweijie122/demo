package day02;
/**
 * replaceAll 替换字符串中全部满足规则的字符串 
 *
 */
public class ReplaceAllDemo {
	public static void main(String[] args) {
		String str="1|范老师|110|fan@tedu.cn";
		//将str中被\|匹配上的数据替换为 ,
		String s = str.replaceAll("\\|",",");
		System.out.println(s); 
	}
}




