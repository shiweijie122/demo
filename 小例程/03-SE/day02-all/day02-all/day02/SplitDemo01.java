package day02;
/**
 * 将字符串"劈开" 
 */
public class SplitDemo01 {
	public static void main(String[] args) {
		String str = 
			"1, 范老师, 110, fan@tedu.cn";
		//split 按照正则表达式匹配的位置
		//将字符串劈开
		String[] data = str.split(",\\s?");
		for(int i=0; i<data.length; i++){
			System.out.println(data[i]);
		}
	}	

}
