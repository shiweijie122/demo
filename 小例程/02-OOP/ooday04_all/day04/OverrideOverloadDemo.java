package oo.day04;
//重写与重载的区别的演示
public class OverrideOverloadDemo {
	public static void main(String[] args) {
		Eoo eoo = new Eoo();
		Coo o = new Doo(); //向上造型
		eoo.test(o); //重载看引用
	}
}

class Eoo{
	void test(Coo o){
		System.out.println("父型参数");
		o.show(); //重写看对象
	}
	void test(Doo o){
		System.out.println("子型参");
		o.show();
	}
}

class Coo{
	void show(){
		System.out.println("父类show");
	}
}
class Doo extends Coo{
	void show(){
		System.out.println("子类show");
	}
}













