module socialimport{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;

    opens de.bbwfi.socialimport to javafx.fxml;
    exports de.bbwfi.socialimport;
}