package de.bbwfi.socialimport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SocialImportApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL fxml = this.getClass().getResource("social-import.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader(fxml);
        Scene scene = new Scene(fxmlLoader.load(), 400, 351);
        String css = this.getClass().getResource("style.css").toExternalForm().toString();
        scene.getStylesheets().add(css);
        stage.setTitle("Hello FIs!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }
}
