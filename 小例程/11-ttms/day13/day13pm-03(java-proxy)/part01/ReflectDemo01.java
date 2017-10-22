package part01;

public class ReflectDemo01 {
    //Java对象:实例对象(new)和类对象(Class类型)
	public static void main(String[] args) {
		String s1="helloworld";
		//1.获得s1指向的对象的类对象
		Class<?> c1=s1.getClass();
		System.out.println(c1.getName());
		System.out.println(c1.isInterface());
		String s2=new String("helloworld");
		Class<?> c2=s2.getClass();
		//所有的类它的类对象只有一份
		System.out.println(c1==c2);
	}//.class-->加载到内存-->创建类对象
}
