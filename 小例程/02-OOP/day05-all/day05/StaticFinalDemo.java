package oo.day05;
//static final常量的演示
public class StaticFinalDemo {
	public static void main(String[] args){
		System.out.println(Hoo.PI); //通过类名点来访问
		//Hoo.PI = 3.1415926; //编译错误，常量不能被改变
		
		//1)加载Ioo.class到方法区中
		//2)静态变量count存储到方法区中
		//3)到方法区中获取count并输出
		System.out.println(Ioo.count);
		
		//编译器在编译时会将常量直接替换为具体的值--效率高
		//相当于System.out.println(5);
		System.out.println(Ioo.NUM);
		
	}
}

class Ioo{
	public static final int NUM = 5; //常量
	public static int count = 5;     //静态变量
}


class Hoo{
	public static final double PI = 3.14159;
	public static final int DOUBLE_NUM = 5;
	//public static final int NUM; //编译错误，常量必须声明同时初始化
}








