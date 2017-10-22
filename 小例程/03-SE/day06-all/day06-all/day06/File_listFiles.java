package day06;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 * @author adminitartor
 *
 */
public class File_listFiles {
	public static void main(String[] args) {
		/*
		 * 查看当前目录中的所有子项
		 */
		File dir = new File(".");
		/*
		 * dir.isFile()
		 * 判断当前File表示的是否为一个文件
		 * 
		 * dir.isDirectory()
		 * 判断当前File表示的是否为一个目录
		 */
		if(dir.isDirectory()){
			//获取一个目录中的所有子项
			File[] subs = dir.listFiles();
			for(File sub : subs){
				if(sub.isFile()){
					System.out.print("文件:");
				}
				if(sub.isDirectory()){
					System.out.print("目录:");
				}
				System.out.println(sub.getName());
			}
		}
		
		
		
	}
}






