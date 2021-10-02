package DAOs;


import interfaces.dataAccessObjTrs;
import models.accMsg;
import projExecptions.badUserInput;

import java.io.IOException;
import java.sql.*;


public class dataAccessObj implements dataAccessObjTrs {




    public dataAccessObj(Connection conn) {
        this.conn = conn;
    }

    private String st;
    private int ci;
    String sql = new String();
    String s = new String();
    String em = new String();
    Integer zi;
    String ad;
    String c;
    String fn;
    String mn;
    String ln;
    String pword;
    String vPword;
    String username;
    private int i;
    private java.lang.Double xx;
    private double bal;
    private Connection conn;

    @Override
    public void addAccount(int to, String fn, String ln, Double bal) throws SQLException, IOException {

    }

    @Override
    public void addAccount(int to, String fn, String ln, String em, Double bal) throws SQLException, IOException {

    }

    @Override
    public void saveCustomer(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput {

    }

    @Override
    public void addAccount(String s, String e, Double bal) throws SQLException, IOException {

    }

    @Override
    public accMsg getItemByID(int id) throws SQLException {
        return null;
    }

    @Override
    public void getItemByKeyword(String keyword) {

    }

}









