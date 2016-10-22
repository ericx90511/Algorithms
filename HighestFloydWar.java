import java.io.*;
import java.util.*;

public class HighestFloydWar
{
	public static void main(String[] args)
	{
		double oo = Double.POSITIVE_INFINITY; //Infinity

		Double[][] w = 
		{
		   // 1,  2,  3,  4,   5 
			{0.0, 3.0, 8.0, oo,  -4.0}, //1
			{oo,  0.0, oo,  1.0,  7.0}, //2
			{oo,  4.0, 0.0, oo,   oo}, //3
			{2.0, oo, -5.0, 0.0,  oo}, //4
			{oo,  oo,  oo,  6.0,  0.0}, //5
		};

		Double[][] l = 
		{
		   // 1, 2, 3,  4,  5 
			{0.0,  1.0, -3.0, 2.0, -4.0}, //1
			{3.0,  0.0, -4.0, 1.0, -1.0}, //2
			{7.0,  4.0,  0.0, 5.0,  3.0}, //3
			{2.0, -1.0, -5.0, 0.0, -2.0}, //4
			{8.0,  5.0,  1.0, 6.0,  0.0}, //5
		};
		int size = w.length;
		Double[][] result = new Double[size][size];
		result = highNumberFloydMatrix(w);
		print(result);

		printPath(result,2,5);
		System.out.println();

	}

	public static Double[][] highNumberFloydMatrix(Double[][] w)
	{
		int size = w.length;
		Double[][] d = new Double[size][size];
		d = copyof(w);
		double oo = Double.POSITIVE_INFINITY;
		Double[][] phi = 
		{
		   // 1,  2,  3,  4,   5 
			{ 0.0, oo, oo, oo,  oo}, //1
			{oo,  0.0, oo, oo,  oo}, //2
			{oo, oo,  0.0, oo,  oo}, //3
			{oo, oo, oo,  0.0,  oo}, //4
			{oo, oo, oo, oo,   0.0}, //5
		};
		
		for(int k = 0; k<size; k++)
		{
			for(int i = 0; i<size; i++)
			{

				for(int j = 0; j<size; j++)
				{

					if(i == j)
					{
						phi[i][j] = 0.0;

					}else if(d[i][j] > d[i][k]+d[k][j])
					{
						d[i][j] = d[i][k]+d[k][j];
						phi[i][j] = k+1.0;
					}else if(phi[i][j] == Double.POSITIVE_INFINITY)
					{
						phi[i][j] = i+1.0;
					}
					
				}
			}
		}
		return phi;
	}

	public static Integer[][] predeMatrix(Integer[][] l, Integer[][] w)
	{
		int size = l.length;
		Integer[][] pred = new Integer[size][size];
		
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

	public static Integer min(Integer ij, Integer ikj)
	{
		if(ij >= ikj)
		{
			return ikj;
		}else
		{
			return ij;
		}
	}

	public static Double[][] copyof(Double[][] matrix)
	{
		int size = matrix.length;
		Double[][] retunrMatrix = new Double[size][size];
		for(int i = 0; i < size ; i++)
		{
			retunrMatrix[i] = matrix[i].clone();
		}
		return retunrMatrix;
	}

	public static void printPath(Double[][] matrix, int i, int j)
	{
		if(i==j)
		{
			System.out.print(i);
		}
		else if(matrix[i-1][j-1] == i)
		{
			System.out.print(j);
		}
		else if (matrix[i-1][j-1] == Double.POSITIVE_INFINITY)
		{
			System.out.println("No path");
		}
		else 
		{
			double tex = matrix[i-1][j-1];
			Integer temp = (int)(tex);
			System.out.print(i);
			printPath(matrix,i,temp);		
			printPath(matrix,temp,j);
		}

	}	

	public static void print(Double[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int y=0; y<matrix[i].length; y++)
			{
				if(matrix[i][y] == Double.POSITIVE_INFINITY)
				{
					System.out.print("oo ");
				}else
				{
					double temp = matrix[i][y];
					Integer result = (int) (temp);
					System.out.print(result+" ");
				}
			}
			System.out.println("  //"+(i+1));
		}
	}	
}