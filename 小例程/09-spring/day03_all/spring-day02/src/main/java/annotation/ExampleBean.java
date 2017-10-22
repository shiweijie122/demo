package annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("eb")
public class ExampleBean {
	
	@Value("李白")
	private String name;
	@Value("#{config.pageSize}")
	private String pageSize;
	
	public ExampleBean() {
		System.out.println("ExampleBean()");
	}
	
	@Override
	public String toString() {
		return "ExampleBean [name=" + name + ", pageSize=" + pageSize + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
}
