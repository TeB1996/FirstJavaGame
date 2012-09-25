package com.Teb.JavaGame;

import javax.swing.JFrame;

public class Main {

	public static int width = 800;
	public static int height = width/12*9;

	public static boolean start = false;
	
	public static boolean checking = true;

	public static String TITLE = "Platformer";

	public static void main(String[] args) {

		Display f = new Display();
		Images image = new Images();
		
		f.setVisible(true);
		f.setSize(width, height);
		f.setTitle(TITLE);
		f.setAlwaysOnTop(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.addKeyListener(new KL());
		f.addMouseListener(new ML());
		f.addMouseMotionListener(new MML());
		f.setAlwaysOnTop(true);
		f.setLocationRelativeTo(null);
		f.add(image);


	}
}
