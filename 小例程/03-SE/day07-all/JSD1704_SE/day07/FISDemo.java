package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 文件输入流
 * java.io.FileInputStream
 * @author adminitartor
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("fos.txt");
		
		byte[] data = new byte[100];
		int len = fis.read(data);
		
		String str = new String(data,0,len,"GBK");
		System.out.println(str);
		
		fis.close();
		
	}
}










