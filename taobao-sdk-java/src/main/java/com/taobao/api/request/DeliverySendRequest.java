package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.delivery.send request
 * 
 * @author auto create
 * @since 1.0, 2010-11-11 19:49:44.0
 */
public class DeliverySendRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 物流公司代码.如"POST"就代表中国邮政,"ZJS"就代表宅急送.调用 taobao.logistics.companies.get 获取。如传入的代码非淘宝官方物流合作公司，默认是“其他”物流的方式，在淘宝不显示物流具体进度，故传入需谨慎。如果orderType为delivery_needed，则必传
	 **/
	private String companyCode;
	
	/** 
	 * 返回的字段
	 **/
	private String fields;
	
	/** 
	 * 卖家备注.最大长度为250个字符。如果orderType为delivery_needed，则必传
	 **/
	private String memo;
	
	/** 
	 * 发货类型. 可选( delivery_needed(物流订单发货),virtual_goods(虚拟物品发货). ) 注:选择virtual_goods类型进行发货的话下面的参数可以不需填写。如果选择delivery_needed 则company_code,out_sid,seller_name,seller_area_id,seller_address,seller_zip,seller_phone,seller_mobile,memo必须要填写
	 **/
	private String orderType;
	
	/** 
	 * 运单号.具体一个物流公司的真实运单号码。淘宝官方物流会校验，请谨慎传入；若company_code中传入的代码非淘宝官方物流合作公司，此处运单号不校验。如果orderType为delivery_needed，则必传
	 **/
	private String outSid;
	
	/** 
	 * 卖家地址(详细地址).如:XXX街道XXX门牌,省市区不需要提供。如果orderType为delivery_needed，则必传
	 **/
	private String sellerAddress;
	
	/** 
	 * 卖家所在地国家公布的标准地区码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm  或者调用 taobao.areas.get 获取。如果orderType为delivery_needed，则必传
	 **/
	private String sellerAreaId;
	
	/** 
	 * 卖家手机号码，必须由8到16位数字构成
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
	 * 交易ID
	 **/
	private Long tid;

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	 public String getCompanyCode() {
		return this.companyCode;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	 public String getOrderType() {
		return this.orderType;
	}
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}
	 public String getOutSid() {
		return this.outSid;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	 public String getSellerAddress() {
		return this.sellerAddress;
	}
	public void setSellerAreaId(String sellerAreaId) {
		this.sellerAreaId = sellerAreaId;
	}
	 public String getSellerAreaId() {
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
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.delivery.send";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("company_code", this.companyCode);
		textParams.put("fields", this.fields);
		textParams.put("memo", this.memo);
		textParams.put("order_type", this.orderType);
		textParams.put("out_sid", this.outSid);
		textParams.put("seller_address", this.sellerAddress);
		textParams.put("seller_area_id", this.sellerAreaId);
		textParams.put("seller_mobile", this.sellerMobile);
		textParams.put("seller_name", this.sellerName);
		textParams.put("seller_phone", this.sellerPhone);
		textParams.put("seller_zip", this.sellerZip);
		textParams.put("tid", this.tid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
