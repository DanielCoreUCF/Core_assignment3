
public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	public void calculateMonthlyInterest(double balance) {
		double interest;
		savingsBalance = balance;
		for(int i = 1; i < 13; i++) {
			interest = savingsBalance * annualInterestRate / 12;
			savingsBalance = interest + savingsBalance;
			System.out.printf("Month %d\n   Interest: $%f Savings $%f\n",i, interest, savingsBalance);
		}
	}
	
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}

}
