package com.Teb.JavaGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Images extends JPanel {
	private static final long serialVersionUID = 1L;

	public Rectangle Player;
	public Rectangle Zombie;
	public Rectangle Platform;
	public Rectangle Platform1;
	public Rectangle chest;
	public Rectangle MenyPlatform;
	public Rectangle Arrow1;
	public Rectangle SpecialAttackRadius;

	public Rectangle[] solide = { Platform, Platform1, MenyPlatform };

	public int playerheight = 40;
	public int playerwidth = 20;
	public static int life = 3;
	public int frames = 0;
	public static int yOffset = 0;
	public static int chooseHead = 2;
	public static int chooseHeadzombie = 2;
	public static int RandomDirection = 0;
	public static int ZombieLife = 0;
	public static int ArrowDamageValue = 9;
	public static int Playerx = 50;
	public static int Playery = 50;
	public static int playerx = 0;
	public static int playery = 0;
	public static int Zombiex = 0;
	public static int Zombiey = 0;
	public static int zombiex = 0;
	public static int zombiey = 0;
	public static int respawning = 0;
	public static int TakenSlot = 0;
	public static int BoxObject = 0;
	public static int JumpHeight = 0;
	public static int Arrow1x;
	public static int Arrow1y;
	public static int SpecialAttack = 0;

	public static Timer timer;

	public static int InventorySlots;
	Random rand = new Random();

	int way = 200 + rand.nextInt(100);
	int chestSpawn = rand.nextInt(Main.width);

	public static boolean running = false;

	public static boolean onplatform = false;
	public static boolean sword = false;
	public static boolean PlayerAlive = true;
	public static boolean ZombieRespawn = false;
	public static boolean playerOnChest = false;
	public static boolean ZombieDead = false;

	public static boolean TakenSlot1 = false;
	public static boolean TakenSlot2 = false;
	public static boolean TakenSlot3 = false;

	private String ArrowDirection = "";

	public Images() {
		Player = new Rectangle(50, 50, playerwidth, playerheight);
		Platform = new Rectangle(0, 400, Main.width - 50, 10);
		Platform1 = new Rectangle(200, 300, 200, 10);
		chest = new Rectangle(chestSpawn, 200, 30, 30);
		Zombie = new Rectangle(50, 50, playerwidth, playerheight);
		MenyPlatform = new Rectangle(0, 555, 800, 10);
		Arrow1 = new Rectangle(0, 0, 16 * 2, 16 * 2);
		SpecialAttackRadius = new Rectangle(Player.x - SpecialAttack / 2
				+ Player.width / 2, Player.y - SpecialAttack / 2
				+ Player.height / 2, SpecialAttack, SpecialAttack);
		new ImportImages();

	}

	@SuppressWarnings("static-access")
	public void paint(Graphics g) {
		ImportImages imageimport = new ImportImages();
		if (!Main.start) {

			Point g1 = new Point(Zombie.x, Zombie.y + Zombie.height);
			if (!ML.Option)
				g.drawImage(imageimport.meny, 0, 0, 800, 2400, null);
			else if (ML.Option) {
				g.drawImage(imageimport.background, 0, 0, 800, 2400, null);
				if (ML.Difficulty.equalsIgnoreCase("HARD")) {
					g.drawImage(imageimport.DH, 0, 0, 800, 600, null);
					ArrowDamageValue = 3;
				}
				if (ML.Difficulty.equalsIgnoreCase("EASY")) {
					g.drawImage(imageimport.DE, 0, 0, 800, 600, null);
					ArrowDamageValue = 9;
				}
			}
			if (MML.Return) {
				g.setColor(Color.PINK);
			}
			g.drawImage(imageimport.body, Zombie.x, Zombie.y, Zombie.width,
					Zombie.height, null);
			g.fillRect(MenyPlatform.x, MenyPlatform.y, MenyPlatform.width,
					MenyPlatform.height);

			if (MML.PlayGameHoover) {

			}

			// Zombie
			if (!MenyPlatform.contains(g1)) {
				Zombie.y++;
			}

			if (RandomDirection == 0) {
				int object = rand.nextInt(600);
				RandomDirection = object;
			}
			if (Zombie.x == RandomDirection) {
				RandomDirection = 0;
			}

			if (Zombie.x != RandomDirection) {

				if (Zombie.x < RandomDirection) {
					Zombie.x++;
					chooseHeadzombie = 2;
				}
				if (Zombie.x > RandomDirection) {
					Zombie.x--;
					chooseHeadzombie = 1;
				}
			}

			if (chooseHeadzombie == 1) {
				g.drawImage(imageimport.zombiel, Zombie.x, Zombie.y
						- Zombie.height / 2, 20, 20, null);
			}
			if (chooseHeadzombie == 2) {
				g.drawImage(imageimport.zombier, Zombie.x, Zombie.y
						- Zombie.height / 2, 20, 20, null);
			}
			if (ML.PlayGame) {
				ML.PlayGame = false;
				Main.start = true;
			}
		} else if (Main.start) {
			if (!ZombieRespawn) {
				Zombie.y = 20;
				ZombieRespawn = true;
				ZombieDead = false;
			}
			KL keylistener = new KL();
			Point p1 = new Point(Player.x + Player.width / 2, Player.y
					+ Player.height);
			Point p2 = new Point(Player.x + Player.width / 2, Player.y - 20);
			Point z1 = new Point(Zombie.x, Zombie.y + Zombie.height);
			Point c1 = new Point(chest.x, chest.y + chest.height);
			Point c2 = new Point(chest.x + 10, chest.y);

			// Background
			g.drawImage(imageimport.background, 0, yOffset, Main.width,
					Main.height * 4, null);

			if (Player.y == Main.height - 1) {
				yOffset--;
				Player.y++;
				Platform.y--;
				Platform1.y--;
			}

			// System.out.println("Loading Images");
			g.fillRect(Platform.x, Platform.y, Platform.width, Platform.height);
			g.fillRect(Platform1.x, Platform1.y, Platform1.width,
					Platform1.height);
			g.drawImage(imageimport.chest1, chest.x, chest.y, chest.width,
					chest.height, null);
			// Hitbox Player

			// Bow
			if (KL.Use1 && TakenSlot1) {
				sword = true;
			} else
				sword = false;
			if (KL.Use2 && TakenSlot2) {
				if (KL.Use || KL.UseNumber >= 1) {

					if (KL.UseNumber == 0) {
						Arrow1.x = Player.x;
						Arrow1.y = Player.y;
						KL.UseNumber = 1;
					} else if (KL.UseNumber >= 1) {

						if (ArrowDirection.equalsIgnoreCase("")) {
							if (chooseHead == 1)
								ArrowDirection = "LEFT";
							if (chooseHead == 2)
								ArrowDirection = "RIGHT";
						}
						if (ArrowDirection.equalsIgnoreCase("LEFT")) {
							Arrow1.x -= 3;
							g.drawImage(imageimport.Arrow1, Arrow1.x, Arrow1.y,
									-Arrow1.width, Arrow1.height, null);
							KL.UseNumber += 3;
						}
						if (ArrowDirection.equalsIgnoreCase("RIGHT")) {
							Arrow1.x += 3;
							g.drawImage(imageimport.Arrow1, Arrow1.x, Arrow1.y,
									Arrow1.width, Arrow1.height, null);
							KL.UseNumber += 3;
						}
						if (KL.UseNumber >= 400) {
							KL.UseNumber = 0;
							KL.Use = false;
							ArrowDirection = "";
						}

					}

				}
			}
			// Arrow
			Point A1 = new Point(Arrow1.x,Arrow1.y);
			if (Zombie.contains(A1)) {
				ZombieLife += ArrowDamageValue;
				Arrow1.x = 801;
				KL.UseNumber = 400;
			}
			// Gravity
			if (!Platform.contains(p1) && keylistener.notjumping
					&& !keylistener.jumping && !Platform1.contains(p1)) {
				Player.y++;
				keylistener.onPlatform = false;
			} else if (Platform.contains(p1) || Platform1.contains(p1)) {
				keylistener.onPlatform = true;
			}
			if (!Platform.contains(z1)) {
				Zombie.y++;
			}
			if (Platform1.contains(p2)) {
				Player.y++;
			}
			if (!Platform1.contains(c1) && !Platform.contains(c1)) {
				chest.y++;
			}
			// Lifes
			if (life >= 4) {
				life = 3;
			}
			if (life == 3) {
				g.drawImage(imageimport.heart, 750, 20, 34, 34, null);
				g.drawImage(imageimport.heart, 710, 20, 34, 34, null);
				g.drawImage(imageimport.heart, 670, 20, 34, 34, null);

			}
			if (life == 2) {
				g.drawImage(imageimport.heart, 750, 20, 34, 34, null);
				g.drawImage(imageimport.heart, 710, 20, 34, 34, null);
				g.drawImage(imageimport.deadheart, 670, 20, 34, 34, null);
			}
			if (life == 1) {
				g.drawImage(imageimport.heart, 750, 20, 34, 34, null);
				g.drawImage(imageimport.deadheart, 710, 20, 34, 34, null);
				g.drawImage(imageimport.deadheart, 670, 20, 34, 34, null);
			}
			if (life < 1) {
				g.drawImage(imageimport.deadheart, 750, 20, 34, 34, null);
				g.drawImage(imageimport.deadheart, 710, 20, 34, 34, null);
				g.drawImage(imageimport.deadheart, 670, 20, 34, 34, null);
				PlayerAlive = false;
			}
			// hitboxes

			// Player bounds
			if (Player.x < 0) {
				Player.x = 0;
			}
			if (Player.x + Player.width > Main.width) {
				Player.x = Main.width - Player.width;
			}

			if (Zombie.x == 0) {
				Zombie.x++;
			}
			if (Zombie.x + Zombie.width == Main.width) {
				Zombie.x -= Player.width;
			}
			// Zombie Life

			g.drawImage(imageimport.ZombieHealth3, Zombie.x - 2, Zombie.y
					- Zombie.height - 10, 9 * 3, 3 * 3, null);
			g.drawImage(imageimport.ZombieHealth0, Zombie.x - 2, Zombie.y
					- Zombie.height - 10, ZombieLife, 3 * 3, null);
			if (ZombieLife >= 27) {
				ZombieDead = true;
			}

			// Player and Items and random
			if (PlayerAlive) {
				if (chooseHead == 1) {
					g.drawImage(imageimport.headl, Player.x, Player.y
							- Player.height / 2, 20, 20, null);
					g.drawImage(imageimport.body, Player.x, Player.y,
							Player.width, Player.height, null);
				}
				if (chooseHead == 2) {
					g.drawImage(imageimport.headr, Player.x, Player.y
							- Player.height / 2, 20, 20, null);
					g.drawImage(imageimport.body, Player.x, Player.y,
							Player.width, Player.height, null);
				}
			}
			// PlayerNotAlive
			if (!PlayerAlive) {

				g.drawImage(imageimport.died, -350, 0, 160 * 10, 60 * 10, null);

				Player.y = 600;

				if (respawning < 2) {
					g.drawImage(imageimport.respawn, 275, 400, 50 * 5, 10 * 5,
							null);
				}

				if (respawning == 3) {
					g.drawImage(imageimport.three, 275, 400, 10 * 5, 10 * 5,
							null);
				}
				if (respawning == 4) {
					g.drawImage(imageimport.two, 275, 400, 10 * 5, 10 * 5, null);
				}
				if (respawning == 5) {
					g.drawImage(imageimport.one, 275, 400, 10 * 5, 10 * 5, null);
				}
				if (respawning == 6) {
					Player.x = 20;
					Player.y = 20;
					life = 3;
					PlayerAlive = true;

				}

			}
			if (sword) {
				if (chooseHead == 1) {
					g.drawImage(imageimport.swordimg, Player.x - 10,
							Player.y + 10, 20, 5, null);
				}
				if (chooseHead == 2) {
					g.drawImage(imageimport.swordimg1, Player.x + 10,
							Player.y + 10, 20, 5, null);
				}

			}
			// Inventory
			g.drawImage(imageimport.InventorySlot, 750, 50, 16 * 2, 16 * 2,
					null);
			g.drawImage(imageimport.InventorySlot, 710, 50, 16 * 2, 16 * 2,
					null);
			g.drawImage(imageimport.InventorySlot, 670, 50, 16 * 2, 16 * 2,
					null);

			if (TakenSlot1) {
				g.drawImage(imageimport.swordimg, 673, 65, 27, 5, null);
			}
			if (TakenSlot2) {
				g.drawImage(imageimport.bow, 717, 60, 16, 16, null);
			}
			if (TakenSlot3) {
				if (Chest.SPECIAL.equalsIgnoreCase("HEART"))
					g.drawImage(imageimport.heart, 755, 55, 8 * 3, 8 * 3, null);
				if (Chest.SPECIAL.equalsIgnoreCase("SPECIAL"))
					g.drawImage(imageimport.special, 754, 54, 8 * 3, 8 * 3,
							null);

			}
			// ZombieDrawing
			if (!ZombieDead) {
				g.drawImage(imageimport.body, Zombie.x, Zombie.y, Zombie.width,
						Zombie.height, null);
				if (chooseHeadzombie == 1) {
					g.drawImage(imageimport.zombiel, Zombie.x, Zombie.y
							- Zombie.height / 2, 20, 20, null);
				}
				if (chooseHeadzombie == 2) {
					g.drawImage(imageimport.zombier, Zombie.x, Zombie.y
							- Zombie.height / 2, 20, 20, null);
				}

			} else
				Zombie.x = 1000;
			// Use Items
			if (KL.Use3) {
				if (Chest.SPECIAL.equalsIgnoreCase("HEART")) {
					life++;
					KL.Use3 = false;
					TakenSlot3 = false;
				}
				if (Chest.SPECIAL.equalsIgnoreCase("SPECIAL")) {
					SpecialAttack++;
					g.drawImage(imageimport.specialOnScreen, Player.x
							- SpecialAttack / 2 + Player.width / 2, Player.y
							- SpecialAttack / 2 + Player.height / 2,
							SpecialAttack, SpecialAttack, null);
					if (SpecialAttack == 300) {
						SpecialAttack = 0;
						TakenSlot3 = false;
						KL.Use3 = false;
					}
				}

			}
			if (KL.Use1)
				g.drawImage(imageimport.InventorySlotOccupied, 670, 50, 16 * 2,
						16 * 2, null);
			if (KL.Use2)
				g.drawImage(imageimport.InventorySlotOccupied, 710, 50, 16 * 2,
						16 * 2, null);
			if (Zombie.x >= Player.x - SpecialAttack / 2
					&& Zombie.x <= Player.x + SpecialAttack / 2
					&& Zombie.y >= Player.y - SpecialAttack / 2
					&& Zombie.y <= Player.y + SpecialAttack / 2
					&& SpecialAttack != 0) {
				ZombieLife++;
			}
			new Chest();
			if (Player.contains(c2)) {
				playerOnChest = true;
				g.drawImage(imageimport.InventorySlot, 50, 50, 16 * 3, 16 * 3,
						null);
				if (Chest.ChestObject.equalsIgnoreCase("SWORD")) {
					g.drawImage(imageimport.swordimg, 60, 72, 27, 5, null);
				}
				if (Chest.ChestObject.equalsIgnoreCase("BOW")) {
					g.drawImage(imageimport.bow, 56, 58, 16 * 2, 16 * 2, null);
				}
				if (Chest.ChestObject.equalsIgnoreCase("HEART")) {
					g.drawImage(imageimport.heart, 58, 60, 16 * 2, 16 * 2, null);
				}
				if (Chest.ChestObject.equalsIgnoreCase("SPECIAL")) {
					g.drawImage(imageimport.special, 58, 58, 16 * 2, 16 * 2,
							null);
				}

			} else
				playerOnChest = false;
			// Zombie / Player Coordinates
			zombiex = Zombie.x;
			zombiey = Zombie.y;
			playerx = Player.x;
			playery = Player.y;

			Arrow1.x += Arrow1x;
			Arrow1x = 0;
			Arrow1.y += Arrow1y;
			Arrow1y = 0;
			new Player();
			Player.x += Playerx;
			Playerx = 0;
			Player.y += Playery;
			Playery = 0;
			new Zombie();
			Zombie.x += Zombiex;
			Zombiex = 0;
			Zombie.y += Zombiey;
			Zombiey = 0;

		}
		if (!running) {
			GameLoop();
			running = true;
		}
		g.dispose();
	}

	public void GameLoop() {
		Timer timer2;
		timer = new Timer(1000 / 190, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				repaint();

				frames++;

			}

		});
		timer.start();
		timer2 = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(frames);
				frames = 0;
			}

		});
		timer2.start();
	}
}
