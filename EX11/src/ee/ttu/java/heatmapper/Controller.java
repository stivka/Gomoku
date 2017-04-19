package ee.ttu.java.heatmapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Stiv on 17/04/2017.
 */
public class Controller implements Initializable {
    /**
     * Created when trying to add a second view.
     */
    @FXML
    AnchorPane apMain;

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
    /**
     * The whole text as one String.
     */
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


        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("heatmapView.fxml"));

//            HeatmapController heatmapController = (HeatmapController) newLoadedPane.getController();
            Scene heatmap = new Scene(newLoadedPane);
            Main.heatmapStage.setScene(heatmap);
//            setGridPane();



        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Down below is a separate call for testing.
         */
//        Heatmapper getCount = new Heatmapper("aabc abcd aaab ab");
//        getCount.getCountForBigram("AB");

//            setGridPane();

//            nextInstance.getMaxCount and so forth..

    }

    /**
     *
     * @param url the URL address.
     */
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
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
//    public void setGridPane() {
//        gridPane.setRowSpan();
//        gridPane.addColumn(26);
//        gridPane.setGridLinesVisible(true);
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO what?
    }
}
