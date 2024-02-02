import static java.lang.Math.*;
public class Geometric extends AbstractSeries {

    // instance variables
	private int power = 0;
	private double r =1;
	boolean firstTime = true;
    
    public double next() {
		if(firstTime){
			power++;
			firstTime = false;
			return r;
		}
		else{
			r = r + 1/Math.pow(2,power);
			power++;
			return r;
		}



        // implement the method

    }
}