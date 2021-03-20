package InheritanceComposition;

import java.util.HashMap;

/**
 * Class zone for particular zone like Mammal, Birds and Reptile
 * @author abhishek.dawer_metac
 *
 */
public class Zones {
	String zoneType;
	boolean hasCanteenPresent, hasParkPresent;
	int numberOfZoneInParticularType, numberOfCageInZone, totalCagesAllowed, numberOfAnimals;
	
	public Zones(String name, int noOfZone, int cagesInZone, int totalCages, boolean canteen, boolean park) {
		this.zoneType = name;
		this.numberOfZoneInParticularType = noOfZone;
		this.numberOfCageInZone = cagesInZone;
		this.totalCagesAllowed = totalCages;
		this.hasCanteenPresent = canteen;
		this.hasParkPresent = park;
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
		if(this.hasCanteenPresent)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to check zone has park
	 * @return true if zone has park else false
	 */
	public boolean hasPark() {
		if(this.hasParkPresent)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to add cage in particular zone
	 */
	public String addCageInZone() {
		if(this.numberOfCageInZone<this.totalCagesAllowed) {
			this.numberOfCageInZone += 1;
			return "Cage added..";
		}
		else
			return "Zone has maximum cages..";
	}
}
