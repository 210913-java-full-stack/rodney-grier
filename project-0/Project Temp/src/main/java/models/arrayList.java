package models;

import interfaces.myArrayInterface;

public class arrayList<E> implements myArrayInterface<E> {

    private int size;

    public arrayList(int i) {
        size = i;

    }

    public arrayList() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add() {

    }

    @Override
    public void add(E e, int index) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int contains(E e) {
        return 0;
    }

        Object e = new Object[2];

        public E[] getArray(){

        return (E[]) e;
        }


}
