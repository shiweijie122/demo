package day09;
/**
 * 线程优先级
 * 由于线程不能主动向线程调度索取CPU时间片,
 * 只能被动的被分配,所以可以通过调整线程的
 * 优先级来最大程度的干涉线程调度分配时间片
 * 的几率.
 * 理论上线程优先级越高的线程获取CPU时间片的
 * 次数就多.
 * @author adminitartor
 *
 */
public class Thread_setPriority {
	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("nor");
				}
			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};	
		/*
		 * 线程的优先级有10个等级,分别用数字1-10表示
		 * 其中1最低,10最高,5为默认值
		 */
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);		
		min.start();
		norm.start();
		max.start();
	}
}








