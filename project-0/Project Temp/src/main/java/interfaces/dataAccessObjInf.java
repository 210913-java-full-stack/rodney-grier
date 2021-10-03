package interfaces;

import models.accMsg;

import java.sql.SQLException;
import java.util.List;

public interface dataAccessObjInf {
    List<accMsg> getAllItems();

    void addTranf() throws SQLException;

    int getI(Integer acId);
}
