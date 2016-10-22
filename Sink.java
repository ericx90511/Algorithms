import java.util.*;
import java.io.*;

public class Sink
{
	public static void main(String[] args)
	{
		int[][] adjacencyMatrix = 
		{
			{0,1,1,1,0}, //1
			{1,0,1,0,1}, //2
			{0,0,0,0,0}, //3
			{1,0,1,0,1}, //4
			{0,1,1,1,0}, //5
		};

		int[][] noSinkMatrix = 
		{
			{0,1,1,1,0}, //1
			{1,0,1,0,1}, //2
			{0,0,1,0,0}, //3
			{1,0,1,0,1}, //4
			{0,1,1,1,0}, //5
		};

		print(adjacencyMatrix);
		int result = findUS(adjacencyMatrix);
		if(result != Integer.MAX_VALUE)
		{
			System.out.println("The vertex "+result+" is the universial sink");	
		}else
		{
			System.out.println("There is no the universial sink");
		}
		
	}
	public static int findUS(int[][] matrix)
	{
		int i=0;
		int y=0;
		int noSink = Integer.MAX_VALUE;
		while(i != matrix.length)
		{
			if(matrix[i][y] == 0)
			{
				y++;
			}else if(matrix[i][y]==1)
			{
				i++;
			}

			if(y == matrix.length-1)
			{	
				return i+1;
			}		
			
		}
		return noSink;
		
	}
	public static void print(int[][] matrix)
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int y=0; y<matrix[i].length; y++)
			{
				System.out.print(matrix[i][y]);
			}
			System.out.println();
		}
	}
}