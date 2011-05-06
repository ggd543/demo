package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.picture.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-12 21:28:12.0
 */
public class PictureGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 是否删除,unfroze代表没有删除
	 **/
	private String deleted;
	
	/** 
	 * 查询上传结束时间点,格式:yyyy-MM-dd HH:mm:ss
	 **/
	private Date endDate;
	
	/** 
	 * 需要返回的字段，根据Picture中的以下字段：picture_id,picture_category_id,picture_path,title,sizes,pixel,status,deleted,created,modified，多个字段用","分隔。如：picture_path,title,sizes
	 **/
	private String fields;
	
	/** 
	 * 图片编辑时间,返回的是图片最后修改（包括标题、分类、内容）时间为大于这个时间点的图片
	 **/
	private Date modifiedTime;
	
	/** 
	 * 图片查询结果排序,time:desc按上传时间从晚到早(默认), time:asc按上传时间从早到晚,sizes:desc按图片从大到小，sizes:asc按图片从小到大,默认time:desc
	 **/
	private String orderBy;
	
	/** 
	 * 页码.传入值为1代表第一页,传入值为2代表第二页,依此类推,默认值为1
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数.每页返回最多返回100条,默认值40
	 **/
	private Long pageSize;
	
	/** 
	 * 图片分类ID
	 **/
	private Long pictureCategoryId;
	
	/** 
	 * 图片ID
	 **/
	private Long pictureId;
	
	/** 
	 * 查询上传开始时间点,格式:yyyy-MM-dd HH:mm:ss
	 **/
	private Date startDate;
	
	/** 
	 * 图片标题,最大长度50字符,中英文都算一字符
	 **/
	private String title;

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	 public String getDeleted() {
		return this.deleted;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	 public Date getEndDate() {
		return this.endDate;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	 public Date getModifiedTime() {
		return this.modifiedTime;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	 public String getOrderBy() {
		return this.orderBy;
	}
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
	public void setPictureCategoryId(Long pictureCategoryId) {
		this.pictureCategoryId = pictureCategoryId;
	}
	 public Long getPictureCategoryId() {
		return this.pictureCategoryId;
	}
	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}
	 public Long getPictureId() {
		return this.pictureId;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	 public Date getStartDate() {
		return this.startDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	 public String getTitle() {
		return this.title;
	}
	
	public String getApiMethodName() {
		return "taobao.picture.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("deleted", this.deleted);
		textParams.put("end_date", this.endDate);
		textParams.put("fields", this.fields);
		textParams.put("modified_time", this.modifiedTime);
		textParams.put("order_by", this.orderBy);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("picture_category_id", this.pictureCategoryId);
		textParams.put("picture_id", this.pictureId);
		textParams.put("start_date", this.startDate);
		textParams.put("title", this.title);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
