package singletondemo;


/**
 * 饿汉式单例
 * @author adminitartor
 *
 */
public class HungrySingleTonDemo02 {
	private HungrySingleTonDemo02(){}
	
	private static HungrySingleTonDemo02 
	instance = 
			new HungrySingleTonDemo02();
	
	public static HungrySingleTonDemo02 
	getInstance(){
		return instance;
	}
}
