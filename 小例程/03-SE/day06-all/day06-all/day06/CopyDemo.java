package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author adminitartor
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile(
				"soft.zip","r"
			);
		
		RandomAccessFile desc
			= new RandomAccessFile(
				"soft_cp.zip","rw"
			);
		//保存每次读取到的字节
		int d = -1;
		
		long start = System.currentTimeMillis();
		while( (d = src.read())!=-1){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!耗时:"+(end-start)+"ms");
		src.close();
		desc.close();
		
	}
}







