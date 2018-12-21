
public class CheckingAccount extends BankAccount
{
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	
	private int numTransactions  = 0;
	
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(n);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		
	}
	
	public void deposit(double amt)
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException();
		}
		else 
		{
			
			super.deposit(amt);
			
			if(numTransactions > FREE_TRANS)
			 super.withdraw(TRANSACTION_FEE);
			
			numTransactions++;
		}
			
		
	}
	public void withdraw(double amt)
	{
		if(getBalance() > 0 || amt > 0)
			
		{
		super.withdraw(amt);
		
		if(numTransactions >= FREE_TRANS)
		 super.withdraw(TRANSACTION_FEE);
		
		if(getBalance() <  0)
			super.withdraw(OVER_DRAFT_FEE);
		numTransactions++;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	public void transfer(BankAccount other, double amt)
	{
		if((other.getName()).equals(getName()))
		{
			if(getBalance() >= amt )
			{
				super.transfer(other, amt);
				if(getBalance()  > 0)
				{
					numTransactions++;
				}
				else
				{
					throw new IllegalArgumentException();
				}
				
				return;
			}
			}
		throw new IllegalArgumentException();
			}
	public  void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
}
 