package day03;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合中持有的是对象的引用 
 */
public class CollectionDemo03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(3,4));
		c.add(new Point(4,5));
		Point p1 = new Point(7, 8);
		//集合中保持的是对象的引用
		c.add(p1);//将元素的引用添加的集合
		System.out.println(c);
		//修改p1影响集合内容
		p1.x = 9;
		System.out.println(c); 
	}
}
class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
}




