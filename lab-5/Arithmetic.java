public class Arithmetic extends AbstractSeries {

    // instance variables
	int s= 1;
	double sn = 0;

    public double next() {
		sn=s+sn;
		s++;
		return sn;
        
    }
}