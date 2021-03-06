package InheritanceComposition;

public class Birds extends Animal {
	int numberOfZones, numberOfCageInZone;
	public Birds(String name, int age, int weight, String sound, int numberZones, int numberCages) {
		super(name, age,  weight, sound);
		numberOfZones= numberZones;
		numberOfCageInZone= numberCages;
	}
}
