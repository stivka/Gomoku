package ee.ttu.java.albumcreation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.valueOf;

/**
 * Created by Stiv on 08/03/2017.
 * Albumi saab avaldada alles siis, kui seal on vähemalt 5 laulu ja kestab kauem vähemalt 25 minutit. Albumil peab
 * olema määratud ka nimi ja žanr. Kõik albumil olevad lood peavad olema valmis.
 */
public class Album extends Song { //Klassi konstruktor
    /**
     *
     */

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
        if (isReady(song)) {
            trackListing.add(song);
        }
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
        Duration totalLength = Duration.ofMinutes(valueOf(0)).plusSeconds(valueOf(0));
        long seconds = 0;
        for (Song song: trackListing) {
            seconds += song.getDuration().getSeconds();
//            totalLength.plus(song.getDuration());
            System.out.println(seconds);
            System.out.println(String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60)));
        }
        if (seconds / 60 >= 25) {
            System.out.println("over 25 mins");
        } else { return false;}
        if (trackListing.size() > 4) {
            System.out.println("over 4 songs");
        } else { return false;}
        if (title != null) {
            System.out.println("title isn't null");
        } else { return false;}
        if (genre != null) {
            System.out.println("genre isn't null");
        }  else { return false;}
        System.out.println("Album is released!");
        return true;
    }

    /**
     *
     * @param album lalalaa
     */
    public void setTitle(String album) {
        if (!album.equals(null) && !album.equals(""))
        this.title = album;
        System.out.println(title);
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param genre sth
     */
    public void setGenre(String genre) {
        if (!genre.equals(null) && !genre.equals("")) {
            this.genre = genre;
            System.out.println(genre);
        }
    }
    /**
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }
}
