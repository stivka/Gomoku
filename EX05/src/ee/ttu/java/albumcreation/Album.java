package ee.ttu.java.albumcreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stiv on 08/03/2017.
 * Albumi saab avaldada alles siis, kui seal on vähemalt 5 laulu ja kestab kauem vähemalt 25 minutit. Albumil peab
 * olema määratud ka nimi ja žanr. Kõik albumil olevad lood peavad olema valmis.
 */
public class Album extends Song { //Klassi konstruktor
    /**
     *
     */
    private String title;
    /**
     *
     */
    private String genre;
    /**
     * List trackListing. list, kus hoitakse Song tüüpi objekte.
     */
    private List<Song> trackListing = new ArrayList<Song>();

    /**
     *
     * @param song sth
     */
    public void removeSong(Song song) {
        trackListing.remove(song);

    }
    /**
     *Albumi saab avaldada alles siis, kui seal on vähemalt 5 laulu ja kestab kauem vähemalt 25 minutit. Albumil peab
     * olema määratud ka nimi ja žanr. Kõik albumil olevad lood peavad olema valmis.
     * @return true or false
     */
    public boolean release() {
        for (int i = 0; i < trackListing.size(); i++) {
            System.out.println(trackListing.get(i));
        };
//        if (trackListing.size() > 4 && )
        return true;
    }
    /**
     *
     * @param album1 lalalaa
     */
    public void setTitle(String album1) {
        this.title = album1;
    }

    /**
     *
     * @param genre sth
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     * @param song sth
     */
    public void addSong(Song song) {
        trackListing.add(song);
    }
}
