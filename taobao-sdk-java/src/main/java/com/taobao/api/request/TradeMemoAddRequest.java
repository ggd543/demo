package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.trade.memo.add request
 * 
 * @author auto create
 * @since 1.0, 2010-08-31 11:57:40.0
 */
public class TradeMemoAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 交易备注旗帜，可选值为：0(灰色), 1(红色), 2(黄色), 3(绿色), 4(蓝色), 5(粉红色)，默认值为0
	 **/
	private Long flag;
	
	/** 
	 * 交易备注。最大长度: 1000个字节
	 **/
	private String memo;
	
	/** 
	 * 交易编号
	 **/
	private Long tid;

	public void setFlag(Long flag) {
		this.flag = flag;
	}
	 public Long getFlag() {
		return this.flag;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.trade.memo.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("flag", this.flag);
		textParams.put("memo", this.memo);
		textParams.put("tid", this.tid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
