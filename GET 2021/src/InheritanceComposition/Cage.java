package InheritanceComposition;

import java.util.HashMap;
import java.util.Map;

/**
 * Class cage for setting cage for particular animal
 * @author abhishek.dawer_metac
 *
 */
public class Cage {
	String animalName;
	int animalInOneCage, fullCage =0;
	
	public Cage(String name, int animalInCage) {
		this.animalName = name;
		this.animalInOneCage = animalInCage;
	}
}
