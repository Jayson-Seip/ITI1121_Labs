import java.util.Random;
public class Customer{
	private int arrvivalTime;
	private int intialNumberOfItems;
	private int numberOfItems;
	private static final int MAX_NUM_ITEMS = 2;
	
	Customer(int arrvivalTime){
		Random r = new Random();
		this.arrvivalTime = arrvivalTime;
		this.intialNumberOfItems = r.nextInt(MAX_NUM_ITEMS-1)+1;
		this.numberOfItems = intialNumberOfItems;
		
	}
	public int getArrivalTime(){
		return arrvivalTime;
	}
	
	public int getNumberOfItems(){
		return this.numberOfItems;
	}
	public int getNumberOfServedItems(){
		return intialNumberOfItems - numberOfItems;
	}
	public void serve(){
		this.numberOfItems--;
	}
}