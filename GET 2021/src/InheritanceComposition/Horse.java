package InheritanceComposition;

/**
 * Class Horse having parent class Mammal and set its values in Animal(super class of all animal)
 * @author abhishek.dawer_metac
 *
 */
public class Horse extends Mammal {
    public Horse(String name, int age, int weight, String sound) {
    	super(name, age, weight, sound);
    }
}
