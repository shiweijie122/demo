package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 子列表: 关键点,子列表与主列表共享存储空间 
 */
public class SublistDemo01 {
	public static void main(String[] args) {
		List<String> list = 
			new ArrayList<String>();
		list.add("红桃3");
		list.add("红桃9");
		list.add("黑桃10");
		list.add("方块J");
		list.add("梅花Q");
		list.add("红桃A");
		System.out.println(list); 
		//获取线性表的子列表
		List<String> sub=list.subList(1, 5);
		System.out.println(sub); 
		//子列表与主列表共享相同的存储空间
		//操作子列表影响主列表
		sub.remove(1);
		System.out.println(list);
		sub.clear();
		System.out.println(list);
	}
}







