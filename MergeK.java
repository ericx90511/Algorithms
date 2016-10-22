import java.util.*;
import java.io.*;

public class MergeK
{
	public ArrayList<Integer> merge(ArrayList<Integer> array1, ArrayList<Integer> array2)
	{	
		Heap heap = new Heap();
		ArrayList<Integer> mergedArray = new ArrayList<Integer>();
		while(array1.size()>=1 || array2.size()>=1)
		{
			if(array1.size()==0 && array2.size()>=1)
			{	
				mergedArray.addAll(array2);
				System.out.println("irh"+array2.toString());
				break;
			}else if (array1.size()>=1 && array2.size()==0)
			{	
				
				mergedArray.addAll(array1);
				break;
			}

			if(array1.get(0)>array2.get(0))
			{
				mergedArray.add(array1.get(0));
				heap.heapExtractMax(array1);
			}else
			{
				mergedArray.add(array2.get(0));
				heap.heapExtractMax(array2);
			}
		}
		return mergedArray;

	}
}