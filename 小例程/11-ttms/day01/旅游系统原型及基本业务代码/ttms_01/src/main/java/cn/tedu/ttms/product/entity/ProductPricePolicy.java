package cn.tedu.ttms.product.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductPricePolicy implements Serializable{
	private static final long serialVersionUID = 140757857518035378L;
	private Integer prodId;
	private Integer pricePolicyId;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getPricePolicyId() {
		return pricePolicyId;
	}
	public void setPricePolicyId(Integer pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "ProductPricePolicy [prodId=" + prodId + ", pricePolicyId=" + pricePolicyId + ", createdUser="
				+ createdUser + ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime="
				+ modifiedTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pricePolicyId == null) ? 0 : pricePolicyId.hashCode());
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPricePolicy other = (ProductPricePolicy) obj;
		if (pricePolicyId == null) {
			if (other.pricePolicyId != null)
				return false;
		} else if (!pricePolicyId.equals(other.pricePolicyId))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}
}
