package InheritanceComposition;

/**
 * Class peacock inheriting parent class Birds
 * @author abhishek.dawer_metac
 *
 */
class Peacock extends Birds {
	public static String sound = "pehpeh";
	
	public Peacock(String peacockName, int peacockAge, int peacockWeight) {
	    super(peacockName, peacockAge, peacockWeight, sound);
	}
	
}
