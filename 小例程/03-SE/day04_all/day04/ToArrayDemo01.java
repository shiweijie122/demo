package day04;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 将集合中的数据复制到数组中 
 */
public class ToArrayDemo01 {
	public static void main(String[] args) {
		//准备集合
		Collection<String> c = 
			new ArrayList<String>();
		c.add("Tom");
		c.add("Jerry");
		c.add("Andy");
		c.add("Robin");
		//准备数组
		String[] ary=
			{"A","A","A","A","A","A","A"}; 
		//将集合中的元素填充到数组中
		c.toArray(ary);
		for(String s:ary){
			System.out.println(s); 
		}
		
		String[] ary2=
			{"A","A","A","A"}; 
		//将集合中的元素填充到数组中
		c.toArray(ary2);
		for(String s:ary2){
			System.out.println(s); 
		}

		//在数组元素数量比集合少的时候
		//返回新数组对象
		String[] ary3={"A","A"}; 
		//将集合中的元素填充到数组中
		ary3=c.toArray(ary3);
		for(String s:ary3){
			System.out.println(s); 
		}


 	}
}





