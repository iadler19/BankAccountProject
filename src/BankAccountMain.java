import java.util.*;

public class BankAccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
	 final double OVER_DRAFT_FEE = 15;
	final double RATE = .0025;
	final double TRANSACTION_FEE = 1.5;
	final double MIN_BAL = 300;
	final double MIN_BAL_FEE = 10;
	final int FREE_TRANSACTIONS = 10;

	
	Scanner in = new Scanner(System.in);
	System.out.println("Would you like to add an account, make a transaction, or terminate the program: Type add, transact, or terminate to do so.");
	String ans = in.next();
	in.nextLine();
	while(!(ans.toLowerCase()).equals("add") && !(ans.toLowerCase()).equals("transact") && !(ans.toLowerCase()).equals("terminate"))
	{
		System.out.print("Please enter a valid answer:");
		ans = in.next();
		in.nextLine();
	}
	
	if( (ans.toLowerCase()).equals("add"))
			{
	
		System.out.println("What type of account would you like to make? Checking or savings?");
		String accountType = in.next();
		in.nextLine();
		while(!(accountType.toLowerCase()).equals("checking") && !(accountType.toLowerCase()).equals("savings"))
		{
			System.out.print("Please enter a valid answer:");
			accountType = in.next();
			in.nextLine();
		}
		if((accountType.toLowerCase()).equals("checking"))
		{
			System.out.println("Please enter your name:");
			String name = in.next();
			in.nextLine();
			System.out.println("What is your initial deposit:");
			double bal = in.nextDouble();
			in.nextLine();
			CheckingAccount checking = new CheckingAccount(name, bal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS);
			accounts.add(checking);
		}
		if((accountType.toLowerCase()).equals("savings"))
		{
			System.out.println("Please enter your name:");
			String name = in.next();
			in.nextLine();
			System.out.println("What is your initial deposit:");
			double bal = 0;
			in.nextLine();
			boolean dean = true;
			while(dean)
			{
				try
				{
						bal = in.nextDouble();
			}
				catch(NumberFormatException e)
				{
					System.out.println("Please enter a Number value:");
					bal = in.nextDouble();
				}
			}
			
			{
				System.out.print("Please enter a valid answer:");
				ans = in.next();
				in.nextLine();
			}
			
			SavingsAccount  savings = new SavingsAccount(name, bal,  RATE, MIN_BAL, MIN_BAL_FEE);
			accounts.add(savings);
		}
			}
	}

}
