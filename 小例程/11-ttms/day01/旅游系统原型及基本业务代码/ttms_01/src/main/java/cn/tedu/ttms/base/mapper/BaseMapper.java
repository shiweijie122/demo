package cn.tedu.ttms.base.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;

public interface BaseMapper<T extends Serializable> {
	int getRowCounts(@Param(value="entity") T entity);
	List<Map<String,Object>> findObjects(@Param(value = "entity") T entity,@Param(value = "pageObj") PageObject pageObj);
    int insertObject(T entity);
    int updateObject(T entity);
    Map<String,Object> findById(@Param (value="id") String id);
	/**
	 * 根据id执行删除动作，底层执行更新操作，修改其标识位0
	 * @param prjId
	 * @return
	 */
	int deleteById(@Param (value="id") String id);
	/**
	 * 修改项目信息的有效状态
	 * @param prjId
	 * @param validInt
	 * @param user
	 * @return
	 */
    int validById(@Param(value = "id") Integer prjId, @Param(value = "valid")Integer valid, @Param(value = "user")String user);
   /**
    * 获取项目列表，用于展示项目下拉列表
 * @return 
    */
    List<Map<String, Object>> projectList();
}
