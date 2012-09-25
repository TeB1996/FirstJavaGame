package com.Teb.JavaGame;

public class Arrow {
	
	public Arrow(){
		
		Images i = new Images();
		if (KL.Use2) {
			if (KL.Use || KL.UseNumber >= 1) {

				if (KL.UseNumber == 0) {
					
					KL.UseNumber = 1;
				} else if (KL.UseNumber >= 1) {
					if (Images.chooseHead == 1) {
						Images.Arrow1x--;
						KL.UseNumber++;
					}
					if (Images.chooseHead == 2) {
						i.Arrow1.x++;
						KL.UseNumber++;
					}
					System.out.println("fireing");
					if (KL.UseNumber == 50) {
						KL.UseNumber = 0;
						KL.Use = false;
					}

				}

			}
		}
	}

}
