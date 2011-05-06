package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.itemcats.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-27 10:17:00.0
 */
public class ItemcatsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品所属类目ID列表，用半角逗号(,)分隔 例如:(18957,19562,) (cids、parent_cid至少传一个)
	 **/
	private String cids;
	
	/** 
	 * 时间戳。格式:yyyy-MM-dd HH:mm:ss
如果没有传，则取所有的类目信息(如果传了parent_cid或者cids，则忽略datetime)
	 **/
	private Date datetime;
	
	/** 
	 * 需要返回的字段列表，见ItemCat，默认返回：cid,parent_cid,name,is_parent
	 **/
	private String fields;
	
	/** 
	 * 父商品类目 id，0表示根节点, 传输该参数返回所有子类目。 (cids、parent_cid至少传一个)
	 **/
	private Long parentCid;

	public void setCids(String cids) {
		this.cids = cids;
	}
	 public String getCids() {
		return this.cids;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	 public Date getDatetime() {
		return this.datetime;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setParentCid(Long parentCid) {
		this.parentCid = parentCid;
	}
	 public Long getParentCid() {
		return this.parentCid;
	}
	
	public String getApiMethodName() {
		return "taobao.itemcats.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cids", this.cids);
		textParams.put("datetime", this.datetime);
		textParams.put("fields", this.fields);
		textParams.put("parent_cid", this.parentCid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
