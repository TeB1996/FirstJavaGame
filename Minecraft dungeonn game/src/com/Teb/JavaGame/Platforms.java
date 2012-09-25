package com.Teb.JavaGame;

import java.awt.Point;
import java.awt.Rectangle;

public class Platforms {

	Images image = new Images();
<<<<<<< HEAD
	public Rectangle[] solide = { image.Platform, image.Platform1 };
=======
	public Rectangle[] solide = { image.Platform1, image.Platform2 };
>>>>>>> New changes
	Point p1 = new Point(image.Player.x, image.Player.y + image.Player.height);
	Point p2 = new Point(image.Player.x, image.Player.y - 20);
	Point z1 = new Point(image.Zombie.x,image. Zombie.y + image.Zombie.height);
	Point c1 = new Point(image.chest.x, image.chest.y + image.chest.height);
	Point c2 = new Point(image.chest.x, image.chest.y + image.chest.height);

	@SuppressWarnings("static-access")
	public Platforms() {
		for (int i = 0; i < solide.length; i++) {
			if (!solide[i].contains(p1)) {
				image.Playery = +1;
				System.out.println(solide[i].contains(p1) +"  "+ solide[i]);
			}
		}

	}
}
