import java.util.*;

public class BankAccountMain {
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isNumeric(String str)
	{	
	try	
	{
		
			Double.parseDouble(str);
			return true;
	}
	catch(IllegalArgumentException e)
	{
		return false;
	}
	}
	 private static String firstPrompt()
	 {
		 System.out.println("Would you like to add an account, make a transaction, or terminate the program: Type add, transact, or terminate to do so.");
			String ans = in.next();
			in.nextLine();
			while(!(ans.toLowerCase()).equals("add") && !(ans.toLowerCase()).equals("transact") && !(ans.toLowerCase()).equals("terminate"))
			{
				System.out.println("Please enter a valid answer:");
				ans = in.next();
				in.nextLine();
			}
	 }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
	 final double OVER_DRAFT_FEE = 15;
	final double RATE = .0025;
	final double TRANSACTION_FEE = 1.5;
	final double MIN_BAL = 300;
	final double MIN_BAL_FEE = 10;
	final int FREE_TRANSACTIONS = 10;
boolean tf = true;
	while(tf)
	{
	
	Scanner in = new Scanner(System.in);
	System.out.println("Would you like to add an account, make a transaction, or terminate the program: Type add, transact, or terminate to do so.");
	String ans = in.next();
	in.nextLine();
	while(!(ans.toLowerCase()).equals("add") && !(ans.toLowerCase()).equals("transact") && !(ans.toLowerCase()).equals("terminate"))
	{
		System.out.println("Please enter a valid answer:");
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
			System.out.println("Please enter a valid answer:");
			accountType = in.next();
			in.nextLine();
		}
		if((accountType.toLowerCase()).equals("checking"))
		{
			System.out.println("Please enter your name:");
			String name = in.next();
			in.nextLine();
			System.out.println("What is your initial deposit:");
			
			//checks if string or negative
			String inBal = in.nextLine();
			while(!isNumeric(inBal) || Double.parseDouble(inBal)<0)
			{
					System.out.println("Please enter a valid answer:");
					
				}
				double bal = Double.parseDouble(inBal);
			
			CheckingAccount checking = new CheckingAccount(name, bal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS);
			accounts.add(checking);
			System.out.println(checking.toString());
			
			
		}
		if((accountType.toLowerCase()).equals("savings"))
		{
			System.out.println("Please enter your name:");
			String name = in.next();
			in.nextLine();
			System.out.println("What is your initial deposit:");
			
			String inBal = in.nextLine();
			while(!isNumeric(inBal) || Double.parseDouble(inBal)<0)
			{
					System.out.println("Please enter a valid answer:");
					
				}
				double bal = Double.parseDouble(inBal);
			SavingsAccount  savings = new SavingsAccount(name, bal,  RATE, MIN_BAL, MIN_BAL_FEE);
			accounts.add(savings);
			System.out.println(savings.toString());
		}
			
	
			}
	
	else if( ans.toLowerCase().equals("transact"))
	{
		System.out.println("What kind of Transaction would you like to make? Withdraw, deposit, transfer, or get account numbers?");
		String transactionType = in.next();
		while(!(transactionType.toLowerCase()).equals("withdraw") && !(transactionType.toLowerCase()).equals("deposit") && !(transactionType.toLowerCase()).equals("transfer") && !(transactionType.toLowerCase()).equals("get account numbers"))
		{
			System.out.println("Please enter a valid answer:");
			transactionType = in.next();
			in.nextLine();
		}
			
		switch(transactionType)
			{
		case "withdraw":
	{
		System.out.println("What is the Account Number of the account you want to withdraw from?");
		
		while(!isNumeric(in.next()) || in.nextInt() > accounts.size())
		{
			System.out.println("Please enter a valid answer:");
			  in.nextLine();
			
		}
		int accNumW = in.nextInt();
		System.out.println("How much money would you like to withdraw?");
		
		try
		{
		(accounts.get(accNumW - 1)).withdraw(in.nextDouble());
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Transaction not authorized");
		}
		
	}
		case "deposit":
			
		{
			System.out.println("What is the Account Number of the account you want to deposit into?");
			String inAccNum = in.nextLine();
			while(!isNumeric(inAccNum) || Integer.parseInt(inAccNum) > accounts.size())
			{
				System.out.println("Please enter a valid answer:");
				inAccNum = in.nextLine();
			}
			int accNumD = Integer.parseInt(inAccNum);
			System.out.println("How much money would you like to deposit?");
			while(!isNumeric(in.next()) || in.nextDouble() < 0)
			{
				
				System.out.print("Please enter a valid answer:");
				
			}
			
			try
			{
			(accounts.get(accNumD - 1)).deposit(in.nextDouble());
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Transaction not authorized");
			}	
		}
		
		case "transfer":
		{
			System.out.println("What is the Account Number of the account you want to transfer from?");
			
			while(!isNumeric(in.next()) || in.nextInt() > accounts.size())
			{
				System.out.println("Please enter a valid answer:");
			}
			int accNum1 = in.nextInt();
			System.out.println("What is the Account Number of the account you want to transfer  to?");
			
			while(!isNumeric(in.next()) || in.nextInt() > accounts.size())
			{
				System.out.println("Please enter a valid answer:");	
			}
			int accNum2 = in.nextInt();
			System.out.println("How much money would you like to transfer?");
			while(!isNumeric(in.next()) || in.nextDouble() < 0)
			{
				
				System.out.print("Please enter a valid answer:");
				
			}
			double amt = in.nextDouble();
			try
			{
				(accounts.get(accNum1 -1)).transfer((accounts.get((accNum2)-1)), amt);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Transaction not Authorized");
			}
		}
		
		case "get account number" :
		{
			for( BankAccount acc : accounts)
			{
				System.out.println(acc.toString());
			}
		}
		
		
		}
	

	}
	else if((ans.toLowerCase()).equals("terminate"))
	{
		return ;
	}
	}
	}
	}
