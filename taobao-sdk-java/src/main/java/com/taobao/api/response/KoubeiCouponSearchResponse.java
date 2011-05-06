package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.KbListCoupon;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.coupon.search response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:57:11.0
 */
public class KoubeiCouponSearchResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7191273196261326486L;

	
	/** 
	 * 返回KBListCoupon的List，其中包含List展示所需的对象列表
	 **/
	@ApiListField("kb_list_coupons")
	@ApiField("kb_list_coupon")
	private List<KbListCoupon> kbListCoupons;
	
	/** 
	 * 查询结果总数
	 **/
	@ApiField("total_results")
	private Long totalResults;

	public void setKbListCoupons(List<KbListCoupon> kbListCoupons) {
		this.kbListCoupons = kbListCoupons;
	}

	public List<KbListCoupon> getKbListCoupons( ) {
		return this.kbListCoupons;
	}
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public Long getTotalResults( ) {
		return this.totalResults;
	}

	public String getApiMethodName() {
		return "taobao.koubei.coupon.search";
	}

}
