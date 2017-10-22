package day06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * File的每一个实例可以表示文件系统中的
 * 一个文件或目录.
 * 使用File可以:
 * 1:访问文件或目录的属性信息(名称,大小等)
 * 2:操作文件或目录(创建,删除)
 * 3:访问一个目录的子项
 * 但是不能访问文件数据.
 * 
 * @author adminitartor
 *
 */
public class File_info {
	public static void main(String[] args) {
		/*
		 * 通常表示路径应当习惯的使用
		 * 相对路径.
		 * "."表示当前目录,在eclipse中运行时
		 * 当前目录为当前类所处项目的根目录
		 */
		File file = new File(
			"."+File.separator+"demo.txt");
		//获取文件名
		String name = file.getName();
		System.out.println(name);
		//文件大小,单位是字节
		long length = file.length();
		System.out.println("length:"+length+"字节");
		//查看是否可读
		boolean canRead = file.canRead();
		System.out.println("可读:"+canRead);
		//查看是否可写
		boolean canWrite = file.canWrite();
		System.out.println("可写:"+canWrite);
		//查看是否隐藏
		boolean isHidden = file.isHidden();
		System.out.println("是否隐藏:"+isHidden);
		
		/*
		 * ‎2017‎年‎5‎月‎27‎日，‏‎9:44:00
		 */
		long time = file.lastModified();
		System.out.println("最后修改时间:"+time);
		
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy年M月d日,H:m:s"	
			);
//		Date date = new Date(time);
//		System.out.println("最后修改时间:"+sdf.format(date));
		System.out.println(
			"最后修改时间:"+sdf.format(time)
	    );
		
	}
}







