import java.util.*;
import java.io.*;

public class RootHeap
{
	public int heapSize;
	public int parent(int i)
	{
		return i/2;
	}

	public int leftChild(int i)
	{	
		return ((2*i)+1);
	}

	public int rightChild(int i)
	{	
		return ((2*i)+2);
	}

	public void maxHeapify(int[] array, int i)
	{

		int left = leftChild(i);
		int right = rightChild(i);
		int largest;
		int temp;
		if(left<heapSize && array[left]>array[i])
		{
			largest = left;
		}
		else
		{
			largest = i;
		}

		if(right<heapSize && array[right]>array[largest])
		{
			largest = right;
		}

		if(largest != i)
		{
			temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(array, largest);
		}
	}

	public void buildMaxHeap(int[] array)
	{
		heapSize = array.length;

		for(int i=0; i<array.length/2; i++)
		{
			maxHeapify(array,i);
		}
	}
}