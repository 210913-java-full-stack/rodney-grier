package interfaces;



//custom list interface to implement list data structure
public interface myArrayInterface <E> {

    int size(); //size of the array
    void add();//add one item - add(E e)
    void add(E e, int index);//add one item in a specific index - add(E e), int index)
    public E get(int index);//get by index - get(int index)
    void remove(int index);//delete by index - remove(int index)
    void clear();//clears array - clear()
    int contains(E e);//contains(E e)
}
