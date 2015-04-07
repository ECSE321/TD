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
				map.tracePath(path);
				
				map.addTile(new Tile(new Vector2D(0,50)));
				map.addTile(new Tile(new Vector2D(50,50)));
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
