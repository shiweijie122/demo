package cn.tedu.demo;

public class GarbageObj {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("调用finalize方法");
		System.out.println("GC的线程名称是:"
		+Thread.currentThread().getName());
		super.finalize();
		
	}
}
