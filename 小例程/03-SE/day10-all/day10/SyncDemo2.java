package day10;
/**
 * 同步块
 * 
 * 有效的缩小同步范围可以在保证并发安全的前提
 * 下提高代码执行效率.
 * 
 * 同步块可以更加精确的控制需要同步的代码片段.
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy(){
		try {
			Thread t = Thread.currentThread();
			System.out.println(
					t.getName()+":正在挑衣服...");
			Thread.sleep(5000);	
			/*
			 * 同步块需要指定同步监视器对象(上锁的对象)
			 * 只要保证该对象多个线程看到的是同一个,
			 * 那么这些线程就不会同时指定同步块中的
			 * 代码.
			 */
			synchronized(this){
				System.out.println(
						t.getName()+":正在试衣服...");
				Thread.sleep(5000);	
			}
			
			System.out.println(
					t.getName()+":结账离开");
			
		} catch (Exception e) {
		}
	}
}











