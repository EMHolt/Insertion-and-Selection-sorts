import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	/**
	 * Main runs the sorts methods and puts them into a file.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Sorting sorter = new Sorting();
		try {
			generate();
			print(myList, myArray, "Original List and Array:");
			sorter.selectionSort(myArray);
			print(myList, myArray, "Sorted List and Array:");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sorts a List of Integers from least to greatest.
	 * Precondition: the List has Integers stored in it.
	 */
	public static void insertionSort(List<Integer> a) {
	    for (int currentSortedIndex = 1; currentSortedIndex < a.size(); currentSortedIndex++) {
	        int nextElement = a.get(currentSortedIndex);
	        int compareI = currentSortedIndex - 1;

	        while (compareI >= 0 && a.get(compareI) > nextElement) {
	            a.set(compareI + 1, a.get(compareI));
	            compareI--;
	        }
	        a.set(compareI + 1, nextElement);
	    }
	}

	/**
	 * Sorts an array of Integers from least to greatest.
	 * Precondition: the array has Integers stored in it.
	 */
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
	
	/**
	 * creates a List/array of N Integers
	 */
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

	/**
	 * Prints the list and array pre sorted and each after the sort. 
	 * Each row has 10 numbers, and each number is evenly spaced.
	 * @param a: list of random Integers
	 * @param b: array of random Integers
	 * @param msg: Specifies list/array, type of sort, and pre/post sort
	 * @throws Exception
	 */
	public static void print(List<Integer> a, Comparable[] b, String msg) throws Exception {
		String filePath = "C:\\Users\\EMHolt\\Documents\\EmmaOutput.txt";

		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
			writer.println(msg);

			writer.println("List:");
			for (int i = 0; i < a.size(); i++) {
				writer.printf("%4d", a.get(i));
				if ((i + 1) % 10 == 0 || i == a.size() - 1) {
					writer.println();
				} else {
					writer.print(", ");
				}
			}

			writer.println("Array:");
			for (int i = 0; i < b.length; i++) {
				writer.printf("%4d", b[i]);
				if ((i + 1) % 10 == 0 || i == b.length - 1) {
					writer.println();
				} else {
					writer.print(", ");
				}
			}
			
			writer.println();
		}
	}
}