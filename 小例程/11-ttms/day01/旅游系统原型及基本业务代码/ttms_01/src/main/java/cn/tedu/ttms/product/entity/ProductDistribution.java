package cn.tedu.ttms.product.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductDistribution implements Serializable {

	private static final long serialVersionUID = -6196769872950577128L;
	private Integer prodId;    //产品id
	private Integer distId;   //分销商id
	private Integer distType;  //分销类型   0：分销商     1：渠道商
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date beginDate;    //销售开始日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;      //销售终止日期
	private Integer distQty;   //分配数量
	private Integer isMono;    //是否独占   0：否     1：是
	private Integer onlineState; //上线状态  :0待售   1 ：上线   2  ：下线
	private String note;       //备注
	private Integer valid;     //禁用启用    0：禁用   1：启用  默认值为1
	private String createdUser;
	private String modifiedUser;
	private Date createdTime;
	private Date modifiedTime;
	
	public Integer getDistId() {
		return distId;
	}
	public void setDistId(Integer distId) {
		this.distId = distId;
	}
	public Integer getDistType() {
		return distType;
	}
	public void setDistType(Integer distType) {
		this.distType = distType;
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
	public Integer getDistQty() {
		return distQty;
	}
	public void setDistQty(Integer distQty) {
		this.distQty = distQty;
	}
	
	public Integer getIsMono() {
		return isMono;
	}
	public void setIsMono(Integer isMono) {
		this.isMono = isMono;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
	public Integer getOnlineState() {
		return onlineState;
	}
	public void setOnlineState(Integer onlineState) {
		this.onlineState = onlineState;
	}
	@Override
	public String toString() {
		return "ProductDistribution [prodId=" + prodId + ", distId=" + distId + ", distType=" + distType
				+ ", beginDate=" + beginDate + ", endDate=" + endDate + ", distQty=" + distQty + ", isMono=" + isMono
				+ ", onlineState=" + onlineState + ", note=" + note + ", valid=" + valid + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distId == null) ? 0 : distId.hashCode());
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
		ProductDistribution other = (ProductDistribution) obj;
		if (distId == null) {
			if (other.distId != null)
				return false;
		} else if (!distId.equals(other.distId))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}
	
}
