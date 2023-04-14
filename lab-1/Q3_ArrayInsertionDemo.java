public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int[] newArray = new int[beforeArray.length+1];
		int counter = 0;
		for(int i =0;i<newArray.length;i++){
			if(i==indexToInsert){
			newArray[indexToInsert] = valueToInsert;
			}
			else{
				newArray[i]=beforeArray[counter];
				counter++;
			}
		}
		return newArray;
	}

	public static void main(String[] args){
		int[] a = new int[]{1,5,4,7,9,6};
		System.out.println("Array before Insertion");
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		int[]newArr = insertIntoArray(a,3,15);
		System.out.println("Array after insertion of 15 at position 3");
		for(int i=0;i<newArr.length;i++){
			System.out.println(newArr[i]);
		}
	}
}