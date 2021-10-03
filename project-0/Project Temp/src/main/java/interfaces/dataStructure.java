package interfaces;

import java.sql.SQLException;

/**
 * Custom list interface we will use to implement our own list data structure
 */
public interface dataStructure<E> {
    int size();




    void add(E e);

    void add();

    void add(E e, int index);

    E get(int index);

    void remove(int index);

    void clear();

    int contains(E e);

    public void save(dataTrans row) throws SQLException;

    public int getId();

}


