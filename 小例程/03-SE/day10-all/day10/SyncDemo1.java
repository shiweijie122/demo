package day10;
/**
 * 多线程并发安全问题
 * 
 * 当多个线程并发访问同一数据时,由于线程切换
 * 时机的不确定,导致代码未按照代码设计顺序执行
 * 而出现混乱.严重时可能导致系统瘫痪.
 * 
 * 
 * @author adminitartor
 *
 */
public class SyncDemo1 {
	public static void main(String[] args) {
		final Table table = new Table();
		
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
}

class Table{
	//桌子上有20个豆子
	private int beans = 20;
	/*
	 * 当一个方法被synchronized修饰后,那么
	 * 该方法称为"同步方法"
	 * 即:多个线程不能同时进入方法内部执行.
	 * 
	 * 在方法上直接使用synhronized,那么同步
	 * 监视器对象就是当前方法所属对象,即方法
	 * 内部看到的"this"
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		//模拟线程执行到这里发生了切换
		Thread.yield();
		
		return beans--;
	}
}







