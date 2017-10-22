package day01;

import java.util.Scanner;

/**
 * 检查用户输入的信息中是否包含敏感词 
 */
public class IndexOfDemo02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("输入：");
		String str = in.nextLine();
		//检查敏感词
		String key = "我去";
		//如果str中包含key这返回值>=0
		int n = str.indexOf(key);
		if(n>=0){
			System.out.println("不能乱说！");
		}
	}
}








