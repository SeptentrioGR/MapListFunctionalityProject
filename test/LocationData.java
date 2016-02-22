package petros.com.project;

/**
 * Created by Peter on 2/15/2016.
 */
public class LocationData {

    //Variables
    private String STORE_NAME;
    private String CITY;
    private String STREET;
    private String ZIP_CODE;
    private String FACEBOOK_ID;
    private String LONGITUDE;
    private String LATITUDE;

    public LocationData(){

    }

    public LocationData(String LONGITUDE, String street, String latitude, String city, String zipcode, String storename, String facebookid) {
        this.LONGITUDE = LONGITUDE;
        STREET = street;
        LATITUDE = latitude;
        CITY = city;
        ZIP_CODE = zipcode;
        STORE_NAME = storename;
        FACEBOOK_ID = facebookid;
    }

    public String getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    public String getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getZIP_CODE() {
        return ZIP_CODE;
    }

    public void setZIP_CODE(String ZIP_CODE) {
        this.ZIP_CODE = ZIP_CODE;
    }

    public String getSTORE_NAME() {
        return STORE_NAME;
    }

    public void setSTORE_NAME(String STORE_NAME) {
        this.STORE_NAME = STORE_NAME;
    }

    public String getFACEBOOK_ID() {
        return FACEBOOK_ID;
    }

    public void setFACEBOOK_ID(String FACEBOOK_ID) {
        this.FACEBOOK_ID = FACEBOOK_ID;
    }
}



