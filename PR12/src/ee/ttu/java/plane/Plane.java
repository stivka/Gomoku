package ee.ttu.java.plane;

/**
 * Created by Stiv on 16/05/2017.
 */
public class Plane {
    private String number;

    /**
     * @param number String of the seat.
     */
    public Plane(String number) {

        this.number = number;
    }
    public String getNumber() {
        return number;
    }
}
