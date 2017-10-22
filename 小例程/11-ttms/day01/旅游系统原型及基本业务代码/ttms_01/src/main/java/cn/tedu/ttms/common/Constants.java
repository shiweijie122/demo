package cn.tedu.ttms.common;

public final class Constants {
	
	public static final Integer TRUE = 1;
	public static final Integer FALSE = 0;


	/**组织机构常量*/
	public static final class Organization{
		/**产品部*/
		public static final String PRODUCT="PROD";
		/**销售部*/
		public static final String SALE="SALE";
		//.....
	}
	
	//附件
	public static final class Attachments{
		public static final String BELONGERPRODUCT = "product";      //附件归属产品
		public static final String BELONGERSUPPLIER = "supplier";    //附件归属供应商
		public static final String BELONGERCHANNEL = "channel";      //附件归属渠道商
		public static final String BELONGERDISTRIBUTION = "distribution";      //附件归属分销商
	}
}
