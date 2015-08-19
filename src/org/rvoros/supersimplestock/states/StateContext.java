package org.rvoros.supersimplestock.states;

import java.util.Scanner;

import org.rvoros.supersimplestock.model.StockModel;

/**
 * The state context for the input states.
 * 
 * @author r.voros
 */
public class StateContext {
	final private Scanner scanner;
	final private StockModel model;
	private InputState inputState;

	public StateContext(StockModel model) {
		this.scanner = new Scanner(System.in);
		this.model = model;
		setInputState(new StateTopLevel());
	}

	public void setInputState(InputState inputState) {
		this.inputState = inputState;
	}

	public StockModel getModel() {
		return model;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void apply(){
		this.inputState.apply(this);
	}
}
