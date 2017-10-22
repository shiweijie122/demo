package cn.tedu.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo04 {
	public static void main(String[] args) {
//		System.out.println(1/2+0.5);
		//B
//		ExecutorService service = 
//			Executors.newFixedThreadPool(2);
//		
//		service.shutdown();
//		service.shutdownNow();
		Demo04 demo04 = new Demo04();
		demo04.test(1,2);
	}
	
	public void test(int...args){
		//可变参数底层采用数组
		System.out.println(args);
		
	}
}
