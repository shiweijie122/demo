package day06;

import java.io.File;

/**
 * 
 * 1:请编写一段代码,要求实现1+2+3+4+..100
 *   并输出结果.
 *   在当前代码中不得出现for,while关键字
 *   
 *   
 * 2:请编写一段代码,计算结果
 *   一块钱买一瓶汽水,2个空瓶可以换一瓶汽水,
 *   3个瓶盖可以换一瓶汽水,问20块钱可以买
 *   多少平汽水?  
 * 
 * 
 * 完成方法,将给定的File对象所表示的
 * 文件或目录删除
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File("a");
		delete(dir);
	}
	/**
	 * 将给定的File对象表示的文件或目录删除
	 * @param file
	 */
	public static void delete(File file){
		if(file.isDirectory()){
			//先将该目录中所有子项删除
			File[] subs = file.listFiles();
			for(File sub : subs){
				delete(sub);
			}
		}
		file.delete();
	}
}





