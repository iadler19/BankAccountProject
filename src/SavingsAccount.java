
public class SavingsAccount extends BankAccount {

	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	
	/**
	 * 
	 * 
	 * @param n
	 * @param b
	 * @param r
	 * @param mb
	 * @param mbf
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
		
	}
	/**
	 * 
	 * @param n
	 * @param r
	 * @param mb
	 * @param mbf
	 */
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * 
	 */
	public void withdraw(double amt)
	{
					
			if(amt > 0 && getBalance() >= amt )
			{
				super.withdraw(amt);
			if(getBalance() - amt < MIN_BAL)
				super.withdraw(MIN_BAL_FEE);
			}
			else
		{
			throw new IllegalArgumentException();
		}
	}
	/**
	 * 
	 */
	public void transfer(BankAccount other, double amt)
	{
		if((other.getName()).equals(getName()))
		{
			if(getBalance() >= amt)
			{
				super.transfer(other, amt);
				
				return;
			}
			}
		throw new IllegalArgumentException();
			}
	
	/**
	 * 
	 */
	public void addInterest()
	{
		deposit(getBalance() * intRate);
	}
	public void endOfMonthUpdate()
	{
		addInterest();
	}
	}
