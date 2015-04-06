package main;


import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.model.GameLogic;
import main.model.Vector2D;
import main.model.map.Map;
import main.model.map.Path;
import main.view.NewJFrame;


public class Driver {
	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Map map = new Map();
				GameLogic model = new GameLogic(map);
				model.addCritter();
				
				NewJFrame frame = new NewJFrame(model);
				frame.setVisible(true);
				frame.setResizable(false);
				frame.validate();
				
				Timer t = new Timer();

				t.scheduleAtFixedRate(
				    new TimerTask()
				    {
				        public void run()
				        {
				            model.updateFrame();
				            frame.mapPanel.repaint();
				        }
				    },
				    0,
				    50);
			}
	});
	}
}
