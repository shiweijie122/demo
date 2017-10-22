package cn.tedu.ttms.product.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductTourSchedual implements Serializable {

	private static final long serialVersionUID = 3511160129117859408L;
	private Integer id;   //主键id
	private String prodId; //产品编号
	private String scheName;  //日程名称
	private Integer dayNumber; //日程序号
	private String schedualContent;   //日程内容
	private String lodgeMessage;  //住宿酒店信息
	private String breakFastMessage;  //早餐信息
	private String lunchMessage;   //午餐信息
	private String dinnerMessage;  //晚餐信息
	private String createdUser;   //创建人
	private Date createdTime;
	private String modifiedUser;  //最后修改人姓名
	private Date modifiedTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getScheName() {
		return scheName;
	}
	public void setScheName(String scheName) {
		this.scheName = scheName;
	}
	public Integer getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getSchedualContent() {
		return schedualContent;
	}
	public void setSchedualContent(String schedualContent) {
		this.schedualContent = schedualContent;
	}
	public String getLodgeMessage() {
		return lodgeMessage;
	}
	public void setLodgeMessage(String lodgeMessage) {
		this.lodgeMessage = lodgeMessage;
	}
	public String getBreakFastMessage() {
		return breakFastMessage;
	}
	public void setBreakFastMessage(String breakFastMessage) {
		this.breakFastMessage = breakFastMessage;
	}
	public String getLunchMessage() {
		return lunchMessage;
	}
	public void setLunchMessage(String lunchMessage) {
		this.lunchMessage = lunchMessage;
	}
	public String getDinnerMessage() {
		return dinnerMessage;
	}
	public void setDinnerMessage(String dinnerMessage) {
		this.dinnerMessage = dinnerMessage;
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
		ProductTourSchedual other = (ProductTourSchedual) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductTourSchedual [id=" + id + ", prodId=" + prodId + ", scheName=" + scheName + ", dayNumber="
				+ dayNumber + ", schedualContent=" + schedualContent + ", lodgeMessage=" + lodgeMessage
				+ ", breakFastMessage=" + breakFastMessage + ", lunchMessage=" + lunchMessage + ", dinnerMessage="
				+ dinnerMessage + ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	
	

}
