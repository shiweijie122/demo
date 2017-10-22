package day06;

import java.io.File;

/**
 * 删除一个目录
 * @author adminitartor
 *
 */
public class File_delete2 {
	public static void main(String[] args) {
		/*
		 * 将当前目录中的demo目录删除
		 */
		File dir = new File("a");
		if(dir.exists()){
			/*
			 * 使用delete删除目录时,要求
			 * 该目录必须是一个空目录才可以
			 * 删除.
			 */
			dir.delete();
			System.out.println("目录已删除");
		}else{
			System.out.println("该目录不存在!");
		}
			
		
	}
}








