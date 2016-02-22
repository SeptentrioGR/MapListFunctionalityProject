package petros.com.project.model;

/**
 * Created by Peter on 2/15/2016.
 */
public class LocationData {

    //Variables
    private String STORENAME;
    private String CITY;
    private String STREET;
    private String ZIPCODE;
    private String FACEBOOKID;
    private String LONGITUDE;
    private String LATITUDE;

    public LocationData(){}

    public LocationData(String LONGITUDE, String street, String latitude, String city, String zipcode, String storename, String facebookid) {
        this.LONGITUDE = LONGITUDE;
        STREET = street;
        LATITUDE = latitude;
        CITY = city;
        ZIPCODE = zipcode;
        STORENAME = storename;
        FACEBOOKID = facebookid;
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
        return ZIPCODE;
    }

    public void setZIP_CODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;
    }

    public String getSTORE_NAME() {
        return STORENAME;
    }

    public void setSTORE_NAME(String STORENAME) {
        this.STORENAME = STORENAME;
    }

    public String getFACEBOOK_ID() {
        return FACEBOOKID;
    }

    public void setFACEBOOK_ID(String FACEBOOKID) {
        this.FACEBOOKID = FACEBOOKID;
    }
}



