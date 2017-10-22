package day05;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历Map
 * 遍历Map有三种方式:
 * 1:遍历所有的key
 * 2:遍历每一组键值对(Entry)
 * 3:遍历所有的value(相对不常用)
 * 
 * @author adminitartor
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,Integer> map
	 		= new LinkedHashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 98);
		map.put("化学", 99);
		
		/*
		 * 遍历所有的key
		 * 
		 * Set keySet()
		 * 将当前Map中所有的key存入一个Set
		 * 集合后将其返回.
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历每一组键值对
		 * 
		 * Set entrySet()
		 * 将当前Map中每一组键值对存入到
		 * 一个Set集合然后将其返回
		 * 一组键值对是用一个Entry实例表示的
		 */
		Set<Entry<String,Integer>> entrySet 
								= map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * 遍历所有的value
		 * Collection values()
		 * 将当前Map中所有的value存入到
		 * 一个集合中后将其返回.
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
		}
	}
}








