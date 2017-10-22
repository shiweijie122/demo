package cn.tedu.ttms.product.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachment.entity.Attachement;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.guide.entity.GuidesInfo;
import cn.tedu.ttms.pricepolice.entity.PricePolice;
import cn.tedu.ttms.product.entity.ProductClass;
import cn.tedu.ttms.product.entity.ProductDistribution;
import cn.tedu.ttms.product.entity.ProductInfo;
import cn.tedu.ttms.product.entity.ProductTourSchedual;

/**
 * 产品模块业务层
 */
public interface ProductService {
//	/**
//	 * 获取项目列表，用于展示项目下拉列表，每个元素只包含 Id 和 name
//	 */
//	public List<Map<String, Object>> getProjectList();
	
	/**
	 * 获取商品一级分类列表 每个元素只包含 Id 和 name
	 */
	public List<Map<String, Object>> findAllClass1();
	
	/**
	 * 获取商品二级分类列表 每个元素只包含 Id 和 name
	 */
	public List<Map<String, Object>> findAllClass2ByClass1(Integer c1Id);

	/**
	 * 获取商品三级分类列表 每个元素只包含 Id 和 name
	 */
	public List<Map<String, Object>> findAllClass3ByClass2(Integer c2Id);
	
	/**
	 * 
	 */
	public List<Map<String, Object>> getProductNumbers();
	
	/**
	 * 获取产品经理列表 每个元素只包含 userId 和 name
	 */
	public List<Map<String, Object>> getProductManagers();
	
//	/**
//	 * 获取部门列表
//	 */
//	public List<Map<String, Object>> getGroups();

	/**
	 * 创建产品
	 * @param productInfo
	 * @param productTours
	 * @param user
	 * @throws Exception
	 */
	public void save(ProductInfo productInfo, String user);


	/**
	 * 加载产品列表
	 * @param productInfo 
	 * @param numName 
	 * @param projName 
	 * @param pageObj 
	 * @return 
	 * @throws Exception 
	 */
	public Map<String, Object> findProductInfos(ProductInfo productInfo, String prjName,String classIds ,PageObject pageObj) ;

	/**
	 * 修改产品待售，上架，下架状态
	 */
	public void updateState(Integer state, String selectedIds);

	/**
	 * 修改产品信息：根据产品id查询旅游产品信息
	 */
	public Map<String, Object> findProdInfoById(Integer prodId);

	/**
	 * 修改产品信息：更新保存产品信息
	 */
	public void updateProdInfo(ProductInfo productInfo, String user);

	/**
	 * 库存分销页面：显示上部分产品表单信息
	 */
	public Map<String, Object> viewProdInfoById(Integer prodId);

	/**
	 * 加载某个产品的分销商列表
	 */
	public List<Map<String, Object>> findDistListByProdId(Integer prodId);

	/**
	 * 库存分销模态框：加载分销商下拉列表
	 */
	public List<Map<String, Object>> findDistributionInfos();

	/**
	 * 添加产品分销商
	 */
	public void saveProductDistribution(ProductDistribution distribution, String user);

	public Map<String, Object> findProductDistribution(Integer prodId, Integer distId);

	/**
	 * 库存分销：修改产品分销商信息
	 */
	public void updateProductDistribution(ProductDistribution productDistribution, String user);

	

	/**
	 * 查询产品的晚数,用于初始化行程设置页面
	 * @return 
	 */
	public int findProductNights(Integer prodId);

	/**
	 *  保存产品日程安排
	 * @param userName 
	 */
	public void saveProductTourSchedual(ProductTourSchedual schedual, String userName);

	/**
	 * 查询指定天数的日程
	 * @return 
	 */
	public Map<String, Object> findDayNumberSchedual(Integer prodId, Integer dayNumber);

	/**
	 * 修改产品日程
	 * @param schedual
	 * @param userName
	 */
	public void updateSchedual(ProductTourSchedual schedual, String userName);

	/**
	 * 删除产品的分销商
	 */
	public void deleteProductDist(Integer prodId, Integer distId);

	/**
	 * 查询指定产品的导游列表
	 * @param prodId
	 * @return 
	 */
	public List<Map<String, Object>> findGuidesListByProdId(Integer prodId);

	/**
	 * 查询所有可选导游信息
	 * @param guidesInfo 
	 * @param pageObj 
	 * @return 
	 */
	public Map<String, Object> findGuides(GuidesInfo guidesInfo, PageObject pageObj);

	/**
	 * 保存产品选择的导游
	 * @param prodId
	 * @param guidesIds
	 * @param userName 
	 * @param session 
	 */
	public void saveProductGuides(Integer prodId, String guidesIds, String userName);

	/**
	 * 解除产品导游关系
	 * @param prodId
	 * @param guideId
	 */
	public void deleteProductGuide(Integer prodId, Integer guideId);

	/**
	 * 查询产品的附件列表
	 * @param prodId
	 * @return 
	 */
	public List<Map<String, Object>> findAttachmentsListByProdId(Integer prodId);

	/**
	 * 文件上传
	 * @param attachements
	 * @param prodFile
	 * @param userName 
	 * @param session
	 */
	public void upload(Attachement attachement, MultipartFile prodFile, String userName, HttpSession session);

	/**
	 * 修改附件禁用启用状态
	 * @param attachmentId
	 * @param state
	 * @param userName
	 */
	public void changeAttachmentState(Integer attachmentId, Integer state, String userName);

	/**
	 * 根据附件id查找附件在服务器上的路径
	 * @param attachmentId
	 * @return
	 */
	public Map<String, Object> findFilePathById(Integer attachmentId);

	/**
	 * 查找产品可用的价格政策
	 * @param prodId
	 * @param pricePolice 
	 * @param pageObj 
	 * @return 
	 */
	public Map<String, Object> findProductPricePoliciesList(Integer prodId, PricePolice pricePolice, PageObject pageObj);

	/**
	 * 保存产品价格政策
	 * @param prodId
	 * @param pricePolicyIds
	 * @param userName
	 */
	public void saveProductPricePolicies(Integer prodId, String pricePolicyIds, String userName);

	/**
	 * 查询指定产品的价格政策列表
	 * @param prodId
	 * @return 
	 */
	public List<Map<String, Object>> findPricePoliciesByProdId(Integer prodId);

	/**
	 * 解除产品的价格政策（解除二者关系）
	 * @param prodId
	 * @param pricePolicyId
	 */
	public void deleteProductPricePolicy(Integer prodId, Integer pricePolicyId);

	/**
	 * 查询所有一级分类
	 * @return 
	 */
//	public List<Map<String, Object>> findTopCategoryList();

	/**
	 * 查询指定一级分类的子分类二级分类
	 * @param topClassId
	 * @return 
	 */
//	public List<Map<String, Object>> findSecondCategoryList(Integer topClassId);

	/**
	 * 查询指定二级分类的子分类三级分类
	 * @param secondClassId
	 * @return 
	 */
//	public List<Map<String, Object>> findThirdCategoryList(Integer secondClassId);

	/**
	 * 保存产品分类
	 * @param productClass
	 * @param userName
	 */
	public void saveProductClass(ProductClass productClass, String userName);

	/**
	 * 根据id查询分类信息，用于编辑修改分类信息
	 * @param classId
	 * @return 
	 */
	public Map<String, Object> findClassInfoById(Integer classId);

	/**
	 * 修改产品分类信息
	 * @param productClass
	 * @param userName
	 */
	public void updateProductClass(ProductClass productClass, String userName);

	/**
	 * 判断要删除的分类下是否有产品
	 * @param classLevel
	 * @param classId
	 * @return 
	 */
	public String hasProduct(String classLevel, Integer classId);

	/**
	 * 删除产品分类
	 * @param classLevel
	 * @param classId
	 */
	public void deleteClasses(String classLevel, Integer classId);

	/**
	 * 查看产品详情 - 基本信息
	 * @param prodId
	 * @return 
	 */
	public Map<String, Object> findProductBasicInfo(Integer prodId);

	/**
	 * 查看产品详情 - 旅游详细信息
	 * @param prodId
	 * @return 
	 */
	public Map<String, Object> findProductDetailInfo(Integer prodId);

}
