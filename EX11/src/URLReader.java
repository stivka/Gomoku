import java.net.*;
import java.io.*;
/**
 * Created by Stiv on 12/04/2017.
 */

public class URLReader {
    public String getText() throws Exception {

        URL oracle = new URL("https://gitlab.cs.ttu.ee/iti0011/materjalid/raw/master/EX11/lorem.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String text = "";

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            text += inputLine;
//            System.out.println(inputLine);
        System.out.println(text);
        in.close();
        return text;
    }

    public static void main(String[] args) {

    }
}
