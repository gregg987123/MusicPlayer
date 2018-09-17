package com.example.android.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StationAdapter extends ArrayAdapter<String> {
    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists. This class may not be necessary, as the ArrayAdapter could
     * probably be used on its own, but this is here to allow for later modification (i.e., for
     * when more than just a single String will be displayed for each item.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param station A List of String objects to display in a list
     */
    public StationAdapter(Activity context, ArrayList<String> station) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, station);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        //If there is not a view being recycled, inflate/populate a newly created view.
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        String currentStation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView stationTextView = (TextView) listItemView.findViewById(R.id
                .station_name_text_view);

        // Get the version name from the current String object and
        // set this text on the name TextView
        stationTextView.setText(currentStation);

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }

}