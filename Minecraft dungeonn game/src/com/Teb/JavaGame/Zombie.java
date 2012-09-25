package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class Zombie {
	Timer timer;
	Random rand = new Random();
	
	public static boolean ZombieAttack = true;
	public static boolean zombieFollow = true;
<<<<<<< HEAD
=======
	public static boolean right = false;
	public static boolean left = false;
>>>>>>> New changes
	
	public Zombie(){
		if (Images.playery == Images.zombiey) {
			if (zombieFollow) {
				if (Images.playerx - 25 > Images.zombiex) {
					Images.Zombiex++;
					Images.chooseHeadzombie = 2;
				}
				if (Images.playerx + 25 < Images.zombiex) {
					Images.Zombiex--;
					Images.chooseHeadzombie = 1;
				}
			}
			if (ZombieAttack) {
				if (Images.zombiex == Images.playerx - 25 && Images.zombiey == Images.playery
						|| Images.zombiex == Images.playerx + 25
						&& Images.zombiey == Images.playery) {
					Images.life -= 1;
					ZombieAttack = false;
					timer = new Timer(1000, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							ZombieAttack = true;
							timer.stop();

						}

					});
					timer.start();

				}
			}
			if (Images.zombiex == Images.playerx) {
				if (!zombieFollow) {
					timer = new Timer(200, new ZombieTimer());
					timer.start();
				}
			}
		} else if (Images.playery != Images.zombiey) {
<<<<<<< HEAD
=======
			if (Images.playery >= Images.zombiey) {
				if(left)
				Images.Zombiex++;
				left = false;
				if(right)
				Images.Zombiex--;
				right = false;
			}else
>>>>>>> New changes
			if (Images.zombiey < Images.playery + 60) {
				if (zombieFollow) {
					if (Images.playerx - 25 > Images.zombiex) {
						Images.Zombiex++;
						Images.chooseHeadzombie = 2;
					}
					if (Images.playerx + 25 < Images.zombiex) {
						Images.Zombiex--;
						Images.chooseHeadzombie = 1;
					}
				}
			} else {
				if (Images.RandomDirection == 0) {
					int object = 100 + rand.nextInt(400);
					Images.RandomDirection = object;
				}
				if (Images.zombiex == Images.RandomDirection) {
					Images.RandomDirection = 0;
				}

				if (Images.zombiex != Images.RandomDirection) {

					if (Images.zombiex < Images.RandomDirection) {
						Images.Zombiex++;
						Images.chooseHeadzombie = 2;
					}
					if (Images.zombiex > Images.RandomDirection) {
						Images.Zombiex--;
						Images.chooseHeadzombie = 1;
					}
				}
			}
		}

	}
}
