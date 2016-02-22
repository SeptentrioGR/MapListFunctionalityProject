package petros.com.project.model;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import petros.com.project.R;
import petros.com.project.model.LocationData;
import petros.com.project.Interfaces.LocationService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit2.Call;

/**
 * Created by Peter on 2/16/2016.
 */
public class LocationAdapter {
    //This string is used for Debuging
    private static final String TAG = "LocationAdapter";
    public static ArrayList<String> longitude;
    public static ArrayList<String> street;
    public static ArrayList<String> latitude;
    public static ArrayList<String> city;
    public static ArrayList<String> zipcode;
    public static ArrayList<String> storename;
    public static ArrayList<String> facebookid;

    //Reference to the getLocationsApi
    protected LocationService mApi;

    //Constructor which takes the LocationServices when created
    public LocationAdapter(LocationService mApi){
        this.mApi =mApi;
        longitude = new ArrayList();
        street = new ArrayList();
        latitude = new ArrayList();
        city = new ArrayList();
        zipcode = new ArrayList();
        storename = new ArrayList();
        facebookid= new ArrayList();
        getLocations();
    }


    //Grabs the locations from URL and put them on arraylist
    public void getLocations() {
        mApi.getLocations(new Callback<List<LocationData>>() {
            @Override
            public void success(List<LocationData> dataDB, Response response) {
                for (int i = 0; i < dataDB.size(); i++) {
                    longitude.add(dataDB.get(i).getLONGITUDE());
                    street.add(dataDB.get(i).getSTREET());
                    latitude.add(dataDB.get(i).getLATITUDE());
                    city.add(dataDB.get(i).getCITY());
                    zipcode.add(dataDB.get(i).getZIP_CODE());
                    storename.add(dataDB.get(i).getSTORE_NAME());
                    facebookid.add(dataDB.get(i).getFACEBOOK_ID());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error.toString());
            }
        });
    }



    public  ArrayAdapter<String> createAdapter(Activity activity){
        //Build the Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.locations,R.id.activity_list_item_1,getCity());
        return  adapter;
    }



    //Getters for The Arrays
    public ArrayList getLongitude() {
        return longitude;
    }
    public ArrayList getStreet() {
        return street;
    }
    public ArrayList getlatitude() {
        return latitude;
    }
    public ArrayList getCity(){
        return city;
    }
    public ArrayList getZipcode(){
        return zipcode;
    }
    public ArrayList getStoreName(){
        return storename;
    }
    public ArrayList getFacebookId(){
        return facebookid;
    }

}
