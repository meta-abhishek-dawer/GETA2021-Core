package GraphicsLibrary;

import java.sql.Timestamp;
/**
 * Interface shape containing different declared methods
 * @author abhishek.dawer_metac
 *
 */
public interface Shape {
    String getType();
    double getArea();
    double getPerimeter();
    boolean isPointEnclosed(Point point);
    Point getOrigin();
    Timestamp getTimestamp();
    
    public static enum shapeType {
    	SQUARE, TRIANGLE, CIRCLE, RECTANGLE, POLYGON
    }
}
