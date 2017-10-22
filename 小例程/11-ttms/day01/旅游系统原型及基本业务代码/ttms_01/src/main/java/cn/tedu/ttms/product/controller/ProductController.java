package cn.tedu.ttms.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachment.entity.Attachement;
import cn.tedu.ttms.base.controller.JsonBaseController;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.base.exception.DownLoadException;
import cn.tedu.ttms.base.exception.UploadException;
import cn.tedu.ttms.guide.entity.GuidesInfo;
import cn.tedu.ttms.pricepolice.entity.PricePolice;
import cn.tedu.ttms.product.entity.ProductClass;
import cn.tedu.ttms.product.entity.ProductDistribution;
import cn.tedu.ttms.product.entity.ProductInfo;
import cn.tedu.ttms.product.entity.ProductTourSchedual;
import cn.tedu.ttms.product.service.ProductService;
import cn.tedu.ttms.base.entity.JsonResult;

/**
 * 产品控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController extends JsonBaseController {
	
	@Resource
	private ProductService productService;
	
	/**
	 * 显示界面
	 * @return
	 */
	@RequestMapping("/add.do")
	public String add(){
		return "ttms/product/addProdInfo";
	}

//	/**
//	 * 获取项目列表， 用于展现项目下拉列表
//	 */
//	@RequestMapping("/projectList.do")
//	@ResponseBody
//	public JsonResult<List<Map<String, Object>>> projectList(){
//		return new JsonResult<List<Map<String,Object>>>( productService.getProjectList());
//	}
	/**
	 * 获取分类1列表， 用于展现项目下拉列表
	 */
	@RequestMapping("/class1List.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> class1List(){
		return new JsonResult<List<Map<String,Object>>>( productService.findAllClass1());
	}
	
	/**
	 * 获取分类2列表， 用于展现分类2下拉列表
	 */
	@RequestMapping("/class2List.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> class2List(Integer c1Id){
		return new JsonResult<List<Map<String,Object>>>( productService.findAllClass2ByClass1(c1Id));
	}
	
	/**
	 * 获取分类3列表， 用于展现分类3下拉列表
	 */
	@RequestMapping("/class3List.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> class3List(Integer c2Id){
		return new JsonResult<List<Map<String,Object>>>( productService.findAllClass3ByClass2(c2Id));
	}
	
	/**
	 * 获取产品编号列表， 用于展现产品编号拉列表
	 */
	@RequestMapping("/numberList.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> numberList(){
		return new JsonResult<List<Map<String,Object>>>( productService.getProductNumbers());
	}
	
	/**
	 * 获取产品经理列表， 用于展现产品经理下拉列表
	 */
	@RequestMapping("/managerList.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> managerList(){
		return new JsonResult<List<Map<String,Object>>>( productService.getProductManagers());
	}
	
//	/**
//	 * 获取部门列表， 用于展现部门选择列表
//	 */
//	@RequestMapping("/groupList.do")
//	@ResponseBody
//	public JsonResult<List<Map<String, Object>>> groupList(){
//		return new JsonResult<List<Map<String,Object>>>( productService.getGroups());
//	}
	
	/**
	 * 创建产品-保存
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult<Object> sava(ProductInfo productInfo,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.save(productInfo,userName);
		return new JsonResult<Object>("创建产品成功！");
	}
	
	/**
	 * 点击导航栏产品列表，跳转到产品列表页面
	 * @return
	 */
	@RequestMapping("/list.do")
	public String list(){
		return "ttms/product/productManageList";
	}
	
	
	/**
	 * 加载产品列表
	 */
	@RequestMapping("/findProductInfos.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findProductList(ProductInfo productInfo,String prjName,String classIds,PageObject pageObj){
		return new JsonResult<Map<String,Object>>(productService.findProductInfos(productInfo,prjName,classIds,pageObj));
	}
	
	/**
	 * 点击修改按钮，跳转到产品编辑页面
	 */
	@RequestMapping("/showEditPage.do")
	public String showDialog(){
		return "ttms/product/editProductInfo";
	}
	
	/**
	 * 修改产品信息：根据产品id查询旅游产品信息
	 */
	@RequestMapping("/findProdInfoById.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findProdInfoById(Integer prodId){
		return new JsonResult<Map<String, Object>>(productService.findProdInfoById(prodId));
	}
	
	/**
	 * 修改产品待售，上架，下架状态
	 */
	@RequestMapping("/updateState.do")
	@ResponseBody
	public JsonResult<Object> updateState(String state,String selectedIds){
		productService.updateState(Integer.parseInt(state),selectedIds);
		return new JsonResult<Object>();
	}
	
	/**
	 * 修改产品信息：更新保存产品信息
	 */
	@RequestMapping("/updateProdInfo.do")
	@ResponseBody
	public JsonResult<Object> updateProdInfo(ProductInfo productInfo,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.updateProdInfo(productInfo,userName);
		return new JsonResult<Object>("修改成功！");
	}
	
	/**
	 * 点击库存分销，跳转到库存分销页面
	 */
	@RequestMapping("/showProductDistPage.do")
	public String showProductDistPage(){
		return "ttms/product/productInventDist";
	}
	
	/**
	 * 库存分销页面：显示上部分产品表单信息
	 */
	@RequestMapping("/viewProdInfoById.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> viewProdInfoById(Integer prodId){
		Map<String, Object> prodInfo = productService.viewProdInfoById(prodId);
		return new JsonResult<Map<String, Object>>(prodInfo);
	}
	
	/**
	 * 库存分销：加载分销商列表
	 */
	@RequestMapping("/findDistListByProdId.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> findDistListByProdId(Integer prodId){
		List<Map<String, Object>> list = productService.findDistListByProdId(prodId);
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 库存分销模态框：加载分销商下拉列表
	 */
	@RequestMapping("/findDistributionInfos.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> findDistributionInfos(){
		List<Map<String, Object>> list = productService.findDistributionInfos();
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 库存分销：给产品添加分销商，保存分销商
	 */
	@RequestMapping("/saveProductDistribution.do")
	@ResponseBody
	public JsonResult<Object> saveProductDistribution(ProductDistribution distribution,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.saveProductDistribution(distribution,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 库存分销：删除产品分销商
	 */
	@RequestMapping("/deleteProductDist.do")
	@ResponseBody
	public JsonResult<Object> deleteProductDist(Integer prodId,Integer distId){
		productService.deleteProductDist(prodId,distId);
		return new JsonResult<Object>();
	}
	
	/**
	 * 库存分销：根据id获取产品分销商信息
	 */
	@RequestMapping("/findProductDistribution.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findProductDistribution(Integer prodId,Integer distId){
		Map<String, Object> distribution = productService.findProductDistribution(prodId,distId);
		return new JsonResult<Map<String, Object>>(distribution);
	}
	
	/**
	 * 库存分销：修改产品分销商信息
	 */
	@RequestMapping("/updateProductDistribution.do")
	@ResponseBody
	public JsonResult<Object> updateProductDistribution(ProductDistribution productDistribution,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.updateProductDistribution(productDistribution,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 点击行程设置，跳转到行程设置页面
	 */
	@RequestMapping("/showProductTourSchedualPage.do")
	public String showProductTourSchedualPage(){
		return "ttms/product/productTourSchedual";
	}
	
	/**
	 * 查询产品的晚数,用于初始化行程设置页面
	 */
	@RequestMapping("/findProductNights.do")
	@ResponseBody
	public JsonResult<Integer> findProductNights(Integer prodId){
		int nights = productService.findProductNights(prodId);
		return new JsonResult<Integer>(nights);
	}
	
	/**
	 * 保存产品日程安排
	 */
	@RequestMapping("/saveProductTourSchedual.do")
	@ResponseBody
	public JsonResult<Object> saveProductTourSchedual(ProductTourSchedual schedual,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.saveProductTourSchedual(schedual,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 修改产品日程安排
	 */
	@RequestMapping("/updateSchedual.do")
	@ResponseBody
	public JsonResult<Object> updateSchedual(ProductTourSchedual schedual,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.updateSchedual(schedual,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 查询指定天数的日程
	 */
	@RequestMapping("/findDayNumberSchedual.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findDayNumberSchedual(Integer prodId,Integer dayNumber){
		Map<String, Object> schedual = productService.findDayNumberSchedual(prodId,dayNumber);
		return new JsonResult<Map<String,Object>>(schedual);
	}
	
	/**
	 * 产品列表点击导游信息，跳转到产品导游页面
	 */
	@RequestMapping("/showProductGuidesPage.do")
	public String showProductGuidesPage(){
		return "ttms/product/productGuides";
	}
	
	/**
	 * 查询指定产品下的所有导游信息
	 */
	@RequestMapping("/findGuidesListByProdId.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> findGuidesListByProdId(Integer prodId){
		List<Map<String, Object>> guidesList = productService.findGuidesListByProdId(prodId);
		return new JsonResult<List<Map<String, Object>>>(guidesList);
	}
	
	/**
	 * 产品添加导游，弹出模态框用于全部显示可选导游信息
	 */
	@RequestMapping("/showProductGuidesDialog.do")
	public String showProductGuidesDialog(){
		return "ttms/product/guidesList";
	}
	
	/**
	 * 查询所有导游信息
	 */
	@RequestMapping("/findGuides.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findGuides(GuidesInfo guidesInfo,PageObject pageObj){
		Map<String, Object> map= productService.findGuides(guidesInfo,pageObj);
		return new JsonResult<Map<String, Object>>(map);
	}
	
	/**
	 * 保存产品选择的导游
	 */
	@RequestMapping("/saveProductGuides.do")
	@ResponseBody
	public JsonResult<Object> saveProductGuides(Integer prodId,String guidesIds,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.saveProductGuides(prodId,guidesIds,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 解除产品导游关系
	 */
	@RequestMapping("/deleteProductGuide.do")
	@ResponseBody
	public JsonResult<Object> deleteProductGuide(Integer prodId,Integer guideId){
		productService.deleteProductGuide(prodId,guideId);
		return new JsonResult<Object>();
	}
	
	/**
	 * 跳转到产品的附件页面
	 */
	@RequestMapping("/showProductAttachmentsPage.do")
	public String showProductAttachmentsPage(){
		return "ttms/product/productAttachments";
	}
	
	/**
	 * 查询产品的附件列表
	 */
	@RequestMapping("/findAttachmentsListByProdId.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> findAttachmentsListByProdId(Integer prodId){
		List<Map<String, Object>> list = productService.findAttachmentsListByProdId(prodId);
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 附件上传
	 */
	@RequestMapping("/upload.do")
	@ResponseBody
	public JsonResult<Object> upload(Attachement attachement,MultipartFile prodFile,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.upload(attachement,prodFile,userName,session);
		return new JsonResult<Object>();
	}
	
	/**
	 * 附件启用禁用切换
	 */
	@RequestMapping("/changeAttachmentState.do")
	@ResponseBody
	public JsonResult<Object> changeAttachmentState(Integer attachmentId,Integer state,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.changeAttachmentState(attachmentId,state,userName);
		return new JsonResult<Object>();
	}
	
	@ExceptionHandler(DownLoadException.class)
	public String handerDownException(DownLoadException e,HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("errMessage", "下载失败！");
		return "ttms/product/downLoadError";
	}
	
	/**
	 * 附件下载
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping("/downLoadFileByFileId.do")
	public void downLoadFileByFileId(Integer attachmentId,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = productService.findFilePathById(attachmentId);
		
		String filePath = (String) map.get("filePath");
		String fileName = (String) map.get("fileName");
		String basePath = request.getServletContext().getRealPath("/");
		File file = new File(basePath,filePath);
		FileInputStream fis = null;
		OutputStream os = null;
		
		if(!file.exists())throw new DownLoadException("file not found");
		try {
				fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
				response.setContentType("appliction/octet-stream");
				response.setHeader("Content-disposition","attachment;filename="+fileName);
				fis = new FileInputStream(file);
				os = response.getOutputStream();
				
				byte[] bys = new byte[1024];
				int len = 0;
				while((len=fis.read(bys))>0){
					os.write(bys, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new UploadException(e.getMessage());
			} finally {
				if(os!=null)try {os.close();} catch (IOException e) {e.printStackTrace();}
				
				if(fis!=null)try {fis.close();} catch (IOException e) {e.printStackTrace();}
				
			}
	}
	
	/**
	 * 跳转到产品价格政策页面
	 */
	@RequestMapping("/showProductPricePoliciesPage.do")
	public String showProductPricePoliciesPage(){
		return "ttms/product/productPricePolicies";
	}
	
	/**
	 * 跳转到添加产品价格政策页面
	 */
	@RequestMapping("/showAddPricePoliceDialog.do")
	public String showAddPricePoliceDialog(){
		return "ttms/product/pricePoliciesList";
	}
	
	/**
	 * 查找产品的价格政策
	 */
	@RequestMapping("/findProductPricePoliciesList.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findProductPricePoliciesList(Integer prodId,PricePolice pricePolice,PageObject pageObj){
		Map<String, Object> map = productService.findProductPricePoliciesList(prodId,pricePolice,pageObj);
		return new JsonResult<Map<String,Object>>(map);
	}
	
	/**
	 * 保存产品的价格政策
	 */
	@RequestMapping("/saveProductPricePolicies.do")
	@ResponseBody
	public JsonResult<Object> saveProductPricePolicies(Integer prodId,String pricePolicyIds,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.saveProductPricePolicies(prodId,pricePolicyIds,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 获取产品价格政策列表
	 */
	@RequestMapping("/findPricePoliciesByProdId.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> findProductPricePolicies(Integer prodId){
		List<Map<String, Object>> list = productService.findPricePoliciesByProdId(prodId);
		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	/**
	 * 解除产品和价格政策关系
	 */
	@RequestMapping("/deleteProductPricPolicy.do")
	@ResponseBody
	public JsonResult<Object> deleteProductPricPolicy(Integer prodId,Integer pricePolicyId){
		productService.deleteProductPricePolicy(prodId,pricePolicyId);
		return new JsonResult<Object>();
	}
	
	/**
	 * 跳转到产品分类页面
	 */
	@RequestMapping("/categoryList.do")
	public String categoryList(){
		return "ttms/product/productCategory";
	}
	
	/**
	 * 保存产品分类信息
	 */
	@RequestMapping("/saveProductClass.do")
	@ResponseBody
	public JsonResult<Object> saveProductClass(ProductClass productClass,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.saveProductClass(productClass,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 根据id查询分类信息，用于编辑修改分类信息
	 */
	@RequestMapping("/findClassInfoById.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findClassInfoById(Integer classId){
		Map<String, Object> map = productService.findClassInfoById(classId);
		return new JsonResult<Map<String, Object>>(map);
	}
	
	/**
	 * 修改分类信息
	 */
	@RequestMapping("/updateProductClass.do")
	@ResponseBody
	public JsonResult<Object> updateProductClass(ProductClass productClass,HttpSession session){
		String userName = getCurrentUser(session).getUserName();
		productService.updateProductClass(productClass,userName);
		return new JsonResult<Object>();
	}
	
	/**
	 * 判断要删除的分类下是否有产品
	 */
	@RequestMapping("/hasProduct.do")
	@ResponseBody
	public JsonResult<String> hasProduct(String classLevel,Integer classId){
		String message = productService.hasProduct(classLevel,classId);
		return new JsonResult<String>(message);
	}
	/**
	 * 删除产品分类
	 */
	@RequestMapping("/deleteClasses.do")
	@ResponseBody
	public JsonResult<Object> deleteClasses(String classLevel,Integer classId){
		productService.deleteClasses(classLevel,classId);
		return new JsonResult<Object>();
	}
	
	/**
	 * 点击产品名称，跳转到产品详情页面
	 */
	@RequestMapping("/showViewProductInfoPage.do")
	public String showViewProductInfoPage(){
		return "ttms/product/productDetail";
	}
	
	/**
	 * 查看产品详情 - 基本信息
	 */
	@RequestMapping("/findProductBasicInfo.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findProductBasicInfo(Integer prodId){
		Map<String, Object> map = productService.findProductBasicInfo(prodId);
		return new JsonResult<Map<String, Object>>(map);
	}
	
	/**
	 * 查看产品详情 - 旅游详细信息
	 */
	@RequestMapping("/findProductDetailInfo.do")
	@ResponseBody
	public JsonResult<Map<String, Object>> findProductDetailInfo(Integer prodId){
		Map<String, Object> map = productService.findProductDetailInfo(prodId);
		return new JsonResult<Map<String, Object>>(map);
	}
}
