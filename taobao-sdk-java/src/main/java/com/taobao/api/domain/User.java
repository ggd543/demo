package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * User Data Structure.
 * 
 * DESC：用户 
 *
 * @author auto create
 * @since 1.0, 2010-11-23 13:20:06.0
 */
@ApiClass("User")
public class User extends TaobaoObject {

	private static final long serialVersionUID = 6588834535469256636L;

	
	/** 
	 * 支付宝账户
	 **/
	@ApiField("alipay_account")
	private String alipayAccount;

	
	/** 
	 * 有无绑定。可选值:bind(绑定),notbind(未绑定)
	 **/
	@ApiField("alipay_bind")
	private String alipayBind;

	
	/** 
	 * 支付宝ID
	 **/
	@ApiField("alipay_no")
	private String alipayNo;

	
	/** 
	 * 是否受限制。可选值:limited(受限制),unlimited(不受限)
	 **/
	@ApiField("auto_repost")
	private String autoRepost;

	
	/** 
	 * 卖家头像地址
	 **/
	@ApiField("avatar")
	private String avatar;

	
	/** 
	 * 生日
	 **/
	@ApiField("birthday")
	private Date birthday;

	
	/** 
	 * 买家信用
	 **/
	@ApiField("buyer_credit")
	private UserCredit buyerCredit;

	
	/** 
	 * 是否参加消保
	 **/
	@ApiField("consumer_protection")
	private Boolean consumerProtection;

	
	/** 
	 * 用户注册时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 联系人email
	 **/
	@ApiField("email")
	private String email;

	
	/** 
	 * 是否购买多图服务。可选值:true(是),false(否)
	 **/
	@ApiField("has_more_pic")
	private Boolean hasMorePic;

	
	/** 
	 * 可上传商品图片数量
	 **/
	@ApiField("item_img_num")
	private Long itemImgNum;

	
	/** 
	 * 单张商品图片最大容量(商品主图大小)。单位:k
	 **/
	@ApiField("item_img_size")
	private Long itemImgSize;

	
	/** 
	 * 最近登陆时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("last_visit")
	private Date lastVisit;

	
	/** 
	 * 用户当前居住地公开信息。如：location.city获取其中的city数据
	 **/
	@ApiField("location")
	private Location location;

	
	/** 
	 * 是否订阅了淘宝天下杂志
	 **/
	@ApiField("magazine_subscribe")
	private Boolean magazineSubscribe;

	
	/** 
	 * 用户昵称
	 **/
	@ApiField("nick")
	private String nick;

	
	/** 
	 * 用户是否为网游用户，属于隐私信息，需要登陆才能查看自己的。
目前仅供taobao.user.get使用
	 **/
	@ApiField("online_gaming")
	private Boolean onlineGaming;

	
	/** 
	 * 有无实名认证。可选值:authentication(实名认证),not authentication(没有认证)
	 **/
	@ApiField("promoted_type")
	private String promotedType;

	
	/** 
	 * 可上传属性图片数量
	 **/
	@ApiField("prop_img_num")
	private Long propImgNum;

	
	/** 
	 * 单张销售属性图片最大容量（非主图的商品图片和商品属性图片）。单位:k
	 **/
	@ApiField("prop_img_size")
	private Long propImgSize;

	
	/** 
	 * 卖家信用
	 **/
	@ApiField("seller_credit")
	private UserCredit sellerCredit;

	
	/** 
	 * 性别。可选值:m(男),f(女)
	 **/
	@ApiField("sex")
	private String sex;

	
	/** 
	 * 状态。可选值:normal(正常),inactive(未激活),delete(删除),reeze(冻结),supervise(监管)
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 用户类型。可选值:B(B商家),C(C商家)
	 **/
	@ApiField("type")
	private String type;

	
	/** 
	 * 用户字符串ID
	 **/
	@ApiField("uid")
	private String uid;

	
	/** 
	 * 用户数字ID
	 **/
	@ApiField("user_id")
	private Long userId;

	
	/** 
	 * 用户参与垂直市场类型。shoes表示鞋城垂直市场用户，3C表示3C垂直市场用户。多个类型之间用","分隔。如：一个用户既是3C用户又是鞋城用户，那么这个字段返回就是"3C,shoes"。如果用户不是垂直市场用户，此字段返回为""。
	 **/
	@ApiField("vertical_market")
	private String verticalMarket;

	public String getAlipayAccount() {
		return this.alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public String getAlipayBind() {
		return this.alipayBind;
	}
	public void setAlipayBind(String alipayBind) {
		this.alipayBind = alipayBind;
	}

	public String getAlipayNo() {
		return this.alipayNo;
	}
	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	public String getAutoRepost() {
		return this.autoRepost;
	}
	public void setAutoRepost(String autoRepost) {
		this.autoRepost = autoRepost;
	}

	public String getAvatar() {
		return this.avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserCredit getBuyerCredit() {
		return this.buyerCredit;
	}
	public void setBuyerCredit(UserCredit buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public Boolean getConsumerProtection() {
		return this.consumerProtection;
	}
	public void setConsumerProtection(Boolean consumerProtection) {
		this.consumerProtection = consumerProtection;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getHasMorePic() {
		return this.hasMorePic;
	}
	public void setHasMorePic(Boolean hasMorePic) {
		this.hasMorePic = hasMorePic;
	}

	public Long getItemImgNum() {
		return this.itemImgNum;
	}
	public void setItemImgNum(Long itemImgNum) {
		this.itemImgNum = itemImgNum;
	}

	public Long getItemImgSize() {
		return this.itemImgSize;
	}
	public void setItemImgSize(Long itemImgSize) {
		this.itemImgSize = itemImgSize;
	}

	public Date getLastVisit() {
		return this.lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Location getLocation() {
		return this.location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getMagazineSubscribe() {
		return this.magazineSubscribe;
	}
	public void setMagazineSubscribe(Boolean magazineSubscribe) {
		this.magazineSubscribe = magazineSubscribe;
	}

	public String getNick() {
		return this.nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public Boolean getOnlineGaming() {
		return this.onlineGaming;
	}
	public void setOnlineGaming(Boolean onlineGaming) {
		this.onlineGaming = onlineGaming;
	}

	public String getPromotedType() {
		return this.promotedType;
	}
	public void setPromotedType(String promotedType) {
		this.promotedType = promotedType;
	}

	public Long getPropImgNum() {
		return this.propImgNum;
	}
	public void setPropImgNum(Long propImgNum) {
		this.propImgNum = propImgNum;
	}

	public Long getPropImgSize() {
		return this.propImgSize;
	}
	public void setPropImgSize(Long propImgSize) {
		this.propImgSize = propImgSize;
	}

	public UserCredit getSellerCredit() {
		return this.sellerCredit;
	}
	public void setSellerCredit(UserCredit sellerCredit) {
		this.sellerCredit = sellerCredit;
	}

	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getUid() {
		return this.uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getVerticalMarket() {
		return this.verticalMarket;
	}
	public void setVerticalMarket(String verticalMarket) {
		this.verticalMarket = verticalMarket;
	}

}
