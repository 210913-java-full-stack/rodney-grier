package interfaces;

import models.accMsg;

import java.io.IOException;
import java.sql.SQLException;

public abstract interface mainDataAccInf<bal, em> extends dataAccess, dataAccessIn, dataAccessFi, dataAccessAd, dataAccessTr {
    double getTbal(Double bal);

    void setBal(double bal);


    @Override
    void save(accMsg row) throws SQLException;

    void addTranf() throws SQLException;

    int getI(Integer acId);

   ;

    <ln> void addAccount(int to, String fn, String ln, Double bal) throws SQLException, IOException;

    <ln, email> void addAccount(int to, String fn, String ln, String em, Double bal) throws SQLException, IOException;


    void addAccount(String s, String e, Double bal) throws SQLException, IOException;

    default double toBal(Double bal) {
        return 0;
    }


    Double getItemByKeyword(String keyword);


    void deleteByID(int id) throws SQLException;


    String toString();
}
