package cn.tedu.ttms.base.entity;

import java.io.Serializable;

public class BaseModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int optType;

	public int getOptType() {
		return optType;
	}

	public void setOptType(int optType) {
		this.optType = optType;
	}
}
