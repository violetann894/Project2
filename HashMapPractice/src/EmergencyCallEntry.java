/**
 * The EmergencyCallEntry class is responsible for taking in data from the Kaggle dataset "Emergency - 911 Calls".
 * This class works alongside the Importer class to accept data from a .csv file and organizes the data in to multiple
 * EmergencyCallEntry objects.
 * Link to dataset here: https://www.kaggle.com/datasets/mchirico/montcoalert?resource=download
 * @author Rachel Hussmann
 */
public class EmergencyCallEntry {

    private String titleOfEmergency;
    private String timeStamp;
    private String twp;
    private String address;

    /**
     * Constructor for the EmergencyCallEntry class
     * @param titleOfEmergency The title of the emergency (example from data set, EMS: DIABETIC EMERGENCY)
     * @param timeStamp The date and time of the emergency
     * @param twp The township that the emergency took place in
     * @param address The street address of the emergency
     */
    public EmergencyCallEntry(String titleOfEmergency, String timeStamp, String twp, String address){
        this.titleOfEmergency = titleOfEmergency;
        this.timeStamp = timeStamp;
        this.twp = twp;
        this.address = address;
    }

    /**
     * Getter for the titleOfEmergency variable
     * @return The title of the emergency
     */
    public String getTitleOfEmergency() {
        return titleOfEmergency;
    }

    /**
     * Setter for the titleOfEmergency variable
     * @param titleOfEmergency The title of the emergency
     */
    public void setTitleOfEmergency(String titleOfEmergency) {
        this.titleOfEmergency = titleOfEmergency;
    }

    /**
     * Getter for the timeStamp variable
     * @return The time and date of the emergency
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Setter for the timeStamp variable
     * @param timeStamp The time and data of the emergency
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Getter for the twp (township) variable
     * @return The township that the emergency took place in
     */
    public String getTwp() {
        return twp;
    }

    /**
     * Setter for the twp (township) variable
     * @param twp The township that the emergency took place in
     */
    public void setTwp(String twp) {
        this.twp = twp;
    }

    /**
     * Getter for the address variable
     * @return The street address where the emergency took place
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for the address variable
     * @param address The street address where the emergency took place
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * The toString method returns a string representation of the object
     * @return A string representation of the EmergencyCallEntry object
     */
    @Override
    public String toString() {
        return timeStamp + ", " + titleOfEmergency;
    }
}
