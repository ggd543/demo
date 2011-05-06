package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbListReview Data Structure.
 * 
 * DESC：口碑的点评POJO对象，用于列表展现 
 *
 * @author auto create
 * @since 1.0, 2010-06-30 14:48:19.0
 */
@ApiClass("KbListReview")
public class KbListReview extends TaobaoObject {

	private static final long serialVersionUID = 2522637854632392679L;

	
	/** 
	 * 在店铺消费时的总人数
	 **/
	@ApiField("consum_num")
	private Long consumNum;

	
	/** 
	 * 在店铺的一次总消费
	 **/
	@ApiField("consum_total")
	private Long consumTotal;

	
	/** 
	 * 评论创建时间
	 **/
	@ApiField("create_time")
	private Date createTime;

	
	/** 
	 * 店铺的环境氛围适合什么活动,例如:家庭聚会，随便吃吃,情侣约会,商务洽谈,朋友聚会,工作午餐,大型聚会.多个氛围以","为分割符
	 **/
	@ApiField("environments")
	private String environments;

	
	/** 
	 * 用户发表的文本评论
	 **/
	@ApiField("feeling")
	private String feeling;

	
	/** 
	 * 对店铺的印象,多个印象以","为分割符
	 **/
	@ApiField("impress")
	private String impress;

	
	/** 
	 * 对店铺的打分,1为差,2为中,3为好
	 **/
	@ApiField("rating")
	private Long rating;

	
	/** 
	 * 对店铺的推荐菜,多个推荐以","为分割符
	 **/
	@ApiField("recommend")
	private String recommend;

	
	/** 
	 * 该条评论被回应的次数
	 **/
	@ApiField("reply_count")
	private Long replyCount;

	
	/** 
	 * UUID随机生成
	 **/
	@ApiField("review_id")
	private String reviewId;

	
	/** 
	 * 被评论对象的ID值
	 **/
	@ApiField("target_id")
	private String targetId;

	
	/** 
	 * 评论对象名
	 **/
	@ApiField("target_name")
	private String targetName;

	
	/** 
	 * 被评论对象的类型，被点评对象为店铺时target_type="1"
	 **/
	@ApiField("target_type")
	private String targetType;

	
	/** 
	 * 点评的标题
	 **/
	@ApiField("title")
	private String title;

	
	/** 
	 * 评论修改时间
	 **/
	@ApiField("update_time")
	private Date updateTime;

	
	/** 
	 * 发表评论的用户ID
	 **/
	@ApiField("user_id")
	private String userId;

	
	/** 
	 * 用户名
	 **/
	@ApiField("username")
	private String username;

	public Long getConsumNum() {
		return this.consumNum;
	}
	public void setConsumNum(Long consumNum) {
		this.consumNum = consumNum;
	}

	public Long getConsumTotal() {
		return this.consumTotal;
	}
	public void setConsumTotal(Long consumTotal) {
		this.consumTotal = consumTotal;
	}

	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEnvironments() {
		return this.environments;
	}
	public void setEnvironments(String environments) {
		this.environments = environments;
	}

	public String getFeeling() {
		return this.feeling;
	}
	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getImpress() {
		return this.impress;
	}
	public void setImpress(String impress) {
		this.impress = impress;
	}

	public Long getRating() {
		return this.rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getRecommend() {
		return this.recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Long getReplyCount() {
		return this.replyCount;
	}
	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}

	public String getReviewId() {
		return this.reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getTargetId() {
		return this.targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTargetName() {
		return this.targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetType() {
		return this.targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
