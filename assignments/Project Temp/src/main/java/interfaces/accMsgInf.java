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

    @Override
    int size();

    @Override
    boolean isEmpty();

    @Override
    boolean contains(Object o);

    @Override
    Iterator iterator();

    @Override
    Object[] toArray();

    @Override
    boolean add(Object o);

    @Override
    boolean remove(Object o);

    @Override
    boolean addAll(Collection c);

    @Override
    boolean addAll(int index, Collection c);

    @Override
    void clear();

    @Override
    Object get(int index);

    @Override
    Object set(int index, Object element);

    @Override
    void add(int index, Object element);

    @Override
    Object remove(int index);

    @Override
    int indexOf(Object o);

    @Override
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
