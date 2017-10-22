package cn.tedu.ttms.sys.entity;



import java.util.Date;
import java.util.List;

import cn.tedu.ttms.base.entity.BaseModel;


/**
 * 用户所属机构
 * @author Admin
 *
 */

public class UserGroup extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 机构编号
    private String grpId;
    // 机构名称
    private String grpName;
    // 上级机构编号
    private String parentId;
    // 机构类型
    private String grpType;
    // 组织编号
    private String orgId;
    // 备注
    private String note;
    // 有效标志
    private String valid;
    // 新增用户
    private String createdUser;
    // 新增时间
    private Date createdTime;
    // 更新用户
    private String modifiedUser;
    // 更新时间
    private Date modifiedTime;
    //类型名称
    private String typeName;
    private String parentName;
    private String compId;
    private String compname;

    private String cascadeGrpIds;
    
    private String grpIds; 
    private String grpNames;
    private String id;
    private String pid;
    public String getGrpNames() {
		return grpNames;
	}

	public void setGrpNames(String grpNames) {
		this.grpNames = grpNames;
	}

	public String getGrpIds() {
		return grpIds;
	}

	public void setGrpIds(String grpIds) {
		this.grpIds = grpIds;
	}

	private List<UserGroup> userGroupList;

    public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getGrpType() {
        return grpType;
    }

    public void setGrpType(String grpType) {
        this.grpType = grpType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
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

    public String getCascadeGrpIds() {
        return cascadeGrpIds;
    }

    public void setCascadeGrpIds(String cascadeGrpIds) {
        this.cascadeGrpIds = cascadeGrpIds;
    }

    public List<UserGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(List<UserGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

    public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}
    
}
