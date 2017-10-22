package cn.tedu.ttms.product.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 产品实体类  - 对应product_info表
 * @author Admin
 *
 */
public class ProductInfo implements Serializable {
	private static final long serialVersionUID = -1105611382102169613L;
	private Integer id;         //产品主键id
	private String prodId;      //产品编号
	private String prodName;     //产品名称
	private Integer numId;       //团号
	private String exText;        //特别提示
	private String prodIntro;      //产品介绍
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date srvcBeginDate;           //服务开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date srvcEndDate;              //服务结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date onlineDate;              //上架时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date offlineDate;             //下架时间
	private Integer quantity;             //预售数量
	private Integer minQty;               //最低数量
	private Integer soldQty;              //已售数量
	private Float  price;                 //价格
	private Integer classId;              //分类id
	private Integer nights;               //晚数
	private Integer state;                 //状态
	private Integer contientId;             //目的地
	private String startPlace;             //出发地
	private String returnPlace;             //返回地
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;                 //出发日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;                   //返回日期
	private Integer mgrId;                   //产品负责人编号
	private String note;                     //备注
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
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
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	
	public Integer getNumId() {
		return numId;
	}
	public void setNumId(Integer numId) {
		this.numId = numId;
	}
	public String getExText() {
		return exText;
	}
	public void setExText(String exText) {
		this.exText = exText;
	}
	public String getProdIntro() {
		return prodIntro;
	}
	public void setProdIntro(String prodIntro) {
		this.prodIntro = prodIntro;
	}
	public Date getSrvcBeginDate() {
		return srvcBeginDate;
	}
	public void setSrvcBeginDate(Date srvcBeginDate) {
		this.srvcBeginDate = srvcBeginDate;
	}
	public Date getSrvcEndDate() {
		return srvcEndDate;
	}
	public void setSrvcEndDate(Date srvcEndDate) {
		this.srvcEndDate = srvcEndDate;
	}
	public Date getOnlineDate() {
		return onlineDate;
	}
	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}
	public Date getOfflineDate() {
		return offlineDate;
	}
	public void setOfflineDate(Date offlineDate) {
		this.offlineDate = offlineDate;
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
	public Integer getSoldQty() {
		return soldQty;
	}
	public void setSoldQty(Integer soldQty) {
		this.soldQty = soldQty;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getNights() {
		return nights;
	}
	public void setNights(Integer nights) {
		this.nights = nights;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getContientId() {
		return contientId;
	}
	public void setContientId(Integer contientId) {
		this.contientId = contientId;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getReturnPlace() {
		return returnPlace;
	}
	public void setReturnPlace(String returnPlace) {
		this.returnPlace = returnPlace;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Integer getMgrId() {
		return mgrId;
	}
	public void setMgrId(Integer mgrId) {
		this.mgrId = mgrId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
		return "ProductInfo [id=" + id + ", prodId=" + prodId + ", prodName=" + prodName + ", numId=" + numId
				+ ", exText=" + exText + ", prodIntro=" + prodIntro + ", srvcBeginDate=" + srvcBeginDate
				+ ", srvcEndDate=" + srvcEndDate + ", onlineDate=" + onlineDate + ", offlineDate=" + offlineDate
				+ ", quantity=" + quantity + ", minQty=" + minQty + ", soldQty=" + soldQty + ", price=" + price
				+ ", classId=" + classId + ", nights=" + nights + ", state=" + state + ", contientId=" + contientId
				+ ", startPlace=" + startPlace + ", returnPlace=" + returnPlace + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", mgrId=" + mgrId + ", note=" + note + ", createdUser=" + createdUser
				+ ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime
				+ "]";
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
		ProductInfo other = (ProductInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
