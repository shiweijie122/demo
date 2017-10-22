package day02;

import java.util.Scanner;

/**
 * 利用replaceAll 实现敏感词的过滤功能 
 */
public class ReplaceAllDemo02 {
	public static void main(String[] args) {
		String reg = 
			"(我去|我草|去年买了表|次奥)";
		Scanner in = new Scanner(System.in);
		System.out.print("输入:");
		String str = in.nextLine();
		//利用replaceAll过滤敏感词
		String s = str.replaceAll(reg,"XX");
		System.out.println(s); 
	}
}




