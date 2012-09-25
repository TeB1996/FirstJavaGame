package com.Teb.JavaGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class KL implements KeyListener {

	public static boolean right = false;
	public static boolean left = false;
	public static boolean jumping = false;
	public static boolean shift = false;
	public static boolean onPlatform = false;
	public static boolean Use = false;
	public static boolean Use1 = false;
	public static boolean Use2 = false;
	public static boolean Use3 = false;
	public static boolean Equip = false;

	public static boolean notjumping = true;
	public static boolean timeroff = true;

	public int jumpTime = 250;
	public static int UseNumber = 0;
	Images image = new Images();

	Timer timer;
	Timer timer1;

	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_E) {
			if (image.playerOnChest) {
				Equip = true;
			}

		}
		if (event.getKeyCode() == KeyEvent.VK_1) {
			Use1 = true;
			Use2 = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_2) {
			
				Use2 = true;
				Use1 = false;
			
		}
		if (event.getKeyCode() == KeyEvent.VK_3) {
			if (image.TakenSlot3)
				Use3 = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_A) {
			left = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_D) {
			right = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_F) {
			image.TakenSlot2 = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			Images.respawning = 2;
			timer1 = new Timer(1000, new RespawnTimer());
			timer1.start();
			if (Images.respawning == 5) {
				timer1.stop();
			}

		}
		if (event.getKeyCode() == KeyEvent.VK_SHIFT) {
			shift = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!Use) {
				Use = true;
			}

		}
		if (event.getKeyCode() == KeyEvent.VK_W) {
			if (notjumping && onPlatform) {
				jumping = true;
				notjumping = false;
				onPlatform = false;
			}
		}
	}

	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_E) {
			Equip = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_A) {
			left = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_D) {
			right = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_SHIFT) {
			shift = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			Use = false;

		}

	}

	public void keyTyped(KeyEvent event) {

	}

}
