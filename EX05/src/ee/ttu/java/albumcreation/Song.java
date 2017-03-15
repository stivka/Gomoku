package ee.ttu.java.albumcreation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Stiv on 08/03/2017.
 * Laulul peavad olema määratud pealkiri, vähemalt üks autor ning see
 peab olema aktsepteeritava pikkusega
 */
public class Song { //Klassi konstruktor
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
     * Laulul peavad olema määratud pealkiri, vähemalt üks autor ning see peab olema aktsepteeritava pikkusega
     */
    public boolean isReady() {
        return !(authors.size() <= 0 || title.length() <= 0); // is this correct. auto suggestion..
    }

    /**
     *
     * @param s bla bla
     */
    public void setTitle(String s) {
        this.title = s;
    }
    @Override
    public String toString() {
        return title;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
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
        DateFormat sdf = new SimpleDateFormat("mm:ss");
        sdf.setLenient(false); // this should make it so, that strings which don't fit the pattern, are rejected.
        Date timeFromDate = null;
        try {
            timeFromDate = sdf.parse(s);
            s = sdf.format(timeFromDate);
            System.out.println("Song length: " + s);
            this.length = s;
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
     * @param s bla bla
     */
    public void removeAuthor(String s) {
        authors.remove(s);
    }
}
