package InheritanceComposition;

import java.util.HashMap;
import java.util.Map;

public class Cage {
	HashMap<String, Integer> numberOfCage= new HashMap<>();
	HashMap<String, Integer> animalInOneCage = new HashMap<>();
	
	public void cageInZone(String value, int cageNumber) {
		if(numberOfCage.containsKey(value)== false)
			numberOfCage.put(value, cageNumber);
		else
			numberOfCage.put(value, numberOfCage.get(value)+ cageNumber);
	}
	
	public void animalInOneCage(String value, int numberOfAnimals) {
		if(animalInOneCage.containsKey(value)==false)
			animalInOneCage.put(value, numberOfAnimals);
		else
			animalInOneCage.put(value, animalInOneCage.get(value)+ numberOfAnimals);
	}
	
	public void animalCapacity() {
		for(Map.Entry<String, Integer> entry: animalInOneCage.entrySet()) {
		    System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	
	public boolean checkAvailability(String animalType) {
		if(numberOfCage.get(animalType)>0)
			return true;
		else
			return false;
	}
}
