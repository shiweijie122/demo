package cn.tedu.ttms.product.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachment.entity.Attachement;
import cn.tedu.ttms.attachment.mapper.AttachmentsMapper;
import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.base.exception.DeleteException;
import cn.tedu.ttms.base.exception.QueryException;
import cn.tedu.ttms.base.exception.SaveException;
import cn.tedu.ttms.base.exception.UpdateException;
import cn.tedu.ttms.base.exception.UploadException;
import cn.tedu.ttms.common.Constants;
import cn.tedu.ttms.guide.entity.GuidesInfo;
import cn.tedu.ttms.guide.mapper.GuidesInfoMapper;
import cn.tedu.ttms.pricepolice.entity.PricePolice;
import cn.tedu.ttms.pricepolice.mapper.PricePoliciesMapper;
import cn.tedu.ttms.product.entity.ProductClass;
import cn.tedu.ttms.product.entity.ProductDistribution;
import cn.tedu.ttms.product.entity.ProductGuidesInfo;
import cn.tedu.ttms.product.entity.ProductInfo;
import cn.tedu.ttms.product.entity.ProductPricePolicy;
import cn.tedu.ttms.product.entity.ProductTourSchedual;
import cn.tedu.ttms.product.mapper.ProductClassMapper;
import cn.tedu.ttms.product.mapper.ProductDistributionMapper;
import cn.tedu.ttms.product.mapper.ProductGuidesMapper;
import cn.tedu.ttms.product.mapper.ProductInfoMapper;
import cn.tedu.ttms.product.mapper.ProductPricePoliciesMapper;
import cn.tedu.ttms.product.mapper.ProductTourSchedualMapper;
import cn.tedu.ttms.product.service.ProductClassNotFoundException;
import cn.tedu.ttms.product.service.ProductService;
import cn.tedu.ttms.project.mapper.ProjectMapper;
import cn.tedu.ttms.team.mapper.TeamMapper;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProjectMapper projectMapper; 
	
	@Resource
	private ProductClassMapper productClassMapper;
	
	@Resource
	private TeamMapper teamMapper;
	 
	@Resource
	private ProductInfoMapper productInfoMapper;
	
	@Resource
	private ProductDistributionMapper productDistributionMapper ;
	
	@Resource
	private ProductTourSchedualMapper productTourSchedualMapper;
	
	@Resource
	private ProductGuidesMapper productGuidesMapper;
	
	@Resource
	private GuidesInfoMapper guidesInfoMapper;
	
	@Resource
	private AttachmentsMapper attachmentsMapper;
	
	@Resource
	private PricePoliciesMapper pricePoliciesMapper;
	
	@Resource
	private ProductPricePoliciesMapper productPricePoliciesMapper;
	
	
//	
//	public List<Map<String, Object>> getProjectList() {
//		return projectMapper.findAllProjects();
//	}

	
	public List<Map<String, Object>> findAllClass1() {
		return productClassMapper.findAllClass1();
	}

	
	public List<Map<String, Object>> findAllClass2ByClass1(Integer c1Id) {
		if(c1Id == null){
			throw new ProductClassNotFoundException("id is null!");
		}
		
		return productClassMapper.findAllClass2ByClass1(c1Id);
	}
	
	
	public List<Map<String, Object>> findAllClass3ByClass2(Integer c2Id) {
		if(c2Id == null){
			throw new ProductClassNotFoundException("id is null!");
		}
		
		return productClassMapper.findAllClass3ByClass2(c2Id);
	}
	
	
	public List<Map<String, Object>> getProductNumbers() {
		return teamMapper.findAllProductNumbers();
	}
	
	
	public List<Map<String, Object>> getProductManagers() {
		return productInfoMapper.findProjectManagers();
	}

//	
//	public List<Map<String, Object>> getGroups() {
//		return userGroupMapper.findGroupsLevel2();
//	}

	//创建产品信息
	
	public void save(ProductInfo productInfo,String userName){
		if(productInfo==null){
			throw new SaveException("保存的产品信息不能为空！");
		}
		if(userName==null){
			throw new QueryException("当前用户信息获取失败！");
		}
		productInfo.setCreatedUser(userName);
		productInfo.setModifiedUser(userName);
		
		//根据产品所属得团号找到项目编号，在项目编号后+00*,如果多个产品属于同一项目，那么在项目编号后的00*依次递增
		String prjId = teamMapper.findProductPrjId(productInfo.getNumId());
		String maxNumber = productInfoMapper.findMaxProductIdContainsPrjId(prjId);
		int maxNum = 0;
		if(maxNumber!=null){
			maxNum = Integer.parseInt(maxNumber);
		}
		
		DecimalFormat decimalFormat = new DecimalFormat("000");
		String prodId = prjId+"-"+decimalFormat.format(maxNum+1);
		productInfo.setProdId(prodId);
		
		//向product_info插入数据
		int i = productInfoMapper.saveProductInfo(productInfo);
		if(i!=1){
			throw new SaveException("创建产品失败！");
		}
	}


	

	
	public Map<String, Object> findProductInfos(ProductInfo productInfo,String prjName,String classIds,PageObject pageObj){
		pageObj.setStartIndex(pageObj.getStartIndex());
		List<Map<String, Object>> list = null;
		List<Integer> numIds = null;
		//查询指定项目下的所有团号
		if(prjName!=null && prjName!=""){
			//根据项目名称查询项目下的所有团id
			numIds = teamMapper.findNumIdsByPrjName(prjName);
		}
		
		List<Integer> classIdList = new ArrayList<Integer>();;
		//根据classIds查询要查询的所有三级分类
		if(classIds!=null && classIds!=""){
			String[] levels = classIds.split("-");
			if("one".equals(levels[0])){   //查询条件截止到一级分类
				classIdList = productClassMapper.findClass3IdsByClass1Id(Integer.parseInt(levels[1]));
			}
			if("two".equals(levels[0])){  //查询条件截止到二级分类
				classIdList = productClassMapper.findClass3IdsByClass2Id(Integer.parseInt(levels[1]));
			}
			if("three".equals(levels[0])){   //查询条件截止到三级分类
				classIdList.add(Integer.parseInt(levels[1]));
			}
		}
		
		list = productInfoMapper.findProductInfos(productInfo,numIds,classIdList,pageObj);
		
		for(Map<String, Object> obj:list){
			//产品类别  一级分类-二级分类-三级分类
			String class3Name = productClassMapper.findClass3Name((Integer)obj.get("classId"));
			Map<String, Object> class2Map = productClassMapper.findClass2NameById((Integer)obj.get("classId"));
			Map<String, Object> c1Message = productClassMapper.findClass1NameById((Integer)class2Map.get("id"));
			String class1Name = (String) c1Message.get("className");
			
			String category = class1Name+"-"+class2Map.get("className")+"-"+class3Name;
			obj.put("category",category);
			
			//查询产品所属项目名称
			String projName = teamMapper.findPrjNameByNumId((Integer)obj.get("numId"));
			obj.put("prjName", projName);
		}
		
		
		pageObj.setRowCount(getRowCounts(productInfo));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pageObj", pageObj);
		
		return map;
	}

	private int getRowCounts(ProductInfo productInfo) {
		return productInfoMapper.getRowCounts(productInfo);
	}

	
	public void updateState(Integer state, String selectedIds){
		if(selectedIds==null){
			throw new UpdateException("请选择修改项！");
		}
		if(state==null){
			throw new UpdateException("修改的状态值不能为空！");
		}
		String[] ids = selectedIds.split(",");
		for(String prodId:ids){
			int i = productInfoMapper.updateState(state,prodId);
			if(i!=1){
				throw new UpdateException("产品编号为"+prodId+"的数据修改状态失败！");
			}
		}
	}

	
	public Map<String, Object> findProdInfoById(Integer prodId){
		if(prodId==null){
			throw new NullPointerException("查询的产品id值为空！");
		}
		Map<String, Object> map = productInfoMapper.findProdInfoById(prodId);
		if(map==null){
			throw new QueryException("查询产品信息失败！");
		}
		//根据c3Id查询出c2Id
		Map<String, Object> c2Message = productClassMapper.findClass2NameById((Integer)map.get("c3Id"));
		map.put("c2Id", c2Message.get("id"));
		
		//根据C2Id查询C1id
		Map<String, Object> c1Message = productClassMapper.findClass1NameById((Integer)c2Message.get("id"));
		map.put("c1Id", c1Message.get("id"));
		
		return map;
	}

	
	public void updateProdInfo(ProductInfo productInfo, String userName){
		if(productInfo==null){
			throw new UpdateException("更新的产品信息不能为空！");
		}
		
		productInfo.setModifiedUser(userName);
		
		int i = productInfoMapper.updateProdInfo(productInfo);
		if(i!=1){
			throw new UpdateException("修改产品信息失败！");
		}
	}


	
	public Map<String, Object> viewProdInfoById(Integer prodId){
		if(prodId==null){
			throw new QueryException("产品id值不能为空！");
		}
		Map<String, Object> prodInfo = productInfoMapper.viewProdInfoById(prodId);
		if(prodInfo==null){
			throw new QueryException("库存分销查询产品信息失败！");
		}
		return prodInfo;
	}

	
	public List<Map<String, Object>> findDistListByProdId(Integer prodId){
		if(prodId==null){
			throw new QueryException("查询库存分销的产品id不能为空！");
		}
		List<Map<String, Object>> productDistList =  productDistributionMapper.findDistListByProdId(prodId);
		if(productDistList==null){
			throw new QueryException("查询产品库存分销列表失败!");
		}
		return productDistList;
	}

	
	public List<Map<String, Object>> findDistributionInfos() {
		List<Map<String, Object>> list = productDistributionMapper.findDistributionInfos();
		if(list==null){
			throw new QueryException("库存分销：查询分销商下拉列表失败！");
		}
		return list;
	}

	
	public void saveProductDistribution(ProductDistribution distribution, String userName) {
		if(distribution==null){
			throw new NullPointerException("保存的分销商不能为空！");
		}
		if(userName==null){
			throw new QueryException("查询当前用户信息失败！");
		}
		//获取分销商类型：是分销商还是渠道商
		int type = productDistributionMapper.findDistributionTypeById(distribution.getDistId());
		int distType = 0;
		if(type==2){   //分销商
			distType = 0;   
		}
		if(type==3){   //渠道商
			distType = 1;
		}
		distribution.setDistType(distType);
		distribution.setCreatedUser(userName);
		distribution.setModifiedUser(userName);
		
		int i = productDistributionMapper.saveProductDistribution(distribution);
		if(i!=1){
			throw new SaveException("添加产品分销商失败！");
		}
	}

	
	public Map<String, Object> findProductDistribution(Integer prodId, Integer distId) {
		if(prodId==null){
			throw new NullPointerException("修改产品分销商产品编号不能为空！");
		}
		if(distId==null){
			throw new NullPointerException("修改产品分销商分销商编号不能为空！");
		}
		Map<String, Object> distribution = productDistributionMapper.findProductDistribution(prodId,distId);
		if(distribution==null){
			throw new QueryException("查询产品分销商失败！");
		}
		return distribution;
	}

	
	public void updateProductDistribution(ProductDistribution productDistribution, String userName) {
		if(productDistribution==null){
			throw new NullPointerException("修改产品分销商信息不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		productDistribution.setModifiedUser(userName);
		int i = productDistributionMapper.updateProductDistribution(productDistribution);
		
		if(i!=1){
			throw new UpdateException("更新产品分销商信息失败！");
		}
	}

	
	public void deleteProductDist(Integer prodId, Integer distId) {
		if(prodId==null){
			throw new NullPointerException("产品分销商的产品编号不能为空！");
		}
		if(distId==null){
			throw new NullPointerException("产品分销商的分销商id不能为空！");
		}
		int i = productDistributionMapper.deleteProductDist(prodId,distId);
		if(i!=1){
			throw new DeleteException("删除产品分销商失败！");
		}
	}

	
	public int findProductNights(Integer prodId) {
		if(prodId==null){
			throw new NullPointerException("查询产品行程设置产品编号不能为空！");
		}
		int nights = productInfoMapper.findProductNights(prodId);
		
		if(nights==0){
			throw new QueryException("初始化行程设置失败！");
		}
		
		return nights;
	}

	
	public void saveProductTourSchedual(ProductTourSchedual schedual,String userName) {
		if(schedual==null){
			throw new NullPointerException("保存的产品日程不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		schedual.setCreatedUser(userName);
		schedual.setModifiedUser(userName);
		int i = productTourSchedualMapper.saveProductTourSchedual(schedual);
		
		if(i!=1){
			throw new SaveException("保存日程失败！");
		}
	}


	
	public Map<String, Object> findDayNumberSchedual(Integer prodId, Integer dayNumber) {
		if(prodId==null){
			throw new NullPointerException("查询产品指定天数日程产品编号不能为空!");
		}
		if(dayNumber==null){
			throw new NullPointerException("查询日程的指定天数不能为空！");
		}
		
		//检查指定天数是否有日程内容
		boolean flag = isExistDaySchedual(prodId,dayNumber);
		Map<String, Object> schedual;
		if(flag){
			schedual = productTourSchedualMapper.findDayNumberSchedual(prodId,dayNumber);
		}else{
			schedual = null;
		}
		return schedual;
	}

	private boolean isExistDaySchedual(Integer prodId, int dayNumber) {
		boolean flag = false;
		Integer id = productTourSchedualMapper.isExistDaySchedual(prodId,dayNumber);
		if(id!=null){
			flag = true;   //数据库中已经存在这一天的日程内容
		}
		return flag;
	}

	
	public void updateSchedual(ProductTourSchedual schedual, String userName) {
		if(schedual==null){
			throw new NullPointerException("修改的产品日程不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		schedual.setModifiedUser(userName);
		productTourSchedualMapper.updateSchedual(schedual);
	}

	
	public List<Map<String, Object>> findGuidesListByProdId(Integer prodId) {
		if(prodId==null){
			throw new NullPointerException("查询产品导游列表的产品id不能为空！");
		}
		List<Map<String, Object>> guidesList = productGuidesMapper.findGuidesListByProdId(prodId);
		
		return guidesList;
	}

	
	public Map<String, Object> findGuides(GuidesInfo guidesInfo, PageObject pageObj) {
		pageObj.setStartIndex(pageObj.getStartIndex());
		List<Map<String, Object>> guidesList = guidesInfoMapper.findGuides(guidesInfo,pageObj);
		pageObj.setRowCount(getGuidesRowCounts(guidesInfo));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("guidesList", guidesList);
		map.put("pageObj", pageObj);
		return map;
	}

	private int getGuidesRowCounts(GuidesInfo guidesInfo) {
		return guidesInfoMapper.getGuidesRowCounts(guidesInfo);
	}

	
	public void saveProductGuides(Integer prodId, String guidesIds,String userName) {
		if(prodId==null){
			throw new NullPointerException("保存产品的导游信息产品id不能为空！");
		}
		if(guidesIds==null || "".equals(guidesIds)){
			throw new NullPointerException("保存产品的导游信息导游id不能为空！");
		}
		if(userName==null){
			throw new QueryException("当前用户信息获取失败！"); 
		}
		String[] ids = guidesIds.split(",");
		int i = 0;
		for(String id:ids){
			int guideId = Integer.parseInt(id);
			//查看指定产品下该导游是否已经存在
			int count = productGuidesMapper.isExist(prodId,guideId);
			if(count!=0){
				throw new SaveException("该导游已经被该产品指定！");
			}
			
			//保存产品导游信息
			ProductGuidesInfo productGuidesInfo = new ProductGuidesInfo();
			productGuidesInfo.setProdId(prodId);
			productGuidesInfo.setGuideId(guideId);
			productGuidesInfo.setCreatedUser(userName);
			productGuidesInfo.setModifiedUser(userName);
			
			i+=productGuidesMapper.saveProductGuides(productGuidesInfo);
		}
		if(i<1){
			throw new SaveException("保存产品导游信息失败！");
		}
	}

	
	public void deleteProductGuide(Integer prodId, Integer guideId) {
		if(prodId==null){
			throw new NullPointerException("删除指定产品的导游信息，产品id不能为空！");
		}
		if(guideId==null){
			throw new NullPointerException("删除指定产品的导游信息，导游id不能为空！");
		}
		int i = productGuidesMapper.deleteProductGuide(prodId,guideId);
		
		if(i!=1){
			throw new DeleteException("删除产品的指定导游失败！");
		}
	}

	
	public List<Map<String, Object>> findAttachmentsListByProdId(Integer prodId) {
		if(prodId==null){
			throw new NullPointerException("查询产品附件列表，产品id不能为空！");
		}
		List<Map<String, Object>> attachmentsList = attachmentsMapper.findAttachmentsListByProdId(prodId);
		return attachmentsList;
	}

	//将文件上传到服务器
	
	public void upload(Attachement attachement, MultipartFile prodFile,String userName ,HttpSession session) {
		if(prodFile==null){
			throw new NullPointerException("上传的文件不能为空！");
		}
		//获取当前项目得绝对路径
		String basePath = session.getServletContext().getRealPath("/");
		File target = new File("/uploads");
		//创建服务器上文件上传的文件夹    uploads/2017/06/16
		File destFolder = new File(target, DateFormatUtils.format(new Date(), "yyyy/MM/dd")); 
		
		//获取文件原名
		String fileOriginalName = prodFile.getOriginalFilename();
		//获取上传的文件名后缀
		String suffix = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
		//用UUID生成一个随机字符串作为上传到服务器的文件名
		String uploadFileName = UUID.randomUUID().toString()+suffix;
		//文件从uploads开始的路径（要保存到数据库的路径）
		File destFile = new File(destFolder,uploadFileName);
		//生成所有文件夹
		File fileUploadPath=new File(basePath+destFile.getPath());
		if(!fileUploadPath.getParentFile().exists()){
			fileUploadPath.getParentFile().mkdirs();
		}
		//上传文件并得到文件内容摘要
		String digest;
		DigestInputStream dis=null;
		FileOutputStream fos=null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//创建DigestInputStream对象
			dis = new DigestInputStream(prodFile.getInputStream(), md);
			//创建输入流对象
			 fos = new FileOutputStream(fileUploadPath);
			//上传文件
			byte[] bys = new byte[1024];
			int len = 0;
			while((len=dis.read(bys))>0){
				fos.write(bys, 0, len);
			}
			// 获取摘要
			byte[] md5 = md.digest();
			digest=new String(Base64.encodeBase64(md5));
		} catch (NoSuchAlgorithmException e) {
			throw new UploadException("文件上传获取摘要失败！", e);
		} catch (IOException e) {
			throw new UploadException("文件上传失败！",e);
		}finally{
			if(fos!=null)try {fos.close();} catch (Exception e) {e.printStackTrace();}
			
			if(dis!=null)try {dis.close();} catch (Exception e) {e.printStackTrace();}
			
		}
		//获取文件类型
		String contentType = prodFile.getContentType();
		//获取文件上传成功在服务器上的相对路径
		String filePath = destFile.getPath();
		//判断摘要是否已经存在 ，即判断文件是否已经上传
		int count = attachmentsMapper.isExistFile(digest,attachement.getBelongId());
		if(count!=0){
			throw new UploadException("该文件已经上传，请重新选择！");
		}
		attachement.setContentType(contentType);
		attachement.setFileName(fileOriginalName);
		attachement.setFilePath(filePath);
		attachement.setDigest(digest);
		attachement.setBelongerCategory(Constants.Attachments.BELONGERPRODUCT);
		attachement.setCreatedUser(userName);
		attachement.setModifiedUser(userName);
		
		//将上传的文件信息保存到数据库
		saveProductAttachment(attachement);
	}


	//保存附件
	private void saveProductAttachment(Attachement attachement) {
		int i = attachmentsMapper.saveProductAttachment(attachement);
		if(i!=1){
			throw new SaveException("添加产品附件失败！");
		}
	}

	
	public void changeAttachmentState(Integer attachmentId, Integer state, String userName) {
		if(attachmentId==null){
			throw new NullPointerException("切换附件禁用启用状态时附件id不能为空！");
		}
		int valid = 1;
		if(state == 0){
			valid = 1;
		}
		if(state == 1){
			valid = 0;
		}
		int i = attachmentsMapper.changeAttachmentState(attachmentId,valid,userName);
		if(i!=1){
			throw new UpdateException("修改附件启用禁用状态失败！");
		}
	}

	//查找文件在服务器上的路径
	
	public Map<String, Object> findFilePathById(Integer attachmentId) {
		if(attachmentId==null){
			throw new NullPointerException("下载文件，文件的id不能为空！");
		}
		return attachmentsMapper.findFilePathById(attachmentId);
	}

	//查找产品可用的价格政策
	
	public Map<String, Object> findProductPricePoliciesList(Integer prodId,PricePolice pricePolice,PageObject pageObj) {
		if(prodId==null){
			throw new NullPointerException("查询产品可用的价格政策，产品id不能为空！");
		}
		List<Map<String, Object>> pricePoliciesList =  pricePoliciesMapper.findProductPricePoliciesList(prodId,pricePolice,pageObj);
		pageObj.setRowCount(getPricePoliciesRowCounts(prodId,pricePolice));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pricePoliciesList", pricePoliciesList);
		map.put("pageObj", pageObj);
		return map;
	}

	private int getPricePoliciesRowCounts(Integer prodId, PricePolice pricePolice) {
		return pricePoliciesMapper.getRowCounts(prodId,pricePolice);
	}

	
	public void saveProductPricePolicies(Integer prodId, String pricePolicyIds, String userName) {
		if(prodId==null){
			throw new NullPointerException("保存产品价格政策，产品的id不能为空！");
		}
		if(pricePolicyIds==null||"".equals(pricePolicyIds)){
			throw new NullPointerException("保存产品价格政策，政策id不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		String[] ids = pricePolicyIds.split(",");
		int i = 0; 
		for(String id:ids){
			int pricePolicyId = Integer.parseInt(id);
			//判断此政策id是否已经在产品政策表中存在
			int count = productPricePoliciesMapper.isExistPricePolicy(prodId,pricePolicyId);
			if(count!=0){   //如果已经存在
				throw new SaveException("该政策已经被该产品指定！");
			}
			
			//保存产品价格政策信息
			ProductPricePolicy policy = new ProductPricePolicy();
			policy.setProdId(prodId);
			policy.setPricePolicyId(pricePolicyId);
			policy.setCreatedUser(userName);
			policy.setModifiedUser(userName);
			 
			i+=productPricePoliciesMapper.saveProductPricePolicy(policy);
		}
		if(i<1){
			throw new SaveException("保存产品价格政策失败！");
		}
	}

	
	public List<Map<String, Object>> findPricePoliciesByProdId(Integer prodId) {
		if(prodId==null){
			throw new NullPointerException("查询产品的价格政策列表，产品的id不能为空!");
		}
		List<Map<String, Object>> list = productPricePoliciesMapper.findPricePoliciesByProdId(prodId);
		return list;
	}

	
	public void deleteProductPricePolicy(Integer prodId, Integer pricePolicyId) {
		if(prodId==null){
			throw new NullPointerException("删除产品的价格政策，产品id不能为空！");
		}
		if(pricePolicyId==null){
			throw new NullPointerException("删除产品的价格政策，价格政策的id不能为空！");
		}
		int i = productPricePoliciesMapper.deleteProductPricePolicy(prodId,pricePolicyId);
		if(i!=1){
			throw new DeleteException("删除产品的价格政策失败！");
		}
	}

//	
//	public List<Map<String, Object>> findTopCategoryList() {
//		return productClassMapper.findTopCategoryList();
//	}

//	
//	public List<Map<String, Object>> findSecondCategoryList(Integer topClassId) {
//		if(topClassId==null){
//			throw new NullPointerException("查询产品二级分类，一级分类id不能为空！");
//		}
//		return productClassMapper.findSecondCategoryList(topClassId);
//	}

//	
//	public List<Map<String, Object>> findThirdCategoryList(Integer secondClassId) {
//		if(secondClassId==null){
//			throw new NullPointerException("查询产品三级分类，二级分类id不能为空！");
//		}
//		return productClassMapper.findThirdCategoryList(secondClassId);
//	}

	
	public void saveProductClass(ProductClass productClass, String userName) {
		if(productClass==null){
			throw new NullPointerException("保存产品分类，分类对象不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		productClass.setCreatedUser(userName);
		productClass.setModifiedUser(userName);
		int i = productClassMapper.saveProductClass(productClass);
		if(i!=1){
			throw new SaveException("保存产品分类失败！");
		}
	}

	
	public Map<String, Object> findClassInfoById(Integer classId) {
		if(classId==null){
			throw new NullPointerException("修改产品分类，分类id不能为空！");
		}
		Map<String, Object> map = productClassMapper.findClassInfoById(classId);
		if(map==null){
			throw new QueryException("获取产品分类信息失败！");
		}
		return map;
	}

	
	public void updateProductClass(ProductClass productClass, String userName) {
		if(productClass==null){
			throw new NullPointerException("修改产品分类信息，产品分类信息不能为空！");
		}
		if(userName==null){
			throw new NullPointerException("获取当前用户信息失败！");
		}
		productClass.setModifiedUser(userName);
		int i = productClassMapper.updateProductClass(productClass);
		if(i!=1){
			throw new UpdateException("修改产品分类失败！");
		}
	}

	
	public String hasProduct(String classLevel, Integer classId) {
		String message = "";
		List<Integer> classList = new ArrayList<Integer>();
		if("three".equals(classLevel)){   //要删除的分类是三级分类
			classList.add(classId);
		}
		if("two".equals(classLevel)){    //要删除的分类是二级分类
			classList = productClassMapper.findClass3IdsByClass2Id(classId);
		}
		if("one".equals(classLevel)){    //要删除的分类是一级分类
			classList = productClassMapper.findClass3IdsByClass1Id(classId);
		}
		if(classList.size()!=0){
			int count = productInfoMapper.hasProduct(classList);
			if(count!=0){
				message = "删除的分类下已存在产品，不能删除！";
			}
		}
		return message;
	}

	
	public void deleteClasses(String classLevel, Integer classId) {
		List<Integer> classIdList = new ArrayList<Integer>();
		if("three".equals(classLevel)){
			classIdList.add(classId);
		}
		if("two".equals(classLevel)){
			classIdList = productClassMapper.findClass3IdsByClass2Id(classId);
			classIdList.add(classId);
		}
		if("one".equals(classLevel)){
			classIdList = productClassMapper.findClass3IdsByClass1Id(classId);
			List<Integer> class2IdList = productClassMapper.findClass2IdsByClass1Id(classId);
			classIdList.addAll(class2IdList);
			classIdList.add(classId);
		}
		int i = productClassMapper.deleteClassList(classIdList);
		if(i!=classIdList.size()){
			throw new DeleteException("删除产品分类失败！");
		}
	}

	
	public Map<String, Object> findProductBasicInfo(Integer prodId) {
		if(prodId==null){
			throw new NullPointerException("查看产品详情基本信息，产品id不能为空！");
		}
		Map<String, Object> map = productInfoMapper.findProductBasicInfo(prodId);
		if(map==null){
			throw new QueryException("查询产品详情基本信息失败！");
		}
		return map;
	}

	
	public Map<String, Object> findProductDetailInfo(Integer prodId) {
		if(prodId==null){
			throw new NullPointerException("查看产品详情旅游详细，产品id不能为空！");
		}
		Map<String, Object> map = productInfoMapper.findProductDetailInfo(prodId);
		if(map==null){
			throw new QueryException("查询产品旅游详细信息失败！");
		}
		return map;
	}

}
