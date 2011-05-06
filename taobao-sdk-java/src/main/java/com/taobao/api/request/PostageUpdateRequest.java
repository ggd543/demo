package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.postage.update request
 * 
 * @author auto create
 * @since 1.0, 2010-08-05 09:37:58.0
 */
public class PostageUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 默认EMS加价费用.精确到1位小数;单位:元。如:10.5
	 **/
	private String emsIncrease;
	
	/** 
	 * 默认EMS费用.精确到1位小数;单位:元。如:10.5
	 **/
	private String emsPrice;
	
	/** 
	 * 默认快递加价费用.精确到1位小数;单位:元。如:10.5
	 **/
	private String expressIncrease;
	
	/** 
	 * 默认快递费用.精确到1位小数;单位:元。如:10.5
	 **/
	private String expressPrice;
	
	/** 
	 * 邮费模板备注
	 **/
	private String memo;
	
	/** 
	 * 邮费模板名称
	 **/
	private String name;
	
	/** 
	 * 默认平邮加价费用.精确到1位小数;单位:元。如:10.5
	 **/
	private String postIncrease;
	
	/** 
	 * 默认平邮费用.精确到1位小数;单位:元。如:10.5
	 **/
	private String postPrice;
	
	/** 
	 * 邮费模板id.注意:给定的postage_id必须是存在的postage的id
	 **/
	private Long postageId;
	
	/** 
	 * 邮费子项涉及的地区，多个地区用逗号连接数量串。可以用taobao.areas.get接口获取。或者参考：http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm  例 (110000;310000;320000,330000)就代表邮费子项涉及(北京;上海;江苏,浙江)四个地区。填写时要注意对照地区代码值，如果填入错误地区代码，将会出现错误信息
	 **/
	private String postageModeDests;
	
	/** 
	 * 运费子模板id:修改多个子模板时,用 “;”区分.注意1:给定的postage_mode_id必须是当前postage所包含的postage_mode的id.注意2:在修改多个PostageMode时,字符串中使用 " ; " 分号区分,必须注意每个字段的数量一定要相等.注意3:在添加运费模板子模板的时候必须是已经有了默认的运费项后才可以添加对应的邮费模板子模板。如,添加了默认的EMS运费项，才可以添加运EMS费模板子项.
	 **/
	private String postageModeIds;
	
	/** 
	 * 运费方式加件费用数量串：例 (1.5;2.4;2.0).精确到1位小数;单位:元。如:10.5
	 **/
	private String postageModeIncreases;
	
	/** 
	 * 子模板操作类型：新增(add),修改(update),删除(delete). 例(add;add;add).注意：对子模板进行操作的时候此参数必填.如果不填那默认为update.新增操作不能传子模板ID
	 **/
	private String postageModeOptTypes;
	
	/** 
	 * 运费方式单价数量串：例 (11.2;14;1;6).精确到1位小数;单位:元。如:10.5
	 **/
	private String postageModePrices;
	
	/** 
	 * 运费方式:平邮(post),快递公司(express),EMS(ems)数量串:例(post;express;ems)分号区分
	 **/
	private String postageModeTypes;
	
	/** 
	 * 删除ems类型的邮费模板，包括所有这个类型的子邮费模板
	 **/
	private Boolean removeEms;
	
	/** 
	 * 删除快递类型的邮费模板，包括所有这个类型的子邮费模板
	 **/
	private Boolean removeExpress;
	
	/** 
	 * 删除平邮类型的邮费模板，包括所有这个类型的子邮费模板
	 **/
	private Boolean removePost;

	public void setEmsIncrease(String emsIncrease) {
		this.emsIncrease = emsIncrease;
	}
	 public String getEmsIncrease() {
		return this.emsIncrease;
	}
	public void setEmsPrice(String emsPrice) {
		this.emsPrice = emsPrice;
	}
	 public String getEmsPrice() {
		return this.emsPrice;
	}
	public void setExpressIncrease(String expressIncrease) {
		this.expressIncrease = expressIncrease;
	}
	 public String getExpressIncrease() {
		return this.expressIncrease;
	}
	public void setExpressPrice(String expressPrice) {
		this.expressPrice = expressPrice;
	}
	 public String getExpressPrice() {
		return this.expressPrice;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	public void setPostIncrease(String postIncrease) {
		this.postIncrease = postIncrease;
	}
	 public String getPostIncrease() {
		return this.postIncrease;
	}
	public void setPostPrice(String postPrice) {
		this.postPrice = postPrice;
	}
	 public String getPostPrice() {
		return this.postPrice;
	}
	public void setPostageId(Long postageId) {
		this.postageId = postageId;
	}
	 public Long getPostageId() {
		return this.postageId;
	}
	public void setPostageModeDests(String postageModeDests) {
		this.postageModeDests = postageModeDests;
	}
	 public String getPostageModeDests() {
		return this.postageModeDests;
	}
	public void setPostageModeIds(String postageModeIds) {
		this.postageModeIds = postageModeIds;
	}
	 public String getPostageModeIds() {
		return this.postageModeIds;
	}
	public void setPostageModeIncreases(String postageModeIncreases) {
		this.postageModeIncreases = postageModeIncreases;
	}
	 public String getPostageModeIncreases() {
		return this.postageModeIncreases;
	}
	public void setPostageModeOptTypes(String postageModeOptTypes) {
		this.postageModeOptTypes = postageModeOptTypes;
	}
	 public String getPostageModeOptTypes() {
		return this.postageModeOptTypes;
	}
	public void setPostageModePrices(String postageModePrices) {
		this.postageModePrices = postageModePrices;
	}
	 public String getPostageModePrices() {
		return this.postageModePrices;
	}
	public void setPostageModeTypes(String postageModeTypes) {
		this.postageModeTypes = postageModeTypes;
	}
	 public String getPostageModeTypes() {
		return this.postageModeTypes;
	}
	public void setRemoveEms(Boolean removeEms) {
		this.removeEms = removeEms;
	}
	 public Boolean getRemoveEms() {
		return this.removeEms;
	}
	public void setRemoveExpress(Boolean removeExpress) {
		this.removeExpress = removeExpress;
	}
	 public Boolean getRemoveExpress() {
		return this.removeExpress;
	}
	public void setRemovePost(Boolean removePost) {
		this.removePost = removePost;
	}
	 public Boolean getRemovePost() {
		return this.removePost;
	}
	
	public String getApiMethodName() {
		return "taobao.postage.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("ems_increase", this.emsIncrease);
		textParams.put("ems_price", this.emsPrice);
		textParams.put("express_increase", this.expressIncrease);
		textParams.put("express_price", this.expressPrice);
		textParams.put("memo", this.memo);
		textParams.put("name", this.name);
		textParams.put("post_increase", this.postIncrease);
		textParams.put("post_price", this.postPrice);
		textParams.put("postage_id", this.postageId);
		textParams.put("postage_mode_dests", this.postageModeDests);
		textParams.put("postage_mode_ids", this.postageModeIds);
		textParams.put("postage_mode_increases", this.postageModeIncreases);
		textParams.put("postage_mode_optTypes", this.postageModeOptTypes);
		textParams.put("postage_mode_prices", this.postageModePrices);
		textParams.put("postage_mode_types", this.postageModeTypes);
		textParams.put("remove_ems", this.removeEms);
		textParams.put("remove_express", this.removeExpress);
		textParams.put("remove_post", this.removePost);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
