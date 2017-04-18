package ee.ttu.java.heatmapper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Stiv on 17/04/2017.
 */
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
        Parent root = FXMLLoader.load(getClass().getResource("fxml.fxml"));
        primaryStage.setTitle("Heatmapper");
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

