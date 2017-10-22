package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈结构
 * 存储一组元素,遵循先进后出原则
 * 一般使用栈来实现"后退"功能
 * @author adminitartor
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack
			= new LinkedList<String>();		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);
		
		String str = stack.pop();
		System.out.println(str);//four
		System.out.println(stack);
		
		
		while(stack.size()>0){
			str = stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
		
	}
}






