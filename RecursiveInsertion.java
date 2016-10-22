import java.util.*;
import java.io.*;

public class RecursiveInsertion
{
	public static void main(String[] args)
	{	
		Integer[] array = {5,4,3,2,1};
		System.out.println("Array before sorting "+Arrays.toString(array));
		// insertion(array);
		System.out.println("Now inserting A[n] to A[1...n]");
		Integer[] array2 = recurInser(array,6);
		System.out.println("Recursive Insertion "+Arrays.toString(array2));
	}

	public static <T extends Comparable<? super T>> T[] recurInser(T[] array, T n)
	{	
		if(array.length < 1)
		{
			return array;
		}else
		{
			array = Arrays.copyOf(array, array.length+1);
			array[array.length-1] = n;
			insertion(array);
			return array;
		}
	}
	public static <T extends Comparable<? super T>> void insertion(T[] array)
	{
		for(int i = 1; i<array.length;i++)
		{
			int j = i;
			
			while(j>0 && array[j].compareTo(array[j-1])<0)
			{
				swap(array, j);
				--j;	
			}
			
		}
	}

	public static <T> void swap(T[] array, int j)
	{
		T temp = array[j];
		array[j]=array[j-1];
		array[j-1]=temp;
	}

}