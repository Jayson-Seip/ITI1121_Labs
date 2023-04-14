public class Q6{
	public static void main(String[] args){

		double[] arr = new double[]{80.6,75.4,49.7,50,21.5,36.5};
		arr = sort(arr);
		for(int i =0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println(calculateNumberFailed(arr));
		System.out.println(calculateMedian(arr));

	}

	public static double calculateAverage(double[] notes){
		double sum=0;
		double average=0;
		for(int i=0;i<notes.length;i++){
			sum+=notes[i];
		}
		average = sum/notes.length;
		return average;
	}

	public static double calculateMedian(double[] notes){
		notes = sort(notes);
		double median = 0;
		if(notes.length%2==1){
			median = notes[notes.length/2];
		}
		else{
			median = (notes[notes.length/2]+notes[(notes.length/2)-1])/2;
		}
		return median;
	}

	public static int calculateNumberFailed(double[] notes){
		int failed = 0;
		for(int i=0;i<notes.length;i++){
			if(notes[i]<50){
				failed++;
			}
		}
		return failed;
	}

	public static int calculateNumberPassed(double[] notes){
		int passed = 0;
		for(int i=0;i<notes.length;i++){
			if(notes[i]>=50){
				passed++;
			}
		}
		return passed;
	}
	
	public static double[] sort(double[] xs){

		int i, j, argMin;
		double tmp=0.0;

		for (i = 0; i < xs.length - 1; i++) {
			argMin = i;
			for (j = i + 1; j < xs.length; j++) {
				if (xs[j] < xs[argMin]) {
					argMin = j;
				}
			}

			tmp = xs[argMin];
			xs[argMin] = xs[i];
			xs[i] = tmp;
		}
		return xs;

	}


}