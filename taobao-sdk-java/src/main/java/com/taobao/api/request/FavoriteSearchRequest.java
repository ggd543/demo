package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.favorite.search request
 * 
 * @author auto create
 * @since 1.0, 2010-09-20 18:32:42.0
 */
public class FavoriteSearchRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * ITEM表示宝贝，SHOP表示商铺，collect_type只能为这两者之一
	 **/
	private String collectType;
	
	/** 
	 * 页码。取值范围:大于零的整数; 默认值:1。一页20条记录。
	 **/
	private Long pageNo;
	
	/** 
	 * 用户昵称
	 **/
	private String userNick;

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}
	 public String getCollectType() {
		return this.collectType;
	}
	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}
	 public Long getPageNo() {
		return this.pageNo;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	 public String getUserNick() {
		return this.userNick;
	}
	
	public String getApiMethodName() {
		return "taobao.favorite.search";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("collect_type", this.collectType);
		textParams.put("page_no", this.pageNo);
		textParams.put("user_nick", this.userNick);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
