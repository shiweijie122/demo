package day04;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 集合的合并与包含 
 */
public class AddAllDemo01 {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		Collection c2 = new ArrayList();
		
		c1.add("Tom");
		c1.add("Jerry");
		c1.add("Andy");

		c2.add("熊大");
		c2.add("熊二");
		
		c1.addAll(c2);
		System.out.println(c1);
		System.out.println(c2);
		
		boolean b = c1.containsAll(c2);
		System.out.println(b);
		b = c2.containsAll(c1);
		System.out.println(b); 
		
	}
}





