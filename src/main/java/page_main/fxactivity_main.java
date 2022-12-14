package page_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class fxactivity_main extends Application {

        public void start(Stage stage) throws IOException {





            FXMLLoader fxmlLoader = new FXMLLoader(fxactivity_main.class.getResource("view_main.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1000);
            stage.setTitle("Story Keepers Library");
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
