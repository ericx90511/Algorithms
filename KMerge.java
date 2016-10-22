import java.util.*;
import java.io.*;

public class KMerge
{
	Heap heap = new Heap();
	ArrayList<Integer> minHeap = new ArrayList<>();
	ArrayList<Integer> finalHeap = new ArrayList<>();
	Node node = new Node();
	ArrayList<Integer> indexA = new ArrayList<>();
	public void merge(ArrayList<ArrayList<Integer>> array)
	{
		int arraySize = getHeapSize(array);

		for(int index = 0; index < array.size(); index++)
		{
			// indexA.add(array.indexOf(index).get(index));
			minHeap.add(heap.heapExtractMax(array.get(index)));
		}
		heap.buildMaxHeap(minHeap);

		while(finalHeap.size()<3)
		{	
			Integer temp = minHeap.get(0); 
			
			for(int i=0; i<array.size();i++)
			{
				for(int j =0; j < array.get(i).size();j++)
				{
					
					if(array.get(i).contains(temp))
					{
						System.out.println("irc"+array.get(i));
						minHeap.add(heap.heapExtractMax(array.get(i)));
					}
				}
			}
			finalHeap.add(heap.heapExtractMax(minHeap));
		}
		
		
		System.out.println("final: "+finalHeap.toString());
	}

	public static int getHeapSize(ArrayList<ArrayList<Integer>> array)
	{
		int result=0;
		for(int i = 0; i<array.size();i++)
		{
			for(int j = 0; j < array.get(i).size(); j++)
			{
				result++;
			}
		}
		return result;
	}
}