import java.util.*;
import java.io.*;

public class KDemo
{
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> array = new ArrayList<>();
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(5,4));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(10,9));
		ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(15,14));
		array.add(array1);
		array.add(array2);
		array.add(array3);

		KMerge kMerge = new KMerge();
		kMerge.merge(array);
		
		// System.out.println("printing 2d array:  "+array.toString());
		System.out.println("printing size:  "+array.size());
		// array.remove(1);
		System.out.println("printing 2d array:  "+array.toString());
	}
}