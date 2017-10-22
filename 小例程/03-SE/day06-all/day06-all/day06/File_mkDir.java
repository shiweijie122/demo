package day06;

import java.io.File;

/**
 * 使用File创建目录
 * @author adminitartor
 *
 */
public class File_mkDir {
	public static void main(String[] args) {
		/*
		 * 在当前目录中创建一个目录"demo"
		 * "./"可以不写,默认就是当前目录
		 */
		File dir = new File("demo");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("创建完毕!");
		}else{
			System.out.println("该目录已存在!");
		}
	}
}







