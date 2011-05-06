package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.KbDetailCoupon;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.coupon.get response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:56:51.0
 */
public class KoubeiCouponGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4879849914186638251L;

	
	/** 
	 * 返回KBDetailCoupon类型，其中包含展示detail必须的一些内容
	 **/
	@ApiField("kb_detail_coupon")
	private KbDetailCoupon kbDetailCoupon;

	public void setKbDetailCoupon(KbDetailCoupon kbDetailCoupon) {
		this.kbDetailCoupon = kbDetailCoupon;
	}

	public KbDetailCoupon getKbDetailCoupon( ) {
		return this.kbDetailCoupon;
	}

	public String getApiMethodName() {
		return "taobao.koubei.coupon.get";
	}

}
