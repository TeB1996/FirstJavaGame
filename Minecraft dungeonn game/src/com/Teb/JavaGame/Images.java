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

	public Rectangle[] solide = { Platform, Platform1, MenyPlatform };

	public int playerheight = 40;
	public int playerwidth = 20;
	public int life = 3;
	public int frames = 0;
	public static int yOffset = 0;
	public static int chooseHead = 2;
	public int chooseHeadzombie = 2;
	public int RandomDirection = 0;
	public int ZombieLife = 3;
	public static int Playerx = 0;
	public static int Playery = 0;
	public static int respawning = 0;
	public static int TakenSlot = 0;
	public static boolean zombiefollow = true;
	public static Timer timer;

	public static int InventorySlots;
	Random rand = new Random();

	int way = 200 + rand.nextInt(100);
	int chestSpawn = rand.nextInt(Main.width);

	public static boolean running = false;

	public static boolean onplatform = false;
	public static boolean sword = false;
	public static boolean zombieFollow = false;
	public static boolean PlayGame = false;
	public boolean PlayerAlive = true;
	public static boolean ZombieAttack = true;
	public static boolean ZombieRespawn = false;
	public static boolean TakenSlot1 = true;
	public static boolean TakenSlot2 = true;
	public static boolean TakenSlot3 = true;

	public Images() {
		Player = new Rectangle(400, 200, playerwidth, playerheight);
		Platform = new Rectangle(0, 400, Main.width - 50, 10);
		Platform1 = new Rectangle(200, 300, 200, 10);
		chest = new Rectangle(chestSpawn, 200, 30, 30);
		Zombie = new Rectangle(20, 200, playerwidth, playerheight);
		MenyPlatform = new Rectangle(0, 555, 800, 10);

	}

	@SuppressWarnings("static-access")
	public void paint(Graphics g) {
		ImportImages imageimport = new ImportImages();
		if (!Main.start) {

			Point g1 = new Point(Zombie.x, Zombie.y + Zombie.height);

			g.drawImage(imageimport.meny, 0, 0, 800, 2400, null);
			g.setColor(Color.BLACK);

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
			if (PlayGame) {
				PlayGame = false;
				Main.start = true;
				System.out.println("clicking");
			}
		} else if (Main.start) {
			if (!ZombieRespawn) {
				Zombie.y = 20;
				ZombieRespawn = true;
			}
			KL keylistener = new KL();
			Point p1 = new Point(Player.x + Player.width / 2, Player.y
					+ Player.height);
			Point p2 = new Point(Player.x + Player.width / 2, Player.y - 20);
			Point z1 = new Point(Zombie.x, Zombie.y + Zombie.height);
			Point c1 = new Point(chest.x, chest.y + chest.height);
			Point c2 = new Point(chest.x + 10, chest.y);
			int[] chestpoint = { chest.x, chest.y + 20 };
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

			// Gravity
			if (Player.y == chestpoint[1] && Player.x == chestpoint[0]) {
				g.fillRect(chest.x, chest.y, chest.width, chest.height);
			}
			if (!Platform.contains(p1) && keylistener.notjumping
					&& !keylistener.jumping && !Platform1.contains(p1)) {
				Player.y++;
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
			// Zombie AI
			if (Player.y == Zombie.y) {
				respawning = 0;
				if (zombiefollow) {
					if (Player.x - 25 > Zombie.x) {
						Zombie.x++;
						chooseHeadzombie = 2;
					}
					if (Player.x + 25 < Zombie.x) {
						Zombie.x--;
						chooseHeadzombie = 1;
					}
				}
				if (ZombieAttack) {
					if (Zombie.x == Player.x - 25 && Zombie.y == Player.y
							|| Zombie.x == Player.x + 25
							&& Zombie.y == Player.y) {
						life -= 1;
						ZombieAttack = false;
						timer = new Timer(1000, new ZombieAttackTimer());
						timer.start();

					}
				}
				if (Zombie.x == Player.x) {
					if (!zombieFollow) {
						timer = new Timer(way, new ZombieTimer());
						timer.start();
					}
					zombieFollow = true;
				}
			} else if (Player.y != Zombie.y) {
				if (Zombie.y < Player.y + 60) {
					respawning = 0;
					if (zombiefollow) {
						if (Player.x - 25 > Zombie.x) {
							Zombie.x++;
							chooseHeadzombie = 2;
						}
						if (Player.x + 25 < Zombie.x) {
							Zombie.x--;
							chooseHeadzombie = 1;
						}
					}
				} else {
					if (RandomDirection == 0) {
						int object = 100 + rand.nextInt(400);
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
				}
			}

			if (ZombieLife == 3) {
				g.drawImage(imageimport.ZombieHealth3, Zombie.x - 2, Zombie.y
						- Zombie.height - 10, 9 * 3, 3 * 3, null);
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
				if (respawning > 1) {

					if (respawning == 3) {
						g.drawImage(imageimport.three, 275, 400, 10 * 5,
								10 * 5, null);
					}
					if (respawning == 4) {
						g.drawImage(imageimport.two, 275, 400, 10 * 5, 10 * 5,
								null);
					}
					if (respawning == 5) {
						g.drawImage(imageimport.one, 275, 400, 10 * 5, 10 * 5,
								null);
					}
					if (respawning == 6) {
						Player.x = 20;
						Player.y = 20;
						life = 3;
						PlayerAlive = true;

					}

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
			if (Player.contains(c2)) {
				g.drawImage(imageimport.InventorySlot, 50, 50, 16 * 3, 16 * 3,
						null);
			}
			// Inventory
			g.drawImage(imageimport.InventorySlot, 750, 50, 16 * 2, 16 * 2,
					null);
			g.drawImage(imageimport.InventorySlot, 710, 50, 16 * 2, 16 * 2,
					null);
			g.drawImage(imageimport.InventorySlot, 670, 50, 16 * 2, 16 * 2,
					null);
			TakenSlot = 2;
			if (sword) {
				if (TakenSlot1) {
					g.drawImage(imageimport.swordimg, 673, 65, 27, 5, null);
				}
				if (TakenSlot2) {
					g.drawImage(imageimport.swordimg, 713, 65, 27, 5, null);
					TakenSlot2 = false;
				}
				if (TakenSlot3) {
					g.drawImage(imageimport.swordimg, 753, 65, 27, 5, null);
					TakenSlot3 = false;
				}
			}

			g.drawImage(imageimport.body, Zombie.x, Zombie.y, Zombie.width,
					Zombie.height, null);

			new Player();
			Player.x += Playerx;
			Playerx = 0;
			Player.y += Playery;
			Playery = 0;
		}
		if (!running) {
			running = true;
			GameLoop();
		}
		g.dispose();
	}

	public void GameLoop() {
		Timer timer2;
		timer = new Timer(3, new ActionListener() {

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

				System.out.println(frames + " FPS");
				frames = 0;
			}

		});
		timer2.start();
	}
}
