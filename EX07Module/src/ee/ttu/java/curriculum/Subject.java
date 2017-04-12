package ee.ttu.java.curriculum;

/** The superclass, does it have to be public?
 * Created by Stiv on 28/03/2017.
 */
public abstract class Subject {
    /**
     *
     */
    int eap;
    /**
     *
     */
    String name, code;


    /**
     *
     * @return tagastab õppeaine eest saadav EAP koguse (näiteks 5)
     */
    public int getEap() {
        return eap;
    }

    /**
     *
     * @return tagastab õppeaine nime (näiteks "Programmeerimise
     * põhikursus Javas")
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
