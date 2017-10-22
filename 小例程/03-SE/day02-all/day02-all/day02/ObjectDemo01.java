package day02;

public class ObjectDemo01 {
	public static void main(String[] args) {
		//任何类都继承于Object, 
		//所以可以用Object定义变量引用Foo对象
		Object obj = new Foo();
		//toString方法来自于Object类
		//是Foo从Object继承的方法
		String str = obj.toString();
		System.out.println(str); 
	}
}
//类默认情况下继承于Object类.
class Foo /* extends Object */{
	
}




