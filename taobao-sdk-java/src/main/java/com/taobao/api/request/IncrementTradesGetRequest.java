package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.increment.trades.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-14 20:58:26.0
 */
public class IncrementTradesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 消息所对应的操作时间的最大值。和start_modified搭配使用能过滤消通知消息的时间段。不传时：如果设置了start_modified，默认为与start_modified同一天的23:59:59；否则默认为调用接口当天的23:59:59。（格式：yyyy-MM-dd HH:mm:ss）
	 **/
	private Date endModified;
	
	/** 
	 * 消息所属于的用户的昵称。设置此参数，返回的消息会根据传入nick的进行过滤。自用型appKey的昵称默认为自己的绑定昵称，此参数无效。
	 **/
	private String nick;
	
	/** 
	 * 页码。取值范围:大于零的整数; 默认值:1,即返回第一页数据。
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。取值范围:大于零的整数;最大值:200;默认值:40。
	 **/
	private Long pageSize;
	
	/** 
	 * 消息所对应的操作时间的最小值。和end_modified搭配使用能过滤消通知消息的时间段。不传时：如果设置了end_modified，默认为与end_modified同一天的00:00:00，否则默认为调用接口当天的00:00:00。（格式：yyyy-MM-dd HH:mm:ss）
	 **/
	private Date startModified;
	
	/** 
	 * 交易或评价的状态，默认查询所有状态的数据，除了默认值外每次只能查询一种状态。除了交易超时提醒消息没有type分类以外，交易的其他消息都有type分类。
可选值 
TradeCreate（创建交易） 
TradeModifyFee（修改交易费用） 
TradeCloseAndModifyDetailOrder（关闭或修改子订单） 
TradeClose（关闭交易） 
TradeBuyerPay（买家付款） 
TradeSellerShip（卖家发货） 
TradeDelayConfirmPay（延长收货时间） 
TradePartlyRefund（子订单退款成功） 
TradePartlyConfirmPay（子订单打款成功） 
TradeSuccess（交易成功） 
TradeTimeoutRemind（交易超时提醒） 
TradeRated（交易评价变更） 
TradeMemoModified（交易备注修改） 
TradeLogisticsAddressChanged（修改交易收货地址） 
TradeChanged（修改订单信息（SKU等））
	 **/
	private String status;
	
	/** 
	 * 交易所属的类型，默认查询所有类型的数据，除了默认值外每次只能查询一种类型。交易超时提醒类型的消息没有消息类型，固定返回“timeout”。
可选值：
ec（直冲） 
guarantee_trade（一口价、拍卖） 
auto_delivery（自动发货） 
cod（货到付款） 
independent_shop_trade（旺店标准版交易） 
independent_simple_trade（旺店入门版交易） 
shopex_trade（ShopEX版) 
netcn_trade（淘宝与万网合作版网） 
travel（旅游产品交易） 
fenxiao（分销平台交易） 
game_equipment（网游虚拟交易）
	 **/
	private String type;

	public void setEndModified(Date endModified) {
		this.endModified = endModified;
	}
	 public Date getEndModified() {
		return this.endModified;
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
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	
	public String getApiMethodName() {
		return "taobao.increment.trades.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("end_modified", this.endModified);
		textParams.put("nick", this.nick);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("start_modified", this.startModified);
		textParams.put("status", this.status);
		textParams.put("type", this.type);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
