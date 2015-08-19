package org.rvoros.supersimplestock.states;

import java.util.List;

/**
 * Select a stock to deal with.
 * 
 * @author r.voros
 */
public class StateASelectStock implements InputState {
	@Override
	public void apply(StateContext context) {
		InputState nextState = null;
		
		final List<String> stockNames = context.getModel().getStockNames();
		
		int idx = 0;
		
		while(nextState == null){
			System.out.println();
			System.out.println("Please type the stock id :");

			while (idx < stockNames.size()) {
				System.out.println(idx + " : " + stockNames.get(idx));
				idx++;
			}

			System.out.println(idx + " - Go back to the main menu");

			final int input = context.getScanner().nextInt();

			if(input == idx){
				nextState = new StateTopLevel();
			} else if (input < idx && input >= 0){
				nextState = new StateASelectOperation(stockNames.get(input));
			}
		}

		context.setInputState(nextState);
		context.apply();
	}
}
