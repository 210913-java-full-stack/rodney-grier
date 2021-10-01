package models;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class getMessages implements List {

    private int id;

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    String messages;


    public getMessages(int id, Integer i) {
        this.id = id;
        this.i = i;
    }

    private String message;
    private boolean complete;
    private Integer i;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    private String name;
    private String string;


    public getMessages(String id, String name) {
        complete = false;
    }


    public getMessages(String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }

    public getMessages(int id, String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }

    public getMessages() {

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
    } //This adds the x for complete


    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }


    public Iterator iterator() {
        return null;
    }


    public Object[] toArray() {
        return new Object[0];
    }


    public boolean add(Object o) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }


    public boolean addAll(Collection c) {
        return false;
    }


    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void clear() {

    }


    public Object get(int index) {
        return null;
    }


    public Object set(int index, Object element) {
        return null;
    }


    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        return null;
    }


    public int indexOf(Object o) {
        return 0;
    }


    public int lastIndexOf(Object o) {
        return 0;
    }


    public ListIterator listIterator() {
        return null;
    }


    public ListIterator listIterator(int index) {
        return null;
    }


    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }


    public boolean removeAll(Collection c) {
        return false;
    }


    public boolean containsAll(Collection c) {
        return false;
    }


    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public void getStrings() {
    }

    public void getStrings(int id, String name, String string) {
        this.id = id;
        this.name = name;
        this.string = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
