package ee.ttu.java.albumcreation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

import static java.lang.Integer.valueOf;

/**
 * Created by Stiv on 08/03/2017.
 * Laulul peavad olema määratud pealkiri, vähemalt üks autor ning see
 peab olema aktsepteeritava pikkusega
 */
public class Song { //Klassi konstruktor
    /**
     *
     */
    public boolean readyBoolean = false;
    /**
     *
     */
    private List<Boolean> ready = new ArrayList<>();
    /**
     *
     * @param s length
     * @return
     */
    private Duration parse(String s) {
        try {
            int colonIndex = s.indexOf(':');
            String mm = s.substring(0, colonIndex);
            String ss = s.substring(colonIndex + 1);
            duration = Duration.ofMinutes(valueOf(mm)).plusSeconds(valueOf(ss));
            long seconds = duration.getSeconds();
            System.out.println(String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60)));
            return duration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    private Duration duration;
    /**
     *
     */
    private static DateFormat sdf = new SimpleDateFormat("mm:ss");
    /**
     *
     */
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
    /**
     *
     */
    private String title;
    /**
     *
     */
    private List<String> authors = new ArrayList<String>(); /* right now by
    default the capacity of the list is 10 - cannot fit more
    authors. */
    /**
     *
     */
    private String length; // does it have to be set to null, for it to be null by default.

    /**
     * Laulul peavad olema määratud pealkiri, vähemalt üks autor ning see peab olema aktsepteeritava pikkusega.
     *
     * Kahtlustan, et seda testitakse ka eraldi. Et söödetakse sisse, Song objekt ning oodatakse sellele väljundit
     * true või false.
     * @param song asdfjkl
     */
    public boolean isReady() {
        if (title != null) {
            System.out.println("song title isn't null");
        } else {
            return false;
        }
        if (authors.size() > 0) {
            System.out.println("song of has at least one author");
        } else {
            return false;
        }
        if (length != null) {
            System.out.println("song has a length");
        } else {
            return false;
        }
        readyBoolean = true;
        ready.add(true);
        return true;
    }

    /**
     *
     * @param s bla bla
     */
    public void setTitle(String s) {
        if (!s.equals(null) && !s.equals("")) {
            this.title = s;
        }
    }
//    @Override
//    public String toString() {
//        return title; // what is this override for? It helps me print with for loop.
//    }
    /**
     *
     * @return title
     */
    private String getTitle(){
            return title;
    }

    /**
     * meetod aktsepteerib loo pikkust järgmistel kujudel:
     * mm:ss, mm:s, m:ss, m:s (m - minut, s - sekund). Ehk siis
     * sobivad on "01:02", "01:2", "1:02", "1:2". Kõik annavad sama
     * tulemuse. Kui sisendina saadud sõne pole korrektne (ei vasta
     * eelnevatele formaatidele või sisaldab muid sümboleid), ei
     * muudeta olemasolevat loo pikkust. Algselt on loo pikkus null.
     * @param s sth like "02:43"
     */
    public void setLength(String s) {
//        try {
//            Duration duration;
//            Date timeFromDate;
//            timeFromDate = formatter.parse(s);
//            duration = formatter.parse(s);
//            duration = sdf.parse(s);
//        }
        DateFormat sdf = new SimpleDateFormat("mm:ss");
        sdf.setLenient(false); // this should make it so, that strings which don't fit the pattern, are rejected.
        Date timeFromDate = null;
        try {
            timeFromDate = sdf.parse(s);
            s = sdf.format(timeFromDate);
//            System.out.println("Song length: " + s);
            this.length = s;
            parse(s); // runs class method parse
            System.out.println(length);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return
     */
    public Duration getDuration() {
        return duration;
    }
    /**
     *
     * @return length
     */
    public String getLength() {
        return length;
    }

    /**
     *
     * @param me string
     */
    public void addAuthor(String me) {
        authors.add(me);
    }

    /**
     *
     * @return authors
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     *
     * @param s bla bla
     */
    public void removeAuthor(String s) {
        authors.remove(s);
    }


}
