package InheritanceComposition;

import java.util.HashMap;

public class Zones {
	HashMap<String, Integer> zoneCategory = new HashMap<>();
	String animalType;
	int numberOfZone;
	
	public void zones(String value, int zone1) {
		if(zoneCategory.containsKey(value)== false)
			zoneCategory.put(value, zone1);
		else {
			zoneCategory.put(value, zoneCategory.get(value)+ zone1);
		}
	}
	
	public boolean hasCanteen(int check) {
		if(check==1)
			return true;
		else
			return false;
	}
	
	public boolean hasPark(int check) {
		if(check==1)
			return true;
		else
			return false;
	}
}
