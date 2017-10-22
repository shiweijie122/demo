package day08;

import java.io.PrintWriter;

/**
 * IO中的异常处理
 * @author adminitartor
 *
 */
public class Exception_finally2 {
	public static void main(String[] args) {
		PrintWriter pw = null;
		try{
			pw = new PrintWriter("pw2.txt");
			pw.println("helloworld!");
		}catch(Exception e){
			System.out.println("出错了!");
		}finally{
			if(pw != null){
				pw.close();
			}	
		}
	}
}



