package oo.day02;
/*
 * 补充:
 * 1)同一个文件可以创建多个类
 * 2)public修饰的类只能有一个
 * 3)public修饰的类必须与文件名相同
 */
//重载的演示
public class OverloadDemo {
	public static void main(String[] args) {
		Aoo o = new Aoo();
		o.say();
		o.say("zhangsan");
		o.say(25);
		o.say("zhangsan", 25);
		o.say(25, "zhangsan");
	}
}

class Aoo{
	void say(){}
	void say(String name){}
	void say(int age){}
	void say(String name,int age){}
	void say(int age,String name){}

	//int say(){return 1;} //编译错误，重载与返回值类型无关
	//void say(String address){} //编译错误，重载与参数名称无关

}
























