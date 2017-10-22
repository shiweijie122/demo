package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * Map 查找表
 * 以key-value对的形式存储元素
 * 其中Map要求key不允许重复(是否重复取决于
 * key的equals方法比较的结果,为true则为重复)
 * 
 * 常用实现类:java.util.HashMap
 * 使用散列算法实现的查找表
 * 也称为:散列表,哈希表
 * 
 * @author adminitartor
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		/*
		 * Map要求两个泛型,分别指定key与value
		 * 的类型
		 */
		Map<String,Integer> map
		 	= new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * 将给定的key-value对存入Map
		 * 由于Map要求key不允许重复,所以若
		 * 给定的key在Map中已经存在了,则是
		 * 替换value操作,那么put方法返回值
		 * 则为被替换的value.
		 * 若key不存在,则返回值为null
		 * 
		 */
		System.out.println(map);
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 98);
		Integer num = map.put("化学", 99);
		System.out.println(num);
		System.out.println(map);
		
		num = map.put("语文", 80);
		System.out.println("old:"+num);
		System.out.println(map);
		
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value
		 * 若给定的key在map中不存在,则返回
		 * 值为NULL
		 */
		num = map.get("数学");
		System.out.println("数学:"+num);
		
		num = map.get("体育");
		System.out.println("体育:"+num);
		
		/*
		 * V remove(K k)
		 * 根据key删除Map中这组键值对
		 * 返回值为该组键值对中对应的value
		 */
		num = map.remove("数学");
		System.out.println(map);
		System.out.println("old:"+num);
		
	}
}







