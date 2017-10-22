package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PrintWriter在流连接中的用法
 * @author adminitartor
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("pw1.txt");
		/*
		 * 如果在流连接中希望使用PW按照指定字符集
		 * 写出字符串时,需要自行添加转换流.并在
		 * 转换流中指定字符集
		 */
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"GBK");
		
		PrintWriter pw
			= new PrintWriter(osw);
		
		pw.println("丑八怪啊啊啊啊啊啊啊啊啊");
		pw.println("在这暧昧的时代");
		
		System.out.println("写出完毕!");
		
		pw.close();
		
		
	}
}






