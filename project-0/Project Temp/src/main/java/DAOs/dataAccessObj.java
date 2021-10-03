package DAOs;


import models.accMsg;
import models.arrayList;
import projExecptions.badUserInput;
import utilities.ConnectionManager;
import utilities.PrintView;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class dataAccessObj implements dataAccessObjIndx {


    private Object String;

    public dataAccessObj(Connection conn) {
        this.conn = conn;
    }



    String sql = new String();
    private Connection conn;


    @Override
    public void save(dataAccessObj row) throws SQLException {
        String sql = "SELECT * FROM junction_ac;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, row.getId());

        ResultSet rs = pstmt.executeQuery();


        if(rs.next()) {
            //UPDATE - item already exists in table
            String updateStatement = "UPDATE junction_ac SET message = ?, complete = ? WHERE id = ?";
            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
            preparedUpdateStatement.setString(1, row.getMessage());
            preparedUpdateStatement.setString(2, row.getMessage());
            preparedUpdateStatement.setString(3, row.getMessage());

            preparedUpdateStatement.executeUpdate();

        } else {
            //INSERT - Item doesn't already exist in table
            String insertStatement = "INSERT INTO junction_ac (message, complete) VALUES (?, ? ,?)";
            PreparedStatement preparedInsertStatement = conn.prepareStatement(insertStatement);
            Object b = new Object();
            preparedInsertStatement.setObject(1, b);
            String a = "";
            preparedInsertStatement.setString(2, a);
            preparedInsertStatement.setString(3, row.getMessage());

            preparedInsertStatement.executeUpdate();

        }



    }

    //        pstmt
//        pstmt.setObject(2, fn);
//        pstmt.setObject(3, m);
//        pstmt.setObject(4, l);

    @Override
    public void addAccount(int to, Integer z, String ee, String l, String s, Double bal) throws SQLException, IOException {

        sql = "INSERT INTO accounts (account_num, account_id, balance) VALUES (?,?,?)";
        PreparedStatement pstmt =conn.prepareStatement(sql);
        pstmt.setString(1, z+ee+l);
        pstmt.setString(2, ee+s);
        pstmt.setDouble(3, bal);
        pstmt.executeQuery(sql);
        pstmt.closeOnCompletion();

    }

    @Override
    public void addAccount(int to, Integer ci, String ee, Double bal) throws SQLException, IOException {

    }

    @Override
    public void trnsfrWthd(int to, String fn, String ln, String em, String em2, Double bal) throws SQLException, IOException {

        sql = "update accounts a join junction_ac j on a.account_id = j.account_id join customers c on c.customer_id = j.customer_id set balance = (balance - ?) WHERE c.firstname = ? and c.lastname = ? and a.account_id = ?;";

        PreparedStatement pstmt =conn.prepareStatement(sql);
        pstmt.setDouble(1, bal);
        pstmt.setString(2, fn);
        pstmt.setString(3, ln);
        pstmt.setString(4, em);
        pstmt.executeQuery(sql);


        sql = "update accounts a join junction_ac j on a.account_id = j.account_id join customers c on c.customer_id = j.customer_id set balance = (balance + ?) WHERE c.firstname = ? and c.lastname = ? and a.account_id = ?;";
        pstmt =conn.prepareStatement(sql);
        pstmt.setDouble(1, bal);
        pstmt.setString(2, fn);
        pstmt.setString(3, ln);
        pstmt.setString(4, em2);
        pstmt.executeQuery(sql);
        pstmt.closeOnCompletion();

    }





    @Override
    public void addAccount(int to, String fn, String ln, Double bal) throws SQLException, IOException {

    }

    @Override
    public void addAccount(int to, String fn, String ln, String em, Double bal) throws SQLException, IOException {

    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public void saveCustomer(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException {


        Connection conn = ConnectionManager.getConnection();

        String sql = "SELECT * FROM junction_ac";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()) {
//            //UPDATE - item already exists in table
//            String updateStatement = "UPDATE junction_ac SET message = ?, complete = ? WHERE id = ?";
//            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
//            preparedUpdateStatement.setString(1, ee);
//            preparedUpdateStatement.setString(2, fn);
//            preparedUpdateStatement.setString(3, l);
//
//            preparedUpdateStatement.executeUpdate();

        } else {
//            //INSERT - Item doesn't already exist in table
//            String insertStatement = "INSERT INTO junction_ac (message, complete) VALUES (?, ? ,?)";
//            PreparedStatement preparedInsertStatement = conn.prepareStatement(insertStatement);
//            preparedInsertStatement.setObject(1, ee);
//            preparedInsertStatement.setString(2, fn);
//            preparedInsertStatement.setString(3, l);
//
//            preparedInsertStatement.executeUpdate();

        }
        List<dataAccessObj> resultList = new ArrayList<>();
        while(rs.next()) {
            dataAccessObj temp = new dataAccessObj(conn);
            System.out.println("======ACCOUNTS ID=================");//Prints GUI
            temp.setName(rs.getString("customer_id"));
            PrintView.printMyView(temp.getMessage());
            temp.setName(rs.getString("account_id"));
            System.out.println("======ACCOUNTS NUMBER=================");//Prints GUI
            System.out.println(temp.getMessage());
            temp.setName(rs.getString("address_id"));
            System.out.println("=========BALANCE=================");//Prints GUI
            System.out.println(temp.getMessage());
            resultList.add(temp);





        }
//
//        for (dataAccessObjTransf tm : resultList) {
//            System.out.println(tm);
//        }


    }
//
//    private void sql(String string) {
//
//    }
//
    private void setName(String name) {
//    }
//




//            String username = ee+s;
//            String accountNum = z+ee+l;
//
//            String sql = new String();
//
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        sql = "INSERT INTO customers (customer_id, firstname, middlename, lastname)";
//        pstmt =conn.prepareStatement(sql);
//        pstmt.setObject(1, ee);
//        pstmt.setObject(2, fn);
//        pstmt.setObject(3, m);
//        pstmt.setObject(4, l);
//
//        sql = "INSERT INTO accounts (account_num, account_id, balance)";
//        pstmt =conn.prepareStatement(sql);
//        pstmt.setObject(1, accountNum);
//        pstmt.setObject(2, ee);
//        pstmt.setObject(3, String.valueOf(b));
//
//        pstmt.executeQuery(sql);
//
//
//        sql = "INSERT junction_ac (email, password, address_id, customer_id, account_id)";
//        pstmt =conn.prepareStatement(sql);
//        pstmt.setObject(1, ee);
//        pstmt.setObject(2, p);
//        pstmt.setObject(3, ee);
//        pstmt.setObject(4, ee);
//        pstmt.setObject(5, ee);
//        pstmt.executeQuery(sql);
//
//
//        pstmt.closeOnCompletion();
//






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

    @Override
    public void getMessage(arrayList<dataAccessObj, java.lang.String> tempBalance) {

    }

    @Override
    public void getItemByID(java.lang.String customer_id) {

    }

    @Override

        public void getValueIndx(int i) {


        int i1 = 0;
    }

    @Override
    public void setId(int customer_id) {

    }

    @Override
    public void sql(String address_id) {

    }

    @Override
    public int getId() {
        return 0;
    }


    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}









