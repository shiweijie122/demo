package part01;

class Connection{}

class ConnectionFactory{
	/**ThreadLocal类提供了这样的一种机制,能够将
	 * 某个对象绑定到当前线程,也可以从当前线程
	 * 获取某个对象,常用方法:
	 * 1)get()从当前线程获取绑定对象
	 * 2)set(obj)将某个对象绑定到当前线程
	 * 3)remove(obj)从当前线程移除某个对象
	 * */
	private static ThreadLocal<Connection> td=
		new ThreadLocal<Connection>();
	public static Connection getConnection(){
		//从当前线程获取Connection对象
		Connection conn=td.get();
		//当前线程假如没有Connection,则创建Connection
		if(conn==null){
			conn=new Connection();
			//将connection绑定到当前线程
			td.set(conn);//map.put(key,value)
		}
		return conn;
	}
}
public class ThreadLocalDemo01 {
    public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				//假设如下两条语句在一个事务内部
				System.out.println("thread-A.conn="+ConnectionFactory.getConnection());
				System.out.println("thread-A.conn="+ConnectionFactory.getConnection());
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				System.out.println("thread-B.conn="+ConnectionFactory.getConnection());
				System.out.println("thread-B.conn="+ConnectionFactory.getConnection());
			}
		}.start();
	}
}
