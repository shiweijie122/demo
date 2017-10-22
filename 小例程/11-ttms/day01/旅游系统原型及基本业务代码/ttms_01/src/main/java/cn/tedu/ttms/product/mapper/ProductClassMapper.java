package cn.tedu.ttms.product.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.ProductClass;

public interface ProductClassMapper {
	
	/**
	 * 查询一级分类！返回值只有两个列 id 和 name
	 */
	public List<Map<String, Object>> findAllClass1();
	
	/**
	 * 根据第一级分类查询第二级分类
	 * @param c1Id
	 * @return 返回值只有两个列 id 和 name
	 */
	public List<Map<String, Object>> findAllClass2ByClass1(Integer c1Id);

	/**
	 * 根据第二级分类查询第三级分类
	 * @param c2Id
	 * @return 返回值只有两个列 id 和 name
	 */
	public List<Map<String, Object>> findAllClass3ByClass2(Integer c2Id);

	/**
	 * 查询三级分类的名称
	 * @param object
	 * @return
	 */
	public String findClass3Name(Integer c3Id);

	/**
	 * 根据三级分类查询二级分类的id和name
	 * @param integer
	 * @return
	 */
	public Map<String, Object> findClass2NameById(Integer c3Id);

	/**
	 * 根据二级分类的id查询一级分类的name值
	 * @param integer
	 * @return
	 */
	public Map<String, Object> findClass1NameById(Integer c2Id);

	/**
	 * 条件查询：根据一级分类查询所有三级分类id
	 * @param string
	 * @return
	 */
	public List<Integer> findClass3IdsByClass1Id(Integer c1Id);

	/**
	 * 条件查询：根据二级分类查询所有三级分类id
	 * @param string
	 * @return
	 */
	public List<Integer> findClass3IdsByClass2Id(Integer c2Id);

	/**
	 * 保存产品分类
	 * @param productClass
	 */
	public int saveProductClass(@Param("productClass")ProductClass productClass);

	/**
	 *  根据id查询分类信息，用于编辑修改分类信息
	 * @param classId
	 */
	public Map<String, Object> findClassInfoById(@Param("classId")Integer classId);

	/**
	 * 修改产品分类信息
	 * @param productClass
	 */
	public int updateProductClass(@Param("productClass")ProductClass productClass);

	/**
	 * 根据一级分类id查询二级分类id
	 * @param classId
	 */
	public List<Integer> findClass2IdsByClass1Id(Integer c1Id);

	/**
	 * 删除分类及其子分类
	 * @param classIdList
	 * @return
	 */
	public int deleteClassList(@Param("classIdList")List<Integer> classIdList);

}
