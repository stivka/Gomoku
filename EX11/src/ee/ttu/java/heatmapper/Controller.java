package ee.ttu.java.heatmapper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
     * Sets the texfield input as String url.
     */
    private String url;

    /**
     *
     * @param setUrlBox URL address.
     */
    public void run(ActionEvent setUrlBox) {
            url = urlBox.getText();
            Heatmapper nextInstance = new Heatmapper(url);

//            nextInstance.getMaxCount and so forth..


    }

}
