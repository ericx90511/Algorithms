import java.util.*;
import java.io.*;

public class MergeDemo
{
	public static void main(String[] args)
	{
		SentinelMergeSort sMerge = new SentinelMergeSort();
		MergeSort merge = new MergeSort();
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,2,4,7,1,3,2,6));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5,2,4,7,1,3,2,6));
		System.out.println("Before merging "+array.toString());
		sMerge.mergeSort(array,0,array.size()-1);
		merge.mergeSort(array2,0,array.size()-1);
		System.out.println("Sentinel merge: "+array.toString());
		System.out.println("No sentinel merge: "+array2.toString());
	}
}