import java.io.*;
import java.util.*;

public class Predecessor
{
	public static void main(String[] args)
	{
		Integer oo = 999; //Infinity
		Integer[][] w = 
		{
		   // 1,  2,  3,  4,   5 
			{ 0,  3,  8, oo,  -4}, //1
			{oo,  0, oo,  1,   7}, //2
			{oo,  4,  0, oo,  oo}, //3
			{ 2, oo, -5,  0,  oo}, //4
			{oo, oo, oo,  6,   0}, //5
		};


		Integer[][] l = 
		{
		   // 1, 2, 3,  4,  5 
			{0,  1, -3, 2, -4}, //1
			{3,  0, -4, 1, -1}, //2
			{7,  4,  0, 5,  3}, //3
			{2, -1, -5, 0, -2}, //4
			{8,  5,  1, 6,  0}, //5
		};

		Integer[][] result = new Integer[l.length][l.length];
		result = predeMatrix(l,w);
		print(result);

		System.out.println();
		printPath(result, 2, 5);
		System.out.println();

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

	public static void printPath(Integer[][] matrix, int i, int j)
	{
		if(i==j)
		{
			System.out.print(i);
		}else if (matrix[i-1][j-1] >= 999)
		{
			System.out.println("No path");
		}else
		{
			printPath(matrix,i,matrix[i-1][j-1]);
			System.out.print(j);

		}

	}	

	public static void print(Integer[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int y=0; y<matrix[i].length; y++)
			{
				if(matrix[i][y]>=999)
				{
					System.out.print("oo ");
				}else
				{
					System.out.print(matrix[i][y]+" ");
				}
			}
			System.out.println("  //"+(i+1));
		}
	}	
}