package com.Teb.JavaGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Meny extends JPanel {
	private static final long serialVersionUID = 1L;

	public Image meny;
	public Image zombiel;
	public Image zombier;
	public Image Body;
	public Rectangle Platform;
	public Rectangle Zombie;

	public boolean running = false;
	public static boolean PlayGame = false;

	public int frames = 0;
	public int RandomDirection = 0;
	public int chooseHeadZombie = 1;
	Timer timer;
	Random rand = new Random();

	public Meny() {
		meny = new ImageIcon("res/meny.png").getImage();
		zombiel = new ImageIcon("res/zombieleft.png").getImage();
		zombier = new ImageIcon("res/zombieright.png").getImage();
		Body = new ImageIcon("res/body.png").getImage();
		Zombie = new Rectangle(20, 200, 20,40);
		Platform = new Rectangle(0, 555, 800, 10);
		GameLoop();

	}

	public void paint(Graphics g) {
	

		Point g1 = new Point(Zombie.x, Zombie.y + Zombie.height);

		g.drawImage(meny, 0, 0, 800, 2400, null);
		g.setColor(Color.BLACK);
		
		g.drawImage(Body, Zombie.x,Zombie.y,Zombie.width,Zombie.height,null);
		g.fillRect(Platform.x, Platform.y, Platform.width, Platform.height);
		
		// Zombie
		if (!Platform.contains(g1)) {
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
				chooseHeadZombie = 2;
			}
			if (Zombie.x > RandomDirection) {
				Zombie.x--;
				chooseHeadZombie = 1;
			}
		}

		if (chooseHeadZombie == 1) {
			g.drawImage(zombiel, Zombie.x, Zombie.y - Zombie.height / 2, 20,
					20, null);
		}
		if (chooseHeadZombie == 2) {
			g.drawImage(zombier, Zombie.x, Zombie.y - Zombie.height / 2, 20,
					20, null);
		}

		if (!running) {
			running = true;
			GameLoop();
		}
		if(PlayGame){
			PlayGame = false;
			Main.start = true;
			System.out.println("clicking");
			
			
			Main.main(null);
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

				System.out.println(frames + " FPS");
				frames = 0;
			}

		});
		timer2.start();
		if(PlayGame)timer.stop();
	}
}
