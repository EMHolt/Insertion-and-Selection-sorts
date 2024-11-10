import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorting {
	
	private static List<Integer> myList;
	private static Integer[] myArray;
	private static final int N = 100;
	
	public static void main(String[] args)
	{
		generate();
		System.out.println(listString());
		System.out.println(arrayString());
	}
	
	public static void insertionSort(List<Integer> a)
	{
		// todo - noah
	}

	public boolean selectionSort(Comparable[] a) {
	    for (int endOfArrayIndex = a.length - 1; endOfArrayIndex > 0; endOfArrayIndex--) {
	        Comparable max = a[0];
	        int maxIndex = 0;

	        for (int i = 1; i <= endOfArrayIndex; i++) {
	            if (a[i].compareTo(max) > 0) { 
	                max = a[i];
	                maxIndex = i;
	            }
	        }
	        Comparable temp = a[maxIndex];
	        a[maxIndex] = a[endOfArrayIndex];
	        a[endOfArrayIndex] = temp;
	    }
	    return true;
	}
	
	private static void generate()
	{
		myList = new ArrayList<Integer>(N);
		myArray = new Integer[N];
		for (int i = 0; i < N; i++)
		{
			Random rand = new Random();
			Integer r = rand.nextInt(200) - 100;
			myList.add(r);
			myArray[i] = r;
		}
	}
	
	private static String arrayString()
	{
		String result = "";
		for (int i = 0; i < myArray.length; i++)
		{
			result += myArray[i].toString();
			if (i != myArray.length - 1)
			{
				result += ", ";
			}
			else
			{
				result += ".";
			}
			if (i % 10 == 0 && i != 0)
			{
				result += "\n";
			}
		}
		return result;
	}
	
	private static String listString()
	{
		String result = "";
		for (int i = 0; i < myList.size(); i++)
		{
			result += myList.get(i).toString();
			if (i != myList.size() - 1)
			{
				result += ", ";
			}
			else
			{
				result += ".";
			}
			if (i % 10 == 0 && i != 0)
			{
				result += "\n";
			}
		}
		return result;
	}
}
