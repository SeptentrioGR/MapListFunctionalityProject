package petros.com.project;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "mapActivity";
    private GoogleMap mMap;
    private static View view;
    private MainActivity main;

    @Override
    public void onResume(){
        super.onResume();
        setUpMapIfNeeded();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        android.support.v4.app.FragmentManager fragManager = getFragmentManager(); //If using fragments from support v4

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map));
        if(mapFragment!=null) {
            mapFragment.getMapAsync(this);
        }else{
            Log.i(TAG,"Map Fragment is Empty");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.activity_maps, container, false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }

        return view;

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setUpMapIfNeeded();



    }


    private void setUpMapIfNeeded(){
        if(mMap == null){
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map) ).getMap();
            if(mMap != null){
                setUpMap();
            }

        }
    }

    //This is the method we use to set up all the Stores in the Map
    private void setUpMap() {
        // Add a marker in Sydney and move the camera

        for (int i = 0; i < main.getAdapter().getlatitude().size(); i++) {
            double tempLat = Double.parseDouble(main.getAdapter().getlatitude().get(i).toString());
            double tempLong = Double.parseDouble(main.getAdapter().getLongitude().get(i).toString());
            String tempName = main.getAdapter().getCity().get(i).toString();
            LatLng city = new LatLng(tempLat, tempLong);
            mMap.addMarker(new MarkerOptions().position(city).title(tempName));
        }


    }

    private void getPointOnMap(LatLng point){
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                Log.d("Map","Map clicked");

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            main = (MainActivity ) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ExampleFragmentCallbackInterface ");
        }
    }
}
