package com.Teb.JavaGame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MML implements MouseMotionListener {
	public Point mouse;

	public static boolean PlayGameHoover = false;
	public static boolean OptionHoover  = false;
	public static boolean DifficultyHoover  = false;
	public static boolean Return  = false;
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent event) {
		mouse = new Point(event.getX(), event.getY());
		if (mouse.x > 237 && mouse.x < 595 && mouse.y > 251 && mouse.y < 316) {
			PlayGameHoover = true;
		} else {
			PlayGameHoover = false;
		}
		if (mouse.x > 232 && mouse.x < 590 && mouse.y > 355 && mouse.y < 421) {
			OptionHoover = true;
		} else {
			OptionHoover = false;
		}
		if (mouse.x > 232 && mouse.x < 590 && mouse.y > 355 && mouse.y < 421 && ML.OptionMeny) {
			DifficultyHoover = true;
		}else {
			DifficultyHoover = false;
		}
		if (mouse.x > 0 && mouse.x < 100 && mouse.y > 0 && mouse.y < 50 && ML.OptionMeny) {
			Return = true;
		}else {
			Return = false;
		}

	}

}
