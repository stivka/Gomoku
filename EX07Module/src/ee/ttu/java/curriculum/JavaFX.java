package ee.ttu.java.curriculum;
/**
 * Created by Stiv on 27/03/2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 */
public class JavaFX extends Application {
    /**
     *
     * @param args INPUT
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setScene(scene);

        Text sceneTitle = new Text("Optional Subject");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label subjectNameOptional = new Label("subject name:");
        gridPane.add(subjectNameOptional, 0, 1);

        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);

        Label subjectCodeOptional = new Label("code:");
        gridPane.add(subjectCodeOptional, 2, 1);

        TextField subjectCodeOptionalTF = new TextField();
        gridPane.add(subjectCodeOptionalTF,3, 1);

        Label eAP = new Label("EAP:");
        gridPane.add(eAP, 4, 1);

        TextField subjectModuleOptional = new TextField();
        gridPane.add(subjectModuleOptional, 5, 1);

        Button add = new Button("Add");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(add);
        gridPane.add(hbBtn, 6, 1);

//        add.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent e) {
////                subjectNameOptional.getText()
//            }
//        });

        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 6);

//        gridPane.setGridLinesVisible(true);

        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");
            }
        });

        primaryStage.show();

    }
}
