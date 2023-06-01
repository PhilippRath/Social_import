package de.bbwfi.socialimport;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SocialimportController {

    public void buttonPress(ActionEvent actionEvent) {
        Button myButton = (Button) actionEvent.getSource();
        System.out.println(myButton.getId());
        System.out.println(((Button) actionEvent.getSource()).getId());
    }
}
