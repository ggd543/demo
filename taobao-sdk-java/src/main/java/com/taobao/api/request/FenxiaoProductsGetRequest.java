package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.fenxiao.products.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-04 18:40:15.0
 */
public class FenxiaoProductsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 结束修改时间
	 **/
	private Date endModified;
	
	/** 
	 * 指定查询额外的信息，可选值：skus（sku数据）、images（多图），多个可选值用逗号分割。
	 **/
	private String fields;
	
	/** 
	 * 商家编码
	 **/
	private String outerId;
	
	/** 
	 * 页码（大于0的整数，默认1）
	 **/
	private Long pageNo;
	
	/** 
	 * 每页记录数（默认20，最大50）
	 **/
	private Long pageSize;
	
	/** 
	 * 产品ID列表（最大限制30），用逗号分割，例如：“1001,1002,1003,1004,1005”
	 **/
	private String pids;
	
	/** 
	 * 产品线ID
	 **/
	private Long productcatId;
	
	/** 
	 * 开始修改时间
	 **/
	private Date startModified;
	
	/** 
	 * 产品状态，可选值：up（上架）、down（下架），不传默认查询所有
	 **/
	private String status;

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
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
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
	public void setPids(String pids) {
		this.pids = pids;
	}
	 public String getPids() {
		return this.pids;
	}
	public void setProductcatId(Long productcatId) {
		this.productcatId = productcatId;
	}
	 public Long getProductcatId() {
		return this.productcatId;
	}
	public void setStartModified(Date startModified) {
		this.startModified = startModified;
	}
	 public Date getStartModified() {
		return this.startModified;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	
	public String getApiMethodName() {
		return "taobao.fenxiao.products.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("end_modified", this.endModified);
		textParams.put("fields", this.fields);
		textParams.put("outer_id", this.outerId);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("pids", this.pids);
		textParams.put("productcat_id", this.productcatId);
		textParams.put("start_modified", this.startModified);
		textParams.put("status", this.status);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
