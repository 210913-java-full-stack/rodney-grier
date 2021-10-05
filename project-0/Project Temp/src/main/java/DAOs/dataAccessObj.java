package DAOs;



import models.accMsg;
import models.arrayList;
import projExecptions.badUserInput;
import utilities.ConnectionManager;
import utilities.PrintView;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class dataAccessObj implements dataAccessObjIndx {


    private Object String;
    private ResultSet rs;

    public dataAccessObj(Connection conn) {
        this.conn = conn;
    }


    String sql = new String();
    private Connection conn;


    public <i> void savenew(dataAccessObj row) throws SQLException {
        String sql = "SELECT * FROM  customers;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, row.getId());

        ResultSet rs = pstmt.executeQuery();


        if (rs.next()) {
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
    ///updates view menu


    @Override
    public void addAccount(int to, Integer ci, java.lang.String ee, Double bal) throws SQLException, IOException {

    }

    @Override
    public void trnsfrWthd(int to, java.lang.String fn, java.lang.String ln, java.lang.String em, java.lang.String em2, Double bal) throws SQLException, IOException {

    }

    @Override
    public void addAccount(int to, java.lang.String fn, java.lang.String ln, Double bal) throws SQLException, IOException {

    }

    @Override
    public void addAccount(int to, java.lang.String fn, java.lang.String ln, java.lang.String em, Double bal) throws SQLException, IOException {

    }

    @Override
    public List<dataAccessObj> save(java.lang.String fn, java.lang.String m, java.lang.String l, java.lang.String ad, java.lang.String c, java.lang.String s, java.lang.String ee, java.lang.String p, Integer z, Double b) throws SQLException, badUserInput, IOException {
        return null;
    }

    @Override
    public List<dataAccessObj> savePrint(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException {


        Connection conn = ConnectionManager.getConnection();

       // String sql = "INSERT INTO customers (customer_id, firstname, middlename, lastname) VALUES ( ? , ? , ? , ?)";
//        String sql = "SELECT * FROM accounts WHERE account_id = ? ";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.getResultSet();
//        PreparedStatement insertStatement = conn.prepareStatement(sql);
//        insertStatement.setString(1, ee+s);



        //This was for testing, but is no longer needed? Results still used below.
       sql = "SELECT * FROM accounts WHERE account_id = ?";

       PreparedStatement queryStatement = conn.prepareStatement(sql);
        queryStatement.setString(1, ee+s);
       queryStatement.getResultSet();

       ResultSet rs = queryStatement.executeQuery();
//        insertStatement.executeUpdate();

//        if (rs.next()) {
            //Insert
            // UPDATE - item already exists in table
//            String updateStatement = "INSERT INTO address (address_id, address, city, state, zip) VALUES ( ? , ? , ? , ?, ?)";
//            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
//            preparedUpdateStatement.setString(1, ee+s);
//            preparedUpdateStatement.setString(2, ad);
//            preparedUpdateStatement.setString(3, c);
//            preparedUpdateStatement.setString(4, s);
//            preparedUpdateStatement.setString(5, java.lang.String.valueOf(z));
//            preparedUpdateStatement.executeUpdate();
//
//            updateStatement = "INSERT INTO accounts (account_id, account_num, balance) VALUES ( ? , ? , ? )";
//            preparedUpdateStatement = conn.prepareStatement(updateStatement);
//            preparedUpdateStatement.setString(1, ee+s);
//            preparedUpdateStatement.setString(2, z+ee+l);
//            preparedUpdateStatement.setString(3, java.lang.String.valueOf(b));
//
//            preparedUpdateStatement.executeUpdate();
//
//            updateStatement = "INSERT INTO junction_ac (email, password, address_id, customer_id, account_id) VALUES ( ? , ? , ? , ?, ?)";
//            preparedUpdateStatement = conn.prepareStatement(updateStatement);
//            preparedUpdateStatement.setString(1, ee);
//            preparedUpdateStatement.setString(2, p);
//            preparedUpdateStatement.setString(3, ee+s);
//            preparedUpdateStatement.setString(4, ee+s);
//            preparedUpdateStatement.setString(5, ee+s);
//            preparedUpdateStatement.executeUpdate();

/*

            System.out.println("COMPLETE!");*/

//
//        } else {
//
//
//            System.out.println("UNABLE TO LOAD DATA. CHECK THE INPUT AND TRY AGAIN");
//
//
//
//
//
//
//        }
        List<dataAccessObj> resultList = new ArrayList<>();

        while (rs.next()) {
            dataAccessObj temp = new dataAccessObj(conn);
            System.out.println("======ACCOUNTS ID=====================");//Prints GUI
            temp.setName(rs.getString(1));
            PrintView.printMyView(rs.getString("account_id"));
            System.out.println("======ACCOUNTS NUMBER=================");//Prints GUI
            temp.setName(rs.getString(2));
            System.out.println(rs.getString("account_num"));
            System.out.println("=========BALANCE======================");//Prints GUI
            temp.setName(rs.getString(3));
            System.out.println("$" + rs.getString("balance"));
            resultList.add(temp);

            return resultList;

     }

        for (dataAccessObjTransf tm : resultList) {
            System.out.println(tm);
        }


        return resultList;
    }

    @Override
    public void addAccount(java.lang.String s, java.lang.String e, java.lang.String l, Integer z, Double b) throws SQLException, IOException {

    }


    @Override
    public List<dataAccessObj> saveCustomer(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException {


        Connection conn = ConnectionManager.getConnection();

          String sql = "INSERT INTO customers (customer_id, firstname, middlename, lastname) VALUES ( ? , ? , ? , ?)";
        //String sql = "SELECT * FROM accounts WHERE account_id = 'rodney@rev.netTX' ";
        PreparedStatement insertStatement = conn.prepareStatement(sql);
        insertStatement.getResultSet();
       insertStatement = conn.prepareStatement(sql);
        insertStatement.setObject(1, ee+s);
        insertStatement.setString(2, fn);
        insertStatement.setString(3, m);
        insertStatement.setString(4, l);
       insertStatement.executeUpdate();

        //This was for testing, but is no longer needed? Results still used below.
//       sql = "SELECT * FROM accounts WHERE account_id = ?";
//       PreparedStatement queryStatement = conn.prepareStatement(sql);
//       queryStatement.setString();



            //Insert
            // UPDATE - item already exists in table
            String updateStatement = "INSERT INTO address (address_id, address, city, state, zip) VALUES ( ? , ? , ? , ?, ?)";
            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
            preparedUpdateStatement.setString(1, ee+s);
            preparedUpdateStatement.setString(2, ad);
            preparedUpdateStatement.setString(3, c);
            preparedUpdateStatement.setString(4, s);
            preparedUpdateStatement.setString(5, java.lang.String.valueOf(z));
           preparedUpdateStatement.execute();

            updateStatement = "INSERT INTO accounts (account_id, account_num) VALUES ( ? , ? )";
            PreparedStatement preparedUpdateStatements = conn.prepareStatement(updateStatement);
            preparedUpdateStatements.setString(1, ee+z);
            preparedUpdateStatements.setString(2, z+ee+l);
//            preparedUpdateStatements.setString(3, java.lang.String.valueOf(b));

            preparedUpdateStatements.execute();

            updateStatement = "INSERT INTO junction_ac (email, password, address_id, account_id, customer_id) VALUES ( ? , ? , ? , ?, ?)";
            PreparedStatement preparedUpdateStatementss = conn.prepareStatement(updateStatement);
            preparedUpdateStatementss.setString(1, ee);
            preparedUpdateStatementss.setString(2, p);
            preparedUpdateStatementss.setString(3, ee+s);
            preparedUpdateStatementss.setString(4, ee+z);
            preparedUpdateStatementss.setString(5, ee+s);




            System.out.println("COMPLETE!");





           System.out.println("UNABLE TO LOAD DATA. CHECK THE INPUT AND TRY AGAIN");







        List<dataAccessObj> resultList = new ArrayList<>();


                preparedUpdateStatementss.execute();



        if(rs.next()) {
            dataAccessObj temp = new dataAccessObj(conn);
            System.out.println("======ACCOUNTS ID=================");//Prints GUI
            temp.setName(rs.getString(1));
            PrintView.printMyView(rs.getString(1));
            System.out.println("======ACCOUNTS NUMBER=================");//Prints GUI
            temp.setName(rs.getString(2));
            PrintView.printMyView(rs.getString(2));
            System.out.println("=========BALANCE=================");//Prints GUI
            temp.setName(rs.getString(3));
            System.out.println(rs.getString(3));
            resultList.add(temp);

        }else {

        }

            return resultList;
        }



    @Override
    public void addAccount(java.lang.String s, java.lang.String e, Double bal) throws SQLException, IOException {

    }

    @Override
    public void addAccount(String f, String ln, String n, String e, Double b) throws SQLException, IOException {


        String updateStatement =  "update accounts a\n" +
                "join junction_ac j on a.account_id = j.account_id\n" +
                "join customers c on c.customer_id = j.customer_id\n" +
                "join address ad on ad.address_id = c.customer_id \n" +
                "set balance = (balance + ? )\n" +
                "WHERE c.firstname = ? and c.lastname = ? and a.account_id = ? ;";
        PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
        preparedUpdateStatement = conn.prepareStatement(updateStatement);
        preparedUpdateStatement.setDouble(1, b);
        preparedUpdateStatement.setString(2, f);
        preparedUpdateStatement.setString(3, ln);
        preparedUpdateStatement.setString(4, n + e);


        preparedUpdateStatement.executeUpdate();

    }

    @Override
    public accMsg getItemByID(int id) throws SQLException {
        return null;
    }

    @Override
    public void getItemByKeyword(java.lang.String keyword) {

    }

    @Override
    public arrayList<dataAccessObj, java.lang.String> getMessage(arrayList<dataAccessObj, java.lang.String> tempBalance) {
        return null;
    }

    @Override
    public void getItemByID(java.lang.String customer_id) {

    }

    @Override
    public void setName(java.lang.String aDouble) {

    }

    @Override
    public void save(dataAccessObj row) throws SQLException {
        
    }

    @Override
    public void save() throws SQLException {

    }

    @Override
    public void save(String e, String s) throws SQLException {

        String sql = "SELECT * FROM accounts WHERE account_id = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.getResultSet();
        dataAccessObj temp = new dataAccessObj(conn);
        ResultSet rs = stmt.executeQuery();



        rs.next();


                System.out.println("======ACCOUNTS ID=================");//Prints GUI
        temp.setName(rs.getString(1));
        PrintView.printMyView(rs.getString("account_id"));
        System.out.println("======ACCOUNTS NUMBER=================");//Prints GUI
        temp.setName(rs.getString(2));
        System.out.println(rs.getString("account_num"));
        System.out.println("=========BALANCE=================");//Prints GUI
        temp.setName(rs.getString(3));
        System.out.println(rs.getString("balance"));



            ///add print


    }

    @Override
    public void addAccount(int to, Integer z, java.lang.String ee, java.lang.String l, java.lang.String s, Double bal) throws SQLException, IOException {

    }

    @Override
    public void deposits(int to, String ee, String s, Double bal) throws SQLException, IOException {

        Connection conn = ConnectionManager.getConnection();

        String sql = "update accounts join junction_ac  on account account_id = junction_ac account_id join customers on customer_id = junction_ac customer_id set balance = (balance + ?) WHERE account_id = ?";

        PreparedStatement insertStatement = conn.prepareStatement(sql);
        insertStatement.setObject(1, bal);
        insertStatement.setString(2, ee+s);

        insertStatement.executeUpdate();

    }

    @Override
    public void deposits(int to, Double bal) throws SQLException, IOException {

    }

    @Override
    public void updateAccount(int to, java.lang.String fn, java.lang.String ln, java.lang.String em, java.lang.String s) throws SQLException, IOException {

    }

    @Override
    public void getValueIndx(int i) {

    }

    @Override
    public void setId(int customer_id) {

    }

    @Override
    public void sql(java.lang.String address_id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public java.lang.String getMessage() {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}




