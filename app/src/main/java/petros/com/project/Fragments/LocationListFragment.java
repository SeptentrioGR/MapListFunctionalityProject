package petros.com.project.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import petros.com.project.Activities.MainActivity;
import petros.com.project.model.LocationAdapter;
import petros.com.project.R;
import retrofit.RestAdapter;

//This is the Fragment responsible to display the List of Places
public class LocationListFragment extends Fragment {

    //This string is used for Debuging
    private static final String TAG = "LocationListFragment";
    //The RestAdapter used in RetroFit API
    protected RestAdapter mRestAdapter;
    private LocationAdapter locationAdapter;
    //The String of the URL where we get the API from
    private static final String API_URL = "the Location Api Goes here";
    //This is reference to our MainActivity in order to get Access to our LocationRestAdapter
    private MainActivity main;
    //A reference to our list
    private ListView Mylist;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //this starts when fragment is called

    }
	
    //The OnCreateView Method it runs everytime our Fragment is displayed
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View myFragmentView = inflater.inflate(R.layout.activity_list_fragment,
                container, false);
        locationAdapter = main.mlocationsAdapter();
        initiateList(myFragmentView);
        return myFragmentView;
    }

    //Initiate list
    public void initiateList(View myFragmentView){
        //configure the list view
        Mylist = (ListView)myFragmentView.findViewById(R.id.mainListView);
        Mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // TODO Auto-generated method stub
                Object obj = Mylist.getAdapter().getItem(position);
                String value = obj.toString();
                LocationInformationDetails details = LocationInformationDetails.newInstance(
                        "" + locationAdapter.getStoreName().get(position),
                        "" + locationAdapter.getCity().get(position),
                        "" + locationAdapter.getStreet().get(position),
                        "" + locationAdapter.getZipcode().get(position),
                        "" + locationAdapter.getFacebookId().get(position),
                        Double.parseDouble(locationAdapter.getLongitude().get(position).toString()),
                        Double.parseDouble(locationAdapter.getlatitude().get(position).toString()));
                //Initialise the new fragment we want to change
                FragmentTransaction trans = getActivity().getSupportFragmentManager().beginTransaction();
                //add the the Back Stack so we can return to this if we want to
                trans.replace(R.id.fragment_container, details);
                trans.addToBackStack("Details");
                //Commit to the replace of the fragment
                trans.commit();
            }
        });


        Mylist.setAdapter(locationAdapter.createAdapter(this.getActivity()));
    }

    //When the Fragment is Attatch to the main Activity we get reference of it so we can access it from anywhere in this class
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
