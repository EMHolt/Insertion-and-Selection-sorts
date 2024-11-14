import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author Noah Buster, Emma Holt
 * Date: 12November2024
 * Class: AP CSA 3rd Hour
 * Description: This class takes a List or array with 100 random integers and
 * 				sorts them least to greatest by an insertion sort and 
 * 				a selection sort. 
 */

public class Sorting {
	
	private static List<Integer> myList;
	private static Integer[] myArray;
	private static final int N = 100;
	
	public static void print(List a, Comparable b[], String msg) throws Exception
	{
		String output = msg + "\n\n" + listString(a) + "\n\n" 
					  + arrayString(b) + "\n";
		System.out.println(output);
		String fileName = "data.txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		out.write(output);
		out.close();
	}
	
	public static void main(String[] args)
	{
		generate();
		try
		{
			print(myList, myArray, "unsorted random arrays");
			insertionSort(myList);
			selectionSort(myArray);
			print(myList, myArray, "sorted random arrays");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void insertionSort(List<Integer> a) // Noah
	{
		for (int i = 1; i < a.size(); i++)
		{
			Integer current = a.get(i);
			int j = 0;
			while (j < i)
			{
				if (current.compareTo(a.get(j)) < 0)
				{
					
					for (int k = i; k > j; k--)
					{
						a.set(k, a.get(k-1));
					}
					a.set(j, current);
					break;
				}
				j++;
			}
		}
	}

	public static void selectionSort(Comparable[] a) // Emma
	{
	    for (int endOfArrayIndex = a.length - 1; endOfArrayIndex > 0; endOfArrayIndex--) 
	    {
	        Comparable max = a[0];
	        int maxIndex = 0;

	        for (int i = 1; i <= endOfArrayIndex; i++) 
		{
	            if (a[i].compareTo(max) > 0) 
		    { 
	                max = a[i];
	                maxIndex = i;
	            }
	        }
	        Comparable temp = a[maxIndex];
	        a[maxIndex] = a[endOfArrayIndex];
	        a[endOfArrayIndex] = temp;
	    }
	}
	
	private static void generate()
	{
		myList = new ArrayList<Integer>(N);
		myArray = new Integer[N];
		for (int i = 0; i < N; i++)
		{
			Random rand = new Random();
			Integer r = rand.nextInt(200) - 100;
			Integer r2 = rand.nextInt(200) - 100;
			myList.add(r);
			myArray[i] = r2;
		}
	}
	
	private static String arrayString(Object[] a)
	{
		String result = "";
		for (int i = 0; i < a.length; i++)
		{
			result += a[i].toString();
			if (i != a.length - 1)
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
	
	private static String listString(List a)
	{
		String result = "";
		for (int i = 0; i < a.size(); i++)
		{
			result += a.get(i).toString();
			if (i != a.size() - 1)
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
