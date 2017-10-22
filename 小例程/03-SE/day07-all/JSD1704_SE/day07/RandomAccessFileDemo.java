package day07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写基本类型数据以及RAF基于指针的读写操作
 * @author adminitartor
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile("raf.dat","rw");	
		/*
		 * 获取指针位置的方法:
		 * long getFilePointer()
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:"+pos);
		
		int imax = Integer.MAX_VALUE;
		/* 
		 *                            vvvvvvvv
		 * 01111111 11111111 11111111 11111111
		 */
		raf.write(imax>>>24);
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.write(imax>>>16);
		raf.write(imax>>>8);
		raf.write(imax);
		System.out.println("pos:"+raf.getFilePointer());
		
		/*
		 * void writeInt(int d)
		 * 将int值写出
		 */
		raf.writeInt(imax);
		System.out.println("pos:"+raf.getFilePointer());
		raf.writeLong(123L);
		System.out.println("pos:"+raf.getFilePointer());
		raf.writeDouble(123.123);
		System.out.println("pos:"+raf.getFilePointer());
		
		System.out.println("写出完毕!");
		//移动指针到文件最开始
		raf.seek(0);
		System.out.println("pos:"+raf.getFilePointer());
		/*
		 * readInt可以一次性读取4字节,转换为int值
		 * 若读取到文件末尾则抛出EOFException
		 * EOF  end of file
		 */
		int d = raf.readInt();
		System.out.println(d);//?
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.seek(8);
		long l = raf.readLong();
		System.out.println(l);
		System.out.println("pos:"+raf.getFilePointer());
		
		double dou = raf.readDouble();
		System.out.println(dou);
		System.out.println("pos:"+raf.getFilePointer());
		raf.close();
	}
}







