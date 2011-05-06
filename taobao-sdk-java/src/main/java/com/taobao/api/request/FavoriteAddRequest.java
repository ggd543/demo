package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.favorite.add request
 * 
 * @author auto create
 * @since 1.0, 2010-09-19 13:21:02.0
 */
public class FavoriteAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * ITEM表示宝贝，SHOP表示店铺，只能传入这两者之一
	 **/
	private String collectType;
	
	/** 
	 * 如果收藏的是商品，就传num_iid，如果是店铺，就传入sid
	 **/
	private Long itemNumid;
	
	/** 
	 * 该收藏是否公开
	 **/
	private Boolean shared;

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}
	 public String getCollectType() {
		return this.collectType;
	}
	public void setItemNumid(Long itemNumid) {
		this.itemNumid = itemNumid;
	}
	 public Long getItemNumid() {
		return this.itemNumid;
	}
	public void setShared(Boolean shared) {
		this.shared = shared;
	}
	 public Boolean getShared() {
		return this.shared;
	}
	
	public String getApiMethodName() {
		return "taobao.favorite.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("collect_type", this.collectType);
		textParams.put("item_numid", this.itemNumid);
		textParams.put("shared", this.shared);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
