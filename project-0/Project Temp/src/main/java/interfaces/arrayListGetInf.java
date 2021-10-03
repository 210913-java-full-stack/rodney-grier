package interfaces;

import models.accMsg;

public interface arrayListGetInf {
    int getId();

    void setId(int id);

    void setE(Object e);

    int size();

    void add(Object o, int index);

    void remove(int index);

    void clear();

    void add(accMsg newItem);
}
