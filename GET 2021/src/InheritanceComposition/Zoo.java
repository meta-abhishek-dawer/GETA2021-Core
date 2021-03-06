package InheritanceComposition;

import java.util.Scanner;

public class Zoo {
	static Cage newCage;
	int vacantSpace= 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String peacockName = scanner.next();
		String peacockSound = scanner.next();
		int peacockAge = scanner.nextInt();
		int peacockWeight= scanner.nextInt();
		int peacockInOneCage = scanner.nextInt();
		int numberOfBirdsZones = scanner.nextInt();
		int numberOfCagesInZone = scanner.nextInt();
		
		Zones newZones = new Zones();
		newZones.zones("Birds", numberOfBirdsZones);
		newCage = new Cage();
		newCage.cageInZone("Birds", numberOfCagesInZone);
		newCage.animalInOneCage("peacock",peacockInOneCage);
		Peacock newPeacock = new Peacock(peacockName, peacockAge, peacockWeight, peacockSound, peacockInOneCage, numberOfBirdsZones, numberOfCagesInZone);
		
		String inputAnimal= scanner.next();
		Zoo newZoo1 = new Zoo();
		System.out.println("Sound of Peacock:- "+ newPeacock.getSound());
		boolean result= newZoo1.addAnimal(inputAnimal, newZoo1,peacockInOneCage);
		if(result== true)
			System.out.println("Animal added");
		else
			System.out.println("Space not available in zone");
	}
	
	public boolean addAnimal(String animalType, Zoo newZoo, int number) {
		if(animalType.equals("peacock")) {
		   newCage = new Cage();
		   if(newCage.checkAvailability("Birds")== true) {
			   if(newZoo.vacantSpace<=number && newCage.numberOfCage.get("Birds")>0) {
			       newZoo.vacantSpace++;
			       return true;
			   }
			   else if(newZoo.vacantSpace==number && newCage.numberOfCage.get("Birds")>0) {
				   newCage.numberOfCage.put("Birds",newCage.numberOfCage.get("Birds")-1);
				   newZoo.vacantSpace=0;
				   return true;
			   }	   
		   }
		   else {
			   return false;
		   }
		}
		return false;
	}
}
