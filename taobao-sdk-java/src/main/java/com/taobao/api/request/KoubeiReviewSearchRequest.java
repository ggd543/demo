package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.review.search request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:58:34.0
 */
public class KoubeiReviewSearchRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 列表翻页用的页码，大于0的整数，默认为1,最大值：50
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数，大于0的整数，默认为20，最大值：80
	 **/
	private Long pageSize;
	
	/** 
	 * 评论对象的id
	 **/
	private String targetId;
	
	/** 
	 * 被评论对象的类型，店铺对象类型为“1”,目前就支持这个
	 **/
	private String targetType;

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
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	 public String getTargetId() {
		return this.targetId;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	 public String getTargetType() {
		return this.targetType;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.review.search";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("target_id", this.targetId);
		textParams.put("target_type", this.targetType);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
