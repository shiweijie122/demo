package cn.tedu.ttms.attachment.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.tedu.ttms.common.DateJsonTypeConvert;


/**
 * 附件
 * @author Admin
 *
 */
public class Attachement implements Serializable {

	private static final long serialVersionUID = 9151347253409614399L;
	private Integer id;    //附件主键id
	private String title;   //附件标题
	private String fileName;    //文件名
	private String contentType;   //文件类型
	private String filePath;     //文件在服务器上的保存路径
	private Integer belongId;    //附件的归属id
	private String belongerCategory;   //附件的归属者的类型
	private String digest;  //文件内容的MD5摘要
	private Integer valid;      //附件启用禁用   0：禁用    1：启用
	private String createdUser;    //创建人用户名
	private Date createdTime;      //创建时间
	private String modifiedUser;    //最后修改人用户名
	private Date modifiedTime;       //最后修改时间
	
	
	@JsonSerialize(using=DateJsonTypeConvert.class)
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getBelongId() {
		return belongId;
	}
	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
	}
	
	public String getBelongerCategory() {
		return belongerCategory;
	}
	public void setBelongerCategory(String belongerCategory) {
		this.belongerCategory = belongerCategory;
	}
	
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
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
	
	
	
	@Override
	public String toString() {
		return "Attachement [id=" + id + ", title=" + title + ", fileName=" + fileName + ", contentType=" + contentType
				+ ", filePath=" + filePath + ", belongId=" + belongId + ", belongerCategory=" + belongerCategory
				+ ", digest=" + digest + ", valid=" + valid + ", createdUser=" + createdUser + ", createdTime="
				+ createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
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
		Attachement other = (Attachement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
