package part01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IService{
	public void save();
}
class Service implements IService{
	@Override
	public void save() {
		System.out.println("save");
	}
}
interface IDao{
	public void insert();
}
class Dao implements IDao{
	@Override
	public void insert() {
		System.out.println("insert");
	}
}
public class DyProxyDemo01 {
	static class WorkHandler implements InvocationHandler{
		private Object target;
		public WorkHandler(Object target){
			this.target=target;
		}
		//扩展业务要写到此方法中
		@Override
		public Object invoke(Object proxy,//代理,基本不用
				Method method, Object[] args) throws Throwable {
			System.out.println("method.start");
			//执行目标对象的method方法,args为参数
			Object result=
			method.invoke(target, args);
			System.out.println("method.end");
			return result;
		}
	}
	public static void main(String[] args) {
		//1.目标对象
		Service s1=new Service();
		Dao d1=new Dao();
		//2.为目标对象创建代理对象(动态代理)
		//静态代理:需要自己写一个类与目标对象实现共同接口
		IService s2=
		(IService)Proxy.newProxyInstance(
		s1.getClass().getClassLoader(),//classLoader
		s1.getClass().getInterfaces(),//目标对象实现了哪些接口
		new WorkHandler(s1));//InvocationHandler(通过此对象添加扩展功能)
		
		IDao d2=(IDao)
		Proxy.newProxyInstance(
		d1.getClass().getClassLoader(),
		d1.getClass().getInterfaces(),
		new WorkHandler(d1));	
		
		//3.访问业务方法
		s2.save();
		//当s2对象的save方法执行时会底层会自动调用
		//WorkHandler中的invoke方法,通过此方法执行扩展业务
		
		d2.insert();
	}
}
