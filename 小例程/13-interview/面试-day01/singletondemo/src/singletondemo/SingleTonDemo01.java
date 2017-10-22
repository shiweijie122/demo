package singletondemo;
/**
 * 懒汉式单例
 * @author adminitartor
 * 让类自行实现实例化
 * 	- 提供一个public的方法,提供实例
 * 
 * 别的类中如果想调用A类中的方法
 * 		static - 类名
 * 		实例方法 - 通过实例来调用的
 * 
 * 懒汉式单例
 *
 */
public class SingleTonDemo01 {
	private SingleTonDemo01(){}
	
	private static SingleTonDemo01 instance 
	= null;
	
	//公有的用于获取实例的方法
	public static SingleTonDemo01 getInstance(){
		if(instance==null){
			instance = new SingleTonDemo01();
		}
		return instance;
	}
	
	
	
	
	

}
