package petros.com.project.Interfaces;

import java.util.List;

import petros.com.project.model.LocationData;
import retrofit2.Call;
import retrofit2.http.GET;

//RetroFit API to get the Locations from the Service
public interface LocationService {

    //sends a GET request into the Server to get the filed we want and store them into the string
    @retrofit.http.GET("/locations/get/")
    void getLocations(
            retrofit.Callback<List<LocationData>> callback
    );

//    @GET("/locations/get/")
//    Call<LocationData>getAllLocations();

}

