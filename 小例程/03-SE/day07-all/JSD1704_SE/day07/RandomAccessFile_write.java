package day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 写出字符串
 * @author adminitartor
 *
 */
public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile("raf.txt","rw");
		
		String str = "夜空中最亮的星是否听清那仰望的人心底的孤独和叹息";
		System.out.println(str.length());
		/*
		 * 将字符串转换为一组字节:
		 * String提供了相关方法
		 * byte[] getBytes()
		 * 将当前字符串按照系统默认字符集转换为
		 * 
		 * byte[] getBytes(String csn)
		 * 按照指定字符集转换为一组字节(推荐)
		 */
		byte[] data = str.getBytes("GBK");
		
		raf.write(data);
		System.out.println("写出完毕!");
		raf.close();
	}
}






