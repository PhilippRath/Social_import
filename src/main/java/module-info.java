module socialimport{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires java.logging;


    opens de.bbwfi.socialimport to javafx.fxml;
    exports de.bbwfi.socialimport;
    exports de.bbwfi.socialimport.model;
    opens de.bbwfi.socialimport.model to javafx.fxml;
    exports de.bbwfi.socialimport.controller;
    opens de.bbwfi.socialimport.controller to javafx.fxml;
}