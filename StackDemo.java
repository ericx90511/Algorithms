import java.util.*;
import java.io.*;

public class StackDemo
{
	public static void main(String[] args)
	{

		InputData input1 = new InputData(1,1);
		InputData input2 = new InputData(2,2);
		InputData input3 = new InputData(3,4);
		InputData input4 = new InputData(4,10);
		

	}

	static class InputData
	{	
		private int priority;
		private int inputInt;
		public InputData(){}
		
		public InputData(int priority, int inputInt)
		{
			this.priority = priority;
			this.inputInt = inputInt;
		}

		public String toString()
		{
			return "Prioriy: "+priority+" value: "+inputInt;
		}
	}

}
