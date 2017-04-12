/**
 * Created by Stiv on 10/04/2017.
 */

package ee.ttu.java.cookie;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *  Main class
 */
public class Main extends Application {
    /**
     * Sets the stage.
     */
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
        getParameters();

    }

    /**
     *
     * @param args dunno
     */
    public static void main(String[] args) {
        launch(args);
    }
}