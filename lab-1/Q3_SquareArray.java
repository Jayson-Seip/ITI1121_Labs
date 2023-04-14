public class Q3_SquareArray{

	public static int[] createArray(int size) 
	{
		int[] a;
		a = new int[size];
		for(int i = 0 ;i<a.length;i++)
		{
			a[i] = i*i;
		}
		return a;
	}

	public static void main(String[] args){
		
		int[] a = createArray(14);
		for(int i =0 ;i<a.length;i++){
			System.out.println("The square of "+i+" is: "+a[i]);
		}
	}
}