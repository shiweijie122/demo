package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制文件
 * @author adminitartor
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("music.mp3");
			
		FileOutputStream fos
			= new FileOutputStream("music_cp2.mp3");
		
		byte[] data = new byte[1024*10];
		int len = -1;
		
		while((len = fis.read(data))!=-1){
			fos.write(data,0,len);
		}
		System.out.println("复制完毕");
		fis.close();
		fos.close();
		
	}
}







