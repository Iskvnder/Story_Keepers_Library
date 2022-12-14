package page_books;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import page_main.fxactivity_main;

import java.io.IOException;
import java.util.Objects;

public class fxactivity_books extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view_books.fxml")));
        stage.setTitle("Story Keepers Library");
        stage.setScene(new Scene(root, 1920, 1000));
        stage.setResizable(true);
        stage.show();
    }
}
