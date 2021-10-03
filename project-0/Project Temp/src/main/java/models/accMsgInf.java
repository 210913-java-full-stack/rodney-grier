package models;

import java.sql.SQLException;

public interface accMsgInf {
    static void getItemByKeyword(String account_id) {
    }

    void setMessage(String message);

    accMsg getItemByID(int id) throws SQLException;

 

    double getBal();

    void setBal(double bal);

    double getBalance();

    void setBalance(double balance);

    int getId();

    void setId(int id);

    String getMessage();

    boolean isComplete();

    void setComplete(boolean complete) //This adds the x for complete
    ;

    int size();

    boolean isEmpty();

    boolean contains(Object o);

   

    Object[] toArray();

    boolean add(Object o);

    boolean remove(Object o);

   

    void clear();

    Object get(int index);

    Object set(int index, Object element);

    void add(int index, Object element);

    Object remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);


    Object[] toArray(Object[] a);

    void saveCustomer(String fn, String mn, String ln, String ad, String ci, String st, String em, String pword, Integer valueOf, Double valueOf1);
}
