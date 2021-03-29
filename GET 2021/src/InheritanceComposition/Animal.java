package InheritanceComposition;

/**
 * Animal class having name, age, id, sound, weight of animal
 * @author abhishek.dawer_metac
 *
 */
public class Animal {
    public String name;
	public String sound;
    public int age, weight;
    public int id;
    
    /**
     * Constructor of animal class
     * @param name1 animal's name
     * @param age1 animal's age
     * @param weight1 animal's weight
     */
    public Animal(String name, int age, int weight, String sound) {
    	this.name= name;
    	this.age= age;
    	this.weight= weight;
    	this.sound = sound;
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
     * Method to get sound of particular animal
     * @return
     */
    public String getSound() {
    	return this.sound;
    }
}
