package demo;

public class Foo {
	static{
		System.out.println("加载Foo");
	}
	
	public void demo(){
		System.out.println("demo()");
	}
	
	public int add(int a , int b){
		return a + b;
	}
	
	public String who(String name){
		return "I am " + name;
	}
	
	public void testHello(){
		System.out.println("Hello  World!");
	}
	
	private void testHelloKitty(){
		System.out.println("Hello Kitty!");
	}
} 




