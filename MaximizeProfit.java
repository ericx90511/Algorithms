import java.util.*;
import java.io.*;

public class MaximizeProfit
{
	
	public static void main(String[] args)
	{
		ArrayList<Integer> arrayA = new ArrayList<>(Arrays.asList(5,4,3,2,1));
		ArrayList<Integer> arrayB = new ArrayList<>(Arrays.asList(10,9,8,7,6));
		QuickSort sortt = new QuickSort();
		sortt.quickSort(arrayA, 0, arrayA.size()-1);
		sortt.quickSort(arrayB, 0, arrayB.size()-1);
		Result result = new Result();
		result = maximize(arrayA, arrayB);
		System.out.println(result.getProfit());
		System.out.println(result.getArray().toString());
	}

	public static Result maximize(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB)
	{
		ArrayList<Double> temp = new ArrayList<>();
		Double payoff=0.0;
		if(arrayA.size()!=arrayB.size())
		{
			throw new IndexOutOfBoundsException();
		}
		for(int i =0; i<arrayA.size(); i++)
		{
			double temp2 = Math.pow(arrayA.get(i), arrayB.get(i));
			temp.add(temp2);
			payoff += temp2;
		}

		return new Result(payoff, temp);
	}

	final static class Result
	{
		private double profit=0;
		private ArrayList<Double> array;
		public Result(double profit, ArrayList<Double> array)
		{
			this.profit = profit;
			this.array = array;
		}
		public Result(){}
		public double getProfit()
		{
			return profit;
		}

		public ArrayList<Double> getArray()
		{
			return array;
		}
	}
}