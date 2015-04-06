package main.model.map_2;

import java.io.*;
import java.util.Scanner;
public class MapLoad
{
  public void loadMap(File loadpath)
  {
	  try
	  
	  
	  {
		  Scanner fileScan= new Scanner(loadpath);
		  
		  for(int y=0; y<MapEditor.map.tile.length; y++)
		  {
			  for(int x=0; x<MapEditor.map.tile[0].length; x++)
			  {
				  MapEditor.map.tile[y][x].grassID = fileScan.nextInt();
			  }  
		  }
		  
		  
		 
		  
		  
		  fileScan.close();
	  } 
	  
	  
	  
	  catch(Exception e)
	  {
		  System.out.print("No file found");
	  }
  }
}
