package part01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Rect{//定义一个矩形
	private int width;
	private int height;
	public Rect() {
	}
	public Rect(int width,int height){
		this.width=width;
		this.height=height;
	}
	public int getArea(){
		return width*height;
	}
}
//<bean id="rect" class="part01.Rect" method="getArea"/>
public class ReflectDemo03 {
	public static void main(String[] args)throws Exception {
		//Rect c1=new Rect();
		
		//获得指定类的类对象
		Class<?> c1=
		Class.forName("part01.Rect");
		//构建类对象的实例
		Rect rect1=(Rect)
		c1.newInstance();//(默认会调用Rect类无参的构造函数)
		System.out.println(rect1);
		//获得类中的构造函数对象
		//c1.getDeclaredConstructors();
		Constructor<?> c=
		c1.getDeclaredConstructor(int.class,int.class);
		//通过构造函数对象构建类的对象(实例)
		Rect rect2=(Rect)c.newInstance(20,10);
		//通过反射调用对象方法
		Method m1=
		c1.getDeclaredMethod("getArea");
		Object result=m1.invoke(rect2);
		System.out.println(result);
	}
}
