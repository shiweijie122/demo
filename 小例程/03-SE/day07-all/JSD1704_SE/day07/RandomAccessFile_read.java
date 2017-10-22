package day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字符串
 * @author adminitartor
 *
 */
public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile("raf.txt","r");
		
		byte[] data = new byte[100];
		
		int len = raf.read(data);
		System.out.println("len:"+len);
		/*
		 * 字符串提供了构造方法可以将给定的字节数组
		 * 转换为字符串.
		 * String(byte[] d,int offset,int len,String csn)
		 * 将给定字节数组从下标offset处开始连续len个
		 * 字节按照csn指定的字符集转换为字符串
		 * 
		 */
		String str = new String(data,0,len,"gbk");
		System.out.println(str);
		
		raf.close();
		
	}
}



