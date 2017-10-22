package web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements 
	ServletRequestListener,
	ServletRequestAttributeListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("销毁request");
	}

	//tomcat调用监听器的代码示例:
	//ServletRequest req = new RequestFacade();
	//ServletRequestListener l = new MyListener();
	//l.requestInitialized();
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("创建request");
		System.out.println(e.getServletRequest());
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println(
			"向request内增加一个数据");
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		
	}

}







