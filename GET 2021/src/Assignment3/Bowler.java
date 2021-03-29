package Assignment3;

/**
 * Class bowler containing value of Bowler
 * @author abhishek.dawer_metac
 *
 */
public class Bowler {
    String bowlerName;
    int numberOfBalls;
    
    public Bowler(String name, int balls) {
    	bowlerName = name;
    	numberOfBalls = balls;
    }
   
    public String toString() {
    	return bowlerName+ " " + numberOfBalls;
    }
}