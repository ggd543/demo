package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.fenxiao.product.add response
 * 
 * @author auto create
 * @since 1.0,2010-08-12 20:46:48.0
 */
public class FenxiaoProductAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5299857164515811643L;

	
	/** 
	 * 产品创建时间 时间格式：yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("created")
	private Date created;
	
	/** 
	 * 产品ID
	 **/
	@ApiField("pid")
	private Long pid;

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated( ) {
		return this.created;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPid( ) {
		return this.pid;
	}

	public String getApiMethodName() {
		return "taobao.fenxiao.product.add";
	}

}
