package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZombieTimer implements ActionListener {

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent event) {
		Images image = new Images();
		if (!image.zombiefollow) {
			image.timer.stop();
			image.zombieFollow = false;
		}

	}
}
