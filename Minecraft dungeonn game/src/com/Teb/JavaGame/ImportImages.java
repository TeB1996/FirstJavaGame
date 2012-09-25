package com.Teb.JavaGame;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class ImportImages {
	public Image background;
	public Image body;
	public Image headl;
	public Image headr;
	public Image zombiel;
	public Image zombier;
	public Image swordimg;
	public Image swordimg1;
	public Image chest1;
	public Image heart;
	public Image deadheart;
	public Image died;
	public Image ZombieHealth3;
	public Image ZombieHealth2;
	public Image ZombieHealth1;
	public Image ZombieHealth0;
	public Image respawn;
	public Image one;
	public Image two;
	public Image three;
	public Image meny;
	public Image InventorySlot;
	public Image pointingArrowl;
	public Image pointingArrowr;
	public Image bow;
	public Image Arrow1;
	public Image special;
	public Image specialOnScreen;
	public Image InventorySlotOccupied;
	public Image OptionMeny;
	public Image DE;
	public Image DH;

	public int playerheight = 40;
	public int playerwidth = 20;
	Random rand = new Random();
	int chestSpawn = rand.nextInt(Main.width);

	public ImportImages() {
		background = new ImageIcon("res/bg.png").getImage();
		body = new ImageIcon("res/body.png").getImage();
		headl = new ImageIcon("res/headleft.png").getImage();
		headr = new ImageIcon("res/headright.png").getImage();
		zombiel = new ImageIcon("res/zombieleft.png").getImage();
		zombier = new ImageIcon("res/zombieright.png").getImage();
		swordimg = new ImageIcon("res/sword.png").getImage();
		swordimg1 = new ImageIcon("res/sword1.png").getImage();
		chest1 = new ImageIcon("res/chest.png").getImage();
		heart = new ImageIcon("res/heart.png").getImage();
		deadheart = new ImageIcon("res/deadheart.png").getImage();
		died = new ImageIcon("res/died.png").getImage();
		ZombieHealth3 = new ImageIcon("res/health3.png").getImage();
		ZombieHealth2 = new ImageIcon("res/health2.png").getImage();
		ZombieHealth1 = new ImageIcon("res/health1.png").getImage();
		ZombieHealth0 = new ImageIcon("res/health0.png").getImage();
		respawn = new ImageIcon("res/respawn.png").getImage();
		one = new ImageIcon("res/1.png").getImage();
		two = new ImageIcon("res/2.png").getImage();
		three = new ImageIcon("res/3.png").getImage();
		meny = new ImageIcon("res/meny.png").getImage();
		pointingArrowl = new ImageIcon("resarrowleft.png").getImage();
		pointingArrowr = new ImageIcon("resarrowright.png").getImage();
		InventorySlot = new ImageIcon("res/BoxInventory.png").getImage();
		bow = new ImageIcon("res/bow.png").getImage();
		Arrow1 = new ImageIcon("res/Arrow.png").getImage();
		special = new ImageIcon("res/Special.png").getImage();
		specialOnScreen = new ImageIcon("res/SpecialBig.png").getImage();
		InventorySlotOccupied  = new ImageIcon("res/BoxInventoryOccupied.png").getImage();
		OptionMeny  = new ImageIcon("res/BoxInventoryOccupied.png").getImage();
		DH  = new ImageIcon("res/DifficultyHard.png").getImage();
		DE  = new ImageIcon("res/DifficultyEasy.png").getImage();
	}

}
