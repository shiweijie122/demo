package day09;
/**
 * 守护线程
 * 当一个进程中的所有前台线程都结束时,进程
 * 结束,那么进程中所有正在运行的守护线程(后台
 * 线程)都要被中断.
 * @author adminitartor
 *
 */
public class Thread_setDaemon {
	public static void main(String[] args) {
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:啊啊啊啊啊AAAAAAaaaaaa....");
				System.out.println("音效:噗通");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		rose.start();
		
		//设置为后台线程,要在start()之前设置!
		jack.setDaemon(true);
		jack.start();
	
	}
}






