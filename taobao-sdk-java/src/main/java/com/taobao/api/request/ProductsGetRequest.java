package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.products.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 15:39:09.0
 */
public class ProductsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 类目id
	 **/
	private Long cid;
	
	/** 
	 * 需返回的字段列表.可选值:Product数据结构中的所有字段;多个字段之间用","分隔
	 **/
	private String fields;
	
	/** 
	 * 用户昵称
	 **/
	private String nick;
	
	/** 
	 * 页码.传入值为1代表第一页,传入值为2代表第二页,依此类推.默认返回的数据是从第一页开始.
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数.每页返回最多返回100条,默认值为40
	 **/
	private Long pageSize;
	
	/** 
	 * 属性串pid:vid
	 **/
	private String props;

	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
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
	public void setProps(String props) {
		this.props = props;
	}
	 public String getProps() {
		return this.props;
	}
	
	public String getApiMethodName() {
		return "taobao.products.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cid", this.cid);
		textParams.put("fields", this.fields);
		textParams.put("nick", this.nick);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("props", this.props);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
