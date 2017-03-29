package ee.ttu.java.curriculum;

/**
 * Created by Stiv on 28/03/2017.
 * Valikaine. Valikaine puhul tuleb (antud rakenduses) määrata ka
 * moodul, kuhu see läheb. Vastav väli tuleb lisada. Laiendab Subject
 * klassi. Peaks sisaldama (lisaks Subjekt klassist päritavatele
 * meetoditele) järgmisi meetodeid:

 konstruktor(String name, String code, int eap, String module)
 public String getModule() - tagastab õppeaine mooduli
 */
public class OptionalSubject extends Subject {

//    String name;

    /**
     * @param name
     * @param code
     * @param eap
     * @param module
     */
    OptionalSubject(String name, String code, int eap, String module) {

    }

    /**
     *
     * @return tagastab õppeaine mooduli
     */
    public String getModule() {
        return module;
    }
}
