package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * CollectItem Data Structure.
 * 
 * DESC：商品或店铺的信息 
 *
 * @author auto create
 * @since 1.0, 2010-10-08 11:11:03.0
 */
@ApiClass("CollectItem")
public class CollectItem extends TaobaoObject {

	private static final long serialVersionUID = 7455637689999283845L;

	
	/** 
	 * 商品或店铺的id号
	 **/
	@ApiField("item_numid")
	private Long itemNumid;

	
	/** 
	 * 收藏目标的标题名字
	 **/
	@ApiField("title")
	private String title;

	public Long getItemNumid() {
		return this.itemNumid;
	}
	public void setItemNumid(Long itemNumid) {
		this.itemNumid = itemNumid;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
