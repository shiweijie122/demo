package oo.day03;
//super的演示
public class SuperDemo {
	public static void main(String[] args) {
		Boo o = new Boo();
	}
}

class Coo{
	Coo(int a){
	}
}
class Doo extends Coo{
	Doo(){
		super(5); //调用父类的有参构造
	}
	
	/*
	//如下代码，写不写都有----默认的
	Doo(){
		super();
	}
	*/
}








class Aoo{
	Aoo(){
		System.out.println("父类构造");
	}
}
class Boo extends Aoo{
	Boo(){
		System.out.println("子类构造");
	}
}









