import java.io.*;
import java.util.*;

public class RecursiveRandomizedSelect
{
	public int randomizedSelect(ArrayList<Integer> array, int p, int r, int i)
	{	
		if(p==r)
		{
			return array.get(p);
		}
		int q = randomizedPartition(array, p,r);
		int k = q-p+1;
		if(i==k)
		{
			return array.get(q);
		}else if(i<k)
		{
			return randomizedSelect(array,p,q-1,i);
		}else
		{
			return randomizedSelect(array,q+1,r,i-k);
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
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(15,25,43,3,22,10));
		RecursiveRandomizedSelect qucikS = new RecursiveRandomizedSelect();
		System.out.println("The array "+array1.toString());
		for(int i =1; i<=array1.size(); i++)
		{
			int result = qucikS.randomizedSelect(array1,0,array1.size()-1,i);
			System.out.println("The "+i+"-th samllest element is "+result);
		}
		System.out.println("The array after randomized select "+array1.toString());
	}
}