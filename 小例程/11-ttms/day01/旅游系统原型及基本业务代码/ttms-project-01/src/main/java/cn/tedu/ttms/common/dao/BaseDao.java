package cn.tedu.ttms.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.util.PageObject;

public interface BaseDao<T> {
	List<Map<String,Object>> findObjects(@Param(value="entity") T entity,@Param(value="pageObject") PageObject pageObject);
	Map<String,Object> findObjectById(@Param (value="id") Integer id);
	int validById(@Param(value="ids")String[] ids,@Param(value="valid")Integer valid);
	int insertObject(T t);
	int updateObject(T t);
	int getRowCounts(@Param(value="entity") T t);
}