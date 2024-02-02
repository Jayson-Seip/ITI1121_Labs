public class Account{
	private double balance;
	 public Account(){
		this.balance = 0;
	}
	
	public void deposit(double amt){
		balance+=amt; //Increases balance by a given amount
		System.out.println("new balance="+balance+"$");
	}
	
	public void withdraw(double amt){
		if(amt> balance){
			throw new NotEnoughMoneyException(amt,balance);
		}
		balance-=amt; //Decreases balance by a given amount
		System.out.println("new balance="+balance+"$");
	} 
	
	public double getBalance(){
		return balance;
	} 
}