/**
 * Author: Layken Gombeda
 * Date: 2025-09-08
 * Time: 12:43 AM
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the Person class.
 * Tests constructor, setters, and special methods.
 * Does not test simple getters (per instructions).
 */
class PersonTest {
    private Person p;

    @BeforeEach
    void setUp() {
        p = new Person("John", "Doe", "12345", "Mr.", 1990);
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", p.fullName());
        assertEquals("Mr. John Doe", p.formalName());
        assertEquals("12345", p.getID());
        assertEquals(1990, p.getYOB());
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
        assertEquals(2000, p.getYOB());
    }

    @Test
    void testSetInvalidYOBTooEarly() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> p.setYOB(1930));
        assertEquals("Year of Birth must be between 1940 and 2010", e.getMessage());
    }

    @Test
    void testSetInvalidYOBTooLate() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> p.setYOB(2020));
        assertEquals("Year of Birth must be between 1940 and 2010", e.getMessage());
    }

    @Test
    void testGetAgeCurrentYear() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(String.valueOf(currentYear - 1990), p.getAge());
    }

    @Test
    void testGetAgeSpecificYear() {
        assertEquals("30", p.getAge(2020));
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
