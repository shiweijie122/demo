package part01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * 注解:一个特殊的类,用于标识类,属性,方法
 * @Interface 用于定义注解
 * target 表示定义的这个注解能够应用在哪
 * Retention表示注解何时生效
 * @author adminitartor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@interface Test{}
@Test
class TestService{
	@Test
	void testSave(){
		System.out.println("save");
	}
	void testUpdate(){
		System.out.println("update");
	}
}

public class ReflectDemo05 {
    static Map<String,Object> map=new HashMap<>(); 
	public static void main(String[] args)
	throws Exception{
        Class<?> c=Class.forName("part01.TestService");
        if(!c.isAnnotationPresent(Test.class))
        return;
        Object instance=c.newInstance();
        //将构建的实例存储起来(假如有需要)
        putInstance(c, instance);
        Method[] ms=c.getDeclaredMethods();
        for(Method m:ms){
        	//判定方法上有没有Test注解
        	boolean flag=
        	m.isAnnotationPresent(Test.class);
        	//假如有则执行方法进行测试
        	if(flag){
        		m.invoke(instance);
        	}
        }
	}
	private static void putInstance(Class<?> c, Object instance) {
		String className=c.getSimpleName();
        String firstChar=
        className.substring(0,1)
        .toLowerCase();
        className=
        className.replaceFirst("\\w",firstChar);
        System.out.println("className="+className);
        map.put(className,instance);
	}
}
