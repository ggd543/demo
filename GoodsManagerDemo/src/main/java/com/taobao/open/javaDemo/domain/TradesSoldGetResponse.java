package com.taobao.open.javaDemo.domain;

public class TradesSoldGetResponse {
	
	private int totalResults;
	private Trade[] trades ;
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public Trade[] getTrades() {
		return trades;
	}
	public void setTrades(Trade[] trades) {
		this.trades = trades;
	}
 
}
