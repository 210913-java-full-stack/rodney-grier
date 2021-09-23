package DAOs;

import models.toDOitems;

import java.sql.SQLException;
import java.util.List;

public interface toDOcrud {

    //we will need a Connection

    //create
    //save object to database method
    public void save(toDOitems row) throws SQLException;
    //read
    //query data from database, fill in empty model object
    public toDOitems getItemByID(int id) throws SQLException;
    public List<toDOitems> getAllItems() throws SQLException;
    //public ToDoItem getItemByKeyword(String keyword); //SELECT * FROM items WHERE message LIKE "%KEYWORD%"
    //update
    // we will use the save() method for updates
    //delete
    //remove by ID
    public void deleteByID(int id) throws SQLException;

}
