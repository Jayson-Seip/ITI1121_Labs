public class Cashier{
	private Queue<Customer> queue;
	private Customer currentCustomer;
	private int totalCustomerWaitTime;
	private int customersServed;
	private int totalItemsServed;
	private boolean serving = false;
	
	private static final String nl = System.getProperty( "line.separator" );
	
	
	Cashier(){
		this.queue = new ArrayQueue<Customer>();
		this.totalCustomerWaitTime = 0;
		this.customersServed = 0;
		this.totalItemsServed = 0;
	}
	
	public void addCustomer(Customer c){
		queue.enqueue(c);
	}
	public int getQueueSize(){
		return queue.size();
	}
	public void serveCustomers(int currentTime){
		if(queue.isEmpty()){
			return;
		}
		if(!serving){
			currentCustomer = queue.dequeue();
			serving = true;
		}
		if(serving){
			totalItemsServed++;
			currentCustomer.serve();
			
			if(currentCustomer.getNumberOfItems()==0){
				this.customersServed+=1;
				serving = false;
			}
					
			totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
		}
	}
	
	public int getTotalCustomerWaitTime(){
		return totalCustomerWaitTime;
	}
	public int getTotalCustomersServed(){
		return this.customersServed;
	}
	public int getTotalItemsServed(){
		return totalItemsServed;
	}
	
	public String toString(){
		StringBuffer results = new StringBuffer();

        results.append( "The total number of customers served is " );
        results.append( customersServed );
        results.append( nl );

        results.append( "The average number of items per customer was " );
		
        results.append( totalItemsServed / customersServed );
        results.append( nl );

        results.append( "The average waiting time (in seconds) was " );
        results.append( totalCustomerWaitTime / customersServed );
        results.append( nl );

        return results.toString();
	
	}
	
}