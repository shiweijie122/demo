package day02;
/**
 * 合理重写equals方法
 */
public class EqualsDemo02 {
	public static void main(String[] args) {
		Point1 p1 = new Point1(3, 4);
		Point1 p2 = new Point1(3, 4);
		Point1 p3 = new Point1(3, 5);
		//利用重写的equals方法比较两个对象是否相等
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
	}
}
class Point1{
	int x,y;
	public Point1(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	/**
	 * 在Point类中重写equals方法
	 * 按照关键属性比较两个对象是否相等
	 * 比如: 如果x和y都相等则相等
	 *   p1.equals(p2)
	 *   p1.equals("4,5")
	 *   p1.equals(p1)
	 *   p1.equals(null)
	 */
	public boolean equals(Object obj){
		//obj 引用 p1
		//this 引用 p1
		if(obj == null){return false;}
		if(this == obj){return true;}
		if(obj instanceof Point1){
			Point1 other = (Point1)obj;
			return this.x == other.x && 
				   this.y == other.y;
		}
		return false;
	}
}








