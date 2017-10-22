package ioc;

public class A {
	private IB b;
	
	public void setB(IB b) {
		System.out.println("setB()");
		this.b = b;
	}
	
	public A() {
		System.out.println("A()");
	}
	
	public void service(){
		System.out.println("service()");
		//需要调用B的f1()方法。
		b.f1();
	}
	
}
