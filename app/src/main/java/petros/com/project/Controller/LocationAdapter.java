package petros.com.project.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import petros.com.project.R;
import petros.com.project.model.LocationData;

/**
 * Created by Peter on 5/22/2016.
 */
public class LocationAdapter extends ArrayAdapter<LocationData> {

    Context mContext;
    int mLayoutResourceId;
    LocationData mData[] = null;

    public LocationAdapter(Context context, int resource, LocationData[] data) {
        super(context, resource, data);

        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Override
    public LocationData getItem(int position) {
        return mData[position];
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LocationHolder holder = null;
        if(row==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new LocationHolder();
            holder.City = (TextView)row.findViewById(R.id.city);
            holder.Store = (TextView)row.findViewById(R.id.name);
            holder.Street = (TextView)row.findViewById(R.id.street);
            holder.Zip = (TextView)row.findViewById(R.id.zip);

            row.setTag(holder);
        }else{
            holder  = (LocationHolder)row.getTag();
        }


        LocationData locationData = mData[position];
        holder.City.setText(locationData.getCity());
        holder.Street.setText(locationData.getStreet());
        holder.Store.setText(locationData.getStoreName());
        holder.Zip.setText(locationData.getZipCode());



        return row;
    }
    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            LocationData p = mData[viewPosition];
            Toast.makeText(getContext(), p.getCity(), Toast.LENGTH_SHORT).show();
        }
    };


    public static class LocationHolder{
        TextView City;
        TextView Store;
        TextView Street;
        TextView Zip;
    }
}
