package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.GuarantyFund;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.guarantyfunds.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-23 20:13:33.0
 */
public class GuarantyfundsGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1271627442639284394L;

	
	/** 
	 * B商家保证金使用记录，最大返回1000条记录。 
如果不传入开始日期和结束日期，则返回所有不超过1000条的记录 
如果只传入开始日期，不传入结束日期，则返回开始日期以后创建的所有不超过1000条的记录 
如果只传入结束日期，不传入开始日期，则返回结束日期以前创建的所有不超过1000条的记录
	 **/
	@ApiListField("guarantyFunds")
	@ApiField("guaranty_fund")
	private List<GuarantyFund> guarantyFunds;

	public void setGuarantyFunds(List<GuarantyFund> guarantyFunds) {
		this.guarantyFunds = guarantyFunds;
	}

	public List<GuarantyFund> getGuarantyFunds( ) {
		return this.guarantyFunds;
	}

	public String getApiMethodName() {
		return "taobao.guarantyfunds.get";
	}

}
