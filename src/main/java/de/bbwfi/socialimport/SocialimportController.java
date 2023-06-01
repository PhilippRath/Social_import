package de.bbwfi.socialimport;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SocialimportController {

    Gson gson;

    public void initialize(){
        gson = new Gson();
    };


    public void buttonPress(ActionEvent actionEvent) {
        Button myButton = (Button) actionEvent.getSource();
        System.out.println(myButton.getId());
        System.out.println(((Button) actionEvent.getSource()).getId());
    }


    public void importHandler(ActionEvent actionEvent) {
        System.out.println("importHandler");
        URL url;
        try {
            url = new URL("https://services6.arcgis.com/jiszdsDupTUO3fSM/arcgis/rest/services/Schulen_OpenData/FeatureServer/0/query?outFields=*&where=1%3D1&f=geojson");
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url.toString())).GET().build();
            HttpResponse<String> httpResponse =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.body());

        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
