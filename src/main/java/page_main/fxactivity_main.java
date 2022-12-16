package page_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class fxactivity_main extends Application {

        public void start(Stage stage) throws IOException {
            backgroundMusic();
            Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view_main.fxml")));
            stage.setTitle("Story Keepers Library");
            stage.setScene(new Scene(root, 1920, 1000));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setMaximized(true);
            stage.show();
    }

    MediaPlayer mediaPlayer;
        public void backgroundMusic(){
            String s = "src/main/java/page_main/backgroundMusic.mp3";
            Media h = new Media(Paths.get(s).toUri().toString());
            mediaPlayer = new MediaPlayer(h);
            mediaPlayer.setVolume(0.015);
            mediaPlayer.play();
        }

    public static void main(String[] args) {
        launch(args);
    }
}
