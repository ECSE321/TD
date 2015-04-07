package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import main.model.GameLogic;
import main.model.Vector2D;
import main.model.map.Map;
import main.model.map.Tile;
import main.view.NewJFrame;


public class Driver {
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Map map = new Map();
				
				/*
				 * FOR TESTING
				 */
				List<Vector2D> path = new ArrayList<Vector2D>();
				path.add(new Vector2D(0,0));
				path.add(new Vector2D(50,0));
				path.add(new Vector2D(100,0));
				path.add(new Vector2D(100,50));
				path.add(new Vector2D(100,100));
				path.add(new Vector2D(50, 100));
				path.add(new Vector2D(50, 150));
				path.add(new Vector2D(50, 200));
				path.add(new Vector2D(100, 200));
				path.add(new Vector2D(150, 200));
				path.add(new Vector2D(200, 200));
				path.add(new Vector2D(250, 200));
				path.add(new Vector2D(300, 200));
				path.add(new Vector2D(350, 200));
				path.add(new Vector2D(400, 200));
				map.tracePath(path);
				
				map.addTile(new Tile(new Vector2D(0,50)));
				map.addTile(new Tile(new Vector2D(0,100)));
				map.addTile(new Tile(new Vector2D(0,150)));
				map.addTile(new Tile(new Vector2D(0,200)));
				map.addTile(new Tile(new Vector2D(0,250)));
				map.addTile(new Tile(new Vector2D(0,300)));
				map.addTile(new Tile(new Vector2D(0,350)));
				
				map.addTile(new Tile(new Vector2D(50,50)));
				map.addTile(new Tile(new Vector2D(50,250)));
				map.addTile(new Tile(new Vector2D(50,300)));
				map.addTile(new Tile(new Vector2D(50,350)));
				
				map.addTile(new Tile(new Vector2D(100,150)));
				map.addTile(new Tile(new Vector2D(100,250)));
				map.addTile(new Tile(new Vector2D(100,300)));
				map.addTile(new Tile(new Vector2D(100,350)));
				
				map.addTile(new Tile(new Vector2D(150,0)));
				map.addTile(new Tile(new Vector2D(150,50)));
				map.addTile(new Tile(new Vector2D(150,100)));
				map.addTile(new Tile(new Vector2D(150,150)));
				map.addTile(new Tile(new Vector2D(150,250)));
				map.addTile(new Tile(new Vector2D(150,300)));
				map.addTile(new Tile(new Vector2D(150,350)));
				
				map.addTile(new Tile(new Vector2D(200,0)));
				map.addTile(new Tile(new Vector2D(200,50)));
				map.addTile(new Tile(new Vector2D(200,100)));
				map.addTile(new Tile(new Vector2D(200,150)));
				map.addTile(new Tile(new Vector2D(200,250)));
				map.addTile(new Tile(new Vector2D(200,300)));
				map.addTile(new Tile(new Vector2D(200,350)));
				
				map.addTile(new Tile(new Vector2D(250,0)));
				map.addTile(new Tile(new Vector2D(250,50)));
				map.addTile(new Tile(new Vector2D(250,100)));
				map.addTile(new Tile(new Vector2D(250,150)));
				map.addTile(new Tile(new Vector2D(250,250)));
				map.addTile(new Tile(new Vector2D(250,300)));
				map.addTile(new Tile(new Vector2D(250,350)));
				
				map.addTile(new Tile(new Vector2D(300,0)));
				map.addTile(new Tile(new Vector2D(300,50)));
				map.addTile(new Tile(new Vector2D(300,100)));
				map.addTile(new Tile(new Vector2D(300,150)));
				map.addTile(new Tile(new Vector2D(300,250)));
				map.addTile(new Tile(new Vector2D(300,300)));
				map.addTile(new Tile(new Vector2D(300,350)));
				
				map.addTile(new Tile(new Vector2D(350,0)));
				map.addTile(new Tile(new Vector2D(350,50)));
				map.addTile(new Tile(new Vector2D(350,100)));
				map.addTile(new Tile(new Vector2D(350,150)));
				map.addTile(new Tile(new Vector2D(350,250)));
				map.addTile(new Tile(new Vector2D(350,300)));
				map.addTile(new Tile(new Vector2D(350,350)));
				/*
				 * END TESTING
				 */
				
				
				final GameLogic model = new GameLogic(map);
				
				final NewJFrame frame = new NewJFrame(model);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.validate();
				
				model.addView(frame);
				
				Timer timer = new Timer();

				timer.scheduleAtFixedRate(
				    new TimerTask()
				    {
				        public void run()
				        {
				            model.updateFrame();
				            frame.mapPanel.repaint();
				            frame.mapPanel.revalidate();
				        }
				    },
				    0,
				    50);
			}
	});
	}
}
