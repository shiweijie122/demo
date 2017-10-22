package cn.tedu.ttms.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.Dictionary;
import cn.tedu.ttms.sys.entity.DictionaryType;



public interface DictionaryMapper {
	/**
	 * 查询字典类型
	 * 
	 * @param dictType
	 * @param pageObj
	 * @return
	 */
	List<DictionaryType> selectDictType(@Param(value = "dictType") DictionaryType dictType,
			@Param(value = "pageObj") PageObject pageObj);

	/**
	 * 取得字典类型条数
	 * 
	 * @param dictType
	 * @return
	 */
	public int getDictTypeCount(@Param(value = "dictType") DictionaryType dictType);

	
	public String getMaxDictTypeId();

	/**
	 * 新增字典类型
	 * 
	 * @param dictType
	 * @return
	 */
	int addDictType(@Param(value = "dictType") DictionaryType dictType);

	/**
	 * 更新字典类型
	 * 
	 * @param dictType
	 * @return
	 */
	int updateDictType(@Param(value = "dictType") DictionaryType dictType);

	/**
	 * 删除字典类型
	 * 
	 * @param dictTypeId
	 * @return
	 */
	int delDictType(@Param(value = "dictTypeId") String dictTypeId);

	/**
	 * 查询字典记录
	 * 
	 * @param dict
	 * @return
	 */
	List<Dictionary> selectDictonary(@Param(value = "dict") Dictionary dict);

	/**
	 * 取得字典记录条数
	 * 
	 * @param dict
	 * @return
	 */
	public int getDictionaryCount(@Param(value = "dict") Dictionary dict);

	/**
	 * 新增字典值
	 * 
	 * @param dict
	 * @return
	 */
	int addDictionary(@Param(value = "dict") Dictionary dict);

	/**
	 * 更新字典值
	 * 
	 * @param dict
	 * @return
	 */
	int updateDictionary(@Param(value = "dict") Dictionary dict);

	/**
	 * 删除字典值
	 * 
	 * @param dictId
	 * @return
	 */
	int delDictionary(@Param(value = "dict") Dictionary dict);
}
