package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.itempropvalues.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-12 20:51:05.0
 */
public class ItempropvaluesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 叶子类目ID ,通过taobao.itemcats.get获得叶子类目ID
	 **/
	private Long cid;
	
	/** 
	 * 假如传2005-01-01 00:00:00，则取所有的属性和子属性(状态为删除的属性值不返回prop_name)
	 **/
	private Date datetime;
	
	/** 
	 * 需要返回的字段。目前支持有：cid,pid,prop_name,vid,name,name_alias,status,sort_order
	 **/
	private String fields;
	
	/** 
	 * 属性和属性值 id串，格式例如(pid1;pid2)或(pid1:vid1;pid2:vid2)或(pid1;pid2:vid2)
	 **/
	private String pvs;

	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
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
	public void setPvs(String pvs) {
		this.pvs = pvs;
	}
	 public String getPvs() {
		return this.pvs;
	}
	
	public String getApiMethodName() {
		return "taobao.itempropvalues.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cid", this.cid);
		textParams.put("datetime", this.datetime);
		textParams.put("fields", this.fields);
		textParams.put("pvs", this.pvs);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
