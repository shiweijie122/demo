package day01;

import java.util.Scanner;

/**
 * 从控制台输入一个URL地址
 * 从这个地址中截取 主机名和访问的网页文件名
 * 1. 利用indexOf查找 / 的位置
 * 2. 利用查找的结果截取字符串
 * 
 * http://tedu.cn/java/course/index.html
 *                          lastIndexOf("/")
 */
public class SubstringDemo02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("输入URL：");
		String url = in.nextLine();
		//查找 / 的位置
		int i = url.indexOf("/", 7);
		//截取主机名
		String host = url.substring(7, i);
		System.out.println(host);
		
		//从后向前查找 “/”
		i = url.lastIndexOf("/");
		//截取url中文件名部分
		String file=url.substring(i+1);
		System.out.println(file);
		
		//从控制台输入 email 地址
		//从email中截取用户名和主机名
		// liucs@tedu.cn  用户名@主机名
	}
}








