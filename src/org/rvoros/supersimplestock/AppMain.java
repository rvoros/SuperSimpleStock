package org.rvoros.supersimplestock;

import org.rvoros.supersimplestock.model.StockData;
import org.rvoros.supersimplestock.model.StockModel;
import org.rvoros.supersimplestock.model.StockType;
import org.rvoros.supersimplestock.states.StateContext;

public class AppMain {
	public static void main(String[] args) {
		final StockModel model = new StockModel("Global Beverage Corporation Exchange");
		model.addData(new StockData("TEA", StockType.COMMON, 0, null, 100));
		model.addData(new StockData("POP", StockType.COMMON, 8, null, 100));
		model.addData(new StockData("ALE", StockType.COMMON, 23, null, 60));
		model.addData(new StockData("GIN", StockType.PREFERRED, 8, 2, 100));
		model.addData(new StockData("JOE", StockType.COMMON, 13, null, 250));

		final StateContext sc = new StateContext(model);
		sc.apply();
		sc.getScanner().close();
	}
}
