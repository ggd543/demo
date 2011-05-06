package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.traderate.list.add request
 * 
 * @author auto create
 * @since 1.0, 2010-11-08 17:21:46.0
 */
public class TraderateListAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 是否匿名，卖家评不能匿名。可选值:true(匿名),false(非匿名)。 注意：输入非可选值将会自动转为false；
	 **/
	private Boolean anony;
	
	/** 
	 * 评价内容,最大长度: 500个汉字 .注意：当评价结果为good时就不用输入评价内容.评价内容为neutral/bad的时候需要输入评价内容
	 **/
	private String content;
	
	/** 
	 * 子订单ID
	 **/
	private Long oid;
	
	/** 
	 * 评价结果。可选值:good(好评),neutral(中评),bad(差评)
	 **/
	private String result;
	
	/** 
	 * 评价者角色。可选值:seller(卖家),buyer(买家)
	 **/
	private String role;
	
	/** 
	 * 交易ID
	 **/
	private Long tid;

	public void setAnony(Boolean anony) {
		this.anony = anony;
	}
	 public Boolean getAnony() {
		return this.anony;
	}
	public void setContent(String content) {
		this.content = content;
	}
	 public String getContent() {
		return this.content;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	 public Long getOid() {
		return this.oid;
	}
	public void setResult(String result) {
		this.result = result;
	}
	 public String getResult() {
		return this.result;
	}
	public void setRole(String role) {
		this.role = role;
	}
	 public String getRole() {
		return this.role;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.traderate.list.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("anony", this.anony);
		textParams.put("content", this.content);
		textParams.put("oid", this.oid);
		textParams.put("result", this.result);
		textParams.put("role", this.role);
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
