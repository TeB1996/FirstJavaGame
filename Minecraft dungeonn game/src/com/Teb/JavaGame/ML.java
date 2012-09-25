package com.Teb.JavaGame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ML implements MouseListener {
	
	public static boolean Option = false;
	public static boolean OptionMeny = false;
	public static boolean PlayGame = false;
	public static String Difficulty = "EASY";
	private int difficulty = 1;
	
	public Point mouse;
	MML mml = new MML();
	Images image = new Images();

	public void mouseClicked(MouseEvent event) {
		if (!Main.start ){
			if (event.getButton() == MouseEvent.BUTTON1) {
				
				if ( !OptionMeny) {
					if (MML.PlayGameHoover) {
						PlayGame = true;
					}
					if (MML.OptionHoover) {
						Option = true;
						OptionMeny = true;
					}
				}
				if(OptionMeny){
					if (MML.DifficultyHoover) {
						if(difficulty == 1){
							Difficulty = "EASY";
						}
						if(difficulty == 2){
							Difficulty = "HARD";
						}
						if(difficulty == 3){
							difficulty = 1;
							Difficulty = "EASY";
						}
						difficulty++;
						
					}
					if (MML.Return) {
						Option = false;
						OptionMeny = false;
					}
				}
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
