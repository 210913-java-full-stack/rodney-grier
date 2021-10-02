package models;


import interfaces.arrayListGetInf;

public class arrayList<E, message> implements arrayListGetInf {

    private int size;
    String message;
    String messageb;
    private int id;

    public int getId(int i) {
        return id;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setE(Object e) {

    }

    public arrayList(int size, String message, String messageb, Double bal) {
        this.size = size;
        this.message = message;
        this.messageb = messageb;
        this.bal = bal;
    }

    Double bal;

    public arrayList() {

    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void add(Object o, int index) {

    }

    @Override
    public void remove(int index) {

    }




    @Override
    public void clear() {

    }

    @Override
    public void add(accMsg newItem) {

    }


    public void add(String newItem) {

    }



}
