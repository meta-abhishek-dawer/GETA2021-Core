package InheritanceComposition;

/**
 * Class lion inheriting parent class Mammal
 * @author abhishek.dawer_metac
 *
 */
public class Lion extends Mammal {
	public static String sound = "roar";
	
	public Lion(String lionName, int age, int weight) {
		super(lionName, age, weight, sound);
	}
	
}
