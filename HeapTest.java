import java.util.*;
import java.io.*;

public class HeapTest
{
	public static void main(String[] args)
	{
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Heap heap = new Heap();
		heap.buildMaxHeap(array);
		System.out.println("Result of normal heap - \"Heap.java\":  "+array.toString());
		heap.heapExtractMax(array);
		System.out.println("After Heap-Extract-Max: "+array.toString());

		ArrayList<Integer> merge1 = new ArrayList<Integer>(Arrays.asList(102,38,64,42,21));
		ArrayList<Integer> merge2 = new ArrayList<Integer>(Arrays.asList(93,47,55,34,11,7,4));
		ArrayList<Integer> merge3 = new ArrayList<Integer>(Arrays.asList(13,10,9,7,6,5,3,2));
		ArrayList<Integer> merge4 = new ArrayList<Integer>(Arrays.asList(150,145,142,132,120,118,110));
		
		ArrayList<Integer> result1 = new ArrayList<Integer>();
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		ArrayList<Integer> finalResult = new ArrayList<Integer>();


		MergeK mergeK = new MergeK();
		result1 = mergeK.merge(merge3,merge4);
		System.out.println(result1.toString());
		result2 = mergeK.merge(merge3,merge4);
		finalResult = mergeK.merge(result1,result2);
		System.out.println(finalResult.toString());

		int[] array2 = {1,2,3,4,5};
		RootHeap rootHeap = new RootHeap();
		rootHeap.buildMaxHeap(array2);
		System.out.println("Result of 1 to last parent node - \"RootHeap.java\":  "+Arrays.toString(array2));

		int[] array3 = {1,2,3,4,5};
		IterHeap iterHeap = new IterHeap();
		iterHeap.buildMaxHeap(array3);
		System.out.println("Result of Iteration Max-Heapify - \"IterHeap.java\": "+Arrays.toString(array3));
	}
}