package day08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流
 * InputStreamReader
 * @author adminitartor
 *
 */
public class InputStreamReader_read {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("osw.txt");
		
		InputStreamReader isr
			= new InputStreamReader(fis,"GBK");
		
		int d = -1;
		while((d = isr.read())!=-1){
			System.out.print((char)d);
		}
		
		isr.close();
	}
}









