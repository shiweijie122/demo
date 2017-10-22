package day06;
//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		
		/*
		//sayHi(); //编译错误，有参必须传参
		//sayHi(250); //编译错误，参数类型不匹配
		sayHi("zhangsan"); //String name="zhangsan"
		sayHi("lisi"); //String name="lisi"
		sayHi("wangwu"); //String name="wangwu"
		*/
		
		/*
		int a = getNum(); //getNum()的值就是return后的值
		System.out.println(a); //88
		*/
		
		/*
		double b = plus(5.0,6.6); //double num1=5.0,double num2=6.6
		System.out.println(b); //11.6
		*/
		
		/*
		double c=5.0,d=6.6;
		double m = plus(c,d); //double num1=5.0,double num2=6.6;
		System.out.println(m); //11.6
		*/
		
		//a(); //方法的嵌套调用
	}
	
	//有参有返回值
	public static double plus(double num1,double num2){
		double num = num1+num2;
		return num; //返回num里面的那个数
		//return num1+num2;
	}
	
	//无参有返回值
	public static int getNum(){
		//return; //编译错误，必须返回一个值
		//return 8.88; //编译错误，返回值类型不匹配
		return 88; //1)结束方法的执行  2)返回结果给调用方
	}
	
	//有参无返回值
	public static void sayHi(String name){
		/*
		if(boolean){
			return; //1)结束方法的执行
		}
		*/
		System.out.println("大家好，我叫"+name);
		
	}
	
	//无参无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
	
	
	
	public static void a(){
		System.out.println(111);
		b();
		System.out.println(222);
	}
	public static void b(){
		System.out.println(333);
	}
}


















