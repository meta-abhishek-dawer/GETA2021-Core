package InheritanceComposition;

import java.util.Scanner;

/**
 * Driver class for Zoo in which we are calling different methods
 * @author abhishek.dawer_metac
 *
 */
public class ZooDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of animal");
		String animalName = scanner.next();
		Zoo newZoo = new Zoo();
		
		Animal newAnimal = newZoo.inputAnimal(animalName.toLowerCase());
		Zones newZone = newZoo.inputZone();
		Cage newCage = newZoo.inputCage();
		newZoo.addAnimal(newAnimal, newZone, newCage);
		System.out.println(newAnimal.getSound());
		
		System.out.println("Zone has canteen:- " + newZone.hasCanteen());
		System.out.println("Zone has park:- " + newZone.hasPark());
		
		System.out.println("Enter the name of second animal..");
		String animalName2 = scanner.next();
		Animal newAnimal2 = newZoo.inputAnimal(animalName2);
		Zones newZones2 = newZoo.inputZone();
		Cage newCage2 = newZoo.inputCage();
		newZoo.addAnimal(newAnimal2, newZones2, newCage2);
		System.out.println(newAnimal2.getName());
		
		System.out.println("Enter the zone name to increase cage like Birds, Reptile or Mammal..");
		String zoneName = scanner.next();
		String resultZone = newZones2.addCageInZone();
		System.out.println(resultZone);
	}

}
