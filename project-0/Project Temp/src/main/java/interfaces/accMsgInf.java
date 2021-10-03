package interfaces;

import models.accMsg;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface accMsgInf extends List {
    static void getItemByKeyword(String s) {
        s = "return";

    }

    accMsg getItemByID(int id) throws SQLException;

    List<accMsg> getAllItems() throws SQLException;

    double getBal();

    void setBal(double bal);

    double getBalance();

    void setBalance(double balance);

    int getId();

    void setId(int id);

    String getMessage();

    void setMessage(String message);

    boolean isComplete();

    void setComplete(boolean complete) //This adds the x for complete
    ;


    int size();


    boolean isEmpty();


    boolean contains(Object o);


    Iterator iterator();


    Object[] toArray();

    boolean add(Object o);


    boolean remove(Object o);

    boolean addAll(Collection c);


    boolean addAll(int index, Collection c);


    void clear();


    Object get(int index);


    Object set(int index, Object element);


    void add(int index, Object element);


    Object remove(int index);


    int indexOf(Object o);


    int lastIndexOf(Object o);

    @Override
    ListIterator listIterator();

    @Override
    ListIterator listIterator(int index);

    @Override
    List subList(int fromIndex, int toIndex);

    @Override
    boolean retainAll(Collection c);

    @Override
    boolean removeAll(Collection c);

    @Override
    boolean containsAll(Collection c);

    @Override
    Object[] toArray(Object[] a);

    void saveCustomer(String fn, String mn, String ln, String ad, String ci, String st, String em, String pword, Integer valueOf, Double valueOf1);
}
