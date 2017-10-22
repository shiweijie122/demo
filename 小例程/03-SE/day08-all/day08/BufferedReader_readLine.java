package day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流
 * 可以按行读取字符串
 * @author adminitartor
 *
 */
public class BufferedReader_readLine {
	public static void main(String[] args) throws IOException {
		/*
		 * 将当前代码的源程序读取出来并输出
		 * 到控制台.
		 */
		FileInputStream fis
			= new FileInputStream(
				"."+File.separator+
				"src"+File.separator+
				"day08"+File.separator+
				"BufferedReader_readLine.java"
			);
		
		InputStreamReader isr
			= new InputStreamReader(fis);
		BufferedReader br 
			= new BufferedReader(isr);
		/*
		 * String readLine()
		 * 按行读取字符串,会连续读取若干个
		 * 字符,直到读取到换行符为止,然后将
		 * 换行符之前的所有字符组成一个字符串
		 * 返回.当返回为值NULL时,表示读取到
		 * 文件末尾.
		 */
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		
		br.close();
	}
}










