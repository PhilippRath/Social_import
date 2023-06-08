package de.bbwfi.socialimport;

import java.sql.*;

public class DB {
    String url = "jdbc:sqlite:./add.db";
    Connection connection = null;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createSchoolTable (){
        String sql = """
                CREATE TABLE IF NOT EXISTS schools (
                	id integer PRIMARY KEY,
                	bezeichnung text NOT NULL,
                	art text NOT NULL,
                	adresse text NOT NULL,
                	ort text NOT NULL,
                	plz text NOT NULL
                );""";

        try {
            Statement statement = connection.createStatement();
            System.out.println( statement.execute(sql) );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSchool(School school) {
        String sql = "INSERT INTO schools(id, bezeichnung,art,adresse,ort,plz) VALUES(?, ?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, school.getId());
            preparedStatement.setString(2, school.getBezeichnung());
            preparedStatement.setString(3, school.getArt());
            preparedStatement.setString(4, school.getStrasse());
            preparedStatement.setString(5, school.getOrt());
            preparedStatement.setString(6, school.getPlz());
            System.out.println( preparedStatement );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

