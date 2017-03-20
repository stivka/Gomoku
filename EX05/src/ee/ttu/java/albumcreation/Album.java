package ee.ttu.java.albumcreation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public void addSong(Song song) {
        trackListing.add(song);
    }
    /**
     *
     * @param song sth
     */
    public void removeSong(Song song) {
        trackListing.remove(song);

    }

    /**
     *
     * @return the song sth
     */
    public List<Song> getTrackListing() {
        return trackListing;
    }

    /**
     *Albumi saab avaldada alles siis, kui seal on vähemalt 5 laulu ja kestab kauem vähemalt 25 minutit. Albumil peab
     * olema määratud ka nimi ja žanr. Kõik albumil olevad lood peavad olema valmis.
     * @return true or false
     */
    public boolean release() {
        String s = "";
        DateFormat sdf = new SimpleDateFormat("mm:ss");
//        sdf.setLenient(false); // this should make it so, that strings which don't fit the pattern, are rejected.
        Date timeFromDate;

        long totalLength = 0;
        for (int i = 0; i < trackListing.size(); i++) {
            s = trackListing.get(i).getLength(); // get object, get its' length
//            System.out.println(trackListing.get(i).getTitle());
//            System.out.println(trackListing.get(i));
//            System.out.println(s);
            try {
                timeFromDate = sdf.parse(s);
                System.out.println(timeFromDate);
                System.out.println("Total length: " + timeFromDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

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

    @Override
    public String getTitle() {
        return title;
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
     * @return genre
     */
    public String getGenre() {
        return genre;
    }
}
