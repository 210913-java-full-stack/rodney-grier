package interfaces;

import DAOs.dataAccessObj;
import interfaces.myArrayInterface;
import models.accMsg;


public interface myArrayListin<E, message> extends myArrayInterface<E> {

    int getId();

    void setId(int id);



    void setE(Object e);

    int size();









    void remove(int index);


    void clear();


    int contains(E e);


    void add(E s);


    E[] getArray();

    void add(accMsg newItem);
}
