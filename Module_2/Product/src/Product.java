/**
 * Author: Layken Gombeda
 * Date: 2025-09-08
 * Time: 12:43 AM
 */

/**
 * Represents a Product with identifying information.
 */
public class Product {
    private String name;
    private String description;
    private final String ID;   // should never change
    private double cost;

    /**
     * Constructor for Product.
     * @param name product name
     * @param description product description
     * @param ID unique product ID (cannot change)
     * @param cost product cost
     */
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    /** @return product name */
    public String getName() { return name; }
    /** @param name name to set */
    public void setName(String name) { this.name = name; }

    /** @return product description */
    public String getDescription() { return description; }
    /** @param description description to set */
    public void setDescription(String description) { this.description = description; }

    /** @return product ID (never changes) */
    public String getID() { return ID; }

    /** @return product cost */
    public double getCost() { return cost; }
    /** @param cost cost to set */
    public void setCost(double cost) { this.cost = cost; }

    /**
     * Converts the Product to CSV format.
     * @return CSV string in the form: name,description,ID,cost
     */
    public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }

    /**
     * Converts the Product to JSON format.
     * @return JSON string representation
     */
    public String toJSON() {
        return String.format(
                "{\"name\":\"%s\",\"description\":\"%s\",\"ID\":\"%s\",\"cost\":%s}",
                name, description, ID, Double.toString(cost)
        );
    }

    /**
     * Converts the Product to XML format.
     * @return XML string representation
     */
    public String toXML() {
        return String.format(
                "<Product><Name>%s</Name><Description>%s</Description><ID>%s</ID><Cost>%s</Cost></Product>",
                name, description, ID, Double.toString(cost)
        );
    }
}
