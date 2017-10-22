package basic;

public class MessageBean {

	public MessageBean() {
		System.out.println("MessageBean()");
	}
	
	public void init(){
		System.out.println("init()");
	}
	
	public void destroy(){
		System.out.println("destroy()");
	}
	
	public void sendMsg(){
		System.out.println("sendMsg()");
	}

}
