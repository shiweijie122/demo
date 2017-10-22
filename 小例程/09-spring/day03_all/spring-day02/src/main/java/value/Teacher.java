package value;

public class Teacher {
	private String name;
	private String interest;
	private double score;
	private int pageSize;
	
	
	public Teacher() {
		System.out.println("Teacher()");
	}
	
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", interest=" + interest + ", score=" + score + ", pageSize=" + pageSize + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
