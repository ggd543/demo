package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.taobaoke.shops.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-25 15:55:21.0
 */
public class TaobaokeShopsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 后台类目id
	 **/
	private Long cid;
	
	/** 
	 * 店铺商品数查询结束值
	 **/
	private String endAuctioncount;
	
	/** 
	 * 店铺佣金比例查询结束值
	 **/
	private String endCommissionrate;
	
	/** 
	 * 店铺掌柜信用等级查询结束
	 **/
	private String endCredit;
	
	/** 
	 * 店铺累计推广数查询结束值
	 **/
	private String endTotalaction;
	
	/** 
	 * 需要返回的字段，目前包括如下字段 user_id click_url shop_title commission_rate seller_credit shop_type auction_count total_auction
	 **/
	private String fields;
	
	/** 
	 * 店铺主题关键字查询
	 **/
	private String keyword;
	
	/** 
	 * 淘宝用户昵称，注：指的是淘宝的会员登录名.如果昵称错误,那么客户就收不到佣金.每个淘宝昵称都对应于一个pid，在这里输入要结算佣金的淘宝昵称，当推广的商品成功后，佣金会打入此输入的淘宝昵称的账户。具体的信息可以登入阿里妈妈的网站查看
	 **/
	private String nick;
	
	/** 
	 * 是否只显示商城店铺
	 **/
	private Boolean onlyMall;
	
	/** 
	 * 自定义输入串.格式:英文和数字组成;长度不能大于12个字符,区分不同的推广渠道,如:bbs,表示bbs为推广渠道;blog,表示blog为推广渠道.
	 **/
	private String outerCode;
	
	/** 
	 * 页码
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数
	 **/
	private Long pageSize;
	
	/** 
	 * 店铺宝贝数查询开始值
	 **/
	private String startAuctioncount;
	
	/** 
	 * 店铺佣金比例查询开始值，注意佣金比例是x10000的整数.50表示0.5%
	 **/
	private String startCommissionrate;
	
	/** 
	 * 店铺掌柜信用等级起始
	 **/
	private String startCredit;
	
	/** 
	 * 店铺累计推广量开始值
	 **/
	private String startTotalaction;

	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setEndAuctioncount(String endAuctioncount) {
		this.endAuctioncount = endAuctioncount;
	}
	 public String getEndAuctioncount() {
		return this.endAuctioncount;
	}
	public void setEndCommissionrate(String endCommissionrate) {
		this.endCommissionrate = endCommissionrate;
	}
	 public String getEndCommissionrate() {
		return this.endCommissionrate;
	}
	public void setEndCredit(String endCredit) {
		this.endCredit = endCredit;
	}
	 public String getEndCredit() {
		return this.endCredit;
	}
	public void setEndTotalaction(String endTotalaction) {
		this.endTotalaction = endTotalaction;
	}
	 public String getEndTotalaction() {
		return this.endTotalaction;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	 public String getKeyword() {
		return this.keyword;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setOnlyMall(Boolean onlyMall) {
		this.onlyMall = onlyMall;
	}
	 public Boolean getOnlyMall() {
		return this.onlyMall;
	}
	public void setOuterCode(String outerCode) {
		this.outerCode = outerCode;
	}
	 public String getOuterCode() {
		return this.outerCode;
	}
	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}
	 public Long getPageNo() {
		return this.pageNo;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	 public Long getPageSize() {
		return this.pageSize;
	}
	public void setStartAuctioncount(String startAuctioncount) {
		this.startAuctioncount = startAuctioncount;
	}
	 public String getStartAuctioncount() {
		return this.startAuctioncount;
	}
	public void setStartCommissionrate(String startCommissionrate) {
		this.startCommissionrate = startCommissionrate;
	}
	 public String getStartCommissionrate() {
		return this.startCommissionrate;
	}
	public void setStartCredit(String startCredit) {
		this.startCredit = startCredit;
	}
	 public String getStartCredit() {
		return this.startCredit;
	}
	public void setStartTotalaction(String startTotalaction) {
		this.startTotalaction = startTotalaction;
	}
	 public String getStartTotalaction() {
		return this.startTotalaction;
	}
	
	public String getApiMethodName() {
		return "taobao.taobaoke.shops.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cid", this.cid);
		textParams.put("end_auctioncount", this.endAuctioncount);
		textParams.put("end_commissionrate", this.endCommissionrate);
		textParams.put("end_credit", this.endCredit);
		textParams.put("end_totalaction", this.endTotalaction);
		textParams.put("fields", this.fields);
		textParams.put("keyword", this.keyword);
		textParams.put("nick", this.nick);
		textParams.put("only_mall", this.onlyMall);
		textParams.put("outer_code", this.outerCode);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("start_auctioncount", this.startAuctioncount);
		textParams.put("start_commissionrate", this.startCommissionrate);
		textParams.put("start_credit", this.startCredit);
		textParams.put("start_totalaction", this.startTotalaction);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
