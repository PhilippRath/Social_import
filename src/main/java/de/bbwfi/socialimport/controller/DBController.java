package de.bbwfi.socialimport.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBController {
    private static final Logger logger = Logger.getLogger(DBController.class.toString());
    private static DBController instance;
    private Connection connection = null;

    public static DBController getInstance() {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public void mkDBCOnnection() throws SQLException {
       String url = "jdbc:sqlite:./schulen.db";
       connection = DriverManager.getConnection(url);
    }

    public void closeDBConnection() throws SQLException {
       connection.close();
    }

    public void createSchoolTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS SCHOOLS (
                	id integer PRIMARY KEY,
                	bezeichnung text NOT NULL,
                	art text NOT NULL,
                	adresse text NOT NULL,
                	ort text NOT NULL,
                	plz text NOT NULL,
                	mail text NOT NULL,
                	web text NOT NULL
                );""";
        connection.createStatement().execute(sql);

    }

}
