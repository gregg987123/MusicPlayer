package com.example.android.musicplayer;

/* {@link Song} represents a song within a station. It contains the artist name and song name */
public class Song {

    /* Song name */
    private String mSongName;

    /* Artist name */
    private String mArtistName;

    /*Create a new Song object - this is a Constructor - should be the same name as the class.
     * @param songName is the name of the song
     * @param artistName is the name of the artist of the song */
    public Song(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    /* Get the default translation of the word */
    public String getSongName() {
        return mSongName;
    }

    /* Get the Miwok translation of the word */
    public String getArtistName() {
        return mArtistName;
    }

}
