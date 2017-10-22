package day09;
/**
 * 线程提供了一个方法:
 * void join()
 * 该方法允许多线程之间同步执行.
 * 
 * 同步:有先后顺序的执行代码
 * 异步:各干各的
 * 
 * @author adminitartor
 *
 */
public class Thread_join {
	//标示图片是否下载完毕
	public static boolean isFinish;
	
	public static void main(String[] args) {	
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++){
					System.out.println("down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down:下载图片完毕!");
				isFinish = true;
			}
		};
		
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:开始显示图片...");
				//首先等待图片下载完毕.
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				if(!isFinish){
					throw new RuntimeException("show:图片没有下载完毕!");
				}
				System.out.println("show:显示图片完毕!");
			}
		};
		
		
		download.start();
		show.start();
	}
}











