package com.Teb.JavaGame;

import java.util.Random;

public class Chest {

	Random rand = new Random();
	ImportImages imageimport = new ImportImages();
<<<<<<< HEAD
	int Randomobject = rand.nextInt(12);
=======
	int Randomobject = rand.nextInt(13);
>>>>>>> New changes
	public static String ChestObject = "UNSTORED";
	public static String SPECIAL = "NONE";

	public Chest() {
		if (ChestObject.equalsIgnoreCase("UNSTORED")) {
			
			if (Images.BoxObject == 0)
				Images.BoxObject = Randomobject;

			if (Images.BoxObject >= 8 &&Images.BoxObject <= 11) {
				ChestObject = "HEART";
			}
			if (Images.BoxObject <= 7 && Images.BoxObject >= 4) {
				ChestObject = "SWORD";
			}
			if (Images.BoxObject <= 3) {
				ChestObject = "BOW";
			}
			if (Images.BoxObject == 12 ) {
				ChestObject = "SPECIAL";
			}
		}

		if (KL.Equip) {
			if (ChestObject.equalsIgnoreCase("HEART")) {
				Images.TakenSlot3 = true;
				SPECIAL = "HEART";
			}
			if (ChestObject.equalsIgnoreCase("SWORD")) {
				Images.TakenSlot1 = true;
			}
			if (ChestObject.equalsIgnoreCase("BOW")) {
				Images.TakenSlot2 = true;
			}
			if (ChestObject.equalsIgnoreCase("SPECIAL")){
				Images.TakenSlot3 = true;
				SPECIAL = "SPECIAL";
			}
				ChestObject = "EMPTY";
		}

	}

}
