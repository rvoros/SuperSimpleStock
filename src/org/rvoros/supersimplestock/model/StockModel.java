package org.rvoros.supersimplestock.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the stock model.
 * 
 * @author r.voros
 */
public class StockModel {
	/**
	 * The name of the stock
	 */
	final private String name;

	/**
	 * The data rows in the stock 
	 */
	private List<StockData> data = new ArrayList<StockData>();

	/**
	 * Constructor.
	 * 
	 * @param name the name of the stock
	 */
	public StockModel(String name) {
		this.name = name;
	}

	/**
	 * @return the name of the stock
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Add stock data to the stock.
	 * 
	 * @param stockData the new stock data
	 */
	public void addData(StockData stockData){
		this.data.add(stockData);
	}

	/**
	 * Get the stock names. (symbols)
	 * 
	 * @return the list of the stock symbols
	 */
	public List<String> getStockNames() {
		final List<String> stockNames = new ArrayList<>();
		for (StockData stockData : data) {
			stockNames.add(stockData.getSymbol());
		}
		return stockNames;
	}

	/**
	 * Used to find stock data according the stock symbol
	 * 
	 * @param stock the name (symbol) of the stock
	 * @return the stock data or else null
	 */
	private StockData findDataBySymbol(String stock) {
		StockData ret = null;
		for (StockData stockData : data) {
			if(stockData.getSymbol().equals(stock)){
				ret = stockData;
				break;
			}
		}
		return ret;
	}
	
	/**
	 * Calculates the geometric mean of the stock.
	 * 
	 * @return the geometric mean of the stock.
	 */
	public double getGeometricMean() {
		double product = 1.0;
		for (StockData stockData : data) {
			product *= stockData.getParValue();
		}
		return Math.pow(product, 1.0 / data.size());
	}

	/**
	 * Calculates the volume weighted stock price.
	 * 
	 * @param stock the stock name (symbol)
	 * @param minutes the minutes to deal with
	 * @return the volume weighted stock price
	 */
	public double getVolumeWeightedStockPrice(String stock, int minutes) {
		long bottomTime = System.currentTimeMillis() - (15 * 60000);

		double d1 = 0.0;
		double d2 = 0.0;
		
		StockData stockData = findDataBySymbol(stock);
		if(stockData != null){
			for (StockTrade stockTrade : stockData.getTrades()) {
				if(stockTrade.getTimestamp() > bottomTime){
					d1 += stockTrade.getTradePrice() * stockTrade.getQuantity();
					d2 += stockTrade.getQuantity();
				}
			}
		}

		if(d2 > 0.0){
			return d1 / d2;
		} else {
			return 0.0;
		}
	}

	/**
	 * Calculate the dividend yield.
	 * 
	 * @param stock the name (symbol) of stock to deal with
	 * @param marketPrice the marketprice
	 * @return the calculated dividend yield
	 */
	public double getDividendYield(String stock, double marketPrice) {
		double ret = 0.0;
		StockData data = findDataBySymbol(stock);
		if(data != null){
			if(data.getType() == StockType.COMMON){
				ret = data.getLastDivident() / marketPrice;
			} else {
				ret = ((data.getFixedDivident() / 100) * data.getParValue()) / marketPrice;
			}
		}
		return ret;
	}

	/**
	 * Calculate P / E ration of the stock.
	 * @param stock the name of the stock 
	 * @param marketPrice the market price
	 * @return the calculated P/E ratio
	 */
	public double getPeRatio(String stock, double marketPrice) {
		double ret = 0.0;
		StockData data = findDataBySymbol(stock);
		if(data != null){
			ret = marketPrice / data.getLastDivident();
		}
		return ret;
	}

	/**
	 * Add a new trade to the stock.
	 * 
	 * @param stock the name of the stock
	 * @param inputType input type (sell or buy)
	 * @param quantity the amount
	 * @param price the price
	 */
	public void addTrade(String stock, String inputType, int quantity, double price) {
		StockData data = findDataBySymbol(stock);
		if(data != null){
			if("sell".equals(inputType)){
				data.addToTrades(new StockTrade(System.currentTimeMillis(), quantity, StockBuySellIndicator.SELL, price));
			} else if("buy".equals(inputType)){
				data.addToTrades(new StockTrade(System.currentTimeMillis(), quantity, StockBuySellIndicator.BUY, price));
			}
		}
	}
}
