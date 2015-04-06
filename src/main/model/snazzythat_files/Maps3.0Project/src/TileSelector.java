import javax.swing.*;
/**
 * Tile Selector class
 * @author AR
 * This class is responsible of tracking mouse position over individual tile and verify if tile was clicked.
 * If left Mouse Button was clicked, the method changes tile ID from grass to path thus resulting the MapEditor class
 * to repaint path. 
 * Moreover, if INITIAL and FINAL tiles are selected, this class throws a dialog notifying the user about their choice. 
 */
public class TileSelector
{
	
	public static int clickedID;
	public static boolean startSelected=false;
	public static boolean finishSelected=false;
	public static JOptionPane startSelectedPanel;
	
	
	
	
	/**
	 * mouseOnTile method. Takes mouse value information from KeyAndMouse and processes tile selection.
	 * @param mouseButton
	 */
	public static void mouseOnTile(int mouseButton)
	{   
		
	    if(mouseButton==1)  //if LEFT MOUSE BUTTON was clicked
		{
	      clickedID=1;
	      
	    }
		   
	       for(int y=0; y<MapEditor.map.tile.length; y++)
		   {
			for(int x=0; x<MapEditor.map.tile[0].length; x++)
			{
				if(MapEditor.map.tile[y][x].contains(MapEditor.mousePoint) && clickedID==1)  //if mouse is within the tile AND if mouse is clicked
				{   
					System.out.println(""+ MapEditor.map.tile[y][x]);    //FOR TESTING PURPOSES. Prints individual Tile location and properties once clicked
					MapEditor.map.tile[y][x].grassID=TileVals.path;            //Swapping grass for path ID's must appear as blank tile.
					
					
				}
				
				
				if(startSelected==false)
				{
			   													     //This part of the code allows user to select possible start and end tiles. 
				   if(MapEditor.map.tile[y][0].contains(MapEditor.mousePoint) && clickedID==1)
				   {
					startSelected=true;
					MapEditor.map.tile[y][0].grassID=TileVals.path;
					JOptionPane.showMessageDialog(null, "START tile is selected!");
					break;
					
				   }
				}
				
				if(finishSelected==false)
				{
				
				   if(MapEditor.map.tile[y][MapEditor.map.tile.length+1].contains(MapEditor.mousePoint)&& clickedID==1)
				   {
					
					finishSelected=true;
					JOptionPane.showMessageDialog(null, "FINISH tile is selected!");
				 	MapEditor.map.tile[y][MapEditor.map.tile.length+1].grassID=TileVals.path; 
					System.out.println(""+ MapEditor.map.tile[y][MapEditor.map.tile.length]);
					
				  
					
					break;
				   }
				   
				 
				}
				
				
				 
				
				//NOTE: Once start/finish have been selected, no more start/finish tiles are allowed.
				
				
				
				}
		    }
	       
	      }

}
