package interfaces;
import DAOs.dataAccessObj;
import models.accMsg;
import projExecptions.badUserInput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public interface dataAccess {

    //we will need a Connection



    //create

    //save object to database method


    ArrayList<dataAccessObj> saveCustomer(String fn, String m, String l, String ad, String c, String s, String e, String p, Integer z, Double b) throws SQLException, badUserInput;

    void addAccount(String s, String e, Double bal) throws SQLException, IOException;

    //read data from database method

    Double getItemByKeyword(String keyword); //SELECT * FROM items WHERE message LIKE "%KEYWORD%"

    //update
    // we will use the save() method for updates

    //delete

    //remove by ID
    void deleteByID(int id) throws SQLException;


    void save(accMsg row) throws SQLException;


}
