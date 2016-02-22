package petros.com.project;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LocationInformationDetails extends Fragment{

    //Variables
    private String name;
    private String city;
    private String street;
    private String code;
    private String facebook;
    private double longgitude;
    private double latitude;

    private TextView nameText;
    private TextView cityText;
    private TextView streetText;
    private TextView codeText;
    private TextView location;
    private TextView facebookText;


    //This is the Fractal we call to show all the information about particular store
    public static final LocationInformationDetails newInstance(String name,String city,String street,String code,String facebook,double longgitude,double latitude){
        LocationInformationDetails adf =  new LocationInformationDetails();
        Bundle bundle = new Bundle(6);
        bundle.putString("name", name);
        bundle.putString("city", city);
        bundle.putString("street", street);
        bundle.putString("facebook", facebook);
        bundle.putDouble("longgitude", longgitude);
        bundle.putDouble("latitude", latitude);
        adf.setArguments(bundle);
        return adf;
    }

    //The OnCreateView Method it runs everytime our Fragment is displayed
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){

        View myFragmentView = inflater.inflate(R.layout.activity_location_information_details,
                container, false);

        //get the arguments from fragments
        this.name = getArguments().getString("name");
        this.city = getArguments().getString("city");
        this.street = getArguments().getString("street");
        this.facebook = getArguments().getString("facebook");
        this.code = getArguments().getString("code");
        this.longgitude = getArguments().getDouble("longgitude");
        this.latitude = getArguments().getDouble("latitude");

        //get reference from the widgets
        nameText = (TextView)myFragmentView.findViewById(R.id.nameTextView);
        cityText = (TextView)myFragmentView.findViewById(R.id.cityTextView);
        streetText = (TextView)myFragmentView.findViewById(R.id.streetTextView);
        codeText = (TextView)myFragmentView.findViewById(R.id.codeTextView);
        facebookText = (TextView)myFragmentView.findViewById(R.id.faceTextView);
        location = (TextView)myFragmentView.findViewById(R.id.latTextView);

        //set the text of the widgets
        nameText.setText("Store Name: " + name);
        cityText.setText("City: " + city);
        streetText.setText("Street: " + street);
        codeText.setText("Zip Code: " + code);
        facebookText.setText("Facebook ID " + facebook);
        location.setText("Location" + longgitude + " : " + latitude);

        return myFragmentView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
