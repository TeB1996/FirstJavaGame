package com.Teb.JavaGame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MML implements MouseMotionListener {
	public Point mouse;

	public static boolean PlayGameHoover = false;
	Meny meny = new Meny();

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

	}

}
