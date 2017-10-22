package part01;
/**单例:保证类的实例在内存中只有一份
 * */
class Singleton0{//线程安全环境下使用
	private Singleton0(){}
	private static Singleton0 instance;
	public static Singleton0 getInstance(){
		if(instance==null){
			instance=new Singleton0();
		}
		return instance;
	}
}
/***
 * 场景:
 * 1)线程不安全
 * 2)大对象,稀少用
 * @author adminitartor
 *
 */
class Singleton01{//线程不安全时使用
	private Singleton01(){}
	private static Singleton01 instance;
	public synchronized static Singleton01 getInstance(){
		if(instance==null){
			instance=new Singleton01();
		}
		return instance;
	}
}
class Singleton02{//线程不安全时使用
	private Singleton02(){}
	private static Singleton02 instance;
	public  static Singleton02 getInstance(){
		if(instance==null){
			synchronized (Singleton02.class) {
				if(instance==null){
				instance=new Singleton02();
				}
			}
		}
		return instance;
	}
	public static void show(){}
}
/**
 * 饿汉单例
 * 场景:小对象,频繁用*/
class Singleton03{
	//private int[] array=new int[8192];
    private static Singleton03 instance=
    		new Singleton03();
	private Singleton03(){}
	public static Singleton03 getInstance(){
		return instance;
	}
	public static void show(){}
}
/**通过延迟加载优化Singleton03的实现*/
class Singleton04{
	//private int[] array=new int[8192];
	private Singleton04(){}
	static class Inner{
		public static Singleton04 instance=
				new Singleton04();
	}
	public static Singleton04 getInstance(){
		return Inner.instance;
	}
	public static void show(){}
	public void display(){}
}


public class SingletonDemo01 {
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++){
			new Thread(){
				public void run() {
					System.out.println(Singleton01.getInstance());
				};
			}.start();
		}
	}
}
