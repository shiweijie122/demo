package part01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**通过反射:
 * 1)获得对象运行时的内部特征(例如有哪些属性)
 * 2)获得对象运行时的内部行为(例如一些方法)
 */
class Point{
	private int x;
	private int y;
	public void setY(int y) {
		this.y = y;
	}
	private int getY() {
		return y;
	}
	private int getX() {
		return x;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
public class ReflectDemo02 {
	public static void main(String[] args)throws Exception {
		//doFields();//alt+shift+m (快速提取方法)
		doMethods();
	}
	
	private static void doMethods()throws Exception{
		//反射应用的起点首先要获得类对象 
		Class<?> c1=Point.class;
		//获得类对象中的方法
		Method ms[]=c1.getDeclaredMethods();
		for(Method m:ms){
		 System.out.println(m.getName());
		}
		//调用Point对象的m方法对象
		Point p1=new Point(); 
	    //p1.getY();//静态调用
		//获得类中指定的setX方法
		Method m1=c1.getDeclaredMethod("setY",int.class);
		m1.setAccessible(true);
		//动态执行p1对象的setX方法,为x赋值20
		m1.invoke(p1,20);
		//获得类中指定的getY方法
		Method m=c1.getDeclaredMethod("getY");
		m.setAccessible(true);
		//执行p1对象的getY方法(动态调用)
		Object result=m.invoke(p1);
		System.out.println("result="+result);
	}

	private static void doFields() throws NoSuchFieldException, IllegalAccessException {
		Point p1=new Point();
		Class<?> c1=p1.getClass();
		//1.运行时获得类对象中的内部属性
		Field[] fields= c1.getDeclaredFields();
		for(Field f:fields){
		//System.out.println(f.getModifiers());//2 表示private
		System.out.print(f.getType().getName());
		System.out.println(" "+f.getName());
		}
		//根据名字获得具体属性对象
		Field f=c1.getDeclaredField("x");
		//设置属性可访问
		f.setAccessible(true);
		//为对象p1的f属性赋值为x
		f.set(p1, 10);
		System.out.println(p1);
	}
}
