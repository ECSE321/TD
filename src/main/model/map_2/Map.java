import java.awt.*;
import java.util.Observable;
/**
 * 
 * @author R
 * @version 1.0
 * Map class. This class builds a map of  specified dimentions, made out of Tile objects.
 *
 */
public class Map extends Observable//extends Rectangle //For assignemnt 2, Map is Observable.
{
	
	//defining physical properties of map *subject to change*
	
	public int mapWidth=10;
	public int mapHeight=8;
	public int tileSize=TileVals.tileSiz;
	
	public static int clickedID=0;       //for mouse use
	public static boolean startSelected=false;
	public static boolean finishSelected=false;

	
	
	//Instantiating Tile object.
	public Tile[][] tile;
	
	/**
	 * Map constructor
	 */
	public Map()
	{
		build();
	}
	
	/**
	 * initialization method. This method creates tiles at X and Y coordinates of the map with appropriate size and texture IDs
	 */
	public void build()
	{
		tile=new Tile[mapHeight][mapWidth];	                    //Initializing Tile object
		
		for(int posY=0; posY<tile.length; posY++)				//Initializing blocks within the map (by X and Y locations)
		{
			for(int posX=0; posX<tile[0].length; posX++)
			{
				tile[posY][posX] = new Tile(posX * tileSize, posY * tileSize, tileSize, tileSize, TileVals.grass, TileVals.path); //Dont forget to chose the offset
				//Geometric allocation of each Tile.
				
			}
			
		}
		
		
	}
	
	/* Map geometrics: 
	 * ------------------------> X
	 * |
	 * |
	 * |
	 * |
	 * |
	 * |
	 * |
	 * ^
	 * Y
	 */

	/**
	 * drawer method. This method traces each tile by calling trace method of Tile class. 
	 * @param graphics
	 */
	public void traceMap(Graphics graphics)
	{
		for(int posY=0; posY<tile.length; posY++)
		{
			for(int posX=0; posX<tile[0].length; posX++)
			{
				
				//drawing grass if ID from scanned file=0
				if(tile[posY][posX].grassID==TileVals.grass)
				{
				tile[posY][posX].traceTileGrass(graphics); 
				}
				//drawing path if ID from scanned file=1
				else if(tile[posY][posX].grassID ==TileVals.path)
				{
				tile[posY][posX].traceTilePath(graphics);	
				}
				
				
			}
		}
	}

			
	/*public static void mouseOnTile(int mouseButton)
	{   
		
	    if(mouseButton==1)  //if LEFT MOUSE BUTTON was clicked
		{
	      clickedID=1;
	      
	    }
		   
	       for(int y=0; y<Window.map.tile.length; y++)
		   {
			for(int x=0; x<Window.map.tile[0].length; x++)
			{
				if(Window.map.tile[y][x].contains(Window.mousePoint) && clickedID==1)  //if mouse is within the tile AND if mouse is clicked
				{   
					System.out.println(""+ Window.map.tile[y][x]);    //FOR TESTING PURPOSES. Prints individual Tile location and properties once clicked
					Window.map.tile[y][x].grassID=TileVals.path;            //Swapping grass for path ID's must appear as blank tile.
					
					
				}
				
				
				if(startSelected==false)
				{
			   													     //This part of the code allows user to select possible start and end tiles. 
				   if(Window.map.tile[y][0].contains(Window.mousePoint) && clickedID==1)
				   {
					startSelected=true;
					Window.map.tile[y][0].grassID=TileVals.path;
					System.out.println("Possible START tile is selected!");
					break;
					
				   }
				}
				
				if(finishSelected==false)
				{
				
				   if(Window.map.tile[y][Window.map.tile.length].contains(Window.mousePoint)&& clickedID==1)
				   {
					finishSelected=true;
					Window.map.tile[y][Window.map.tile.length].grassID=TileVals.path; 
					System.out.println(""+ Window.map.tile[y][Window.map.tile.length]);
					System.out.println("Possible FINISH tile is selected!");
					break;
				   }
				   
				   
				}
				
				 
				
				//NOTE: Once start/finish have been selected, no more start/finish tiles are allowed.
				
				
				
				}
		    }
	       
	      }*/
	
	
	
	
	
	
		
}
	
	
	
		
	
	
	


