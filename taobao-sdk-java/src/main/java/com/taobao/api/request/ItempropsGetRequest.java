package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.itemprops.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-28 11:06:04.0
 */
public class ItempropsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 类目子属性路径,由该子属性上层的类目属性和类目属性值组成,格式pid:vid;pid:vid.取类目子属性需要传child_path,cid
	 **/
	private String childPath;
	
	/** 
	 * 叶子类目ID，如果只传cid，则只返回一级属性,通过taobao.itemcats.get获得叶子类目ID
	 **/
	private Long cid;
	
	/** 
	 * 增量时间戳。格式:yyyy-MM-dd HH:mm:ss
假如传2005-01-01 00:00:00，则取所有的属性和子属性ID(如果传了pid会忽略datetime)
	 **/
	private Date datetime;
	
	/** 
	 * 需要返回的字段列表，见：ItemProp，默认返回：pid, name, must, multi, prop_values
	 **/
	private String fields;
	
	/** 
	 * 是否颜色属性。可选值:true(是),false(否) (删除的属性不会匹配和返回这个条件)
	 **/
	private Boolean isColorProp;
	
	/** 
	 * 是否枚举属性。可选值:true(是),false(否) (删除的属性不会匹配和返回这个条件)
	 **/
	private Boolean isEnumProp;
	
	/** 
	 * 是否是卖家可以自行输入的属性。可选值:true(是),false(否) (删除的属性不会匹配和返回这个条件)
	 **/
	private Boolean isInputProp;
	
	/** 
	 * 是否商品属性，这个属性只能放于发布商品时使用。可选值:true(是),false(否)
	 **/
	private Boolean isItemProp;
	
	/** 
	 * 是否关键属性。可选值:true(是),false(否)
	 **/
	private Boolean isKeyProp;
	
	/** 
	 * 是否销售属性。可选值:true(是),false(否)
	 **/
	private Boolean isSaleProp;
	
	/** 
	 * 父属性ID
	 **/
	private Long parentPid;
	
	/** 
	 * 属性id (取类目属性时，传pid，不用同时传PID和parent_pid)
	 **/
	private Long pid;

	public void setChildPath(String childPath) {
		this.childPath = childPath;
	}
	 public String getChildPath() {
		return this.childPath;
	}
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
	public void setIsColorProp(Boolean isColorProp) {
		this.isColorProp = isColorProp;
	}
	 public Boolean getIsColorProp() {
		return this.isColorProp;
	}
	public void setIsEnumProp(Boolean isEnumProp) {
		this.isEnumProp = isEnumProp;
	}
	 public Boolean getIsEnumProp() {
		return this.isEnumProp;
	}
	public void setIsInputProp(Boolean isInputProp) {
		this.isInputProp = isInputProp;
	}
	 public Boolean getIsInputProp() {
		return this.isInputProp;
	}
	public void setIsItemProp(Boolean isItemProp) {
		this.isItemProp = isItemProp;
	}
	 public Boolean getIsItemProp() {
		return this.isItemProp;
	}
	public void setIsKeyProp(Boolean isKeyProp) {
		this.isKeyProp = isKeyProp;
	}
	 public Boolean getIsKeyProp() {
		return this.isKeyProp;
	}
	public void setIsSaleProp(Boolean isSaleProp) {
		this.isSaleProp = isSaleProp;
	}
	 public Boolean getIsSaleProp() {
		return this.isSaleProp;
	}
	public void setParentPid(Long parentPid) {
		this.parentPid = parentPid;
	}
	 public Long getParentPid() {
		return this.parentPid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	 public Long getPid() {
		return this.pid;
	}
	
	public String getApiMethodName() {
		return "taobao.itemprops.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("child_path", this.childPath);
		textParams.put("cid", this.cid);
		textParams.put("datetime", this.datetime);
		textParams.put("fields", this.fields);
		textParams.put("is_color_prop", this.isColorProp);
		textParams.put("is_enum_prop", this.isEnumProp);
		textParams.put("is_input_prop", this.isInputProp);
		textParams.put("is_item_prop", this.isItemProp);
		textParams.put("is_key_prop", this.isKeyProp);
		textParams.put("is_sale_prop", this.isSaleProp);
		textParams.put("parent_pid", this.parentPid);
		textParams.put("pid", this.pid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
