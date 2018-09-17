package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        final ArrayList<String> station = new ArrayList<String>();

        /*Creating an ArrayList of Strings*/
        station.add("Pop");
        station.add("Country");
        station.add("Rock");
        station.add("Classic Rock");
        station.add("Hip Hop");
        station.add("Jazz");
        station.add("Rap");
        station.add("Punk");
        station.add("Folk");
        station.add("50s");
        station.add("60s");
        station.add("70s");
        station.add("80s");
        station.add("90s");
        station.add("2000s");
        station.add("Oldies");
        station.add("Classical");

        // Create an {@link WordAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create list items for each item in the list.
        StationAdapter adapter = new StationAdapter(this, station);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called station_list, which is
        // declared in the
        // activity_main.
        ListView listView = (ListView) findViewById(R.id.station_list);

        // Make the {@link ListView} use the {@link StationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        //Here we are setting an onItemClickListener and a new Intent. We are also passing
        // through the station name that was clicked. Regardless of the station that was clicked,
        // it will open the same PlayerActivity. What gets played in PlayerActivity depends on
        // the station that was clicked.
        //https://stackoverflow.com/questions/8615417/how-can-i-set-onclicklistener-on-arrayadapter/8615564
        //https://stackoverflow.com/questions/2091465/how-do-i-pass-data-between-activities-in-android-application?rq=1
        //https://developer.android.com/reference/android/content/Intent.html#putExtra(java.lang.String,%20android.os.Bundle)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent playerScreenIntent = new Intent (MainActivity.this, PlayerActivity.class);
                playerScreenIntent.putExtra("station_name_key", station.get(position));

                startActivity(playerScreenIntent);
            }
        });

    }


}