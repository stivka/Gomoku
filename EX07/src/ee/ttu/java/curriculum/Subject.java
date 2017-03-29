package ee.ttu.java.curriculum;

/**
 * Created by Stiv on 28/03/2017.
 */
public abstract class Subject {
    /**
     *
     */
    private int eap;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String code;

    /**
     *
     * @return tagastab õppeaine eest saadav EAP koguse (näiteks 5)
     */
    public int getEap() {
        return eap;
    }

    /**
     *
     * @return tagastab õppeaine nime (näiteks "Programmeerimise põhikursus Javas")
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return tagastab õppeaine koodi (näiteks "ITI0011")
     */
    public String getCode() {
        return code;
    }
}
