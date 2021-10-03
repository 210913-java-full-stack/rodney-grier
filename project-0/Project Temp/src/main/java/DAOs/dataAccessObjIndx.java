package DAOs;

import java.io.IOException;
import java.sql.SQLException;

public interface dataAccessObjIndx extends dataAccessObjTransf {
    void save(dataAccessObj row) throws SQLException;

    void addAccount(int to, Integer z, String ee, String l, String s, Double bal) throws SQLException, IOException;

    void getValueIndx(int i);

    void setId(int customer_id);

    void sql(String address_id);

    int getId();


    String getMessage();

    boolean isComplete();
}


