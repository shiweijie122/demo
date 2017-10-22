package day08;
/**
 * 异常处理机制中的try-catch
 * @author adminitartor
 *
 */
public class Exception_try_catch {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String str = "a";
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
			System.out.println("!!!!");
		}catch(NullPointerException e){
			System.out.println("出现了空指针!");
			
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界了!");
		
		//最后应当捕获Exception
		}catch(Exception e){
			System.out.println("反正就是出了个错!");
		}
		System.out.println("程序结束了");
	}
}





