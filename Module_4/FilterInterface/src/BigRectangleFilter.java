// Interfaces/BigRectangleFilter.java
// Implements Filter and accepts java.awt.Rectangles with perimeter > 10.
import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {

    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle r = (Rectangle) x;
            double perimeter = 2 * (r.getWidth() + r.getHeight());
            return perimeter > 10;
        }
        return false;
    }
}
