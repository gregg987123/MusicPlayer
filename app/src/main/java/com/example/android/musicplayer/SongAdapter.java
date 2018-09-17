package com.example.android.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists. This class may not be necessary, as the ArrayAdapter could
     * probably be used on its own, but this is here to allow for later modification (i.e., for
     * when more than just a single String will be displayed for each item.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param song    A List of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> song) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, song);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        //If there is not a view being recycled, inflate/populate a newly created view.
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_list_item.xml layout with the ID song_name_text_view
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id
                .song_name_text_view);

        // Get the version name from the current Song object and set this text on the name TextView
        songNameTextView.setText(currentSong.getSongName());

        // Find the TextView in the song_list_item.xml layout with the ID artist_name_text_view
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id
                .artist_name_text_view);

        // Get the version name from the current Song object and set this text on the name TextView
        artistNameTextView.setText(currentSong.getArtistName());

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }

}