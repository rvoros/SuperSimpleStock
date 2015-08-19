package org.rvoros.supersimplestock.states;

/**
 * Sell or Buy trade.
 * 
 * @author r.voros
 */
public class StateARecordTrade implements InputState{
	final private String stockName;

	public StateARecordTrade(String stockName) {
		this.stockName = stockName;
	}

	/** {@inheritDoc} */
	@Override
	public void apply(StateContext context) {
		InputState nextState = null;
		
		while(nextState == null){
			printHeader();

			System.out.print("Would you like to sell or buy? Please type sell or buy : ");
			final String inputType = context.getScanner().next();
			
			if("0".equals(inputType)){
				nextState = new StateASelectOperation(stockName);
			} else if(inputType != null && ("sell".equals(inputType.toLowerCase()) || "buy".equals(inputType.toLowerCase())) ){

				System.out.print("Please type the quantity: ");
				final int quantity = context.getScanner().nextInt();
				
				if(quantity == 0){
					nextState = new StateASelectOperation(stockName);
				} else if(quantity > 0){					
					System.out.print("Please type the price: ");
					final double price = context.getScanner().nextDouble();

					if(price == 0){
						nextState = new StateASelectOperation(stockName);
					} else if(price > 0){
						context.getModel().addTrade(stockName, inputType, quantity, price);
					}
				}
			}
		}
		
		context.setInputState(nextState);
		context.apply();
	}

	/**
	 * Print the prompt header for input.
	 */
	private void printHeader() {
		System.out.println();
		System.out.println("Selected stock is : " + stockName);
		System.out.println("To return to operation selection type 0");
	}
}
