import java.io.*;
import java.util.*;

public class FasterAllShortestPath
{
	public static void main(String[] args)
	{
		double oo = Double.POSITIVE_INFINITY; //Infinity

		double[][] w = 
		{
		   // 1,  2,  3,  4,   5 
			{0.0, 3.0, 8.0, oo,  -4.0}, //1
			{oo,  0.0, oo,  1.0,  7.0}, //2
			{oo,  4.0, 0.0, oo,   oo}, //3
			{2.0, oo, -5.0, 0.0,  oo}, //4
			{oo,  oo,  oo,  6.0,  0.0}, //5
		};

		double[][] l = 
		{
		   // 1, 2, 3,  4,  5 
			{0.0,  1.0, -3.0, 2.0, -4.0}, //1
			{3.0,  0.0, -4.0, 1.0, -1.0}, //2
			{7.0,  4.0,  0.0, 5.0,  3.0}, //3
			{2.0, -1.0, -5.0, 0.0, -2.0}, //4
			{8.0,  5.0,  1.0, 6.0,  0.0}, //5
		};

		double[][] result = new double[w.length][w.length];
		result = extendShortest(l,w);
		print(result);

		System.out.println();
		double[][] fastResult = new double[w.length][w.length];
		fastResult = fasterAllShort(w);
		print(fastResult);

	}

	public static double[][] fasterAllShort(double[][] w)
	{
		int size = w.length;
		double[][] l = new double[size][size];
		l = copyof(w);
		int m = 1;

		while(m<size-1)
		{
			l = extendShortest(l,l);
			m *=2;
		}

		return l;
	}

	public static double[][] extendShortest(double[][] l, double[][] w)
	{
		int size = l.length;
		double[][] lprime = new double[size][size];
		lprime = copyof(l);

		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				for(int k = 0; k<size; k++)
				{
					lprime[i][j] = min(lprime[i][j], lprime[i][k]+w[k][j]);
				}
			}
		}
		return lprime;
	}

	public static double min(double ij, double ikj)
	{
		if(ij >= ikj)
		{
			return ikj;
		}else
		{
			return ij;
		}
	}

	public static double[][] copyof(double[][] matrix)
	{
		int size = matrix.length;
		double[][] retunrMatrix = new double[size][size];
		for(int i = 0; i < size ; i++)
		{
			retunrMatrix[i] = matrix[i].clone();
		}
		return retunrMatrix;
	}

	public static void print(double[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int y=0; y<matrix[i].length; y++)
			{
				if(matrix[i][y]==Double.POSITIVE_INFINITY)
				{
					System.out.print("oo ");
				}else
				{
					Integer temp = (int) (matrix[i][y]);
					System.out.print(temp+" ");
				}
			}
			System.out.println("  //"+(i+1));
		}
	}	
}