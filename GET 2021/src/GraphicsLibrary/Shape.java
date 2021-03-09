package GraphicsLibrary;

import java.sql.Timestamp;
/**
 * Interface shape containing different declared methods
 * @author abhishek.dawer_metac
 *
 */
public interface Shape {
    String getShapeType();
    double getArea();
    double getPerimeter();
    boolean isPointEnclosed(Point point);
    Point getOrigin();
    Timestamp getTimestamp();
    
    public static enum shapeType {
    	Square, Triangle, Circle, Rectangle, Polygon
    }
}
