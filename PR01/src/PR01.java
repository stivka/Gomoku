/**
 * Created by Stiv on 31/01/2017.
 */
public class PR01 {
    /**
     *
     * @param args will be a string the server provides.
     */
    public static void main(String[] args) {
        System.out.println(printAndReturnHello("Peeter"));
    }
    /**
     *
     * @param name the String given by the server.
     * @return a String with the message "Hello (name),
     * number of letters in your name: (name.length())."
     */
    public static String printAndReturnHello(String name) {
        if (name == null || name.length() == 0) {
            return null;
        } else {
            return ("Hello " + name + ", number of letters in your name: "
                    + name.length() + ".");

        }

    }
}
