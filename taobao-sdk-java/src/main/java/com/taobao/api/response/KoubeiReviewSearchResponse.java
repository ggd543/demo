package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.KbListReview;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.review.search response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:58:34.0
 */
public class KoubeiReviewSearchResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8794687141974471111L;

	
	/** 
	 * 评论列表对象
	 **/
	@ApiListField("kb_list_reviews")
	@ApiField("kb_list_review")
	private List<KbListReview> kbListReviews;
	
	/** 
	 * 返回的点评总数，如：500，可以用于翻页时计算总页数
	 **/
	@ApiField("total_results")
	private Long totalResults;

	public void setKbListReviews(List<KbListReview> kbListReviews) {
		this.kbListReviews = kbListReviews;
	}

	public List<KbListReview> getKbListReviews( ) {
		return this.kbListReviews;
	}
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public Long getTotalResults( ) {
		return this.totalResults;
	}

	public String getApiMethodName() {
		return "taobao.koubei.review.search";
	}

}
