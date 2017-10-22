package cn.tedu.demo;
/**
 * 可变参数  int...args
 * 	如果一个方法的参数列表中有多个参数,那么
 * 可变参数一定是位于最后的
 * 	可变参数底层是以数组的形式存储数据的
 * @author adminitartor
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
		int[] ary = {1,2,3};
		demo01.test(1,2);
		//int ...is 
	}
	
	public void test(int is1,int... is){
//		System.out.println(is);
		for(int i:is){
			System.out.println(i);
		}
	}
	
//	public void test(int o,int k){
//		System.out.println("调用test方法");
//		System.out.println(o);
//	}
	

}
