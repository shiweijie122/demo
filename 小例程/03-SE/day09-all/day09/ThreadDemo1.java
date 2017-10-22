package day09;
/**
 * 多线程
 * 线程主要用来解决"同时"执行多段代码的需求.
 * 
 * 线程实际是并发运行的.即:宏观上感觉多个线程
 * 执行代码是同时的,但实际微观上所有线程都是
 * 走走停停的.线程调度会将CPU的运行时间分成
 * 若干片段,然后尽可能均匀的分配给所有并发运行
 * 的线程,获得CPU时间片的线程被CPU执行,其他线程
 * 则等待.这样可以导致所有线程进度差不多,由于
 * CPU执行效率高,感官上这些线程就像在同时运行.
 * 
 * 线程有两种创建形式:
 * 方式一:继承线程Thread并重写run方法.
 * @author adminitartor
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 不要直接去调用run方法,因为run方法
		 * 是线程要执行的任务,线程启动后当获取
		 * 时间片以后会自动调用.
		 * 启动线程执行start方法.
		 */
		t1.start();
		t2.start();
	}
}
/*
 * 第一种创建线程的方式存在两个不足:
 * 1:由于java是单继承的,那么当继承了Thread后
 *   就不能再继承其他类,这在实际开发中经常会
 *   出现继承冲突问题.
 * 2:由于将线程要执行的任务直接定义在run方法
 *   之中,这就导致线程与任务有一个必然耦合关系
 *   导致线程重用性变差.  
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊?");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<10000;i++){
			System.out.println("我是查水表的!");
		}
	}
}





