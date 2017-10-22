package day02;
/**
 * 包装类中声明了每种类型的最大值和最小值 
 */
public class DoubleDemo01 {
	public static void main(String[] args) {
		double max = Double.MAX_VALUE;
		System.out.println(max); 
		max = max + 200000;
		System.out.println(max); 
	}
}
