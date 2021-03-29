package InheritanceComposition;

/**
 * Class Horse having parent class Mammal and set its values in Animal(super class of all animal)
 * @author abhishek.dawer_metac
 *
 */
public class Horse extends Mammal {
	public static String sound = "neigh";
	
	//constructor of horse class
    public Horse(String name, int age, int weight) {
    	super(name, age, weight, sound);
    }
    
}
