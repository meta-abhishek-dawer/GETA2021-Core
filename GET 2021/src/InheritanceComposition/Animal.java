package InheritanceComposition;

public class Animal {
    String name, sound;
    int age, weight;
    int id;
    public Animal(String name1, int age1, int weight1, String sound1) {
    	this.name= name1;
    	this.age= age1;
    	this.weight= weight1;
    	this.sound= sound1;
    	this.id= (int) (Math.random() * 100);
    }
    
    public String getSound() {
    	return this.sound;
    }
}
