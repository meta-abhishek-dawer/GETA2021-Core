package InheritanceComposition;

/**
 * Class Parrot inheriting parent class birds
 * @author abhishek.dawer_metac
 *
 */
public class Parrot extends Birds {
	public static String sound = "whistles";
	
    public Parrot(String name, int age, int weight) {
    	super(name, age, weight, sound);
    }
    
}
