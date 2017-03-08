package ee.ttu.java.albumcreation;

import java.util.*;

/**
 * Created by Stiv on 08/03/2017.
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
    private String length;

    public void isReady() {
    }

    public void setTitle(String s) {
        this.title = s;
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
        int colonCount = 0;
        int otherThanDigitOrColon = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') {
                colonCount++;
            }
            else if (!Character.isDigit(s.charAt(i))) {
                otherThanDigitOrColon++;
            }
        }
        /* if there's only one colon and nothing other tha digits*/
        if (colonCount == 1 && otherThanDigitOrColon == 0) {

        }
        if (s.length() == 3 && s.charAt(1) == ':') {

        }
        this.length = s;
    }

    public void addAuthor(String me) {
    }

    public void removeAuthor(String s) {
    }
/* Laulul peavad olema määratud pealkiri, vähemalt üks autor ning see
peab olema aktsepteeritava pikkusega */

}
