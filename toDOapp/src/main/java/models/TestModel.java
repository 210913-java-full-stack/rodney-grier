package models;

public class TestModel {

    private int id;
    private double balance;
    private String name; //or other field
    private String string; //or other field

    public TestModel() {
    }

    public TestModel(int id, String name, String string, double balance) {
        this.id = id;
        this.name = name;
        this.string = string;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.string;
    }

}
