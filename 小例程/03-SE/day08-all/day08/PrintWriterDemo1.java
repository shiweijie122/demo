package day08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓冲字符输入输出流
 * 缓冲字符流的特点:可以按行读写字符串
 * BufferedWriter,BufferedReader
 * 
 * PrintWriter内部集成了BufferedWriter作为
 * 缓冲作用,它自身有提供了自动行刷新功能.
 * 
 * @author adminitartor
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * PW提供了直接针对文件写操作的构造方法
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 * 
		 * 按照指定字符集对文件写操作
		 * PrintWriter(String path,String csn)
		 * PrintWriter(File file,String csn)
		 */
		PrintWriter pw 
			= new PrintWriter("pw.txt","GBK");
		
		pw.println("你还要我怎样,");
		pw.println("要怎样,");
		pw.println("你突然来的短信就够我悲伤.");
		
		System.out.println("写出完毕!");
		
		pw.close();
	}
}








