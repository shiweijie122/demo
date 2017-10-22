package cn.tedu.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
	public static void main(String[] args) {
		Demo02 demo02 = new Demo02();
		demo02.test(80000000);
	}
	
	public void test(int count){
		List<String> list = 
				new ArrayList<String>();
		for(int i=0;i<count;i++){
			String str = new String("abc");
			list.add(str);
		}
		
	}

}
