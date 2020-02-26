public class SavingsAccountTest{
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		
		SavingsAccount.modifyInterestRate(.4);
		System.out.printf("\nYour monthly interest rates for an annual rate of 4%% are as follows:\n");
		System.out.printf("\nSavings account 1\n");
		saver1.calculateMonthlyInterest(2000.00);
		System.out.printf("\nSavings account 2\n");
		saver2.calculateMonthlyInterest(3000.00);
		
		
		SavingsAccount.modifyInterestRate(.5);
		System.out.printf("\nYour monthly interest rates for an annual rate of 5%% are as follows:\n");
		System.out.printf("\nSavings account 1\n");
		saver1.calculateMonthlyInterest(2000.00);
		System.out.printf("\nSavings account 2\n");
		saver2.calculateMonthlyInterest(3000.00);
	}
}
//Month 12 savings = total savings