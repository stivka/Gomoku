/**
 * Created by Stiv on 10/04/2017.
 */

package ee.ttu.java.cookie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  Main class.
 */

// uus objekt luua controlleris.
    // @FXML public void initialize.

public class Main extends Application {
      /**
     * Laius on 600.
     */
    private static final int WIDTH = 600;
    /**
     * Heigth of the window is 400.
     */
    private static final int HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
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
