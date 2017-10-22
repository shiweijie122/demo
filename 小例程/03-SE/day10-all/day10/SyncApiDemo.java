package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 将集合和Map转换为线程安全的
 * 
 * List常用实现类:ArrayList,LinkedList
 * Set常用实现类:HashSet
 * Map常用实现类:HashMap
 * 以上都不是线程安全的.
 * 
 * 可以通过集合工具类:Collections将他们转换为
 * 线程安全的.
 * 
 * 
 * @author adminitartor
 *
 */
public class SyncApiDemo {
	public static void main(String[] args) {
		List<String> list 
			= new ArrayList<String>();	
		list.add("one");
		list.add("two");
		list.add("three");	
		list.add("four");
		System.out.println(list);
		/*
		 * 将给定List集合转换为线程安全的
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		/*
		 * 将Set集合转换为线程安全的
		 */
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		map.put("语文", 90);
		map.put("数学", 98);
		map.put("英语", 96);
		
		System.out.println(map);	
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
		
	}
}








