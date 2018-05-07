package ATM;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ATMStatus {
	public Map<String, Integer> avaialableMoney = new HashMap<String, Integer>();

	public ATMStatus() {
		// MyLog.logit().log(Level.INFO, " ATMStatus Initialized");
		System.out.println(" ATMStatus Initialized");
		avaialableMoney.put("2000", 10);
		avaialableMoney.put("100", 10);
		avaialableMoney.put("50", 10);
		avaialableMoney.put("10", 10);
	}

	public Map<String, Integer> getAvaialableMoney() {
		return this.avaialableMoney;
	}

	public void setAvaialableMoney(Map<String, Integer> avaialableMoney) {
		this.avaialableMoney = avaialableMoney;
	}

}
