package DAOs;

import interfaces.dataAccessObjTrs;
import models.accMsg;
import models.arrayList;
import projExecptions.badUserInput;

import java.io.IOException;
import java.sql.SQLException;

public interface dataAccessObjTransf extends dataAccessObjTrs {
    void addAccount(int to, Integer ci, String ee, Double bal) throws SQLException, IOException;

    void trnsfrWthd(int to, String fn, String ln, String em, String em2, Double bal) throws SQLException, IOException;

    @Override
    void saveCustomer(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException;

    @Override
    void addAccount(String s, String e, Double bal) throws SQLException, IOException;

    @Override
    accMsg getItemByID(int id) throws SQLException;

    @Override
    void getItemByKeyword(String keyword);

    void getMessage(arrayList<dataAccessObj, String> tempBalance);

    void getItemByID(String customer_id);

}
