package models;

public class toDOitems {

    private int id;
    private String message;
    private boolean complete;

    public toDOitems() {
        complete = false;
    }

    public toDOitems(String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }

    public toDOitems(int id, String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
