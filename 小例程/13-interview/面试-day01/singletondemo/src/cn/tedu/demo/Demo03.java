package cn.tedu.demo;

public class Demo03 {
	public static void main(String[] args) {
		GarbageObj garbageObj = new GarbageObj();
		garbageObj = null;
		System.gc();
		System.out.println("启用Gc");
		
	}

}
