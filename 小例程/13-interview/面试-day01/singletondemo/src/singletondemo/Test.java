package singletondemo;

public class Test {
	public static void main(String[] args) {
//		懒汉式单例调用 - lazy
//		SingleTonDemo01 s1 = 
//				SingleTonDemo01.getInstance();
//		
//		SingleTonDemo01 s2 = 
//				SingleTonDemo01.getInstance();
//		
//		System.out.println(s1);
//		System.out.println(s2);
		
		//饿汉式单例调用 - hungry
		HungrySingleTonDemo02 s1 = 
				HungrySingleTonDemo02.getInstance();
		
		HungrySingleTonDemo02 s2 = 
				HungrySingleTonDemo02.getInstance();
		
		System.out.println(s1==s2);
		
	}

}
