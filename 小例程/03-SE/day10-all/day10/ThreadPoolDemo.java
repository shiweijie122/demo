package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池主要解决两个问题:
 * 1:控制线程数量
 * 2:重用该线程
 * 
 * 由于每个线程都需要资源消耗,且占用CPU计算时间
 * 那么线程数量过大会对系统资源消耗产生影响,
 * 并且由于CPU过度切换导致系统拖慢.
 * 频繁的创建线程和销毁线程也会给系统带来不小
 * 的开销,为此重用线程和控制线程数量是在使用
 * 线程时必须注意的问题.
 * @author adminitartor
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
	
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					try {
						Thread t = Thread.currentThread();
						System.out.println(
							t.getName()+":正在运行任务...");
						Thread.sleep(5000);
						System.out.println(
							t.getName()+":运行任务完毕...");
					} catch (InterruptedException e) {
						System.out.println("线程被中断了!");
					}
				}
			};
			/*
			 * 将任务交给线程池去运行,如果线程池中
			 * 有空闲线程,那么会立即分配线程来运行
			 * 这个任务.若没有,则会加入线程池内部的
			 * 队列,等待线程来运行.
			 */
			threadPool.execute(runn);
			System.out.println("指派了一个任务...");
		}
		/*
		 * shutdown()与shutdownNow()
		 * shutdown():当线程池中所有任务运
		 *            行完毕后停止
		 *            
		 * shutdownNow():强制将线程池中所有
		 *               线程中断,并停止
		 */
		threadPool.shutdownNow();
		System.out.println("线程池停止了.");
		
	}
}








