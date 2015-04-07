/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.List;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import main.model.GameLogic;
import main.model.View;
import main.model.critter.*;
import main.model.map.Tile;
import main.model.tower.CanonTower;
import main.model.tower.MachineGunTower;
import main.model.tower.MortarTower;
import main.model.tower.Tower;

/**
 *
 * @author justin
 */
@SuppressWarnings("serial")
public class NewJFrame extends javax.swing.JFrame implements View {
	GameLogic model;
	
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame(GameLogic model) {
        initComponents();
        this.model = model;
        
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	final Image pathImage = new ImageIcon("src/main/view/img/path.png").getImage();
    	final Image landscapeImage = new ImageIcon("src/main/view/img/landscape.png").getImage();

        jPanel1 = new javax.swing.JPanel();
		mapPanel = new javax.swing.JPanel() {
		
			@Override
			 public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        
		        g.setColor(Color.black);
		        List<Tile> tiles = model.getTilesList();
		        for(Tile t : tiles) {
		        	if(t.isPath()) {
		        		g.drawRect(t.getPosition().getX(), t.getPosition().getY(), 50, 50);
		        		g.drawImage(pathImage, t.getPosition().getX(), t.getPosition().getY(),
		        				50, 50, null);
		        	} else {
		        		g.drawImage(landscapeImage, t.getPosition().getX(), t.getPosition().getY(),
		        				50, 50, null);
		        		if(t.equals(model.getSelectedTile())) {
		        			g.setColor(Color.yellow);
		        			((Graphics2D)g).setStroke(new BasicStroke(5));
		        			g.drawRect(t.getPosition().getX(), t.getPosition().getY(), 50, 50);
		        		}
		        	}
		        }
		        
		        List<Critter> critters = model.getCrittersList();
		        for(Critter c : critters) {
		        	if(c instanceof FastCritter) {
		        		g.setColor(Color.pink);
		        	}else if(c instanceof TankCritter) {
		        		g.setColor(Color.green);
		        	} else {
		        		g.setColor(Color.blue);
		        	}
		        	g.fillOval(c.getPosition().getX(), c.getPosition().getY(), 25, 25);
		        	int health = c.getHitPoints();
		        	g.setColor(Color.red);
		        	g.fillRect(c.getPosition().getX(), c.getPosition().getY(), health/3, 5);
		        }
		        
		        List<Tower> towers = model.getTowersList();
		        for(Tower t: towers) {
		        	if(t instanceof CanonTower) {
		        		g.setColor(Color.blue);
		        	} else if(t instanceof MachineGunTower) {
		        		g.setColor(Color.yellow);
		        	} else if(t instanceof MortarTower) {
		        		g.setColor(Color.orange);
		        	} else {
		        		g.setColor(Color.cyan);
		        	}
		        	g.fillRect(t.getPosition().getX() - 12, t.getPosition().getY() - 12, 25, 25);
		        }
		        
		        if(model.getMap().getSelectedTile() != null) {
		        	if(model.getMap().getSelectedTile().getTower() != null) {
		        		g.setColor(Color.red);
		        		Tower t = model.getMap().getSelectedTile().getTower();
		        		int range = t.getRange()*10;
		        		int x = t.getPosition().getX() - range/2;
		        		int y = t.getPosition().getY() - range/2;
		        		((Graphics2D)g).setStroke(new BasicStroke(2));
		        		g.drawOval(x, y, range, range);
		        	}
		        }
			}
		};
        PurchasePanel = new javax.swing.JPanel();
        PurchaseA = new javax.swing.JButton();
        PurchaseB = new javax.swing.JButton();
        PurchaseC = new javax.swing.JButton();
        PurchaseD = new javax.swing.JButton();
        Upgrade = new javax.swing.JButton();
        Sell = new javax.swing.JButton();
        sellValue = new javax.swing.JLabel();
        upgradeCost = new javax.swing.JLabel();
        StrengthA = new javax.swing.JLabel();
        RoFA = new javax.swing.JLabel();
        RangeA = new javax.swing.JLabel();
        CostA = new javax.swing.JLabel();
        CostB = new javax.swing.JLabel();
        StrengthB = new javax.swing.JLabel();
        RoFB = new javax.swing.JLabel();
        RangeB = new javax.swing.JLabel();
        RoFC = new javax.swing.JLabel();
        RangeC = new javax.swing.JLabel();
        StrengthC = new javax.swing.JLabel();
        CostC = new javax.swing.JLabel();
        CostD = new javax.swing.JLabel();
        RangeD = new javax.swing.JLabel();
        StrengthD = new javax.swing.JLabel();
        RoFD = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        playerPanel = new javax.swing.JPanel();
        Gold = new javax.swing.JLabel();
        Health = new javax.swing.JLabel();
        Level = new javax.swing.JLabel();
        NextWave = new javax.swing.JButton();
        
        /*
         * Disable Buttons on start
         */
        PurchaseA.setEnabled(false);
        PurchaseB.setEnabled(false);
        PurchaseC.setEnabled(false);
        PurchaseD.setEnabled(false);
        
        Upgrade.setEnabled(false);
        Sell.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        mapPanel.setBackground(new java.awt.Color(238, 238, 238));
        mapPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PurchasePanel.setBackground(new java.awt.Color(238, 238, 238));

        PurchaseA.setText("Purchase");
        PurchaseA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseAActionPerformed(evt);
            }
        });

        PurchaseB.setText("Purchase");
        PurchaseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseBActionPerformed(evt);
            }
        });

        PurchaseC.setText("Purchase");
        PurchaseC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseCActionPerformed(evt);
            }
        });

        PurchaseD.setText("Purchase");
        PurchaseD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseDActionPerformed(evt);
            }
        });

        Upgrade.setText("Upgrade");
        Upgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeActionPerformed(evt);
            }
        });

        Sell.setText("Sell");
        Sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellActionPerformed(evt);
            }
        });

        sellValue.setText("Value");

        upgradeCost.setText("Cost");

        StrengthA.setText("Strength: 50");

        RoFA.setText("RoF: 3");

        RangeA.setText("Range: ");

        CostA.setText("Cost");

        CostB.setText("Cost");

        StrengthB.setText("Strength");

        RoFB.setText("RoF");

        RangeB.setText("Range");

        RoFC.setText("RoF");

        RangeC.setText("Range");

        StrengthC.setText("Strength");

        CostC.setText("Cost");

        CostD.setText("Cost");

        RangeD.setText("Range");

        StrengthD.setText("Strength");

        RoFD.setText("RoF");

        javax.swing.GroupLayout PurchasePanelLayout = new javax.swing.GroupLayout(PurchasePanel);
        PurchasePanel.setLayout(PurchasePanelLayout);
        PurchasePanelLayout.setHorizontalGroup(
            PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PurchaseA)
                    .addComponent(RangeA)
                    .addComponent(RoFA)
                    .addComponent(StrengthA)
                    .addComponent(CostA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PurchaseB)
                    .addComponent(RangeB)
                    .addComponent(RoFB)
                    .addComponent(StrengthB)
                    .addComponent(CostB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PurchaseC)
                    .addComponent(RangeC)
                    .addComponent(RoFC)
                    .addComponent(StrengthC)
                    .addComponent(CostC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RangeD)
                    .addComponent(RoFD)
                    .addComponent(StrengthD)
                    .addComponent(CostD)
                    .addComponent(PurchaseD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                        .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sellValue)
                            .addComponent(upgradeCost))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Sell, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Upgrade)))
                .addContainerGap())
        );
        PurchasePanelLayout.setVerticalGroup(
            PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                        .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PurchasePanelLayout.createSequentialGroup()
                                .addComponent(sellValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sell))
                            .addGroup(PurchasePanelLayout.createSequentialGroup()
                                .addComponent(CostA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StrengthA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RoFA)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(upgradeCost)
                            .addComponent(RangeA)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                        .addComponent(CostB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StrengthB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoFB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RangeB))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                        .addComponent(CostC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StrengthC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoFC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RangeC))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PurchasePanelLayout.createSequentialGroup()
                        .addComponent(CostD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StrengthD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoFD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RangeD)))
                .addGap(5, 5, 5)
                .addGroup(PurchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PurchaseA)
                    .addComponent(PurchaseB)
                    .addComponent(PurchaseC)
                    .addComponent(PurchaseD)
                    .addComponent(Upgrade))
                .addContainerGap())
        );

        playerPanel.setBackground(new java.awt.Color(238, 238, 238));

        Gold.setText("Gold");

        Health.setText("Health");

        Level.setText("Level");

        NextWave.setText("Next Wave");
        NextWave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWave(evt);
            }
        });

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Gold)
                    .addComponent(Health)
                    .addComponent(Level))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addComponent(NextWave)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Gold)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Health)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Level)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addComponent(NextWave))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PurchasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PurchasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    private void startWave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWave
        model.startWave();
    }//GEN-LAST:event_startWave

    private void mapPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMouseClicked
        // TODO add your handling code here:
        Point point = evt.getPoint();
        model.selectTile(point);
        if(model.getSelectedTile() != null) {
        	if(model.getSelectedTile().getTower() == null) {
        		purchaseMode();
        	} else {
        		upgradeMode();
        	}
        	
        }
        
    }//GEN-LAST:event_mapPanelMouseClicked

    private void SellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellActionPerformed
        // TODO add your handling code here:
        model.sellTower();
        
        purchaseMode();
    }//GEN-LAST:event_SellActionPerformed

    private void UpgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeActionPerformed
        // TODO add your handling code here:
        model.upgradeTower();
    }//GEN-LAST:event_UpgradeActionPerformed

    private void PurchaseDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseDActionPerformed
        // TODO add your handling code here:
        model.purchaseTower(3);
        
        upgradeMode();
    }//GEN-LAST:event_PurchaseDActionPerformed

    private void PurchaseCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseCActionPerformed
        // TODO add your handling code here:
        model.purchaseTower(2);
        
        upgradeMode();
    }//GEN-LAST:event_PurchaseCActionPerformed
    
    private void PurchaseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseBActionPerformed
        // TODO add your handling code here:
        model.purchaseTower(1);
        
        upgradeMode();
    }//GEN-LAST:event_PurchaseBActionPerformed

    private void PurchaseAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseAActionPerformed
        // TODO add your handling code here:
        model.purchaseTower(0);
        upgradeMode();
        
    }//GEN-LAST:event_PurchaseAActionPerformed
    
    public void purchaseMode() {
    	
    	PurchaseA.setEnabled(true);
    	PurchaseB.setEnabled(true);
    	PurchaseC.setEnabled(true);
    	PurchaseD.setEnabled(true);
        
        Upgrade.setEnabled(false);
        Sell.setEnabled(false);
        
        update();
    }
    
    public void upgradeMode() {
    	 PurchaseA.setEnabled(false);
         PurchaseB.setEnabled(false);
         PurchaseC.setEnabled(false);
         PurchaseD.setEnabled(false);
         
         Upgrade.setEnabled(true); 
         Sell.setEnabled(true);
         
         updateUpgrade();
         update();
    }
    
    public void updateUpgrade() {
    	int cost;
    	int refund;
    	
    	if(model.getSelectedTile().getTower() != null) {
    		cost = model.getSelectedTile().getTower().getUpgradeCost();
    		refund = model.getSelectedTile().getTower().getRefundValue();
    	} else {
    		cost = 0;
    		refund = 0;
    	}
    	
    	upgradeCost.setText("Cost: " + cost);
    	sellValue.setText("Refund: " + refund);
    	update();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CostA;
    private javax.swing.JLabel CostB;
    private javax.swing.JLabel CostC;
    private javax.swing.JLabel CostD;
    private javax.swing.JLabel Gold;
    private javax.swing.JLabel Health;
    private javax.swing.JLabel Level;
    private javax.swing.JButton NextWave;
    private javax.swing.JButton PurchaseA;
    private javax.swing.JButton PurchaseB;
    private javax.swing.JButton PurchaseC;
    private javax.swing.JButton PurchaseD;
    private javax.swing.JPanel PurchasePanel;
    private javax.swing.JLabel RangeA;
    private javax.swing.JLabel RangeB;
    private javax.swing.JLabel RangeC;
    private javax.swing.JLabel RangeD;
    private javax.swing.JLabel RoFA;
    private javax.swing.JLabel RoFB;
    private javax.swing.JLabel RoFC;
    private javax.swing.JLabel RoFD;
    private javax.swing.JButton Sell;
    private javax.swing.JLabel StrengthA;
    private javax.swing.JLabel StrengthB;
    private javax.swing.JLabel StrengthC;
    private javax.swing.JLabel StrengthD;
    private javax.swing.JButton Upgrade;
    private javax.swing.JLabel sellValue;
    private javax.swing.JLabel upgradeCost;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel mapPanel;
    private javax.swing.JPanel playerPanel;
    // End of variables declaration//GEN-END:variables

	@Override
	public void update() {
		// TODO Auto-generated method stub
		int playerGold = model.getPlayer().getGold();
		if(playerGold < 1200) {
			PurchaseA.setEnabled(false);
		}
		if(playerGold < 1200) {
			PurchaseB.setEnabled(false);
		}
		if(playerGold < 1200) {
			PurchaseC.setEnabled(false);
		}
		if(playerGold < 1200) {
			PurchaseD.setEnabled(false);
		}
		
		if(playerGold < 1200) {
			Upgrade.setEnabled(false);
		}
		
		Gold.setText("Gold: " + playerGold);
		Health.setText("Health: " + model.getPlayer().getHealth());
		Level.setText("Level: " + model.getPlayer().getLevel());
	}
}
