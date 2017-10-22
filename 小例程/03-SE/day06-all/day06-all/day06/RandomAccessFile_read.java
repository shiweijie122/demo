package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取一个字节
 * @author adminitartor
 *
 */
public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","r"	
			);
		/*
		 * int read()
		 * 读取一个字节,并以10进制的int值
		 * 形式返回.如果返回值为-1,则表示
		 * 读取到文件末尾.
		 * 
		 * 00000000 00000000 00000000 00000001
		 * 
		 */
		int d = raf.read();
		System.out.println(d);
		
		raf.close();
	}
}







