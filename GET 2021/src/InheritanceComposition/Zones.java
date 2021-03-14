package InheritanceComposition;

import java.util.HashMap;

/**
 * Class zone for particular zone like Mammal, Birds and Reptile
 * @author abhishek.dawer_metac
 *
 */
public class Zones {
	String zoneType;
	boolean canteenPresent, parkPresent;
	int numberOfZoneInType, numberOfCageInZone, totalCagesAllowed, numberOfAnimals;
	
	public Zones(String name, int noOfZone, int cagesInZone, int totalCages, boolean canteen, boolean park) {
		this.zoneType = name;
		this.numberOfZoneInType = noOfZone;
		this.numberOfCageInZone = cagesInZone;
		this.totalCagesAllowed = totalCages;
		this.canteenPresent = canteen;
		this.parkPresent = park;
    }
	
	/**
	 * Method to check availability in zone
	 * @param cage having object of cage 
	 * @return true if space else false
	 */
	public boolean checkAvailability(Cage cage) {
		this.numberOfAnimals = this.numberOfCageInZone * cage.animalInOneCage;
		if(this.numberOfCageInZone>0)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check zone has canteen
	 * @return true if have else return false
	 */
	public boolean hasCanteen() {
		if(this.canteenPresent == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check zone has park
	 * @return true if zone has park else false
	 */
	public boolean hasPark() {
		if(this.parkPresent ==true)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to add cage in particular zone
	 */
	public void addCageInZone() {
		if(this.numberOfCageInZone<this.totalCagesAllowed) {
			this.numberOfCageInZone += 1;
			System.out.println("Cage added..");
		}
		else
			System.out.println("Zone has maximum cages..");
	}
}
