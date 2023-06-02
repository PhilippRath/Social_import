package de.bbwfi.socialimport;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SocialimportController {

    Gson gson;
    String schoolsJSONUrl = "https://services6.arcgis.com/jiszdsDupTUO3fSM/arcgis/rest/services/Schulen_OpenData/FeatureServer/0/query?outFields=*&where=1%3D1&f=geojson";

    public void initialize(){
        gson = new Gson();
    }

    public void buttonPress(ActionEvent actionEvent) {
        Button myButton = (Button) actionEvent.getSource();
        System.out.println(myButton.getId());
        System.out.println(((Button) actionEvent.getSource()).getId());
    }

    public void importHandler(ActionEvent actionEvent) {
        System.out.println("importHandler");
        SchoolGeo schoolgeo = parseJSON(fetchJSON(schoolsJSONUrl));
        ArrayList<Schule> schulen = extractSchulen(schoolgeo);

    }

    public String fetchJSON(String url){
        try {
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
            HttpResponse<String> httpResponse =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(httpResponse.statusCode());
         // System.out.println(httpResponse.body());
            return httpResponse.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public SchoolGeo parseJSON(String json){

//        Type schoolListType = new TypeToken<ArrayList<SchoolGeo>>(){}.getType();
        return gson.fromJson(json, SchoolGeo.class);
    }

    public ArrayList<Schule> extractSchulen(SchoolGeo schoolgeo){
        ArrayList<Schule> schulen = new ArrayList<>();
        for ( SchoolGeo.Features feature : schoolgeo.getFeatures()) {
            schulen.add(feature.getSchool());
        }
        return schulen;
    }

}
