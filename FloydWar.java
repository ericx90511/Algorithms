import java.io.*;
import java.util.*;

public class FloydWar
{
	static String str = "LOL";
	public static void main(String[] args)
	{
		double oo = Double.POSITIVE_INFINITY; //Infinity

		double[][] w = 
		{
		   // 1,  2,  3,  4,   5 
			{ 0.0, 3.0,  8.0, oo,  -4.0}, //1
			{ oo,  0.0,  oo,  1.0,  7.0}, //2
			{ oo,  4.0,  0.0, oo,   oo}, //3
			{ 2.0, oo,  -5.0, 0.0,  oo}, //4
			{ oo,  oo,   oo,  6.0,  0.0}, //5
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
		result = floydMatrix(w);
		print(result);

		System.out.println();
		double[][] pred = new double[l.length][l.length];
		pred = predeMatrix(result,w);
		print(pred);
		System.out.println();
		printPath(pred,2,5);
		System.out.println();

	}

	public static double[][] floydMatrix(double[][] w)
	{
		int size = w.length;
		double[][] d = new double[size][size];
		d = copyof(w);
		for(int k = 0; k<size; k++)
		{
			for(int i = 0; i<size; i++)
			{
				for(int j = 0; j<size; j++)
				{
					d[i][j] = min(d[i][j],d[i][k]+d[k][j]);
				}
			}
		}
		return d;
	}

	public static double[][] predeMatrix(double[][] l, double[][] w)
	{
		int size = l.length;
		double[][] pred = new double[size][size];
		
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				for(int k = 0; k<size; k++)
				{
					if(l[i][k]+w[k][j]==0)
					{
						pred[i][j] =0;
					}
					else if(l[i][j] == l[i][k]+w[k][j] && w[k][j] !=0)
					{
						pred[i][j] = k+1;
					}
				}
			}
		}
		return pred;
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
					int temp = (int)(matrix[i][y]); //casting double to int
					System.out.print(temp+" "); 
				}
			}
			System.out.println("  //"+(i+1));
		}
	}	
	public static void printPath(double[][] matrix, int i, int j)
	{
		if(i==j)
		{
			System.out.print(i);
		}else if (matrix[i-1][j-1] == Double.POSITIVE_INFINITY)
		{
			System.out.println("No path");
		}else
		{
			int latestVertex = (int)(matrix[i-1][j-1]); //casting double to int
			printPath(matrix,i,latestVertex);
			System.out.print(j);

		}

	}		
}