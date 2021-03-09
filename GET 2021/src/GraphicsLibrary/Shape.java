package GraphicsLibrary;

import java.sql.Timestamp;

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
