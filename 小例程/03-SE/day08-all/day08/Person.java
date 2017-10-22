package day08;
/**
 * 测试异常的抛出
 * @author adminitartor
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age)throws Exception{
		if(age<0||age>100){
			/*
			 * 通常在一个方法中主动抛出一个异常
			 * 时就要在当前方法上使用throws声明
			 * 该类异常的抛出以通知调用者处理该
			 * 异常.
			 * 只有抛出RuntimeException编译器不
			 * 要求必须这样做,除此之外,不这样做
			 * 编译不通过.
			 */
			throw new Exception("年龄不合法!");
		}
		this.age = age;
	}
	
	
}







