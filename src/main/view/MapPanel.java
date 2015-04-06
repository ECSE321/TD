package main.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.model.GameLogic;
import main.model.critter.Critter;
import main.model.map.Tile;
import main.model.tower.Tower;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author justin
 */
@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	private GameLogic gameLogic;
	
	Image pathImage = new ImageIcon("img/path.png").getImage();
	Image grassImage = new ImageIcon("img/grass.png").getImage();
	Image critterImage = new ImageIcon("img/critter.png").getImage();
	Image towerImage = new ImageIcon("img/tower.png").getImage();
	
	public MapPanel(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
		this.setSize(100, 100);
	}
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        g.drawImage(pathImage, 10, 10, this);
        
        /*
        try {
        List<Tile> tiles = gameLogic.getTilesList();
        for(Tile t : tiles) {
            if(t.isPath()) {
                g.drawImage(pathImage, t.getPosition().getX(), t.getPosition().getY(), this);
            } else {
                g.drawImage(grassImage, t.getPosition().getX(), t.getPosition().getY(), this);
            }
        }
        } catch (NullPointerException e) {
        	
        }
        
        try {
        List<Critter> critters = gameLogic.getCrittersList();
        for(Critter c : critters) {
            g.drawImage(critterImage, c.getPosition().getX(), c.getPosition().getY(), this);
            System.out.println(c.getPosition().getX());
        }
        } catch (NullPointerException e) {
        	System.out.println("critterlist had a null pointer exception");
        }
        
        try {
        List<Tower> towers = gameLogic.getTowersList();
        for(Tower t : towers) {
            g.drawImage(towerImage, t.getPosition().getX(), t.getPosition().getY(), this);
        }
        } catch (NullPointerException e) {
        	
        }
        */
    }
}
