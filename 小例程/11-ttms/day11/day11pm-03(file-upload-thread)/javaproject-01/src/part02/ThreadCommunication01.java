package part02;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * 线程同步:多个线程并发执行时在共享数据集上的互斥与协作
 * 线程互斥:
 * 1)同步代码块
 * 2)同步方法
 * 
 * 线程协作:
 * 1)构建于互斥(借助synchronized)的基础之上
 * 2)借助Object类wait,notify,notifyall实现
 * 2.1)概念
 * a)wait表示等待 (此方法一旦执行会释放对象锁)
 * b)notify/notifyall表示唤醒
 * 2.2)应用
 * a)wait,notify,notifyall方法必须用在同步代码块或同步同发中
 * b)wait,notify,notifyall方法必须由对象锁(同步锁)调用
 * 
 * */
public class ThreadCommunication01 {
	static String content;
	static String LOCK="lock";
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
			    synchronized (ThreadCommunication01.class) {
			     content="helloworld";
			     ThreadCommunication01.class.notifyAll();
				}
			}
		}.start();
		synchronized (ThreadCommunication01.class) {
			while(content==null)
			try{ThreadCommunication01.class.wait();}catch(Exception e){}
			System.out.println(content.toUpperCase());
		}
	}
}
