package day10;
/**
 * 静态方法上使用synchronized修饰,那么该方法
 * 一定具有同步效果.
 * 静态方法的同步监视器对象为当前静态方法所属
 * 类的类对象(Class的实例)
 * JVM在加载每一个类的时候都会实例化一个且只会
 * 实例化一个Class类的实例来描述它.所以每个类
 * 都有且只有一个Class的实例,静态方法锁的就是
 * 这个对象.
 * 
 * @author adminitartor
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				Boo.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Boo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在运行dosome方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+":运行dosome方法完毕");
	}
}





