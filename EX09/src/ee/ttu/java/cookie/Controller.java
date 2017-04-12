package ee.ttu.java.cookie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Random;

/**
 * Created by Stiv on 10/04/2017.
 */
public class Controller {
    /**
     *
     */
    @FXML
    private Label myMessage;



    /**
     *
     * @param event when cookie is clicked
     */
    public void generateRandom(ActionEvent event) {
        Random rand = new Random();
        int myrand = rand.nextInt(50) + 1;

        myMessage.setText(Integer.toString(myrand));
//        System.out.println(Integer.toString(myrand));
    }

    /**
     *
     * @param cookieClick does sth
     */
    public void clickOnCookie(ActionEvent cookieClick) {
//        CookieGame.cookieAmount += clickValue;
    }
//    public void clickOnCookie(ActionEvent cookieClick) {
//        ImageView img = new ImageView("ee/ttu/java/cookie/images/cookie.png");
//        img.setPickOnBounds(true); // allows click on transparent areas
//        img.setOnMouseClicked((MouseEvent e) -> {
//            System.out.println("Clicked!"); // change functionality
//        });
//    }

//    close.setOnAction()

}

