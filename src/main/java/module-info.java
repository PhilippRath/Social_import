module socialimport{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens de.bbwfi.socialimport to javafx.fxml;
    exports de.bbwfi.socialimport;
}