package petros.com.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Query;

//This is the Fragment responsible to display the List of Places
public class LocationListFragment extends Fragment {

    //This string is used for Debuging
    private static final String TAG = "LocationListFragment";
    //The RestAdapter used in RetroFit API
    protected RestAdapter mRestAdapter;

    //The String of the URL where we get the API from
    private static final String API_URL = "http://getairport.com/subprise/api/";
    //This is reference to our MainActivity in order to get Access to our LocationRestAdapter
    private MainActivity main;

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

        //Build the Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.locations,R.id.activity_list_item_1, populateTheCities());


        //configure the list view
        Mylist = (ListView)myFragmentView.findViewById(R.id.mainListView);


        Mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // TODO Auto-generated method stub
                Object obj = Mylist.getAdapter().getItem(position);
                String value = obj.toString();


                //Initialise the new fragment we want to change
                FragmentTransaction trans = getActivity().getSupportFragmentManager().beginTransaction();
                //add the the Back Stack so we can return to this if we want to
                trans.replace(R.id.fragment_container, LocationInformationDetails.newInstance(
                        "" + main.getAdapter().getStoreName().get(position),
                        "" + main.getAdapter().getCity().get(position),
                        "" + main.getAdapter().getStreet().get(position),
                        "" + main.getAdapter().getZipcode().get(position),
                        "" + main.getAdapter().getFacebookId().get(position),
                        Double.parseDouble(main.getAdapter().locationsList.get(position).getLONGITUDE()),
                        Double.parseDouble(main.getAdapter().locationsList.get(position).getLATITUDE())));
                trans.addToBackStack("Details");
                //Commit to the replace of the fragment
                trans.commit();
            }
        });

        Mylist.setAdapter(adapter);

        return myFragmentView;
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

    //We populate our ListView here
    public ArrayList populateTheCities(){
        ArrayList<String> locationsList = new ArrayList<String>();
        GetLocationRestAdapter adapter = main.getAdapter();

        //Get the cities and populate the List
        for(int i = 0 ; i < adapter.getlatitude().size();i++){
            String tempString = ""+adapter.getCity().get(i);

            if(tempString!=null)
            locationsList.add(tempString);
        }
        return locationsList;
    }


    //We populate our ListView here
    public ArrayList populateTheStreet(){
        ArrayList<String> locationsList = new ArrayList<String>();
        GetLocationRestAdapter adapter = main.getAdapter();

        //Get the cities and populate the List
        for(int i = 0 ; i < adapter.getlatitude().size();i++){
            String tempString = ""+adapter.getStreet().get(i);

            if(tempString!=null)
                locationsList.add(tempString);
        }
        return locationsList;
    }
}
