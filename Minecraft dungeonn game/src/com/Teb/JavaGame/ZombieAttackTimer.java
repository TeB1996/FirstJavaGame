package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZombieAttackTimer implements ActionListener {

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent event) {
		Images image = new Images();
			image.timer.stop();
			System.out.println("out of ordeer");
			image.ZombieAttack = true;
		

	}
}
