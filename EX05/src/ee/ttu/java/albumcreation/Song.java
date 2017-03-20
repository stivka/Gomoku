package ee.ttu.java.albumcreation;

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
     * @param s length
     * @return
     */
    public Duration parse(String s) {
        int colonIndex = s.indexOf(':');
        String mm = s.substring(0, colonIndex);
        String ss = s.substring(colonIndex + 1);
        Duration duration = Duration.ofMinutes(valueOf(mm)).plusSeconds(valueOf(ss));
        long seconds = duration.getSeconds();
        System.out.println(String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60)));
        return duration;
    }

//    public static DateFormat sdf = new SimpleDateFormat("mm:ss");
    /**
     *
     */
//    String bestFormat.format(DateTimeFormatter.ofPattern("mm:ss");
    /**
     *
     */
    private String title;
    /**
     *
     */
//    private Duration duration;
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
//    @Override
//    public String toString() {
//        return title; // what is this override for? It helps me print with for loop.
//    }
    /**
     *
     * @return title
     */
    public String getTitle(){
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
        this.length = String.valueOf(parse(s));

//        DateFormat sdf = new SimpleDateFormat("mm:ss");
//        sdf.setLenient(false); // this should make it so, that strings which don't fit the pattern, are rejected.
//        Date timeFromDate = null;
//        try {
//            timeFromDate = sdf.parse(s);
//            s = sdf.format(timeFromDate);
////            System.out.println("Song length: " + s);
//            this.length = s;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Duration duration;
//        String[] fields = s.split(":");
//        System.out.println(Duration.parse(String.format("P%dM%sS", fields[0], fields[1])));
//        System.out.println(duration);
//        DateTimeFormatter bestFormatter = DateTimeFormatter.ofPattern("mm:ss");
//        duration = bestFormatter.parse(s);
//        System.out.println(duration);
//        String.format(s, bestFormatter);
//        System.out.println(s);
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
