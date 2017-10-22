package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 利用泛型约束集合中元素的类型
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		//没有泛型的集合:
		//可以存储任何类型的元素, 不好!!
		Collection c = new ArrayList();
		c.add("Tom");
		c.add("Jerry");
		c.add(100);
		System.out.println(c); 
		//使用了泛型的集合: 可以约束集合
		//中存储的元素类型, 避免混合存储
		//<String> 泛型: 约束集合中只能存储
		// String 类型数据
		// 泛型的工作原理: Java利用编译器
		// 实现泛型类型的检查功能, 运行期间不
		// 检查泛型.
		Collection<String> c1=
			new ArrayList<String>();
		c1.add("Mac");
		c1.add("熊大");
		//c1.add(200); //编译错误
		System.out.println(c1);
		//增强for循环支持泛型
		for(String name:c1){
			System.out.println(name);
		}
		
	}
}







