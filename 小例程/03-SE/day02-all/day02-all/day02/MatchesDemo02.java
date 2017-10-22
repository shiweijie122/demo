package day02;

import java.util.Scanner;

/**
 * 检查用户从控制台输入的电话号码是否符合规则 
 */
public class MatchesDemo02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String reg = 
				"^(\\+86|0086)?\\s?\\d{11}$";
		while(true){
			System.out.print("电话号码:");
			String str = in.nextLine();
			if(str.matches(reg)){
				System.out.println("OK");
				break;
			}
			System.out.println("重来!");
		}
	}
}





