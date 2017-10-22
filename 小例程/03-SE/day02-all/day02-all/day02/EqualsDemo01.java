package day02;
/**
 * 默认的equals方法的问题:
 */
public class EqualsDemo01 {
	public static void main(String[] args) {
		Point p1=new Point(3,4);
		Point p2=new Point(3,4);
		//调用了Object提供的equals方法
		//比较两个对象是否相等: Object
		//提供的默认比较方法equals不能
		//满足我们的需要!! Java建议重写!!
		boolean b = p1.equals(p2);
		System.out.println(b);//false
	}
}
class Point{
	int x,y;
	public Point(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
}

