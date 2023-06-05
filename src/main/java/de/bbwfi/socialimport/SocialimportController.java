package de.bbwfi.socialimport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.google.gson.Gson;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SocialimportController {

    Gson gson;
    String schoolsJSONUrl = "https://services6.arcgis.com/jiszdsDupTUO3fSM/arcgis/rest/services/Schulen_OpenData/FeatureServer/0/query?outFields=*&where=1%3D1&f=geojson";
    ObservableList<School> schoolObservableList;
    @FXML
    TableView<School> schoolTableView;
    @FXML
    TableColumn<School, Integer> idTableColumn;
    @FXML
    TableColumn<School, String> bezeichnungTableColumn;
    @FXML
    TableColumn<School, String> artTableColumn;
    @FXML
    TableColumn<School, String> plzTableColumn;
    @FXML
    TableColumn<School, String> strasseTableColumn;

    public void initialize(){
        gson = new Gson();

        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        bezeichnungTableColumn.setCellValueFactory(new PropertyValueFactory<>("bezeichnung"));
        artTableColumn.setCellValueFactory(new PropertyValueFactory<>("art"));
        plzTableColumn.setCellValueFactory(new PropertyValueFactory<>("plz"));
        strasseTableColumn.setCellValueFactory(new PropertyValueFactory<>("strasse"));

    }

    public void buttonPress(ActionEvent actionEvent) {
        Button myButton = (Button) actionEvent.getSource();
        System.out.println(myButton.getId());
        System.out.println(((Button) actionEvent.getSource()).getId());
    }

    public void importHandler(ActionEvent actionEvent) {
        System.out.println("importHandler");
        SchoolGeo schoolgeo = parseJSON(fetchJSON(schoolsJSONUrl));
        ArrayList<School> schools = extractSchulen(schoolgeo);
        schoolObservableList = FXCollections.observableArrayList(schools);
        schoolTableView.setItems(schoolObservableList);
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

    public ArrayList<School> extractSchulen(SchoolGeo schoolgeo){
        ArrayList<School> schulen = new ArrayList<>();

        int count = 90000;

        for ( SchoolGeo.Features feature : schoolgeo.getFeatures()) {
            if (feature.getSchool().id == 0) {
                feature.school.setId(count++);
            }
            schulen.add(feature.getSchool());
        }
        return schulen;
    }

}
