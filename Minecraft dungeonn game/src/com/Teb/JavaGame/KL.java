package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class KL implements KeyListener {

	public static boolean right = false;
	public static boolean left = false;
	public static boolean jumping = false;
	public static boolean shift = false;
	public static boolean onPlatform = false;

	public static boolean notjumping = true;
	public static boolean timeroff = true;

	public int jumpTime = 250;
	Images image = new Images();

	Timer timer;
	Timer timer1;

	@SuppressWarnings("static-access")
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_A) {
			left = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_D) {
			right = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_F) {
			image.sword = true;

		}
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			image.respawning = 2;
			timer1 = new Timer(1000, new RespawnTimer());
			timer1.start();
			if(image.respawning == 5){
				timer1.stop();
			}
			

		}
		if (event.getKeyCode() == KeyEvent.VK_SHIFT) {
			shift = true;
			

		}
		if (event.getKeyCode() == KeyEvent.VK_W) {
			if (notjumping && onPlatform) {
				jumping = true;
				notjumping = false;
				timer = new Timer(jumpTime, new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (jumping) {
							jumping = false;
							notjumping = true;
							onPlatform = false;
							timer.stop();

						
					}
						
					}
					
				
				});
				timer.start();

			}
		}
	}

	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_A) {
			left = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_D) {
			right = false;

		}
		if (event.getKeyCode() == KeyEvent.VK_SHIFT) {
			shift = false;

		}

	}

	public void keyTyped(KeyEvent event) {

	}

}
