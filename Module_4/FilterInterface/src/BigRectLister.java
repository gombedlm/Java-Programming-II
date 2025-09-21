// Interfaces/BigRectLister.java
// Creates an ArrayList of 10 Rectangles and lists those with perimeter > 10.
import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(4, 1));
        rectangles.add(new Rectangle(5, 5));
        rectangles.add(new Rectangle(3, 2));
        rectangles.add(new Rectangle(6, 2));
        rectangles.add(new Rectangle(1, 6));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(7, 1));
        rectangles.add(new Rectangle(4, 4));

        Filter filter = new BigRectangleFilter();
        System.out.println("Rectangles with perimeter > 10:");
        for (Rectangle r : rectangles) {
            if (filter.accept(r)) {
                System.out.println(r);
            }
        }
    }
}
