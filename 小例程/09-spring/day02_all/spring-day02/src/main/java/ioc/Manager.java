package ioc;

public class Manager {
	private Computer cp;

	public Manager(Computer cp) {
		System.out.println("Manager(cp)");
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Manager [cp=" + cp + "]";
	}
	
	
	
}
