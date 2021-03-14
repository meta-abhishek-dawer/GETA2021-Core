package InheritanceComposition;

/**
 * Animal class is super class for all animals
 * @author abhishek.dawer_metac
 *
 */
public class Animal {
    String name, sound;
    int age, weight;
    int id;
    
    /**
     * Constructor of animal class
     * @param name1 animal's name
     * @param age1 animal's age
     * @param weight1 animal's weight
     * @param sound1 animal's sound
     */
    public Animal(String name1, int age1, int weight1, String sound1) {
    	this.name= name1;
    	this.age= age1;
    	this.weight= weight1;
    	this.sound= sound1;
    	this.id= (int) (Math.random() * 100);
    }
    
    /**
     * Method to get Name of animal
     * @return value name of type string
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * Method to get sound of Animal
     * @return value of type String
     */
    public String getSound() {
    	return this.sound;
    }

}
