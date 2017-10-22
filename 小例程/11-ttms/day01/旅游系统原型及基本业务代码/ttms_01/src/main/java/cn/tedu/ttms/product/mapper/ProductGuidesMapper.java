package cn.tedu.ttms.product.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.ProductGuidesInfo;

public interface ProductGuidesMapper {

	List<Map<String, Object>> findGuidesListByProdId(Integer prodId);

	int saveProductGuides(@Param("productGuidesInfo")ProductGuidesInfo productGuidesInfo);

	int isExist(@Param("prodId")Integer prodId, @Param("guideId")int guideId);

	int deleteProductGuide(@Param("prodId")Integer prodId, @Param("guideId")Integer guideId);


}
