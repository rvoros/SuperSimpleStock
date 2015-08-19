package org.rvoros.supersimplestock.states;

/**
 * Calculate the Dividend Yield.
 * 
 * @author r.v
 */
public class StateADividendYield implements InputState{
	final private String stockName;

	public StateADividendYield(String stockName) {
		this.stockName = stockName;
	}

	/** {@inheritDoc} */
	@Override
	public void apply(StateContext context) {
		InputState nextState = null;
		
		while(nextState == null){
			printHeader();

			final double input = context.getScanner().nextDouble();
			if(input > 0){
				runOperationA1(context, input);
			} else if(input == 0){
				nextState = new StateASelectOperation(stockName);
			}
		}
		
		context.setInputState(nextState);
		context.apply();
	}

	private void runOperationA1(StateContext context, double marketPrice) {
		final String name = context.getModel().getName();
		final double dividendYield = context.getModel().getDividendYield(stockName, marketPrice);
		System.out.println("The calculated dividend yield by market price " + marketPrice + " for stock " + name + " is : " + dividendYield);		
	}

	/**
	 * Print the prompt header for input.
	 */
	private void printHeader() {
		System.out.println();
		System.out.println("Selected stock is : " + stockName);
		System.out.println("Please type 0 to return to operation selection");
		System.out.println("Please type the market price greater than 0");
	}
}
