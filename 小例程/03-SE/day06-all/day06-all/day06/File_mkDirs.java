package day06;

import java.io.File;

/**
 * 创建一个多级目录
 * @author adminitartor
 *
 */
public class File_mkDirs {
	public static void main(String[] args) {
		/*
		 * 在当前目录中创建目录:a/b/c/d/e/f
		 */
		File dir = new File(
			"a"+File.separator+
			"b"+File.separator+
			"c"+File.separator+
			"d"+File.separator+
			"e"+File.separator+
			"f"
		);
		
		if(!dir.exists()){
			/*
			 * mkdir与mkdirs的主要区别是
			 * mkdir在创建目录时要求父目录必须
			 * 存在,而mkdirs则会将不存在的父目
			 * 录自动创建出来
			 */
			dir.mkdirs();
			System.out.println("创建完毕!");
		}else{
			System.out.println("该目录已存在!");
		}
	}
}





	