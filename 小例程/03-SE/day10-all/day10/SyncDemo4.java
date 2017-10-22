package day10;
/**
 * 互斥锁
 * 
 * 当使用synchronized修饰多段不同代码时,
 * 同步监视器对象相同,那么这些代码间就存在
 * 互斥,即:多个线程不能同时执行这些代码.
 * 
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Foo foo = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				foo.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				foo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在运行A方法...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":运行A方法完毕...");
	}
	public void methodB(){
		synchronized(this){
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+":正在运行B方法...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+":运行B方法完毕...");
		}
	}
}











