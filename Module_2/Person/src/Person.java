import java.util.Calendar;

/** --- Class Initializer --- **/
 class Person {
    String firstName;
    String lastName;
    String ID;
    String title;
    int YOB;

    /** --- Constructor ---
     * @param firstName - First name of the user
     * @param lastName  - Last name of the user
     * @param ID        - ID of the user
     * @param title     - Title of the user
     * @param YOB       - Year of Birth of the user
     **/

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB); // this will validate the yob range
    }


    /** --- Getters and Setters --- **/
     public String getFirstName() { return firstName; }
     public void setFirstName(String firstName) { this.firstName = firstName; }


     public String getLastName() { return lastName; }
     public void setLastName(String lastName) { this.lastName = lastName; }


     public String getID() { return ID; }
     public void setID(String ID) { this.ID = ID; }


     public String getTitle() { return title; }
     public void setTitle(String title) { this.title = title; }


     public int getYOB() { return YOB; }

     // Setting the custom range on that YOB ranged input that prof was talking about in the lesson video
     public void setYOB(int YOB) {
         if (YOB >= 1940 && YOB <= 2010) {
             this.YOB = YOB;
         } else {
             throw new IllegalArgumentException("Year of Birth must be between 1940 and 2010");
         }
     }

    /**
     * ------ Some Required Methods below ------
     */




    /**
     * @return full name of the user
     */
    public String fullName() {
         return firstName + " " + lastName;
     }

    /**
     * @return formal name in the format "Title FirstName LastName
     */
     public String formalName() {
         return title + " " + fullName();
     }

    /**
     * @return Returns age in years based on the current year
     */
    public String getAge() {
         int currentYear = Calendar.getInstance().get(Calendar.YEAR);
         return String.valueOf(currentYear - this.YOB);
     }

    /**
     * @param year The year to calculate age against
     * @return Age in that year
     */
    public String getAge(int year) {
        return String.valueOf(year - this.YOB);
    }

    /**
     * @return CSV string in the format: firstName,lastName,ID,title,YOB
     */
    public String toCSV() {
        return firstName + " " + lastName + " " + ID + " " + title + " " + YOB;
    }

    /**
     * @return JSON string representation of the Person
     */
    public String toJSON() {
        return String.format("{\\\"firstName\\\":\\\"%s\\\",\\\"lastName\\\":\\\"%s\\\",\\\"ID\\\":\\\"%s\\\",\\\"title\\\":\\\"%s\\\",\\\"YOB\\\":%d}",
                firstName, lastName, ID, title, YOB);
    }

    /**
     * @return XML string representation of the Person
     */
    public String toXML() {
        return String.format("<Person><FirstName>%s</FirstName><LastName>%s</LastName><ID>%s</ID><Title>%s</Title><YOB>%d</YOB></Person>",
                firstName, lastName, ID, title, YOB);
    }
}
