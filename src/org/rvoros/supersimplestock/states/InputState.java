package org.rvoros.supersimplestock.states;

/**
 * Interface that represents an input state.
 * 
 * @author r.voros
 */
public interface InputState {

	/**
	 * Apply the the state.
	 * @param context
	 */
	public void apply(StateContext context);
}
