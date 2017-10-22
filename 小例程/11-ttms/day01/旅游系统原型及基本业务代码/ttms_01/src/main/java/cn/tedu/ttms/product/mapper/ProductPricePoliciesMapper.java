package cn.tedu.ttms.product.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.product.entity.ProductPricePolicy;

public interface ProductPricePoliciesMapper {

	int isExistPricePolicy(@Param("prodId")Integer prodId, @Param("pricePolicyId")Integer pricePolicyId);

	int saveProductPricePolicy(@Param("policy")ProductPricePolicy policy);

	List<Map<String, Object>> findPricePoliciesByProdId(@Param("prodId")Integer prodId);

	int deleteProductPricePolicy(@Param("prodId")Integer prodId, @Param("pricePolicyId")Integer pricePolicyId);

}
