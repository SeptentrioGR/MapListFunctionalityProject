package petros.com.project;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Peter on 2/6/2016.
 */


public class GetLocationRestAdapter {

    ArrayList<LocationData> locationsList = new ArrayList();
    public static ArrayList<String> longitude = new ArrayList();
    public static ArrayList<String> street = new ArrayList();
    public static ArrayList<String> latitude = new ArrayList();
    public static ArrayList<String> city = new ArrayList();
    public static ArrayList<String> zipcode = new ArrayList();
    public static ArrayList<String> storename = new ArrayList();
    public static ArrayList<String> facebookid= new ArrayList();



    //TAG to be used in Log
    protected final String TAG = "GetLocationRestAdapter";
    LocationData dataDB = new LocationData();
    //My RestAdapter for RetroFit API
    protected RestAdapter mRestAdapter;

    //Reference to the getLocationsApi
    protected GetLocationApi mApi;

    //My Api Location
    private static final String API_URL = "http://getairport.com/subprise/api/";


    public GetLocationRestAdapter() {
        Log.i(TAG, "Get Location Rest Adapter is Created");

        mRestAdapter = new RestAdapter.Builder().
                setLogLevel(RestAdapter.LogLevel.FULL).
                setEndpoint(API_URL)
                .build();
        mApi = mRestAdapter.create(GetLocationApi.class);
        grabLocationsFromURL();
    }

    //gets the ArrayList
    public ArrayList getLocationDataArray() {
        return locationsList;
    }

//Grabs the locations from URL and put them on arraylist
    public void grabLocationsFromURL() {
        mApi.getLocations("LONGITUDE", "STREET", "LATITUDE", "CITY", "ZIP CODE", "STORE NAME", "FACEBOOK ID", new Callback<List<LocationData>>() {
            @Override
            public void success(List<LocationData> dataDB, Response response) {

                for (int i = 0; i < dataDB.size(); i++) {
                    locationsList.add(dataDB.get(i));
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

            }
        });
    }


    //RetroFit API to get the Locations from the Service
    public interface GetLocationApi {

        @GET("/locations/get/")
        void getLocationFromApi(
                @Query("mid") String id, Callback<List<LocationData>> callback

        );

        //sends a GET request into the Server to get the filed we want and store them into the string
        @GET("/locations/get/")
        void getLocations(
                @Query("LONGITUDE") String LONGITUDE,
                @Query("STREET") String STREET,
                @Query("LATITUDE") String LATITUDE,
                @Query("CITY") String CITY,
                @Query("ZIP CODE") String ZIP_CODE,
                @Query("STORE NAME") String STORE_NAME,
                @Query("FACEBOOK ID") String FACEBOOK_ID,
                Callback<List<LocationData>> callback

        );


        @GET("/locations/get/")
        void getLONGITUDE(
                @Query("LONGITUDE") String LONGITUDE, Callback<List<LocationData>> callback

        );

        @GET("/locations/get/")
        void getSTREET(
                @Query("STREET") String STREET, Callback<List<LocationData>> callback
        );

        @GET("/locations/get/")
        void getLATITUDE(
                @Query("LATITUDE") String LATITUDE, Callback<List<LocationData>> callback
        );

        @GET("/locations/get/")
        void getCITY(
                @Query("CITY") String CITY, Callback<List<LocationData>> callback
        );

        @GET("/locations/get/")
        void getZIP_CODE(
                @Query("ZIP CODE") String ZIP_CODE, Callback<List<LocationData>> callback
        );

        @GET("/locations/get/")
        void getSTORE_NAME(
                @Query("STORE NAME") String STORE_NAME, Callback<List<LocationData>> callback
        );

        @GET("/locations/get/")
        void getFACEBOOK_ID(
                @Query("FACEBOOK ID") String FACEBOOK_ID, Callback<List<LocationData>> callback
        );
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
