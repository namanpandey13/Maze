package com.pesit.main;

import com.pesit.maze.Maze;
import com.pesit.maze.EnchantedMazeFactory;
import com.pesit.maze.MazeGame;
import com.pesit.maze.MazeFactory;
import java.util.*;
import java.io.*;

/**
 * Created by vp2 on 20/02/16.
 */

public class MainClass 
{
public static void main(String args[]) throws NumberFormatException, IOException 
{  
    	
MazeGame newgame = new MazeGame();
MazeFactory factory = new EnchantedMazeFactory();
newgame.CreateMaze(factory);
      
        int x=0;
        int y=0;
        
        int[][] myInt = new int[100][100];
        
	try
         {
String line;
          BufferedReader in = new BufferedReader(new FileReader("CreateMaze.txt"));
          
          while ((line = in.readLine()) != null)
          {
        	String[] numbers = line.split(" ");
        	
           	for (int i=0;i<numbers.length;i++)
          	{
        	  int str_int = Integer.parseInt(numbers[i]);
        	  myInt[x][y]=str_int;
        	  
        	  y=y+1;
        	}
        	 
           	y=0;
        	x=x+1;
          }
                in.close();
         }
         
        catch( IOException ioException ) {}
        Traversal(myInt);
    }

    public static void Traversal(int my[][]) throws NumberFormatException, IOException
	{
    	BufferedReader in = new BufferedReader(new FileReader("TraverseMaze.txt"));
		StringBuffer strbf = new StringBuffer();
		String line;
         int room=0;
         while ((line = in.readLine()) != null)	//file reading
         {
       	String[] numbers = line.split("\\s+");
       	int str_int[]=new int[numbers.length];
          	for (int t=0;t<numbers.length;t++)
         	{
          		str_int[t] = Integer.parseInt(numbers[t]);
          		
          		
         	}
          	
          	room=str_int[0]-1;
          
          	for(int cnt=1;cnt<numbers.length;cnt++){
          		if(my[room][str_int[cnt]+1]>0)
          		{
          			room=my[room][str_int[cnt]+1]-1;
          		}
          	}
          	
          	
			strbf.append((room+1));
			strbf.append(" ");
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("Destination.txt")) );
			bwr.write(strbf.toString());
			bwr.flush();
			bwr.close();
         }
    }
}
