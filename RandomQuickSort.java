import java.util.*;
import java.io.*;

public class RandomQuickSort
{
	public void randomQuickSort(ArrayList<Integer> array, int p, int r)
	{
		if(p<r)
		{
			int q = randomizedPartition(array,p,r);
			randomQuickSort(array,p,q-1);
			randomQuickSort(array,q+1,r);
		}
	}

	public int randomizedPartition(ArrayList<Integer> array, int p, int r)
	{
		Random rand = new Random();
		int i = rand.nextInt((r-p)+1)+p;
		swap(array, r, i);
		return partition(array,p,r);
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
		RandomQuickSort qucikS = new RandomQuickSort();
		qucikS.randomQuickSort(array1,0,array1.size()-1);
		System.out.println(array1.toString());
	}
}