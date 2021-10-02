package interfaces;

import models.accMsg;
import projExecptions.badUserInput;

import java.io.IOException;
import java.sql.SQLException;

public interface dataAccessObjTrs {
    void addAccount(int to, String fn, String ln, Double bal) throws SQLException, IOException;

    void addAccount(int to, String fn, String ln, String em, Double bal) throws SQLException, IOException;

    void saveCustomer(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput;

    void addAccount(String s, String e, Double bal) throws SQLException, IOException;

    accMsg getItemByID(int id) throws SQLException;

    void getItemByKeyword(String keyword);
}
