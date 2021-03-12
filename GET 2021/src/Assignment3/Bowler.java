package Assignment3;

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