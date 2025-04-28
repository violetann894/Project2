/**
 * The EmergencyCallEntry class
 */
public class EmergencyCallEntry {

    private String titleOfEmergency;
    private String timeStamp;
    private String twp;
    private String address;

    /**
     *
     * @param titleOfEmergency
     * @param timeStamp
     * @param twp
     * @param address
     */
    public EmergencyCallEntry(String titleOfEmergency, String timeStamp, String twp, String address){
        this.titleOfEmergency = titleOfEmergency;
        this.timeStamp = timeStamp;
        this.twp = twp;
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getTitleOfEmergency() {
        return titleOfEmergency;
    }

    /**
     *
     * @param titleOfEmergency
     */
    public void setTitleOfEmergency(String titleOfEmergency) {
        this.titleOfEmergency = titleOfEmergency;
    }

    /**
     *
     * @return
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     *
     * @param timeStamp
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     *
     * @return
     */
    public String getTwp() {
        return twp;
    }

    /**
     *
     * @param twp
     */
    public void setTwp(String twp) {
        this.twp = twp;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return twp + ", " + titleOfEmergency;
    }
}
