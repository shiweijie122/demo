package cn.tedu.ttms.sys.service;

import java.util.List;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.Dictionary;
import cn.tedu.ttms.sys.entity.DictionaryType;


public interface DictionaryService {
	/**
	 * 查询字典类型
	 * 
	 * @param dictType
	 * @param pageObj
	 * @return
	 */
	List<DictionaryType> selectDictType(DictionaryType dictType, PageObject pageObj) throws Exception;

	/**
	 * 取得字典类型条数
	 * 
	 * @param dictType
	 * @return
	 */
	int getDictTypeCount(DictionaryType dictType) throws Exception;

	String getMaxDictTypeId() throws Exception;

	/**
	 * 新增字典类型
	 * 
	 * @param dictType
	 * @return
	 */
	int addDictType(DictionaryType dictType) throws Exception;

	/**
	 * 更新字典类型
	 * 
	 * @param dictType
	 * @return
	 */
	int updateDictType(DictionaryType dictType) throws Exception;

	/**
	 * 删除字典类型
	 * 
	 * @param dictTypeId
	 * @return
	 */
	int delDictType(String dictTypeId) throws Exception;

	/**
	 * 查询字典记录
	 * 
	 * @param dict
	 * @return
	 */
	List<Dictionary> selectDictonary(Dictionary dict) throws Exception;

	/**
	 * 取得字典记录条数
	 * 
	 * @param dict
	 * @return
	 */
	int getDictionaryCount(Dictionary dict) throws Exception;

	/**
	 * 新增字典值
	 * 
	 * @param dict
	 * @return
	 */
	int addDictionary(Dictionary dict) throws Exception;

	/**
	 * 更新字典值
	 * 
	 * @param dict
	 * @return
	 */
	int updateDictionary(Dictionary dict) throws Exception;

	/**
	 * 删除字典值
	 * 
	 * @param dictId
	 * @return
	 */
	int delDictionary(Dictionary dict) throws Exception;
}
