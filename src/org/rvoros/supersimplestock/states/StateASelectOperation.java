package org.rvoros.supersimplestock.states;

/**
 * Select operation for selected stock.
 * @author r.voros
 */
public class StateASelectOperation implements InputState {
	private final String stockName;
	
	public StateASelectOperation(String stockName) {
		this.stockName = stockName;
	}

	/** {@inheritDoc} */
	@Override
	public void apply(StateContext context) {
		InputState nextState = null;
		
		while(nextState == null){
			printHeader();

			final int input = context.getScanner().nextInt();
			
			switch (input) {
			case 1:
				nextState = new StateADividendYield(stockName);
				break;
			case 2:
				nextState = new StateAPeRation(stockName);
				break;
			case 3:
				nextState = new StateARecordTrade(stockName);
				break;			
			case 4:
				runOperationA4(context);
				break;			
			case 5:
				nextState = new StateASelectStock();
				break;			
			}
		}
		
		context.setInputState(nextState);
		context.apply();
	}

	private void runOperationA4(StateContext context) {
		final int minutes = 15;
		final String name = context.getModel().getName();
		final double volumeWeightStockPrice = context.getModel().getVolumeWeightedStockPrice(stockName, minutes);
		System.out.println("The Volume Weighted Stock Price based on trades in past " + minutes + " minutes for " + name + " is : " + volumeWeightStockPrice);
	}

	/**
	 * Print the prompt header for input.
	 */
	private void printHeader() {
		System.out.println();
		System.out.println("Selected stock is : " + stockName);
		System.out.println("1 - Given a market price as input, calculate the dividend yield");
		System.out.println("2 - Given a market price as input,  calculate the P/E Ratio");
		System.out.println("3 - Record a trade, with timestamp, quantity of shares, buy or sell indicator and trade price");
		System.out.println("4 - Calculate Volume Weighted Stock Price based on trades in past 15 minutes");
		System.out.println("5 - Go back to stock selection.");
		System.out.print("Please type 1 , 2 , 3 , 4 or 5 : ");
	}
}
