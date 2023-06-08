package de.bbwfi.socialimport.dao;

import de.bbwfi.socialimport.model.School;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SchoolDAO implements DAO<School> {

    private List<School> schools = new ArrayList<>();
    @Override
    public Optional<School> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<School> getAll() {
        return null;
    }

    @Override
    public void save(School school) {

    }

    @Override
    public void update(School school, String[] params) {

    }

    @Override
    public void delete(School school) {

    }
}
