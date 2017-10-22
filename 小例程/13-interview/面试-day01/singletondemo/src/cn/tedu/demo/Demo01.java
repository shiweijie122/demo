package cn.tedu.demo;
/**
 * 内存这件事
 * @author adminitartor
 *
 */
public class Demo01 {
	public static void main(String[] args) {
//		int i = 3;
		String str = "gbk";
		char[] chs = {'a','b','c'};
		Demo01 demo01 = new Demo01();
		demo01.change(str, chs);
		System.out.println(str);
		System.out.println(chs);
	}
	
	public void change(String str1,char[] chs){
		str1 = "abk";
		chs[0] = 'k';
	}

}
