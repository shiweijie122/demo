package cn.tedu.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreaPoolDemo {
	public static void main(String[] args) {
		ExecutorService service = 
			Executors.newFixedThreadPool(3);
		
//		service.execute(command);
		
		service.shutdown();
		
		service.shutdownNow();
		
	}
}
