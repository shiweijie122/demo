package day02;
/**
 * toString方法
 * 
 * **子类中建议重写toString方法
 */
public class ToStringDemo01 {
	public static void main(String[] args) {
		//Object上为子类定义了toString()
		//toString方法的默认值,没有意义!
		//建议子类重写掉toString
		//Java API经常重用(调用)toString,
		//重写后,可以是API表现的更好!
		//如何重写:返回对象中关键的信息
		//  飞机: 位置,大小
		//   方块: 位置,形状
		//   圆: 圆心,半径
		Cell c = new Cell(4,5);
		String s = c.toString();
		System.out.println(s); 
		
		//重用toString使用可以简化软件的调试
		System.out.println(c.row+","+c.col); 
		//println自动调用toString
		//而toString输出的是关键信息
		//这样就可以替代 上述调试方法了
		System.out.println(c); 
	}
}
class Cell{
	int row;
	int col;
	public Cell(int row, int col) {
		this.row = row; 
		this.col = col;
	}
	public String toString() {
		return row+","+col;
	}
}










