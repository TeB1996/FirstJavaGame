package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RespawnTimer implements ActionListener {

	Images image = new Images();
	KL keylistener = new KL();

	public void actionPerformed(ActionEvent e) {
		if (Images.respawning == 6) {
			keylistener.timer1.stop();
		}
		Images.respawning++;
		System.out.println("Respawning");

	}
}
