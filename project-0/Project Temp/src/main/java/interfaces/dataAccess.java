package interfaces;
import models.getMessages;
import projExecptions.badUserInput;

import java.sql.SQLException;
import java.util.ArrayList;


public interface dataAccess {

    //we will need a Connection



    //create

    //save object to database method
    

    public void addAccount(String s, String e, Double bal) throws SQLException;

    public void save(getMessages row) throws SQLException;


    //read data from database method

    //query data from database, fill in empty model object
    public getMessages getItemByID(int id) throws SQLException;
    public void getMessages void pull(getMessages row);

    //public ArrayList<String> getAllItems(ArrayList x) throws SQLException;

    //public getMessages getItemByKeyword(String keyword); //SELECT * FROM items WHERE message LIKE "%KEYWORD%"

    //update
    // we will use the save() method for updates

    //delete

    //remove by ID
    public void deleteByID(int id) throws SQLException;




}
