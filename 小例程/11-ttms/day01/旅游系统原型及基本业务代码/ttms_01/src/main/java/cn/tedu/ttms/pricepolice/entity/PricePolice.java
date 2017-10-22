package cn.tedu.ttms.pricepolice.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PricePolice implements Serializable{

	private static final long serialVersionUID = -172381170642154839L;
	private Integer id;               //政策id
	private String policyName;        //政策名称
	private Integer quantity;         //政策的最大数量
	private Integer minQty;           //政策的最小数量
	private String reduce;            //政策优惠   可以是折扣，也可以是-2000
	private String note;              //政策说明
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date beginDate;           //政策开始日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;             //政策结束日期
	private Integer valid;            //政策禁用启用   1：启用   0：禁用
	private String createdUser;       //创建人用户名
	private Date createdTime;         //创建时间
	private String modifiedUser;      //最后修改人用户名
	private Date modifiedTime;        //最后修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getMinQty() {
		return minQty;
	}
	public void setMinQty(Integer minQty) {
		this.minQty = minQty;
	}
	public String getReduce() {
		return reduce;
	}
	public void setReduce(String reduce) {
		this.reduce = reduce;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
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
		return "PricePolice [id=" + id + ", policyName=" + policyName + ", quantity=" + quantity + ", minQty=" + minQty
				+ ", reduce=" + reduce + ", note=" + note + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", valid=" + valid + ", createdUser=" + createdUser + ", createdTime=" + createdTime
				+ ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PricePolice other = (PricePolice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
