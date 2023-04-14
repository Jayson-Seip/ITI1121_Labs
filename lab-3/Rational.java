public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
		 this.denominator = 1;
		 reduce();
    }

    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
		 this.denominator = denominator;
		 reduce();

    }

    // getters
    public int getNumerator() {
	     return this.numerator;
    }
    public int getDenominator() {
	     return this.denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
		this.numerator = this.numerator*other.denominator;
		other.numerator = other.numerator*this.denominator;
		
		int newNumerator = this.numerator+other.numerator;
		int newDenominator = this.denominator*other.denominator;
		
	    Rational rational = new Rational(newNumerator,newDenominator);
		rational.reduce();
		return rational;
    }

    public static Rational plus(Rational a, Rational b) {
		a.numerator = a.numerator*b.denominator;
		b.numerator = b.numerator*a.denominator;
		
		int newNumerator = a.numerator+b.numerator;
		int newDenominator = a.denominator*b.denominator;
    	
		 Rational rational = new Rational(newNumerator,newDenominator);
		 rational.reduce();
		
		return rational;
    }

    // Transforms this number into its reduced form

    private void reduce() {
      int commonDivisor = gcd(this.numerator, this.denominator);
	  this.numerator = this.numerator/commonDivisor;
	  this.denominator = this.denominator/commonDivisor;
	  
	  
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
		if(a<0){
			a = a*-1;
		}
		if(b<0){
			b=b*-1;
		}

    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
		int num1 = 0;
		int num2 = 0;
      num1 = this.numerator*other.denominator;
	  num2= other.numerator*this.denominator;
	  if(num1 < num2){
		  return -1;
	  }
	  else if(num1 == num2){
		  return 0;
	  }
	  else{
		  return 1;
	  }
    }

    public boolean equals(Rational other) {
      this.numerator = this.numerator*other.denominator;
	  other.numerator = other.numerator*this.denominator;
	  return this.numerator == other.numerator;
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = this.numerator+"";
    	} else {
    	    result = this.numerator+"/"+this.denominator;
    	}
    	return result;
    }

}