package day08;
/**
 * 测试异常的抛出
 * @author adminitartor
 *
 */
public class Exception_throw {
	public static void main(String[] args) {
		Person p = new Person();
		try {
			/*
			 * 当调用一个含有throws异常抛出
			 * 声明的方法时,编译器要求必须
			 * 处理该异常.处理方式两种:
			 * 1:try-catch捕获并处理
			 * 2:继续在当前方法上使用throws
			 *   将异常抛出.
			 * 具体使用哪种,取决于异常应当在
			 * 那里被处理.
			 */
			p.setAge(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("年龄:"+p.getAge());
	}
}



