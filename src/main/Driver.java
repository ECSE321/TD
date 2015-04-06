package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.controller.PurchaseController;
import main.model.Attack;
import main.model.Player;
import main.model.Vector2D;
import main.model.critter.*;
import main.model.tower.*;
import main.view.PurchaseView;

public class Driver {
	public static void main(String[] args) {
		Vector2D origin = new Vector2D(0,0);
		Tower canonTower = new CanonTower(origin);
		Tower mortarTower = new MortarTower(origin);
		Tower machineGunTower = new MachineGunTower(origin);
		Tower spellTower = new SpellTower(origin);
		TowerManager tm = new TowerManager();
		tm.addTower(canonTower);
		tm.addTower(mortarTower);
		tm.addTower(machineGunTower);
		tm.addTower(spellTower);
		
		Critter fastCritter = new FastCritter(10);
		Critter normalCritter = new NormalCritter(10);
		Critter tankCritter = new TankCritter(10);
		CritterManager cm = new CritterManager();
		cm.addCritter(fastCritter);
		cm.addCritter(normalCritter);
		cm.addCritter(tankCritter);
		
		Player p = new Player(10,10,10);
		
		Printer print_thread = new Printer(cm);
		print_thread.start();
		
		Attack attack_thread = new Attack(cm,tm,p);
		attack_thread.start();
		
		
	}
}
