import java.util.*;
import java.io.*;

public class Stack<T>
{
	ArrayList<? super T> stack = new ArrayList<>();
	public boolean stackEmpty()
	{
		if(stack.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void push(T x)
	{
		stack.add(0, x);
	}

	public void pop(ArrayList<T> stack)
	{
		if(stack.isEmpty())
		{	
			throw new RuntimeException("Underflow occured");
		}
		else
		{
			stack.remove(0);
		}
	}


}