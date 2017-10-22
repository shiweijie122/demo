package cn.tedu.ttms.pricepolice.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.pricepolice.entity.PricePolice;

public interface PricePoliciesMapper {

	/**
	 * 查询产品可选的价格政策
	 * @param prodId
	 * @param pricePolice 
	 * @param pageObj 
	 */
	List<Map<String, Object>> findProductPricePoliciesList(@Param("prodId")Integer prodId, @Param("pricePolice")PricePolice pricePolice, @Param("pageObj")PageObject pageObj);

	/**
	 * 查询产品可选的价格政策的总数
	 * @param prodId
	 * @param pricePolice
	 * @return
	 */
	int getRowCounts(@Param("prodId")Integer prodId, @Param("pricePolice")PricePolice pricePolice);

}
