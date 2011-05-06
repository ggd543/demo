package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.topats.delivery.send request
 * 
 * @author auto create
 * @since 1.0, 2010-11-24 15:45:07.0
 */
public class TopatsDeliverySendRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 每个tid所对应的物流公司代码。可以不传，表示所有的物流公司都为"其他"，但是只要有一个订单需要指定物流公司，所有的订单都需要指定物流公司,每个类型之间用";"连接。排列要和tid顺序一致，不需要指定物流公司的订单，该位置上放上一个空字符串""。可以不传，传了长度和位置要和tid保持一致。

每个company_code表示物流公司代码.如"POST"就代表中国邮政,"ZJS"就代表宅急送.调用 taobao.logisticcompanies.get 获取。如传入的代码非淘宝官方物流合作公司，默认是“其他”物流的方式，在淘宝不显示物流具体进度，故传入需谨慎。如果orderType为delivery_needed，则必传
	 **/
	private String companyCodes;
	
	/** 
	 * 每个tid所对应的卖家备注。可以不传，表示所有的发货订单都不需要卖家备注，但是只要有一个订单需要指定卖家备注，所有的订单都需要指定卖家备注,每个卖家备注之间用";"连接。排列要和tid顺序一致，不需要指定卖家备注的订单，该位置上放上一个空字符串""。可以不传，传了长度和位置要和tid保持一致。卖家备注.最大长度为250个字符。如果orderType为delivery_needed，则必传
	 **/
	private String memos;
	
	/** 
	 * 每个tid所对应的物流发货类型。可以不传，表示所有的发货类型都为"delivery_needed"，但是只要有一个订单需要指定发货类型，所有的订单都需要指定发货类型,每个类型之间用";"连接。排列要和tid顺序一致，不需要指定发货类型的订单，该位置上放上一个空字符串""。可以不传，传了长度和位置要和tid保持一致。 每个类型可选( delivery_needed(物流订单发货),virtual_goods(虚拟物品发货). ) 注:选择virtual_goods类型进行发货的话下面的参数可以不需填写。如果选择delivery_needed 则下面的参数必须要填写
	 **/
	private String orderTypes;
	
	/** 
	 * 每个tid所对应的物流公司运单号。可以不传，表示所有的物流订单都没有订单号，但是只要有一个订单需要有订单号，所有的订单都需要指定订单号,每个订单号之间用";"连接。排列要和tid顺序一致，不需要指定订单号的订单，该位置上放上一个空字符串""。可以不传，传了长度和位置要和tid保持一致。
具体一个物流公司的真实运单号码。淘宝官方物流会校验，请谨慎传入；若company_codes中传入的代码非淘宝官方物流合作公司，此处运单号不校验。如果orderType为delivery_needed，则必传
	 **/
	private String outSids;
	
	/** 
	 * 卖家地址(详细地址).如:XXX街道XXX门牌,省市区不需要提供。如果orderType为delivery_needed，则必传
	 **/
	private String sellerAddress;
	
	/** 
	 * 卖家所在地国家公布的标准地区码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm 或者调用 taobao.areas.get 获取。如果orderType为delivery_needed，则必传
	 **/
	private Long sellerAreaId;
	
	/** 
	 * 卖家手机号码
	 **/
	private String sellerMobile;
	
	/** 
	 * 卖家姓名。如果orderType为delivery_needed，则必传
	 **/
	private String sellerName;
	
	/** 
	 * 卖家固定电话.包含区号,电话,分机号,中间用 " – "; 卖家固定电话和卖家手机号码,必须填写一个.
	 **/
	private String sellerPhone;
	
	/** 
	 * 卖家邮编。如果orderType为delivery_needed，则必传
	 **/
	private String sellerZip;
	
	/** 
	 * 批量发货的订单id列表，每个订单id必需是合法的数字类型的tid，每个tid之间以";"分隔，至少要指定一个tid，最多不超过40个tid
	 **/
	private String tids;

	public void setCompanyCodes(String companyCodes) {
		this.companyCodes = companyCodes;
	}
	 public String getCompanyCodes() {
		return this.companyCodes;
	}
	public void setMemos(String memos) {
		this.memos = memos;
	}
	 public String getMemos() {
		return this.memos;
	}
	public void setOrderTypes(String orderTypes) {
		this.orderTypes = orderTypes;
	}
	 public String getOrderTypes() {
		return this.orderTypes;
	}
	public void setOutSids(String outSids) {
		this.outSids = outSids;
	}
	 public String getOutSids() {
		return this.outSids;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	 public String getSellerAddress() {
		return this.sellerAddress;
	}
	public void setSellerAreaId(Long sellerAreaId) {
		this.sellerAreaId = sellerAreaId;
	}
	 public Long getSellerAreaId() {
		return this.sellerAreaId;
	}
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	 public String getSellerMobile() {
		return this.sellerMobile;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	 public String getSellerName() {
		return this.sellerName;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	 public String getSellerPhone() {
		return this.sellerPhone;
	}
	public void setSellerZip(String sellerZip) {
		this.sellerZip = sellerZip;
	}
	 public String getSellerZip() {
		return this.sellerZip;
	}
	public void setTids(String tids) {
		this.tids = tids;
	}
	 public String getTids() {
		return this.tids;
	}
	
	public String getApiMethodName() {
		return "taobao.topats.delivery.send";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("company_codes", this.companyCodes);
		textParams.put("memos", this.memos);
		textParams.put("order_types", this.orderTypes);
		textParams.put("out_sids", this.outSids);
		textParams.put("seller_address", this.sellerAddress);
		textParams.put("seller_area_id", this.sellerAreaId);
		textParams.put("seller_mobile", this.sellerMobile);
		textParams.put("seller_name", this.sellerName);
		textParams.put("seller_phone", this.sellerPhone);
		textParams.put("seller_zip", this.sellerZip);
		textParams.put("tids", this.tids);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
