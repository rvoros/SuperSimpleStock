package org.rvoros.supersimplestock.states;

/**
 * The top level state for interaction with the user.
 * 
 * @author r.voros
 */
public class StateTopLevel implements InputState {

	/** {@inheritDoc} */
	@Override
	public void apply(StateContext context) {
		InputState nextState = null;

		while(nextState == null){
			printHeader();

			final int input = context.getScanner().nextInt();
			
			switch (input) {
			case 1:
				nextState = new StateASelectStock();
				break;
			case 2:
				runOperationB(context);
				break;
			case 3:
				nextState = new StateExitApp();
				break;			
			}
		}

		context.setInputState(nextState);
		context.apply();
	}

	/**
	 * Print the header for input.
	 */
	private void printHeader() {
		System.out.println();
		System.out.println("Please type 1 , 2 or 3");
		System.out.println("1 - Do an operation on a stock.");
		System.out.println("2 - Calculate All Share Index using the geometric mean of prices for all stocks.");
		System.out.println("3 - Exit from the app.");
	}

	public void runOperationB(StateContext context) {
		final String name = context.getModel().getName();
		final double geometricMean = context.getModel().getGeometricMean();
		System.out.println("The geometric mean for " + name + " is : " + geometricMean);
	}
}
