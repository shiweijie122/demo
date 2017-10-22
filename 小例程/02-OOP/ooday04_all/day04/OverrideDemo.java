package oo.day04;
//重写的演示
public class OverrideDemo {
	public static void main(String[] args) {
		
	}
}

/*
 * 重写遵循"两同两小一大"原则:
 * 1)两同:
 *   1.1)方法名相同
 *   1.2)参数列表相同
 * 2)两小:
 *   2.1)子类方法的返回值类型要小于或等于父类的
 *       2.1.1)void时，必须相同
 *       2.1.2)基本数据类型时，必须相同
 *       2.1.3)引用类型时，小于或等于
 *   2.2)子类方法抛出的异常要小于或等于父类的----异常之后
 * 3)一大:
 *   3.1)子类方法的访问权限要大于或等于父类的---访问控制修饰符之后
 */

//父类大，子类小
class Aoo{
	void show(){}
	double test(){return 0.0;}
	Boo sayHi(){return null;}
	public Aoo say(){return null;}
}
class Boo extends Aoo{
	//int show(){return 1;} //编译错误，void时必须相同
	//int test(){return 0;} //编译错误，基本类型时必须相同
	//Aoo sayHi(){return null;} //编译错误，引用类型必须小于或等于
	public Boo say(){return null;}
}



















