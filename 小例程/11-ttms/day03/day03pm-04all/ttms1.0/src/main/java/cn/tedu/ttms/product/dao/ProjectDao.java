package cn.tedu.ttms.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.Project;
/**数据持久层对象(方法名必须
 * 与ProjectMapper中的id值对应)*/
public interface ProjectDao {
	
	/**获得表中所有记录
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态值(1,0)
	 * @param startIndex 表示从哪条记录开始取数据
	 * @param pageSize 表示每页显示多少条记录
	 * @return 表示查询到的当前页的所有记录
	 * 当方法中的参数个数多于1个时需要使用
	 * @param 注解进行声明
	 * */
	List<Project> findObjects(
	@Param("name")String name,
	@Param("valid")Integer valid,
	@Param("startIndex")int startIndex,
	@Param("pageSize")int pageSize);
	/**获得总记录数
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态值(1,0)
	 * @return 总记录数
	 */
	int getRowCount(
			@Param("name")String name,
			@Param("valid")Integer valid);
	
	/**将对象信息写入到表中*/
	int insertObject(Project entity);
	/**修改表中记录信息*/
	//int updateObject(Project entity);
	//.....
	
}
