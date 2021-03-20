package InheritanceComposition;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class zoo for used all the classes and to add, remove animal
 * @author abhishek.dawer_metac
 *
 */
public class Zoo {
	static Scanner scanner = new Scanner(System.in);
	ArrayList<String> animalsAdded = new ArrayList<String>();
	int spaceInCage=0;
	
	/**
	 * Method to take input of animal
	 * @param name containing animal name
	 * @return object of particular animal
	 */
	public Animal inputAnimal(String name) {
		if(name.equals("peacock")) {
			System.out.println("Enter age, weight of peacock..");
			int age = scanner.nextInt();
			int weight = scanner.nextInt();
			Peacock newPeacock = new Peacock(name, age, weight);
			return newPeacock;
		}
		else if(name.equals("lion")) {
			System.out.println("Enter age, weight of Lion..");
			int age = scanner.nextInt();
			int weight = scanner.nextInt();
			Lion newLion = new Lion(name, age, weight);
			return newLion;
		}
		else if(name.equals("crocodile")) {
			System.out.println("Enter age, weight of Crocodile..");
			int age = scanner.nextInt();
			int weight = scanner.nextInt();
			Crocodile newCrocodile = new Crocodile(name, age, weight);
			return newCrocodile;
		}
		else if(name.equals("Horse")) {
			System.out.println("Enter age, weight of Horse..");
			int age = scanner.nextInt();
			int weight = scanner.nextInt();
			Horse newHorse = new Horse(name, age, weight);
			return newHorse;
		}
		else if(name.equals("parrot")) {
			System.out.println("Enter age, weight of parrot..");
			int age = scanner.nextInt();
			int weight = scanner.nextInt();
			Parrot newParrot = new Parrot(name, age, weight);
			return newParrot;
		}
		return null;
	}
	
	/**
	 * Method to take input for zone
	 * @return object of zones
	 */
	public Zones inputZone() {
		System.out.println("Enter category like Birds, Reptile or Mammal");
		String category = scanner.next();
		System.out.println("Enter the number of zone, cage, number Of cages allowed");
		System.out.println("Enter true if Zone has canteen and park else false");
		int numberOfZones = scanner.nextInt();
		int numberOfCages = scanner.nextInt();
		int cagesAllowed = scanner.nextInt();
		boolean canteen = scanner.nextBoolean();
		boolean park = scanner.nextBoolean();
		Zones newZone = new Zones(category, numberOfZones, numberOfCages, cagesAllowed, canteen, park);
		return newZone;
	}
	
	/**
	 * Method to take input of cage for particular zone
	 * @return object of cage
	 */
	public Cage inputCage() {
		System.out.println("Enter category like Birds, Reptile or Mammal");
		String category = scanner.next();
		System.out.println("Enter number of Animal in one cage..");
		int animalInCage = scanner.nextInt();
		Cage newCage = new Cage(category, animalInCage);
		return newCage;
	}
	
	/**
	 * Method to add animal
	 * @param newAnimal containing object of animal having values
	 * @param newZone object of zone
	 * @param newCage object of cage
	 */
	public void addAnimal(Animal newAnimal, Zones newZone, Cage newCage) {
	    if(newZone.checkAvailability(newCage) == true) {
			if(newCage.spaceInOneCage< newCage.animalInOneCage) {
				this.animalsAdded.add(newAnimal.getName());
				System.out.println("animal added..");
				newCage.spaceInOneCage++;
			}
			else if(newCage.spaceInOneCage == newCage.animalInOneCage){
				newZone.numberOfCageInZone -= 1;
				System.out.println("Animal added");
				this.animalsAdded.add(newAnimal.getName());
				newCage.spaceInOneCage = 0;
			} 
		}
	    else {
	    	System.out.println("Space not vacant!!");
	    }
	}
	
	/**
	 * Method to remove animal 
	 * @param animalName name of animal
	 * @param animalInCage having value of animal in one cage
	 * @param newZone object of Zones
	 * @param newCage object of Cage
	 */
	public void removeAnimal(String animalName, int animalInCage, Zones newZone, Cage newCage) {
		if(this.animalsAdded.contains(animalName)) {
			if(animalInCage == newCage.animalInOneCage) {
				newZone.numberOfCageInZone += 1;
				this.animalsAdded.remove(animalName);
				System.out.println("Animal removed..");
			}
			else if(animalInCage < newCage.animalInOneCage) {
				newCage.spaceInOneCage += animalInCage;
				this.animalsAdded.remove(animalName);
				System.out.println("Animal Removed..");
			}
		}
		else 
			System.out.println("ëlement not present..");
	}
}
