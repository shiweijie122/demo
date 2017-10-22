package oo.day05;
//final的演示
public class FinalDemo {
	public static void main(String[] args) {
		
	}
}


//演示final修饰类
final class Doo{}
//class Eoo extends Doo{} //编译错误，final的类不能被继承
class Foo{}
final class Goo extends Foo{} //final的类可以继承别的类


//演示final修饰方法
class Boo{ 
	final void show(){}
	void say(){}
}
class Coo extends Boo{
	//void show(){} //编译错误，final的方法不能被重写
	void say(){}
}


/*
 * final修饰成员变量，只有两种初始化方式:
 * 1)声明的同时初始化
 * 2)在构造方法中初始化
 * final修饰局部变量，只要在用之前初始化即可
 */
class Aoo{ //演示final修饰变量
	final int a = 5;
	final int b;
	Aoo(){
		b = 6;
	}
	void show(){
		final int c;
		//a = 55; //编译错误，final的变量不可被改变
	}
}
















