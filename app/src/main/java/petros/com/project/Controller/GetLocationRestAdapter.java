package petros.com.project.Controller;

import android.util.Log;

import petros.com.project.model.LocationData;
import petros.com.project.Interfaces.LocationService;
import retrofit.RestAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Peter on 2/6/2016.
 */


public class GetLocationRestAdapter {

    //TAG to be used in Log
    protected final String TAG = "GetLocationRestAdapter";
    //My RestAdapter for RetroFit API
    protected RestAdapter mRestAdapter;

    //My Api Location
    private static final String API_URL = "The Api Location Goes Here";
    private LocationService mApi;
    public GetLocationRestAdapter(){
        Log.i(TAG, "Get Location Rest Adapter is Created");

        //Diffrent way to use Retrofit with Gson.
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        mApi = retrofit.create(LocationService.class);

        mRestAdapter = new RestAdapter.Builder().
                setLogLevel(RestAdapter.LogLevel.FULL).
                setEndpoint(API_URL)
                .build();
        mApi = mRestAdapter.create(LocationService.class);
    }


    public LocationService getLocationRestAdapter() {
        return mApi;
    }

}