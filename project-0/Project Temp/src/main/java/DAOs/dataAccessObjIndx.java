package DAOs;

import projExecptions.badUserInput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface dataAccessObjIndx<i> extends dataAccessObjTransf {
    void trnsfrWthd(String ee, String s, Double bal) throws SQLException, IOException;

    void trnsfrWthd(String l, String fn, String ee, String s, Double bal) throws SQLException, IOException;

    List<dataAccessObj> save(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException;

    List<dataAccessObj> savePr(String fn, String m, String l, String ad, String c, String s, String ee, Integer z) throws SQLException, badUserInput, IOException;

    void savePr(Integer choice, String fn, String m, String l, String ad, String c, String s, String ee, Integer z) throws SQLException, badUserInput, IOException;

    List<dataAccessObj> savePrint(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException;

    List<dataAccessObj> savePrintS(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException;

    void addAccount(String s, String e, String l, Integer z, Double b) throws SQLException, IOException;

    void addAccount(String f, String ln, String n, String e, Double b) throws SQLException, IOException;

    void addNewaccount(String f, String ln, Integer z, String e, Double b) throws SQLException, IOException;

    void addNewaccount(String f, String ln, Integer z, String e, String s, Double b) throws SQLException, IOException;

    void save(dataAccessObj row) throws SQLException;


    void save() throws SQLException;

    void save(String ee, String s) throws SQLException;

    void save(String e, String ln, Integer z) throws SQLException;

    void addAccount(int to, Integer z, String ee, String l, String s, Double bal) throws SQLException, IOException;

    void deposits(int to, String fn, String ln, Double bal) throws SQLException, IOException;

    void deposits(int to, String ee, Integer z, Double bal) throws SQLException, IOException;

    void deposits(int to, String ee, String l, Integer z, Double bal) throws SQLException, IOException;

    void deposits(String s, String ee, String l, Integer z, Double bal) throws SQLException, IOException;

    void deposits(int to, Double bal) throws SQLException, IOException;

    void updateAccount(int to, String fn, String ln, String em, String s) throws SQLException, IOException;

    void getValueIndx(int i);

    void setId(int customer_id);

    void sql(String address_id);

    int getId();


    String getMessage();

    boolean isComplete();
}


