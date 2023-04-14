public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		System.out.println("");
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
		int max,j;
		char temp = ' ';
		for(int i = 0;i<values.length;i++){
			max = i;
			for(j = i+1;j<values.length;j++){
				if(values[j]>values[max]){
					max = j;
				}
			}
			temp = values[max];
			values[max] = values[i];
			values[i] = temp;
		}

	}

}