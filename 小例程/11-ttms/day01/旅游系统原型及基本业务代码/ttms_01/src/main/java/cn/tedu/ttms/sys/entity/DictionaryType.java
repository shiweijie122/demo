package cn.tedu.ttms.sys.entity;

import java.io.Serializable;

/**
 * 字典类型
 * @author Admin
 *
 */
public class DictionaryType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 字典类型编号
	 */
	private String dictTypeId;
	/**
	 * 字典类型名称
	 */
	private String dictTypeName;
	
	public String getDictTypeId() {
		return dictTypeId;
	}
	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}
	public String getDictTypeName() {
		return dictTypeName;
	}
	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}
}
