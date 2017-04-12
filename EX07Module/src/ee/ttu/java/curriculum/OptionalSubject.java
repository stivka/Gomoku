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
    private final String name;
    private final String code;
    private final int eap;
    private final String module;

    /**
     * @param name bla
     * @param code bla
     * @param eap bla
     * @param module bla
     */
    OptionalSubject(String name, String code, int eap, String module) {

        this.name = name;
        this.code = code;
        this.eap = eap;
        this.module = module;
    }

    /**
     *
     * @return tagastab õppeaine mooduli
     */
    public String getModule() {
        return module;
    }
}
