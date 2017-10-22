package cn.tedu.ttms.product.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.ProductDistribution;

public interface ProductDistributionMapper {

	List<Map<String, Object>> findDistListByProdId(@Param(value="prodId")Integer prodId);

	List<Map<String, Object>> findDistributionInfos();

	int findDistributionTypeById(Integer distId);

	int saveProductDistribution(@Param(value="distribution")ProductDistribution distribution);

	Map<String,Object> findProductDistribution(@Param(value="prodId")Integer prodId, @Param(value="distId")Integer distId);

	int updateProductDistribution(@Param(value="productDistribution")ProductDistribution productDistribution);

	int deleteProductDist(@Param("prodId")Integer prodId, @Param("distId")Integer distId);

}
