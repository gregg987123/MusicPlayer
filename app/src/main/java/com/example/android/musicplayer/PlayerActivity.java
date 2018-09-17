package com.example.android.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    //Initializing variables, creating an array of Songs, and and initializing TextViews outside of
    // the onCreate method in case they are to be used in other methods later. Particularly, I
    // needed to do this when I used "onClick" before changing to OnClickListeners. I am leaving
    // it this way in case that functionality is desired later.
    int songIndex;
    Song currentSong;
    ArrayList<Song> songs = new ArrayList<Song>();
    TextView songNameTextView;
    TextView artistNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_screen);
        String stationName = getIntent().getStringExtra("station_name_key") + " Station";

        TextView stationNameTextView = (TextView) findViewById(R.id.station_name);
        stationNameTextView.setText(stationName);
        songIndex = 0;
        songNameTextView = (TextView) findViewById(R.id.song_name);
        artistNameTextView = (TextView) findViewById(R.id.artist_name);

        if (stationName.equals("Pop Station")) {
            songs.add(new Song("Better Now", "Post Malone"));
            songs.add(new Song("Love Lies", "Khalid & Normani"));
            songs.add(new Song("Girls Like You", "Maroon 5 Featuring Cardi B"));
            songs.add(new Song("I Like It", "Cardi B, Bad Bunny & J Balvin"));
            songs.add(new Song("Back To You", "Selena Gomez"));
            songs.add(new Song("Youngblood", "5 Seconds of Summer"));
            songs.add(new Song("In My Feelings", "Drake"));
            songs.add(new Song("No Brainer", "DJ Khaled"));
            songs.add(new Song("God Is A Woman", "Ariana Grande"));
            songs.add(new Song("No Tears Left to Cry", "Ariana Grande"));
            songs.add(new Song("Mine", "Bazzi"));
            songs.add(new Song("Remind Me To Forget", "Kygo"));
            songs.add(new Song("Psycho", "Post Malone"));
            songs.add(new Song("Delicate", "Taylor Swift"));
            songs.add(new Song("I'm A Mess", "Bebe Rexha"));
            songs.add(new Song("Side Effects", "The Chainsmokers"));

        } else if (stationName.equals("Country Station")) {
            songs.add(new Song("Meant To Be", "Florida Georgia Line & Bebe Rexha"));
            songs.add(new Song("Tequila", "Dan + Shay"));
            songs.add(new Song("Simple", "Florida Georgia Line"));
            songs.add(new Song("Sunrise, Sunburn, Sunset", "Luke Bryan"));
            songs.add(new Song("Heaven", "Kane Brown"));
            songs.add(new Song("Drowns The Whiskey", "Jason Aldean F. Miranda Lambert"));
            songs.add(new Song("Life Changes", "Thomas Rhett"));
            songs.add(new Song("Hotel Key", "Old Dominion"));
            songs.add(new Song("Mercy", "Brett Young"));
            songs.add(new Song("Get Along", "Kenny Chesney"));
            songs.add(new Song("Hooked", "Dylan Scott"));
            songs.add(new Song("She Got The Best of Me", "Luke Combs"));
            songs.add(new Song("Blue Tacoma", "Russell Dickerson"));
            songs.add(new Song("Break Up In The End", "Cole Swindell"));
        }

        if (songs.size() < 1) {
            songNameTextView.setText(R.string.station_not_configured_text);
        } else {
            currentSong = songs.get(songIndex);
            songNameTextView.setText(currentSong.getSongName());
            artistNameTextView.setText(currentSong.getArtistName());
        }

        //Pause/Play Button: not currently implemented

        /*Next Song Button ClickListener*/

        // Find the Next Song Button View
        Button nextSong = (Button) findViewById(R.id.next_song_button);

        // Set a click listener on that Button
        nextSong.setOnClickListener(new View.OnClickListener() {
            // The code in this method will execute when the next song button view is clicked.
            //If songs.size() == 0, then nothing is to be done when the button is clicked.
            @Override
            public void onClick(View view) {
                if (songs.size() == 0) {

                } else if (songIndex < songs.size() - 1) {
                    songIndex++;
                    currentSong = songs.get(songIndex);
                    songNameTextView.setText(currentSong.getSongName());
                    artistNameTextView.setText(currentSong.getArtistName());
                } else {
                    songIndex = 0;
                    currentSong = songs.get(songIndex);
                    songNameTextView.setText(currentSong.getSongName());
                    artistNameTextView.setText(currentSong.getArtistName());
                }
            }
        });

        /*Previous Song Button ClickListener*/

        // Find the Previous Song Button View
        Button previousSong = (Button) findViewById(R.id.previous_song_button);

        // Set a click listener on that Button
        previousSong.setOnClickListener(new View.OnClickListener() {
            // The code in this method will execute when the previous song button view is clicked.
            //If songs.size() == 0, then nothing is to be done when the button is clicked.
            @Override
            public void onClick(View view) {
                if (songs.size() == 0) {

                } else if (songIndex > 0) {
                    songIndex--;
                    currentSong = songs.get(songIndex);
                    songNameTextView.setText(currentSong.getSongName());
                    artistNameTextView.setText(currentSong.getArtistName());
                } else {
                    songIndex = songs.size() - 1;
                    currentSong = songs.get(songIndex);
                    songNameTextView.setText(currentSong.getSongName());
                    artistNameTextView.setText(currentSong.getArtistName());
                }
            }
        });

        //The following only executes if the selected station is implemented with Songs
        if (songs.size() > 0) {
            TextView songListHeadingTextView = (TextView) findViewById(R.id
                    .song_list_heading);
            songListHeadingTextView.setText(R.string.song_list_heading);

            // Create an {@link SongAdapter}, whose data source is a list of Songs. The
            // adapter knows how to create list items for each item in the list.
            SongAdapter adapter = new SongAdapter(this, songs);

            // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
            // There should be a {@link ListView} with the view ID called song_list, which is
            // declared in the PlayerActivity.
            ListView listView = (ListView) findViewById(R.id.song_list);

            // Make the {@link ListView} use the {@link StationAdapter} we created above, so that the
            // {@link ListView} will display list items for each {@link Word} in the list.
            listView.setAdapter(adapter);
        }

    }
}
