package controller;

/**
 * 	属性名与请求参数名要保持一致。
 * 注：
 * 	 会自动做类型转换。
 */
public class BmiParam {
	private double height;
	private double weight;
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
