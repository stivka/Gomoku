package ee.ttu.java.heatmapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Stiv on 17/04/2017.
 */
public class Controller {
    /**
     * textfield where URL address is given.
     */
    @FXML
    private TextField urlBox;
    /**
     * On the push of the button, the URL is processed.
     */
    @FXML
    private Button submitUrl;
    /**
     * Sets the texfield input as String url.
     */
    private String url;

    /**
     *
     */
    @FXML
    private GridPane gridPane;

    private String wholeString;

    /**
     *
     * @param setUrlBox URL address.
     */
    public void pushButton(ActionEvent setUrlBox) {
            url = urlBox.getText();

            /*
            If the string will be taken from the text on the site
            provided by the URL address, as opposed to the string
            being fed into the constructor directly, as in the
            automated tests. In that case the method stringFromUrl
            should be separated from the constructor.
             */

            stringFromUrl(url);

            Heatmapper nextInstance = new Heatmapper(wholeString);

            nextInstance.getBigrams();
            nextInstance.getMaxCount();
            nextInstance.getCountForBigram("ip");
            nextInstance.getTotalCount();

            Heatmapper getCount = new Heatmapper("aabc abcd aaab ab");
            getCount.getCountForBigram("AB");

//            setGridPane();

//            nextInstance.getMaxCount and so forth..


    }
    public void stringFromUrl(String url) {
        try {

            URL url1 = new URL(url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url1.openStream()));

            wholeString = ""; // clears the string.
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                wholeString += inputLine;
                System.out.println(wholeString);
                in.close();
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
    public void setGridPane() {
        gridPane.addRow(26);
        gridPane.addColumn(26);
        gridPane.setGridLinesVisible(true);
    }

}
