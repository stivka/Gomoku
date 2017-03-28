/**
 * Created by Stiv on 27/03/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

/**
 *
 */
public class Main extends Application {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane main = new BorderPane();
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);

        javafx.scene.control.Button button = new Button("Press here!");

        button.setOnAction(event -> {
            System.out.println("tere:" + ((Button)event.getSource()).getText());
        });


        main.setCenter(button);


    }
}
