package ATM;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;

public class CalculateMoneyAtm {
	static Integer initialtwothousandrupees = 0;
	static Integer initialhundressrupees = 0;
	static Integer initialfiftyrupees = 0;
	static Integer initialtenrupees = 0;

	static Integer twothousandrupees = 0;
	static Integer hundressrupees = 0;
	static Integer fiftyrupees = 0;
	static Integer tenrupees = 0;
	static Integer totalAmount = 0;

	public static void main(String[] args) {

		ATMStatus atmStatus = new ATMStatus();
		getMoney(atmStatus);

	}// end of psvm

	public static void reRun(ATMStatus atmStatus) {
		// MyLog.logit().info("Would u like to credit more money ? y/n");
		System.out.println("Would u like to credit more money ? y/n ");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		if (choice.equals("y") || choice.equals("Y")) {
			getMoney(atmStatus);
		}
		if (choice.equals("n") || choice.equals("N")) {
			System.exit(1);
		} else {
			// MyLog.logit().log(Level.SEVERE, "Invalid Input :"+choice);
			System.out.println("Invalid Input");
		}
		reRun(atmStatus);
	}

	public static void getMoney(ATMStatus atmStatus) {
		twothousandrupees = 0;
		hundressrupees = 0;
		fiftyrupees = 0;
		tenrupees = 0;
		totalAmount = 0;
		Integer amountInt = 0;
		System.out.println("Currency Avaialbe in ATM");
		for (String key : atmStatus.getAvaialableMoney().keySet()) {
			System.out.println(atmStatus.getAvaialableMoney().get(key) + ":"
					+ key + " Notes");
		}

		for (String key : atmStatus.getAvaialableMoney().keySet()) {
			if (key.equals("2000"))
				initialtwothousandrupees = atmStatus.getAvaialableMoney().get(
						key);
			if (key.equals("100"))
				initialhundressrupees = atmStatus.getAvaialableMoney().get(key);
			if (key.equals("50"))
				initialfiftyrupees = atmStatus.getAvaialableMoney().get(key);
			if (key.equals("10"))
				initialtenrupees = atmStatus.getAvaialableMoney().get(key);
		}
		totalAmount = ((initialtwothousandrupees * 2000)
				+ (initialhundressrupees * 100) + (initialfiftyrupees * 50) + (initialtenrupees * 10));
		System.out.println("Total Available amount in ATM : " + totalAmount);

		Scanner input = new Scanner(System.in);
		System.out.print("Enter Money > ");
		String amount = input.nextLine();
		try {
			try {
				amountInt = Integer.parseInt(amount);
				if (amountInt % 10 != 0) {
					System.out
							.println("Please enter amount in multiple of 10 ");
					reRun(atmStatus);
				}
			} catch (NumberFormatException ne) {
				// MyLog.logit().log(Level.SEVERE, ne.getMessage());
				ne.printStackTrace();
			}
			System.out.print("Required Amount : ");
			System.out.println(amount);

			totalAmount = ((initialtwothousandrupees * 2000)
					+ (initialhundressrupees * 100) + (initialfiftyrupees * 50) + (initialtenrupees * 10));
			System.out
					.println("Total Available amount in ATM : " + totalAmount);
			if (totalAmount < amountInt) {
				System.out
						.println("Total Avaialble amount is less in atm, Sorry for Inconvience");
				reRun(atmStatus);
			}

			while (amountInt >= 2000 && initialtwothousandrupees > 0) {
				initialtwothousandrupees = initialtwothousandrupees - 1;
				twothousandrupees++;
				amountInt = amountInt - 2000;
			}

			while (amountInt >= 100 && initialhundressrupees > 0) {
				initialhundressrupees = initialhundressrupees - 1;
				hundressrupees++;
				amountInt = amountInt - 100;
			}

			while (amountInt >= 50 && initialfiftyrupees > 0) {
				initialfiftyrupees = initialfiftyrupees - 1;
				fiftyrupees++;
				amountInt = amountInt - 50;
			}
			while (amountInt >= 10 && initialtenrupees > 0) {
				initialtenrupees = initialtenrupees - 1;
				tenrupees++;
				amountInt = amountInt - 10;
			}
			if (amountInt > 0) {
				System.out.println("No avalable balance in this unit");
				reRun(atmStatus);
			} else {
				System.out.println("Plz take your money in currency");
				Map<String, Integer> avaialableMoney = new HashMap<String, Integer>();
				System.out.println("     No of 2000:" + twothousandrupees);
				System.out.println("     No of 100:" + hundressrupees);
				System.out.println("     No of 50:" + fiftyrupees);
				System.out.println("     No of 10:" + tenrupees);
				avaialableMoney.put("2000", (initialtwothousandrupees));
				avaialableMoney.put("100", (initialhundressrupees));
				avaialableMoney.put("50", (initialfiftyrupees));
				avaialableMoney.put("10", (initialtenrupees));
				atmStatus.setAvaialableMoney(avaialableMoney);
			}
			// return amountInt;
		} catch (Exception e) {
			// MyLog.logit().log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Take your Amount = "
				+ (2000 * twothousandrupees + 100 * hundressrupees + 50
						* fiftyrupees + 10 * tenrupees));
		reRun(atmStatus);

	}// end of getMoney
}
