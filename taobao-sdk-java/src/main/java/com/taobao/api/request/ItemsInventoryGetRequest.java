package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.items.inventory.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-03 10:01:46.0
 */
public class ItemsInventoryGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 分类字段。可选值:

regular_shelved(定时上架)
never_on_shelf(从未上架)
sold_out(全部卖完)
off_shelf(我下架的)
for_shelved(等待所有上架)
violation_off_shelf(违规下架的)
默认查询的是for_shelved(等待所有上架)这个状态的商品
	 **/
	private String banner;
	
	/** 
	 * 商品类目ID。ItemCat中的cid字段。可以通过taobao.itemcats.get取到
	 **/
	private Long cid;
	
	/** 
	 * 商品结束修改时间
	 **/
	private Date endModified;
	
	/** 
	 * 需返回的字段列表。可选值：Item商品结构体中的以下字段： 
approve_status,num_iid,title,nick,type,cid,pic_url,num,props,valid_thru, 

list_time,price,has_discount,has_invoice,has_warranty,has_showcase, 

modified,delist_time,postage_id,seller_cids,outer_id；字段之间用“,”分隔。 

不支持其他字段，如果需要获取其他字段数据，调用taobao.item.get。
	 **/
	private String fields;
	
	/** 
	 * 是否参与会员折扣。可选值：true，false。默认不过滤该条件
	 **/
	private Boolean hasDiscount;
	
	/** 
	 * 是否橱窗推荐商品
	 **/
	private Boolean hasShowcase;
	
	/** 
	 * 商品是否在外部网店显示
	 **/
	private Boolean isEx;
	
	/** 
	 * 商品是否在淘宝显示
	 **/
	private Boolean isTaobao;
	
	/** 
	 * 排序方式。格式为column:asc/desc ，column可选值:list_time(上架时间),delist_time(下架时间),num(商品数量)，modified(最近修改时间);默认上架时间降序(即最新上架排在前面)。如按照上架时间降序排序方式为list_time:desc
	 **/
	private String orderBy;
	
	/** 
	 * 页码。取值范围:大于零的整数;默认值为1，即返回第一页数据。用此接口获取数据，当翻页获取的条数（page_no*page_size）超过15万条,为了保护后台搜索引擎，接口将报错。请大家尽可能的细化自己的搜索条件，例如根据修改时间分段获取商品
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。取值范围:大于零的整数;最大值：200；默认值：40。
	 **/
	private Long pageSize;
	
	/** 
	 * 搜索字段。搜索商品的title。
	 **/
	private String q;
	
	/** 
	 * 卖家店铺内自定义类目ID。多个之间用“,”分隔。可以根据taobao.sellercats.list.get获得
	 **/
	private String sellerCids;
	
	/** 
	 * 商品起始修改时间
	 **/
	private Date startModified;

	public void setBanner(String banner) {
		this.banner = banner;
	}
	 public String getBanner() {
		return this.banner;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setEndModified(Date endModified) {
		this.endModified = endModified;
	}
	 public Date getEndModified() {
		return this.endModified;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setHasDiscount(Boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}
	 public Boolean getHasDiscount() {
		return this.hasDiscount;
	}
	public void setHasShowcase(Boolean hasShowcase) {
		this.hasShowcase = hasShowcase;
	}
	 public Boolean getHasShowcase() {
		return this.hasShowcase;
	}
	public void setIsEx(Boolean isEx) {
		this.isEx = isEx;
	}
	 public Boolean getIsEx() {
		return this.isEx;
	}
	public void setIsTaobao(Boolean isTaobao) {
		this.isTaobao = isTaobao;
	}
	 public Boolean getIsTaobao() {
		return this.isTaobao;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	 public String getOrderBy() {
		return this.orderBy;
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
	public void setQ(String q) {
		this.q = q;
	}
	 public String getQ() {
		return this.q;
	}
	public void setSellerCids(String sellerCids) {
		this.sellerCids = sellerCids;
	}
	 public String getSellerCids() {
		return this.sellerCids;
	}
	public void setStartModified(Date startModified) {
		this.startModified = startModified;
	}
	 public Date getStartModified() {
		return this.startModified;
	}
	
	public String getApiMethodName() {
		return "taobao.items.inventory.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("banner", this.banner);
		textParams.put("cid", this.cid);
		textParams.put("end_modified", this.endModified);
		textParams.put("fields", this.fields);
		textParams.put("has_discount", this.hasDiscount);
		textParams.put("has_showcase", this.hasShowcase);
		textParams.put("is_ex", this.isEx);
		textParams.put("is_taobao", this.isTaobao);
		textParams.put("order_by", this.orderBy);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("q", this.q);
		textParams.put("seller_cids", this.sellerCids);
		textParams.put("start_modified", this.startModified);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
