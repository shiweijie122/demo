package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流 缓冲流是一对高级流,作用是提高读写效率. java.io.BufferedInputStream
 * java.io.BufferedOutputStream
 * 
 * @author adminitartor
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis 
			= new FileInputStream("music.mp3");
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		
		
		FileOutputStream fos 
			= new FileOutputStream("music_cp3.mp3");
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		int d = -1;
		
		long start = System.currentTimeMillis();
		while ((d = bis.read()) != -1) {
			bos.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕,耗时:"+(end-start)+"ms");
		bis.close();
		bos.close();
	}
}
