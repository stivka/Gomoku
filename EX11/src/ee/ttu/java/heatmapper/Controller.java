package ee.ttu.java.heatmapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
     * @param setUrlBox URL address.
     */
    public void pushButton(ActionEvent setUrlBox) {
            url = urlBox.getText();
            Heatmapper nextInstance = new Heatmapper(url);

            nextInstance.getBigrams();
            nextInstance.getMaxCount();
            nextInstance.getCountForBigram("ip");
            nextInstance.getTotalCount();

//            nextInstance.getMaxCount and so forth..


    }

}
