package com.Teb.JavaGame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ML implements MouseListener {
	
	public Point mouse;
	
	Meny meny = new Meny();
	MML mml = new MML();
	Images image = new Images();

	public void mouseClicked(MouseEvent event) {
		if(event.getButton() == MouseEvent.BUTTON1){
			
			if(MML.PlayGameHoover){
				Images.PlayGame = true;
			}
		}
	}

	public void mouseEntered(MouseEvent event) {

	}

	public void mouseExited(MouseEvent event) {

	}

	public void mousePressed(MouseEvent event) {

	}

	public void mouseReleased(MouseEvent event) {

	}


	

}
