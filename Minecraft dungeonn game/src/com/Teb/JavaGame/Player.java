package com.Teb.JavaGame;

public class Player {
	KL keylistener = new KL();
	Images image = new Images();

	@SuppressWarnings("static-access")
	public Player(){
		//Movement
		if (keylistener.left) {
			if(keylistener.shift){
				image.Playerx = image.Playerx-1;
			}else{
			image.Playerx = image.Playerx-2;
			}
			image.chooseHead = 1;
		}
		if (keylistener.right) {
			if(keylistener.shift){
				image.Playerx =  image.Playerx + 1;
			}
			else{
			 image.Playerx =  image.Playerx + 2;
			}
			image.chooseHead = 2;
		}
		if (keylistener.jumping) {
			image.Playery = image.Playery- 2;
			
			
		}
		
	
	}
}
