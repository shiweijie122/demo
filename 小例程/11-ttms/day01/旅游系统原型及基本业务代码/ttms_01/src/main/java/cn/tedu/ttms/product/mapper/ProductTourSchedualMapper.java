package cn.tedu.ttms.product.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.ProductTourSchedual;

public interface ProductTourSchedualMapper {

	Integer saveProductTourSchedual(@Param("schedual")ProductTourSchedual schedual);


	Map<String, Object> findDayNumberSchedual(@Param("prodId")Integer prodId, @Param("dayNumber")int dayNumber);

	Integer isExistDaySchedual(@Param("prodId")Integer prodId, @Param("dayNumber")int dayNumber);

	void updateSchedual(@Param("schedual")ProductTourSchedual schedual);

}
