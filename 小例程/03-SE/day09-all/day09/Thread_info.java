package day09;
/**
 * 获取线程信息的相关方法
 * @author adminitartor
 *
 */
public class Thread_info {
	public static void main(String[] args) {
		//获取运行main方法的线程
		Thread t = Thread.currentThread();
		
		long id = t.getId();
		System.out.println("id:"+id);
		
		String name = t.getName();
		System.out.println("name:"+name);
		
		int priority = t.getPriority();
		System.out.println("优先级:"+priority);
		
		boolean isAlive = t.isAlive();
		System.out.println("isAlive:"+isAlive);
		
		boolean isDaemon = t.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		
		boolean isInterrupted = t.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
		
	}
}






