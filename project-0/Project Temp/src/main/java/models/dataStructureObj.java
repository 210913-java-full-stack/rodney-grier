package models;

import interfaces.dataStructure;
import interfaces.dataTrans;

import java.sql.SQLException;

public class dataStructureObj implements dataStructure {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void add() {

    }

    @Override
    public void add(Object o, int index) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int contains(Object o) {
        return 0;
    }

    @Override
    public void save(dataTrans row) throws SQLException {

    }

    @Override
    public int getId() {
        return 0;
    }
}

