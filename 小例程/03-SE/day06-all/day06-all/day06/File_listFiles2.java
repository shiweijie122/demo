package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 重载的listFiles方法:
 * File[] listFiles(FileFilter filter)
 * 该方法要求传入一个文件过滤器,然后返回当前
 * File表示的目录中所有满足过滤器要求的子项.
 * 
 * @author adminitartor
 *
 */
public class File_listFiles2 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录中所有文本文件
		 */
		File dir = new File(".");
		
		FileFilter filter = new FileFilter(){
			public boolean accept(File file){
				String name = file.getName();
				System.out.println("正在过滤:"+name);
				return name.endsWith(".txt");
			}
		};
		File[] subs = dir.listFiles(filter);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}






