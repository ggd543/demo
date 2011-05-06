package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.products.search request
 * 
 * @author auto create
 * @since 1.0, 2010-09-02 11:05:51.0
 */
public class ProductsSearchRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品类目ID.调用taobao.itemcats.get获取.
	 **/
	private Long cid;
	
	/** 
	 * 需返回的字段列表.可选值:Product数据结构中的以下字段:product_id,name,pic_url,cid,props,price,tsc;多个字段之间用","分隔.新增字段status(product的当前状态)
	 **/
	private String fields;
	
	/** 
	 * 页码.传入值为1代表第一页,传入值为2代表第二页,依此类推.默认返回的数据是从第一页开始.
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数.每页返回最多返回100条,默认值为40.
	 **/
	private Long pageSize;
	
	/** 
	 * 属性,属性值的组合.格式:pid:vid;pid:vid;调用taobao.itemprops.get获取类目属性pid 
,再用taobao.itempropvalues.get取得vid.
	 **/
	private String props;
	
	/** 
	 * 搜索的关键词是用来搜索产品的title以及关键属性值的名称.如:"优衣库 1234",这种用来表示查询优衣库这个品牌下的货号为1234的产品;　注:q,cid和props至少传入一个
	 **/
	private String q;
	
	/** 
	 * 想要获取的产品的状态列表，支持多个状态并列获取，多个状态之间用","分隔，最多同时指定5种状态。例如，只获取小二确认的spu传入"3",只要商家确认的传入"0"，既要小二确认又要商家确认的传入"0,3"。目前只支持者两种类型的状态搜索，输入其他状态无效。
	 **/
	private String status;
	
	/** 
	 * 传入值为：3表示3C表示3C垂直市场产品，4表示鞋城垂直市场产品，8表示网游垂直市场产品。一次只能指定一种垂直市场类型
	 **/
	private Long verticalMarket;

	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
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
	public void setProps(String props) {
		this.props = props;
	}
	 public String getProps() {
		return this.props;
	}
	public void setQ(String q) {
		this.q = q;
	}
	 public String getQ() {
		return this.q;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	public void setVerticalMarket(Long verticalMarket) {
		this.verticalMarket = verticalMarket;
	}
	 public Long getVerticalMarket() {
		return this.verticalMarket;
	}
	
	public String getApiMethodName() {
		return "taobao.products.search";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cid", this.cid);
		textParams.put("fields", this.fields);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("props", this.props);
		textParams.put("q", this.q);
		textParams.put("status", this.status);
		textParams.put("vertical_market", this.verticalMarket);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
