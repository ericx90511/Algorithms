import java.util.*;
import java.io.*;

public class Heap
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

	public void maxHeapify(ArrayList<Integer> array, int i)
	{

		int left = leftChild(i);
		int right = rightChild(i);
		int largest;
		int temp;
		if(left<heapSize && array.get(left)>array.get(i))
		{
			largest = left;
		}
		else
		{
			largest = i;
		}

		if(right<heapSize && array.get(right)>array.get(largest))
		{
			largest = right;
		}

		if(largest != i)
		{
			temp = array.get(i);
			array.set(i,array.get(largest));
			array.set(largest,temp);
			maxHeapify(array, largest);
		}
	}

	public void buildMaxHeap(ArrayList<Integer> array)
	{
		heapSize = array.size();
		for(int i=array.size()/2; i>=0; i--)
		{
			maxHeapify(array,i);
		}

	}

	public int heapExtractMax(ArrayList<Integer> array)
	{
		if(array.size()<1){
			throw new EmptyStackException();
		}
		int max;
		max = array.get(0);
		int temp = array.get(array.size()-1);
		array.set(0,array.get(array.size()-1));
		array.remove(array.size()-1);
		heapSize = array.size();
		maxHeapify(array, 0);
		return max;
	}


}