import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the Person class.
 * Tests constructors, setters, and special methods.
 * Does not test simple getters (per assignment instructions).
 */
class PersonTest {
    private Person p;

    @BeforeEach
    void setUp() {
        // This runs before each test, creating a new Person object
        p = new Person("John", "Doe", "12345", "Mr.", 1990);
    }

    @Test
    void testConstructor() {
        // Constructor should correctly assign values
        assertEquals("John Doe", p.fullName());
        assertEquals("Mr. John Doe", p.formalName());
        assertEquals("12345", p.getID());  // ID should never change
    }

    @Test
    void testSetFirstName() {
        p.setFirstName("Jane");
        assertEquals("Jane Doe", p.fullName());
    }

    @Test
    void testSetLastName() {
        p.setLastName("Smith");
        assertEquals("John Smith", p.fullName());
    }

    @Test
    void testSetTitle() {
        p.setTitle("Dr.");
        assertEquals("Dr. John Doe", p.formalName());
    }

    @Test
    void testSetValidYOB() {
        p.setYOB(2000);
        assertEquals("2000", String.valueOf(p.getYOB()));
    }

    @Test
    void testSetInvalidYOBTooEarly() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            p.setYOB(1930);
        });
        assertEquals("Year of Birth must be between 1940 and 2010", exception.getMessage());
    }

    @Test
    void testSetInvalidYOBTooLate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            p.setYOB(2020);
        });
        assertEquals("Year of Birth must be between 1940 and 2010", exception.getMessage());
    }

    @Test
    void testGetAgeCurrentYear() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int expectedAge = currentYear - 1990;
        assertEquals(String.valueOf(expectedAge), p.getAge());
    }

    @Test
    void testGetAgeSpecificYear() {
        assertEquals("30", p.getAge(2020)); // 2020 - 1990 = 30
    }

    @Test
    void testToCSV() {
        assertEquals("John,Doe,12345,Mr.,1990", p.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"ID\":\"12345\",\"title\":\"Mr.\",\"YOB\":1990}";
        assertEquals(expected, p.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Person><FirstName>John</FirstName><LastName>Doe</LastName><ID>12345</ID><Title>Mr.</Title><YOB>1990</YOB></Person>";
        assertEquals(expected, p.toXML());
    }
}
