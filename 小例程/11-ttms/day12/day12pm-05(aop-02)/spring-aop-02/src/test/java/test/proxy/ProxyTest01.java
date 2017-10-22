package test.proxy;
import org.junit.Before;
import org.junit.Test;
import com.company.project.service.ProjectService;
import com.company.project.service.ProjectServiceImpl;
import com.company.project.service.aspect.LogAspect;
import com.company.project.service.proxy.ProjectServiceProxy;
public class ProxyTest01 {
     private ProjectServiceProxy proxyObject;
	 @Before
	 public void init(){
		 //目标对象(被代理对象)
		 ProjectService targetObject=
		 new ProjectServiceImpl();
		 //代理对象(通过代理对象为目标对象扩展新的功能)
		 proxyObject=
		 new ProjectServiceProxy(targetObject);
		 //借助此类封装日志操作
		 LogAspect logAspect=new LogAspect();
		 proxyObject.setLogAspect(logAspect);
	 }
	 @Test
	 public void testSaveObject(){
		 proxyObject.saveObject(null);
	 }
	 @Test
	 public void testUpdateObject(){
		 proxyObject.updateObject(null);
	 }
}
