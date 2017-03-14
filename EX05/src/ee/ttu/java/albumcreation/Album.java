package ee.ttu.java.albumcreation;

import java.util.ArrayList;
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
//    List trackListing //list, kus hoitakse Song tüüpi objekte
    /**
     *
     */
    private String genre;
    /**
     *
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
     *
     * @return
     */
    public boolean release() {
        return true;
    } //Albumi saab avaldada alles siis, kui seal on vähemalt 5 laulu ja kestab kauem vähemalt 25 minutit. Albumil peab
    // olema määratud ka nimi ja žanr. Kõik albumil olevad lood peavad olema valmis.

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
     * @param song1 sth
     */
    public void addSong(Song song1) {
        trackListing.add(song1);
    }
}
