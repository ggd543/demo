package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.trades.sold.increment.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-15 10:38:13.0
 */
public class TradesSoldIncrementGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 查询修改结束时间，必须大于修改开始时间(修改时间跨度不能大于一天)。格式:yyyy-MM-dd HH:mm:ss
	 **/
	private Date endModified;
	
	/** 
	 * 需要返回的字段。目前支持有：
1.Trade中可以指定返回的fields:seller_nick, buyer_nick, title, type, created, tid, seller_rate, buyer_rate, status, payment, discount_fee, adjust_fee, post_fee, total_fee, pay_time, end_time, modified, consign_time, buyer_obtain_point_fee, point_fee, real_point_fee, received_payment, commission_fee, pic_path, num_iid, num, price, cod_fee, cod_status, shipping_type, receiver_name, receiver_state, receiver_city, receiver_district, receiver_address, receiver_zip, receiver_mobile, receiver_phone 
2.Order中可以指定返回fields：
orders.title, orders.pic_path, orders.price, orders.num, orders.num_iid, orders.sku_id, orders.refund_status, orders.status, orders.oid, orders.total_fee, orders.payment, orders.discount_fee, orders.adjust_fee, orders.sku_properties_name, orders.item_meal_name, orders.buyer_rate, orders.seller_rate, orders.outer_iid, orders.outer_sku_id, orders.refund_id, orders.seller_type 
3.fields：orders（返回Order的所有内容）
	 **/
	private String fields;
	
	/** 
	 * 页码。取值范围:大于零的整数;默认值:1
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。取值范围：1~100，默认值：40。建议使用40可以提高成功率，减少超时数量。
	 **/
	private Long pageSize;
	
	/** 
	 * 查询修改开始时间(修改时间跨度不能大于一天)。格式:yyyy-MM-dd HH:mm:ss
	 **/
	private Date startModified;
	
	/** 
	 * 交易状态，默认查询所有交易状态的数据，除了默认值外每次只能查询一种状态。 可选值 TRADE_NO_CREATE_PAY(没有创建支付宝交易) WAIT_BUYER_PAY(等待买家付款) WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) TRADE_BUYER_SIGNED(买家已签收,货到付款专用) TRADE_FINISHED(交易成功) TRADE_CLOSED(交易关闭) TRADE_CLOSED_BY_TAOBAO(交易被淘宝关闭) ALL_WAIT_PAY(包含：WAIT_BUYER_PAY、TRADE_NO_CREATE_PAY) ALL_CLOSED(包含：TRADE_CLOSED、TRADE_CLOSED_BY_TAOBAO)
	 **/
	private String status;
	
	/** 
	 * 卖家对交易的自定义分组标签，目前可选值为：time_card（点卡软件代充），fee_card（话费软件代充）
	 **/
	private String tag;
	
	/** 
	 * 交易类型列表，同时查询多种交易类型可用逗号分隔。默认同时查询guarantee_trade, auto_delivery, ec, cod的4种交易类型的数据 。可选值： fixed(一口价) auction(拍卖) guarantee_trade(一口价、拍卖) independent_simple_trade(旺店入门版交易) independent_shop_trade(旺店标准版交易) auto_delivery(自动发货) ec(直冲) cod(货到付款) fenxiao(分销) game_equipment(游戏装备) shopex_trade(ShopEX交易) netcn_trade(万网交易) external_trade(统一外部交易) instant_trade (即时到账), b2c_cod(大商家货到付款)
	 **/
	private String type;
	
	/** 
	 * 是否启用has_next的分页方式，如果指定true,则返回的结果中不包含总记录数，但是会新增一个是否存在下一页的的字段，通过此种方式获取增量交易，成功率在原有的基础上有80%的提升。
	 **/
	private Boolean useHasNext;

	public void setEndModified(Date endModified) {
		this.endModified = endModified;
	}
	 public Date getEndModified() {
		return this.endModified;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
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
	public void setStartModified(Date startModified) {
		this.startModified = startModified;
	}
	 public Date getStartModified() {
		return this.startModified;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	 public String getTag() {
		return this.tag;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	public void setUseHasNext(Boolean useHasNext) {
		this.useHasNext = useHasNext;
	}
	 public Boolean getUseHasNext() {
		return this.useHasNext;
	}
	
	public String getApiMethodName() {
		return "taobao.trades.sold.increment.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("end_modified", this.endModified);
		textParams.put("fields", this.fields);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("start_modified", this.startModified);
		textParams.put("status", this.status);
		textParams.put("tag", this.tag);
		textParams.put("type", this.type);
		textParams.put("use_has_next", this.useHasNext);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
