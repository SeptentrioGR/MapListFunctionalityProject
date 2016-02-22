package petros.com.project.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

import petros.com.project.Controller.GetLocationRestAdapter;
import petros.com.project.Fragments.MapsActivity;
import petros.com.project.Fragments.LocationListFragment;
import petros.com.project.Fragments.intoActivity;
import petros.com.project.Interfaces.LocationService;
import petros.com.project.model.LocationAdapter;
import petros.com.project.R;


//This is the MainActivity for the App
public class MainActivity extends FragmentActivity  {
    //String to used in Log
    private static final String TAG = "MainActivity";

    //Creates the two Fragments
    private MapsActivity one;
    private intoActivity two;
    private GetLocationRestAdapter restAdapter;
    private LocationAdapter locationsAdapter;
    private LocationService mLocationService;
    Button mapButton,listButton;

    public MainActivity(){

    }
	
    //When the App starts up
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Entered on Create");
        //Initialise the GetLocationRestAdapter
        restAdapter = new GetLocationRestAdapter();
        mLocationService = restAdapter.getLocationRestAdapter();
        locationsAdapter = new LocationAdapter(mLocationService);
        initializeViews();
        initializeButtons();
    }

    //Initialize the Views
    public void initializeViews(){
       one = new MapsActivity();
       two = new intoActivity();
        changeFragment(new intoActivity());
    }

    //Initialize the Buttons
    public void initializeButtons(){
        mapButton = (Button) findViewById(R.id.MapButton);
        listButton = (Button) findViewById(R.id.ListButton);

        //Add onClick Functionality onmapButton
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showNotification("Map Button Has Been Pressed!");
                changeFragment(new MapsActivity());
            }
        });

        //Add onClick Functionality on ListButton
        listButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showNotification("List Button Has Been Pressed!");
                changeFragment(new LocationListFragment());
            }
        });
    }
    //Show Notification on Screen Method
    public void showNotification(String msg){
        // Notification that the button has pressed
        Context context = getApplicationContext();
        //The test for our Notification
        CharSequence text = msg;
        //The Duration of the Message that will be disabled
        int duration = Toast.LENGTH_SHORT;
        //Create a new Toast Object
        Toast toast = Toast.makeText(context, text, duration);
        //Show the Message on the Screen
        toast.show();
    }

    //Change Fragment Method
    public void changeFragment(Fragment newActivity){
        //Starts the transition to the new Fragment
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        //Initialise the new fragment we want to change
        trans.replace(R.id.fragment_container, newActivity);
        //add the the Back Stack so we can return to this if we want to
        trans.addToBackStack("Map");
        //Search our fragment manager for the Fragment with the name List if it exist remove it else continue
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag("List");
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        //Commit to the replace of the fragment
        trans.commit();
    }

    public LocationAdapter mlocationsAdapter(){
        return locationsAdapter;
    }


}
