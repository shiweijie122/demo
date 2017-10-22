package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列 java.util.Queue
 * 队列是Collection的子接口
 * 队列也可以存储一组元素,但是增删元素必须遵循
 * 先进先出原则.FIFO(First Input First Output)
 * 
 * @author adminitartor
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue 
			= new LinkedList<String>();	
		/*
		 * boolean offer(E e)
		 * 从队尾追加元素
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		/*
		 * E poll()
		 * 出队操作,获取队首元素后该元素
		 * 即从队列中被移除.
		 */
		String str = queue.poll();
		System.out.println(str);//one
		System.out.println(queue);
		
		/*
		 * E peek()
		 * 引用队首元素,与poll方法的主要
		 * 区别在于该元素不会从队列中删除
		 */
		str = queue.peek();
		System.out.println(str);//two
		System.out.println(queue);
		
		//遍历队列元素
		//1迭代器遍历
		for(String s : queue){
			System.out.println(s);
		}
		System.out.println(queue);
				
		//2 poll遍历(这种遍历是一次性的)
		while(queue.size()>0){
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println(queue);
		
		
	}
}








