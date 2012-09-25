package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZombieTimer implements ActionListener {

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent event) {
		Zombie zombie = new Zombie();
		if (!zombie.zombieFollow) {
			zombie.timer.stop();
			System.out.println("ZombieTimer");
			Zombie.zombieFollow = true;
		}

	}
}
