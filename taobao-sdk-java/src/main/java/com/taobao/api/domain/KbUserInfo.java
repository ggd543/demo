package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbUserInfo Data Structure.
 * 
 * DESC：用户的非隐式信息 
 *
 * @author auto create
 * @since 1.0, 2010-05-17 14:03:23.0
 */
@ApiClass("KbUserInfo")
public class KbUserInfo extends TaobaoObject {

	private static final long serialVersionUID = 3171395532438396573L;

	
	/** 
	 * 地区名称
	 **/
	@ApiField("area")
	private String area;

	
	/** 
	 * int 男:1 女:0 其它:2
	 **/
	@ApiField("gender")
	private Long gender;

	
	/** 
	 * 用户等级
	 **/
	@ApiField("grade")
	private String grade;

	
	/** 
	 * 用户默认头像
	 **/
	@ApiField("photo")
	private String photo;

	
	/** 
	 * 淘宝旺旺
	 **/
	@ApiField("tb_ww")
	private String tbWw;

	
	/** 
	 * String not null 主键 数值型自增值(主站大部分应用使用),暂时由mysql生成
	 **/
	@ApiField("user_id")
	private String userId;

	
	/** 
	 * 用户名
String NOT NULL 一个中文占2个字符 UNIQUE KEY， 登录Handle
	 **/
	@ApiField("username")
	private String username;

	public String getArea() {
		return this.area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public Long getGender() {
		return this.gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return this.grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhoto() {
		return this.photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTbWw() {
		return this.tbWw;
	}
	public void setTbWw(String tbWw) {
		this.tbWw = tbWw;
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
