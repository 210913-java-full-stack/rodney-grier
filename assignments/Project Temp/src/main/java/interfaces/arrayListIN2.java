package interfaces;



public interface arrayListIN2<E, message> extends myArrayListin<E, message> {




    int getId();


    void setId(int id);

    Object getE();


    int size();



    E get(int index);

    void add(E e, int index);

    void remove(int index);

    void clear();

    int contains(E e);


    void add(E s);




    E[] getArray();
}
