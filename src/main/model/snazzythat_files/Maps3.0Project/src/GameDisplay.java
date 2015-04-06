
import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ISE321
 * @author R
 * @version 1.1
 * MapObserver Class. Responsible of main window where the game will be running. This class contains the main method.
 * TO NOTE: As for the first assignment, it was decided to implement the graphics to make sure that maps are being built properly. 
 *
 *
 *NOTE2: This class is the Observer class that displays the map and notifies changes in the map. For this example,
 *the class notifies if a tile was added and at what position if was added. 
 */

public class GameDisplay extends JFrame implements ActionListener
{
	
	public static CardLayout layout = new CardLayout();
	public static Dimension size = new Dimension(800,750); //setting dimension of the frame (variable)
	public static boolean clicked;
	public JButton loadmap;
	public JButton play;
	public JButton newmap;
	public boolean launchSave;
	/**
	 * Constructor for main Window where the game will be running.
	 */
	public GameDisplay()
	{
	
		setLocationRelativeTo(null);
		JLabel mainLabel = new JLabel("A Tower Defence Game (Beta 1.0)"); 
		mainLabel.setFont(new Font("TrebuchetMS", Font.BOLD, 14));
        mainLabel.setBounds(280,500, 400, 20);  
        this.add(mainLabel);
        setResizable(false);
       
		setSize(size);
		setTitle("A Tower Defence Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //exit if closed
		visible();  //Part of visibility of the map 
		
		
	}
	
	/**
	 * Method that makes the game screen visible.
	 */	
	public void visible()
	{
	  JLabel background=new JLabel(new ImageIcon("img/background.png"));
	  launchSave=false;
	  JPanel dialogbox = new JPanel();
	  dialogbox.setLayout(null);
	  dialogbox.setBackground(Color.lightGray);
	  loadmap= new JButton("Load Map"); 
	  newmap =new JButton("New Map");
	  loadmap.setFont(new Font("Arial", 1, 12));
	  newmap.setFont(new Font("Arial", 1, 12));
	  
	 // dialogbox.add(play);
	  loadmap.setBounds(200,300,100, 100);
	  dialogbox.add(loadmap, BorderLayout.CENTER);
	  newmap.setBounds(500,300, 100, 100);
	  dialogbox.add(newmap, BorderLayout.CENTER);
	  
	  this.add(dialogbox);
	  
	  loadmap.addActionListener(this);
	  newmap.addActionListener(this);
	
	  
	  setVisible(true);
	  
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		 JButton clickedButton = (JButton) e.getSource();                //neutral button (to be clicked)
         String buttonText = clickedButton.getText();
         
         if (buttonText.equals("Load Map"))                              //load existing map
         {	
        	 launchSave=true;
             this.getContentPane().removeAll();
             MapEditor medit= new MapEditor(this,launchSave);            //launchSave boolean determines if map editor is loaded
             this.getContentPane().add(medit); 							//with existing map or new map
     		 setVisible(true);
     		 
         }
         
         
         else if(buttonText.equals("New Map"))                                //create a new map
         {
        	 
        	 launchSave=false;
        	 this.getContentPane().removeAll();
             MapEditor medit= new MapEditor(this,launchSave);            //launchSave boolean determines if map editor is loaded
             this.getContentPane().add(medit); 							//with existing map or new map
     		 setVisible(true);
     		 
         }
         	
	}
	
		 
}

		
	
	
	
	
	
	
	

