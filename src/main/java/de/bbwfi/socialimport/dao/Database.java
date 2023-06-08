package de.bbwfi.socialimport.dao;

import de.bbwfi.socialimport.SocialImportApplication;
import de.bbwfi.socialimport.controller.DBController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


public class Database {
    private static final String location = SocialImportApplication.class.getResource("database.db").toExternalForm();
    private static final Logger logger = Logger.getLogger(Database.class.toString());

    private  boolean checkConnection() {
        try (Connection connection = this.connect()) {
            return true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Connection connect() throws SQLException {
        String url = "jdbc:sqlite:" + location;

        try (Connection connection = DriverManager.getConnection(url)) {
            return connection;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
