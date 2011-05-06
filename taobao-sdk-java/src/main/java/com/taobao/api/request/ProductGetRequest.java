package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.product.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 16:00:46.0
 */
public class ProductGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品类目id.调用taobao.itemcats.get获取;必须是叶子类目id,如果没有传product_id,那么cid和props必须要传.
	 **/
	private Long cid;
	
	/** 
	 * 需返回的字段列表.可选值:Product数据结构中的所有字段;多个字段之间用","分隔.
	 **/
	private String fields;
	
	/** 
	 * Product的id.两种方式来查看一个产品:1.传入product_id来查询 2.传入cid和props来查询
	 **/
	private Long productId;
	
	/** 
	 * 比如:诺基亚N73这个产品的关键属性列表就是:品牌:诺基亚;型号:N73,对应的PV值就是10005:10027;10006:29729.
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
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	 public Long getProductId() {
		return this.productId;
	}
	public void setProps(String props) {
		this.props = props;
	}
	 public String getProps() {
		return this.props;
	}
	
	public String getApiMethodName() {
		return "taobao.product.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cid", this.cid);
		textParams.put("fields", this.fields);
		textParams.put("product_id", this.productId);
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
