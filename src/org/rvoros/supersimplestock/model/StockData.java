package org.rvoros.supersimplestock.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a data (row) for the stock model.
 * 
 * @author r.voros
 */
public class StockData {
	private String symbol;
	private StockType type;
	private Integer lastDivident;
	private Integer fixedDivident;
	private Integer parValue;
	private List<StockTrade> trades;
	
	/**
	 * Constructor for all field.
	 * 
	 * @param symbol the symbol name
	 * @param type the symbol type value
	 * @param lastDivident the last divident value
	 * @param fixedDivident the fixed divident
	 * @param parValue the par value
	 */
	public StockData(String symbol, StockType type, Integer lastDivident, Integer fixedDivident, Integer parValue) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDivident = lastDivident;
		this.fixedDivident = fixedDivident;
		this.parValue = parValue;
		this.trades = new ArrayList<>();
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the type
	 */
	public StockType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(StockType type) {
		this.type = type;
	}

	/**
	 * @return the lastDivident
	 */
	public Integer getLastDivident() {
		return lastDivident;
	}

	/**
	 * @param lastDivident
	 *            the lastDivident to set
	 */
	public void setLastDivident(Integer lastDivident) {
		this.lastDivident = lastDivident;
	}

	/**
	 * @return the fixedDivident
	 */
	public Integer getFixedDivident() {
		return fixedDivident;
	}

	/**
	 * @param fixedDivident
	 *            the fixedDivident to set
	 */
	public void setFixedDivident(Integer fixedDivident) {
		this.fixedDivident = fixedDivident;
	}

	/**
	 * @return the parValue
	 */
	public Integer getParValue() {
		return parValue;
	}

	/**
	 * @param parValue
	 *            the parValue to set
	 */
	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}

	public List<StockTrade> getTrades() {
		return trades;
	}

	public void setTrades(List<StockTrade> trades) {
		this.trades = trades;
	}

	public void addToTrades(StockTrade trade){
		this.trades.add(trade);
	}
}
