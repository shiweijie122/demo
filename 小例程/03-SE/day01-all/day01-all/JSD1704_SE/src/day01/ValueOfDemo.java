package day01;
/**
 * valueOf 将其他类型转换为字符串
 */
public class ValueOfDemo {
	public static void main(String[] args) {
		double pi = 3.1415926535897932384;
		//输出一个double时候自动调用了
		//String.valueOf()方法，将2进制
		//的double转换为10进制的字符输出！
		System.out.println(pi);
		//相当于:
		String s = String.valueOf(pi);
		System.out.println(s); 
		//在字符串连接之前Java会利用 
		//String.valueOf()转换数据再进行
		//字符串连接！
		String str = "PI:"+pi;
		System.out.println(str); 
		
	//案例：将数字和boolean类型进行字符串连接
		int num = 520;
		boolean b = true;
		//需要得到：520true
		String ss = String.valueOf(num)+
				String.valueOf(b);
		System.out.println(ss); 
	}
}


