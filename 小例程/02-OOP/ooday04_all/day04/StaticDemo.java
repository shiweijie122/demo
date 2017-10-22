package oo.day04;
//static的演示
public class StaticDemo {
	public static void main(String[] args) {
		Joo o1 = new Joo();
		o1.show();
		Joo o2 = new Joo();
		o2.show();
		System.out.println(Joo.b); //建议类名点来访问
		System.out.println(o1.b);  //不建议
		
		Koo.test();
		
		Loo o3 = new Loo();
		Loo o4 = new Loo();
	}
}

class Loo{ //演示静态块
	static{
		System.out.println("静态块");
	}
	Loo(){
		System.out.println("构造方法");
	}
}

class Koo{ //演示静态方法
	int a;
	static int b;
	void show(){ //有隐式this
		System.out.println(a); //this.a
		System.out.println(b); //Koo.b
	}
	static void test(){ //没有隐式this
		//没有this意味着没有对象，
		//而实例成员必须通过对象点来访问
		//所以静态方法中不能直接访问实例成员
		//System.out.println(a); //编译错误
		System.out.println(b); //Koo.b
	}
}

class Joo{ //演示静态变量
	int a; //实例变量
	static int b; //静态变量
	Joo(){
		a++;
		b++;
	}
	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}















