package InheritanceComposition;

    class Peacock extends Birds {
    int numberOfPeacockInOneCage;
    
	public Peacock(String peacockName, int peacockAge, int peacockWeight, String peacockSound, int peacockInOneCage1, int numberOfBirdsZones, int numberOfCagesInZone) {
	    super(peacockName, peacockAge, peacockWeight, peacockSound, numberOfBirdsZones, numberOfCagesInZone);
	    numberOfPeacockInOneCage = peacockInOneCage1;
	}
	
	
}
