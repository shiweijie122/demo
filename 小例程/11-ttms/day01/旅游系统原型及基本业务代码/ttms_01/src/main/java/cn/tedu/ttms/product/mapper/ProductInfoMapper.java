package cn.tedu.ttms.product.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.product.entity.ProductInfo;

public interface ProductInfoMapper {

	int saveProductInfo(@Param(value="productInfo")ProductInfo productInfo);

	List<Map<String, Object>> findProductInfos(@Param("productInfo")ProductInfo productInfo, @Param("numIds")List<Integer> numIds, @Param("classIdList")List<Integer> classIdList, @Param("pageObj")PageObject pageObj);

	int getRowCounts(@Param(value="productInfo")ProductInfo productInfo);

	int updateState(@Param(value="state")Integer state, @Param(value="prodId")String prodId);

	Map<String, Object> findProdInfoById(Integer prodId);

	int updateProdInfo(@Param(value="productInfo")ProductInfo productInfo);

	Map<String, Object> viewProdInfoById(@Param(value="prodId")Integer prodId);

	String findMaxProductIdContainsPrjId(@Param(value="prjId")String prjId);

	int findProductNights(Integer prodId);

	/**
	 * 判断要删除的分类下是否有产品
	 * @param classList
	 */
	public int hasProduct(@Param("classList")List<Integer> classList);

	/**
	 * 查看产品详情 - 基本信息
	 * @param prodId
	 */
	Map<String, Object> findProductBasicInfo(@Param("prodId")Integer prodId);

	/**
	 * 查看产品详情 - 旅游详细信息
	 * @param prodId
	 */
	Map<String, Object> findProductDetailInfo(@Param("prodId")Integer prodId);

	/**
	 * 查询项目经理信息
	 */
	List<Map<String, Object>> findProjectManagers();

}
