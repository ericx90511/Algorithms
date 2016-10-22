import java.util.*;
import java.io.*;

public class MergeSort
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

		int i = 0;
		int j = 0;
		int k = p;
		while(i<n1 &&j<n2)
		{
			if(left.get(i) <= right.get(j))
			{
				array.set(k,left.get(i));
				i++;
				k++;
			}
			else
			{
				array.set(k, right.get(j));
				j++;
				k++;
			}			
		}
		while(i<n1)
		{
			array.set(k,left.get(i));
			k++;
			i++;
		}	
		while(j<n2)
		{
			array.set(k,right.get(j));
			k++;
			j++;
		}		
	}

}