package DAOs;

import java.io.IOException;
import java.sql.SQLException;

public interface dataAccessObjIndx extends dataAccessObjTransf {
    void save(dataAccessObj row) throws SQLException;

    void addAccount(int to, Integer z, String ee, String l, String s, Double bal) throws SQLException, IOException;

    void deposits(int to, String fn, String ln, Double bal) throws SQLException, IOException;

    void updateAccount(int to, String fn, String ln, String em, String s) throws SQLException, IOException;

    void getValueIndx(int i);

    void setId(int customer_id);

    void sql(String address_id);

    int getId();


    String getMessage();

    boolean isComplete();
}


