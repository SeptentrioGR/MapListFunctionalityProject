package petros.com.project;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

//This is the MainActivity for the App
public class MainActivity extends FragmentActivity  {
    //String to used in Log
    private static final String TAG = "MainActivity";

    private GetLocationRestAdapter locationService = null;

    //An Array to store all the locations
    ArrayList<String> locations = new ArrayList<>();
    //Creates the two Fragments
    protected  MapsActivity one = new MapsActivity();
    protected intoActivity two = new intoActivity();
    protected GetLocationRestAdapter adapter;
    public MainActivity(){

    }
    //When the App starts up
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"MainActivity has Started entered onCreate()");

        // Notification that the button has pressed
        Context context = this.getApplicationContext();
        CharSequence text = "Service has been started!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //Initialise the Main Menu Buttons
        Button mapButton = (Button) findViewById(R.id.MapButton);
        Button listButton = (Button) findViewById(R.id.ListButton);

        //Initialise the GetLocationRestAdapter
        adapter = new GetLocationRestAdapter();
        if(adapter!=null){
            Log.i(TAG,"STARTED"+adapter);
        }
        //Starts the transition to the new Fragment
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        //Initialise the new fragment we want to change
        trans.replace(R.id.fragment_container, new intoActivity());
        trans.addToBackStack("Main");

        trans.commit();


        //Add onClick Functionality onmapButton
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Notification that the button has pressed
                Context context = getApplicationContext();
                //The test for our Notification
                CharSequence text = "Map Button Has Been Pressed!";
                //The Duration of the Message that will be disabled
                int duration = Toast.LENGTH_SHORT;
                //Create a new Toast Object
                Toast toast = Toast.makeText(context, text, duration);
                //Show the Message on the Screen
                toast.show();

                //Starts the transition to the new Fragment
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                //Initialise the new fragment we want to change
                trans.replace(R.id.fragment_container, new MapsActivity());
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
        });

        //Add onClick Functionality on ListButton
        listButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Notification that the button has pressed
                Context context = getApplicationContext();
                //The test for our Notification
                CharSequence text = "Link Button Has Been Pressed!";
                //The Duration of the Message that will be disabled
                int duration = Toast.LENGTH_SHORT;
                //Create a new Toast Object
                Toast toast = Toast.makeText(context, text, duration);
                //Show the Message on the Screen
                toast.show();

                //Starts the transition to the new Fragment
                LocationListFragment lists = new LocationListFragment();
                //Initialise the new fragment we want to change
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                //add the the Back Stack so we can return to this if we want to
                trans.replace(R.id.fragment_container, new LocationListFragment());
                //add the the Back Stack so we can return to this if we want to
                trans.addToBackStack("List");
                //Search our fragment manager for the Fragment with the name List if it exist remove it else continue
                android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag("Map");
                if(fragment!=null){
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                }
                //Commit to the replace of the fragment
                trans.commit();
            }
        });
    }

    //getters for the GetLocationAdapter
    public GetLocationRestAdapter getAdapter(){
        return adapter;
    }


}
