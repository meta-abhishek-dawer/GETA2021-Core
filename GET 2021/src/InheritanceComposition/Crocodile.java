package InheritanceComposition;

/**
 * Class crocodile inheriting Class animals and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Crocodile extends Reptile {
	public static String sound = "grunt";
	
	//class crocodile's constructor
	public Crocodile(String name, int age, int weight) {
		super(name, age, weight, sound);
	}
	
}	
