package day08;
/**
 * finally块
 * finally块只能定义在异常捕获机制的最后.
 * finally的作用是保证块中的代码一定执行,无论
 * try块中的代码是否抛出异常.
 * 
 * 通常会将诸如释放资源等操作放在finally块中
 * @author adminitartor
 *
 */
public class Exception_finally {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "";
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("出错了");
		} finally{
			System.out.println("finally中的代码执行了");
		}
		System.out.println("程序结束了");
	}
}









