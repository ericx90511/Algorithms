import java.io.*;
import java.util.*;


public class Prims
{
	public static void main(String[] args)
	{
		int oo = Integer.MAX_VALUE;
		Integer[][] matrix = 
		{
		   // a, b, c,  d,  e,  f,  g,   h,  i 
			{oo, 4, oo, oo, oo, oo, oo, oo, oo}, //a
			{4, oo,  8, oo, oo, oo, oo, 11, oo}, //b
			{oo, 8, oo,  7,  oo,  4, oo, oo, 2}, //c
			{oo, oo, 7, oo,  9, 14, oo, oo, oo}, //d
			{oo, oo, oo, 9, oo, 10, oo, oo, oo}, //e
			{oo, oo, 4, 14, 10, oo,  2, oo, oo}, //f
			{oo, oo,oo, oo, oo,  2, oo,  1,  6}, //g
			{8,  11,oo, oo, oo, oo,  1, oo,  7}, //h
			{oo, oo, 2, oo, oo, oo,  6,  7, oo} //i
		};
		print(matrix);
		Integer[][] result = new Integer[matrix.length][matrix.length];
		result = prims(matrix,0);
		System.out.println("LOL");
		print2(result);
		print(matrix);
	}
	public static Integer[][] prims(Integer[][] matrix, int startVertex)
	{
		int size = matrix.length;

		Integer[][] result= new Integer[matrix.length][2];

		for(int vertex=startVertex;vertex<matrix.length;vertex++)
		{
			int currentMin=matrix[vertex][0];
			int minIndex =0;	
			for(int row=startVertex; row<matrix.length-1; row++)
			{
				if(currentMin>matrix[vertex][row+1])
				{
					currentMin = matrix[vertex][row+1];
					// System.out.println(currentMin);
					minIndex = row+1;
				}
			}
			result[vertex][0] = vertex;
			result[vertex][1] = minIndex;
			// startVertex = minIndex;
			matrix[vertex][minIndex]=Integer.MAX_VALUE;
			// System.out.println("finished "+vertex);

		}
		return result;
	}

	public static void print(Integer[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int y=0; y<matrix[i].length; y++)
			{
				if(matrix[i][y]==Integer.MAX_VALUE)
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

	public static void print2(Integer[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int y=0; y<matrix[i].length; y++)
			{

					System.out.print(matrix[i][y]+" ");
				
			}
			System.out.println("  //"+(i+1));
		}
	}	
}