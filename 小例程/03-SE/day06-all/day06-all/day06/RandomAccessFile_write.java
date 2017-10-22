package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 基于指针读写文件数据.
 * 
 * @author adminitartor
 *
 */
public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
		/*
		 * 对当前目录中的raf.dat文件进行写操作
		 * 常用构造方法:
		 * RandomAccessFile(String path,String mode)
		 * RandomAccessFile(File file,String mode)
		 * 
		 * 其中第二个参数为模式:
		 * "r":只读模式
		 * "rw":读写模式
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","rw"	
			);
		/*
		 * void write(int d)
		 * 写出一个字节,写出的是给定int
		 * 值对应2进制的"低八位"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00000001
		 * 00000000 00000000 00000001 00000001
		 */
		raf.write(257);

		System.out.println("over!");
		
		raf.close();
	}
}






