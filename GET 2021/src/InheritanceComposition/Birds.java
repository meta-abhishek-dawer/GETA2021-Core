package InheritanceComposition;

/**
 * Class Birds inheriting Class animal
 * @author abhishek.dawer_metac
 *
 */
public class Birds extends Animal {
	//constructor of Birds to set particular value in animal
	public Birds(String name, int age, int weight, String sound) {
		super(name, age,  weight, sound);
	}
}
