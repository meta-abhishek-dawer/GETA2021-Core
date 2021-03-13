package GraphicsLibrary;

/**
 * Class point in which we define coordinates
 * @author abhishek.dawer_metac
 *
 */
public class Point {
    double xAxisCoordinate, yAxisCoordinate;
    /**
     * Constructor to setting the coordinate of a parrticular shape
     * @param xValue value containing coordinate of X-axis
     * @param yValue value containing coordinate of Y-axis
     */
    Point(double xValue, double yValue) {
    	this.xAxisCoordinate = xValue;
    	this.yAxisCoordinate = yValue;
    }
}
