public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination = combination;
		this.open = false;
		this.numberOfAttempts = 0;
		this.activated = true;
    }

    // Access methods.

    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {
		this.numberOfAttempts++;
		if(isActivated()){
			if(this.combination.equals(combination)){
			this.numberOfAttempts = 0;
			this.open = true;
		}
		else if(this.numberOfAttempts == MAX_NUMBER_OF_ATTEMPTS){
			this.activated = false;
			this.open = false;
		}
		}
		
		
        // Put your code here, then remove the line below.
		
        return open;
    }

    public void activate( Combination c ) {
		if(this.combination.equals(c)){
			this.activated = true;
		}
		else{
			this.activated = false;
			numberOfAttempts = 0;
		}
        // Put your code here, then remove this comment.
    }

}