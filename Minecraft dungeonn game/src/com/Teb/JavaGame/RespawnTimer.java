package com.Teb.JavaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RespawnTimer implements ActionListener {

	Images image = new Images();
	KL keylistener = new KL();

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(image.respawning == 6){
			keylistener.timer1.stop();
		}
		image.respawning = image.respawning+1;
		System.out.println("Respawning");

	}
}
