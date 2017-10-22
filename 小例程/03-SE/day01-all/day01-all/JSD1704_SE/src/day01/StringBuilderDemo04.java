package day01;

/**
 * 大量的字符串连接操作应用使用StringBuilder
 * 可以提高软件的性能
 */
public class StringBuilderDemo04 {
	public static void main(String[] args) {
		//测试StringBuilder的连接性能
		long t1=System.currentTimeMillis();
		StringBuilder buf = new StringBuilder();
		for(int i=0; i<100000; i++){
			buf.append("A");
		}
		System.out.println(buf.length());
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
		
		//测试String的连接性能
		t1 = System.currentTimeMillis();
		String s = "";
		for(int i=0; i<100000; i++){
			//每次连接都会创建StringBuilder对象
			//造成大量的内存资源耗费，严重影响性能
			s = s+"A";//new StringBuilder()
		}
		System.out.println(s.length()); 
		t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
}
