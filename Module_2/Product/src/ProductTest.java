import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the Product class.
 * Tests constructor, setters, and special methods.
 * Does not test simple getters (per instructions).
 */
class ProductTest {
    private Product prod;

    @BeforeEach
    void setUp() {
        prod = new Product("Widget", "Basic widget", "W123", 9.99);
    }

    @Test
    void testConstructor() {
        assertEquals("Widget,Basic widget,W123,9.99", prod.toCSV());
        assertEquals("W123", prod.getID());
        assertEquals(9.99, prod.getCost(), 0.0001);
    }

    @Test
    void testSetName() {
        prod.setName("Gadget");
        assertTrue(prod.toCSV().startsWith("Gadget,"));
    }

    @Test
    void testSetDescription() {
        prod.setDescription("Upgraded gadget");
        assertTrue(prod.toCSV().contains("Upgraded gadget"));
    }

    @Test
    void testSetCost() {
        prod.setCost(12.50);
        assertEquals(12.50, prod.getCost(), 0.0001);
    }

    @Test
    void testToCSV() {
        assertEquals("Widget,Basic widget,W123,9.99", prod.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"name\":\"Widget\",\"description\":\"Basic widget\",\"ID\":\"W123\",\"cost\":9.99}";
        assertEquals(expected, prod.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Product><Name>Widget</Name><Description>Basic widget</Description><ID>W123</ID><Cost>9.99</Cost></Product>";
        assertEquals(expected, prod.toXML());
    }
}
