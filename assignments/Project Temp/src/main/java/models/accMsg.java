package models;


import java.sql.SQLException;




public class accMsg implements accMsgInf {

    private int id;
    private String message;
    private Double balance;
    private boolean complete;


    @Override
    public void setMessage(String message) {

    }

    @Override
    public accMsg getItemByID(int id) throws SQLException {
        return null;
    }


    @Override
    public double getBal() {
        return bal;
    }

    @Override
    public void setBal(double bal) {
        this.bal = bal;
    }

    public accMsg(double bal) {
        this.bal = bal;
    }

    private double bal;

    public accMsg(String id, String name) {
        complete = false;
    }


    public accMsg(String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }

    public accMsg(int id, String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }

    public accMsg() {

    }
    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public void setComplete(boolean complete) {
        this.complete = complete;
    } //This adds the x for complete

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }



    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public void saveCustomer(String fn, String mn, String ln, String ad, String ci, String st, String em, String pword, Integer valueOf, Double valueOf1) {
    }
}

