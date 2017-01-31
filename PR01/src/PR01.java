/**
 * Created by Stiv on 31/01/2017.
 */
public class PR01 {
    /**
     *
     * @param args will be a string the server provides.
     */
    public static void main(String[] args) {
        /*

         */

        //    Hello Peeter, number of letters in your name: 6.
        System.out.println(printAndReturnHello("Peeter"));

    }

    /**
     *
     * @param name does it take time
     * @return
     */
    public static String printAndReturnHello(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        else {
            return ("Hello " + name + " number of letters in your name: "
                    + name.length() + ".");

        }

    }
}
