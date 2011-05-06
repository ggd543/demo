package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.delivery.cod.send request
 * 
 * @author auto create
 * @since 1.0, 2010-09-14 14:37:31.0
 */
public class DeliveryCodSendRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 物流公司代码.如"POST"就代表中国邮政,"ZJS"就代表宅急送.调用 taobao.logisticcompanies.get  获取.
	 **/
	private String companyCode;
	
	/** 
	 * 物流公司取货地址.XXX街道XXX门牌,省市区不需要提供.目的在于让物流公司能清楚的知道在哪取货。
	 **/
	private String fetcherAddress;
	
	/** 
	 * 取货地国家公布的标准地区码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm  或者调用 taobao.areas.get 获取
	 **/
	private String fetcherAreaId;
	
	/** 
	 * 取货地手机号码
	 **/
	private String fetcherMobile;
	
	/** 
	 * 联系人名称
	 **/
	private String fetcherName;
	
	/** 
	 * 取货地固定电话.包含区号,电话,分机号,中间用 " – "; 取货地固定电话和取货地手机号码,必须填写一个.
	 **/
	private String fetcherPhone;
	
	/** 
	 * 取货地邮编
	 **/
	private String fetcherZip;
	
	/** 
	 * 发货类型.cod(货到付款)
	 **/
	private String orderType;
	
	/** 
	 * 运单号.具体一个物流公司的真实运单号码。淘宝官方物流会校验，请谨慎传入；若company_code中传入的代码非淘宝官方物流合作公司，此处运单号不校验。
	 **/
	private String outSid;
	
	/** 
	 * 卖家地址(详细地址).如:XXX街道XXX门牌,省市区不需要提供.
	 **/
	private String sellerAddress;
	
	/** 
	 * 卖家所在地国家公布的标准地区码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm  或者调用 taobao.areas.get 获取
	 **/
	private String sellerAreaId;
	
	/** 
	 * 卖家手机号码
	 **/
	private String sellerMobile;
	
	/** 
	 * 卖家姓名
	 **/
	private String sellerName;
	
	/** 
	 * 卖家固定电话.包含区号,电话,分机号,中间用 " – "; 卖家固定电话和卖家手机号码,必须填写一个.
	 **/
	private String sellerPhone;
	
	/** 
	 * 卖家邮编
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
	public void setFetcherAddress(String fetcherAddress) {
		this.fetcherAddress = fetcherAddress;
	}
	 public String getFetcherAddress() {
		return this.fetcherAddress;
	}
	public void setFetcherAreaId(String fetcherAreaId) {
		this.fetcherAreaId = fetcherAreaId;
	}
	 public String getFetcherAreaId() {
		return this.fetcherAreaId;
	}
	public void setFetcherMobile(String fetcherMobile) {
		this.fetcherMobile = fetcherMobile;
	}
	 public String getFetcherMobile() {
		return this.fetcherMobile;
	}
	public void setFetcherName(String fetcherName) {
		this.fetcherName = fetcherName;
	}
	 public String getFetcherName() {
		return this.fetcherName;
	}
	public void setFetcherPhone(String fetcherPhone) {
		this.fetcherPhone = fetcherPhone;
	}
	 public String getFetcherPhone() {
		return this.fetcherPhone;
	}
	public void setFetcherZip(String fetcherZip) {
		this.fetcherZip = fetcherZip;
	}
	 public String getFetcherZip() {
		return this.fetcherZip;
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
		return "taobao.delivery.cod.send";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("company_code", this.companyCode);
		textParams.put("fetcher_address", this.fetcherAddress);
		textParams.put("fetcher_area_id", this.fetcherAreaId);
		textParams.put("fetcher_mobile", this.fetcherMobile);
		textParams.put("fetcher_name", this.fetcherName);
		textParams.put("fetcher_phone", this.fetcherPhone);
		textParams.put("fetcher_zip", this.fetcherZip);
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
