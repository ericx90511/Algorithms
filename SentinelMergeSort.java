import java.util.*;
import java.io.*;

public class SentinelMergeSort
{
	public void mergeSort(ArrayList<Integer> array, int p, int r)
	{	
		if(p<r)
		{
			int q = (p+r)/2;
			mergeSort(array,p,q);
			mergeSort(array,q+1,r);
			merge(array,p,q,r);
		}
	}

	public void merge(ArrayList<Integer> array, int p, int q, int r)
	{
		int n1 = q-p+1;
		int n2 = r-q;
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		
		for(int i = 0; i<n1; i++)
		{
			left.add(i,array.get(p+i));
		}

		for(int j = 0; j<n2; j++)
		{
			right.add(j,array.get(q+j+1));
		}
		
		left.add(Integer.MAX_VALUE);
		right.add(Integer.MAX_VALUE);

		int i = 0;
		int j = 0;

		for(int k=p; k<=r; k++)
		{
			if(left.get(i) <= right.get(j))
			{
				array.set(k,left.get(i));
				i++;
			}
			else
			{
				array.set(k, right.get(j));
				j++;
			}			
		}
	
	}

}