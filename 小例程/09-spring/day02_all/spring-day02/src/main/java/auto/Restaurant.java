package auto;

public class Restaurant {
	private Waiter wt;

	public void setWt(Waiter wt) {
		System.out.println("setWt()");
		this.wt = wt;
	}

	public Restaurant() {
		System.out.println("Restaurant()");
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}
	
	
	
}
