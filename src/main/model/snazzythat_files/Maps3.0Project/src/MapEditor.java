import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;

/**
 * 
 * @author R
 * @version 1.0
 * Window class. This class is responsible of loading texture images and tracing the initial blank map.
 */
public class MapEditor extends JPanel implements Runnable //set as a runnable
{  
	
	public static Point mousePoint =new Point(0,0);    //location of the mouse on the screen 
	
	public static Image grass;        //random number generated (depends how many tiles we have in the map)
	public static Image path;
	public static Image creeper;
	public static int windWidth, windHeight;
	public static boolean isFirst=true;
	public static Map map;
	public static MapLoad mapLoad;   //loading map
    public boolean newORsave;
    public JButton play;
	public JButton restart;
	Thread thread= new Thread(this);
	/**
	 * Constructor for Window class (implemented as Thread)
	 */
	public MapEditor(GameDisplay disp, boolean newORsave)
	{	
		this.newORsave=newORsave;
		disp.addMouseListener(new KeyAndMouse());    //will extend KeyAndMouse methods (used for user interaction)
		disp.addMouseMotionListener(new KeyAndMouse());
		initialize();
		thread.start();
		
	
		
	}
	
	
	
	/**
	 * Initialize method. This method initializes the map and loads+filters images from the img folder. The images are
	 * cropped to suit any tile size. TO NOTE: as tile size is increased, pixelation will be obvious. This can be fixed by
	 * creating a texture with higher resolution. For testing purposes, textures were downloaded.
	 * FilteredImageSource is called with provided texture file directories as well as CropImage Filter, which crops the image to
	 * tile size respectably (in this case, tileSize is 64, thus 64/2=32 by x and y components)
	 * 
	 * NOTE2: initialize has 2 cases. If in Game Display LoadButton is clicked, initialize loads a presaved
	 * existing map from a text file. If NewMap button is clicked, initialize creates a new button
	 * 
	 *  
	 *  
	 *NOTE3: Decide Logic 
	 */
	public void initialize()
	{
		
	    grass = new ImageIcon("img/grass.png").getImage();   //getting texture from img folder
	    path  = new ImageIcon("img/path.png").getImage();    //getting texture from img folder 
	    this.setLayout(new BorderLayout());
	    
	    
	    if(newORsave==true)
	    {
	    play=new JButton("Play");
	    map=new Map();
		mapLoad=new MapLoad(); 
	    mapLoad.loadMap(new File("mapSaves/firstMap.txt"));  //if load save button is clicked, load from save file
	    this.add(play,BorderLayout.SOUTH);
	    
	    }
	    
	    else
	    {		
	    this.setLayout(null);
	    play=new JButton("Save And Play");
	    map=new Map(); 
	    play.setBounds(200,600,100, 100);
		this.add(play, BorderLayout.SOUTH);
		JOptionPane.showMessageDialog(null, "BEFORE YOU MAKE YOUR OWN MAP"+"\n"+"Here are the rules:"+"\n"+
				"1.No loops in path are allowed"+"\n"+
				"2.Path must be unidirectional (no tiles are allowed to be grouped together)"+"\n"+
				"3.ONE WAY ONLY! Enjoy :)");
		
		restart = new JButton("Restart");
		restart.setBounds(400,600,100, 100);
		this.add(restart, BorderLayout.SOUTH);
		
		//play.addActionListener(this);
		
	    }
	}
	    
		
		
	/**
	 * paint method. This method traces the actual blank map (derived from JComponent)
	 */
	
	public void paintComponent(Graphics graphics)                  //drawer method
	{
		super.paintComponent(graphics);
		
		
		if(isFirst)
		{
			windWidth=getWidth();
			windHeight=getHeight();
			isFirst= false;
		}
		
		map.traceMap(graphics);//actually drawing the Map	
		
	}

	//---------------------------------------------------------
	/**
	 * run method for Thread
	 */
	public void run()
	{
		while(true)
		{	
			
		 repaint();
		
		try
		  {
		    Thread.sleep(15); //set interval between graphical changes
		  }
		      catch(Exception e)
			  {
		    	  
			  }
			
	}
		
	}



	
}
	

	
	

	


