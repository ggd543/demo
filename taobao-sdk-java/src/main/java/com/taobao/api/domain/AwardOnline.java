package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * AwardOnline Data Structure.
 * 
 * DESC：封装了具体的奖品信息 
 *
 * @author auto create
 * @since 1.0, 2010-10-15 10:36:48.0
 */
@ApiClass("AwardOnline")
public class AwardOnline extends TaobaoObject {

	private static final long serialVersionUID = 3173261771496845924L;

	
	/** 
	 * 奖品的名称
	 **/
	@ApiField("award_name")
	private String awardName;

	
	/** 
	 * 奖品图片的url
	 **/
	@ApiField("award_pic_url")
	private String awardPicUrl;

	
	/** 
	 * 商品的原价
	 **/
	@ApiField("award_price")
	private String awardPrice;

	
	/** 
	 * 所属类目的id
	 **/
	@ApiField("category_id")
	private Long categoryId;

	
	/** 
	 * 在交易线的detailUrl
	 **/
	@ApiField("detail_url")
	private String detailUrl;

	
	/** 
	 * 剩余数量
	 **/
	@ApiField("left_count")
	private Long leftCount;

	
	/** 
	 * 上架的总数量
	 **/
	@ApiField("online_count")
	private Long onlineCount;

	
	/** 
	 * 结束时间，精确到日
	 **/
	@ApiField("online_ec_end")
	private Date onlineEcEnd;

	
	/** 
	 * 可以兑换的时间段。
	 **/
	@ApiField("online_ec_range")
	private String onlineEcRange;

	
	/** 
	 * 开始日期，精确到日的。
	 **/
	@ApiField("online_ec_start")
	private Date onlineEcStart;

	
	/** 
	 * 奖品的在线id，用于发起领奖请求
	 **/
	@ApiField("online_id")
	private Long onlineId;

	public String getAwardName() {
		return this.awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardPicUrl() {
		return this.awardPicUrl;
	}
	public void setAwardPicUrl(String awardPicUrl) {
		this.awardPicUrl = awardPicUrl;
	}

	public String getAwardPrice() {
		return this.awardPrice;
	}
	public void setAwardPrice(String awardPrice) {
		this.awardPrice = awardPrice;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDetailUrl() {
		return this.detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public Long getLeftCount() {
		return this.leftCount;
	}
	public void setLeftCount(Long leftCount) {
		this.leftCount = leftCount;
	}

	public Long getOnlineCount() {
		return this.onlineCount;
	}
	public void setOnlineCount(Long onlineCount) {
		this.onlineCount = onlineCount;
	}

	public Date getOnlineEcEnd() {
		return this.onlineEcEnd;
	}
	public void setOnlineEcEnd(Date onlineEcEnd) {
		this.onlineEcEnd = onlineEcEnd;
	}

	public String getOnlineEcRange() {
		return this.onlineEcRange;
	}
	public void setOnlineEcRange(String onlineEcRange) {
		this.onlineEcRange = onlineEcRange;
	}

	public Date getOnlineEcStart() {
		return this.onlineEcStart;
	}
	public void setOnlineEcStart(Date onlineEcStart) {
		this.onlineEcStart = onlineEcStart;
	}

	public Long getOnlineId() {
		return this.onlineId;
	}
	public void setOnlineId(Long onlineId) {
		this.onlineId = onlineId;
	}

}
