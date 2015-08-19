package org.rvoros.supersimplestock.states;

/**
 * Calculate the P/E ration.
 * 
 * @author r.voros
 */
public class StateAPeRation implements InputState{
	final private String stockName;

	public StateAPeRation(String stockName) {
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
				runOperationA2(context, input);
			} else if(input == 0){
				nextState = new StateASelectOperation(stockName);
			}
		}
		
		context.setInputState(nextState);
		context.apply();
	}

	private void runOperationA2(StateContext context, double marketPrice) {
		final String name = context.getModel().getName();
		final double dividendYield = context.getModel().getPeRatio(stockName, marketPrice);
		System.out.println("The calculated P / E ratio by market price " + marketPrice + " for stock " + name + " is : " + dividendYield);		
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
