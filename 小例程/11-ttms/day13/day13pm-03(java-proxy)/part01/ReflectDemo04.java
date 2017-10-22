package part01;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectDemo04 {
    public static void main(String[] args) 
    throws Exception{
		//泛型:编译时的一种类型
    	List<String> list=
		new ArrayList<String>();//Object[]
		list.add("A");
		list.add("B");
		//list.add(100);
		//现在希望通过反射将100写入到list?
		//1.获得list的类对象
		Class<?> c=list.getClass();
		//2.获得类对象的add方法对象
		Method m=c.getDeclaredMethod("add",
				Object.class);
		//3.执行list对象的add方法
		m.invoke(list, 100);
		System.out.println(list);
		
		
		
	}
}
