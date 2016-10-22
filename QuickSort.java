import java.util.*;
import java.io.*;

public class QuickSort
{
	public void quickSort(ArrayList<Integer> array, int p, int r)
	{
		if(p<r)
		{
			int q = partition(array,p,r);
			quickSort(array,p,q-1);
			quickSort(array,q+1,r);
		}
	}

	public int partition(ArrayList<Integer> array, int p, int r)
	{

		int x = array.get(r);
		int i = p-1;
		for(int j = p; j<r; j++)
		{
			if(array.get(j)<= x)
			{
				i = i+1;
				swap(array, i, j);
			}
		}
		swap(array, i+1, r);
		return i+1;
	}

	public void swap(ArrayList<Integer> array, int x, int y)
	{
		int temp = array.get(x);
		array.set(x,array.get(y));
		array.set(y,temp);
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(5,4,3,2,1));
		QuickSort qucikS = new QuickSort();
		qucikS.quickSort(array1,0,array1.size()-1);
		System.out.println(array1.toString());
	}
}