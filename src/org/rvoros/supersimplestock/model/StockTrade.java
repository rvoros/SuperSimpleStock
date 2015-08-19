package org.rvoros.supersimplestock.model;

/**
 * Class that represents the stock trade.
 * 
 * @author r.voros
 */
public class StockTrade {
	private long timestamp;
	private int quantity;
	private StockBuySellIndicator stockSellIndicator;
	private double tradePrice;

	/**
	 * @param timestamp
	 * @param quantity
	 * @param stockSellIndicator
	 * @param tradePrice
	 */
	public StockTrade(long timestamp, int quantity, StockBuySellIndicator stockSellIndicator, double tradePrice) {
		this.timestamp = timestamp;
		this.quantity = quantity;
		this.stockSellIndicator = stockSellIndicator;
		this.tradePrice = tradePrice;
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the stockSellIndicator
	 */
	public StockBuySellIndicator getStockSellIndicator() {
		return stockSellIndicator;
	}

	/**
	 * @param stockSellIndicator
	 *            the stockSellIndicator to set
	 */
	public void setStockSellIndicator(StockBuySellIndicator stockSellIndicator) {
		this.stockSellIndicator = stockSellIndicator;
	}

	/**
	 * @return the tradePrice
	 */
	public double getTradePrice() {
		return tradePrice;
	}

	/**
	 * @param tradePrice
	 *            the tradePrice to set
	 */
	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}
}
