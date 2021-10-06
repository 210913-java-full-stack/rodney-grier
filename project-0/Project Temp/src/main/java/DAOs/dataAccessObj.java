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
import java.util.Scanner;


public class dataAccessObj implements dataAccessObjIndx {


    private Object String;
    private ResultSet rs;

    public dataAccessObj(Connection conn) {
        this.conn = conn;
    }


    String sql = new String();
    private Connection conn;


    @Override
    public void addAccount(int to, Integer ci, java.lang.String ee, Double bal) throws SQLException, IOException {

    }

    @Override
    public void trnsfrWthd(int to, java.lang.String fn, java.lang.String ln, java.lang.String em, java.lang.String em2, Double bal) throws SQLException, IOException {

    }

    @Override
    public void trnsfrWthd(java.lang.String ee, java.lang.String s, Double bal) throws SQLException, IOException {

    }

    @Override
    public void trnsfrWthd(String l, String fn, String ee, String s, Double bal) throws SQLException, IOException {
        String updateStatement = "INSERT savings (account_s, balance) VALUES (?, -?)";
        PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
        preparedUpdateStatement.setString(1, l + fn);
        preparedUpdateStatement.setDouble(2, bal);
        updateStatement = "INSERT savings (account_s, balance) VALUES (?, ?)";
        preparedUpdateStatement = conn.prepareStatement(updateStatement);
        preparedUpdateStatement.setString(1, ee + s);
        preparedUpdateStatement.setDouble(2, bal);


        preparedUpdateStatement.executeUpdate();
    }

    @Override
    public List<dataAccessObj> save(java.lang.String fn, java.lang.String m, java.lang.String l, java.lang.String ad, java.lang.String c, java.lang.String s, java.lang.String ee, java.lang.String p, Integer z, Double b) throws SQLException, badUserInput, IOException {
        return null;
    }


    @Override
    public List<dataAccessObj> savePr(java.lang.String fn, java.lang.String m, java.lang.String l, java.lang.String ad, java.lang.String c, java.lang.String s, java.lang.String ee, Integer z) throws SQLException, badUserInput, IOException {
        return null;
    }

    @Override
    public void addAccount(int to, java.lang.String fn, java.lang.String ln, Double bal) throws SQLException, IOException {

    }

    @Override
    public void addAccount(int to, java.lang.String fn, java.lang.String ln, java.lang.String em, Double bal) throws SQLException, IOException {

    }
    @Override
    public void savePr(Integer choice, String fn, String m, String l, String ad, String c, String s, String ee, Integer z) throws SQLException, badUserInput, IOException {


        Scanner sc = new Scanner(System.in);
        Connection conn = ConnectionManager.getConnection();


        String name = java.lang.String.valueOf(sc.nextInt());
        switch (name) {

            case "1":
                sql = "UPDATE customers set lastname = ? WHERE firstname = ?;";

                PreparedStatement queryStatement;
                queryStatement = conn.prepareStatement(sql);
                queryStatement.setString(1, fn);
                queryStatement.setString(2, l);

                queryStatement.executeQuery();
                queryStatement.getResultSet();


                break;


            case "2":
                sql = "UPDATE customers set firstname = ? WHERE lastname = ?;";

                PreparedStatement fnqueryStatement;
                fnqueryStatement = conn.prepareStatement(sql);
                fnqueryStatement.setString(1, fn);
                fnqueryStatement.setString(2, l);
                fnqueryStatement.executeQuery();
                fnqueryStatement.getResultSet();


                break;
            case "3":
                sql = "UPDATE customers set address = ? WHERE lastname = ?;";

                PreparedStatement asqueryStatement;
                asqueryStatement = conn.prepareStatement(sql);
                asqueryStatement.setString(1, fn);
                asqueryStatement.setString(2, l);
                asqueryStatement.executeQuery();
                asqueryStatement.getResultSet();
                String zsql = "UPDATE customers set zip = ? WHERE lastname = ?;";

                PreparedStatement zasqueryStatement;
                zasqueryStatement = conn.prepareStatement(zsql);
                zasqueryStatement.setString(1, fn);
                zasqueryStatement.setString(2, l);
                zasqueryStatement.executeQuery();
                zasqueryStatement.getResultSet();
                String stsql = "UPDATE customers set state = ? WHERE lastname = ?;";

                PreparedStatement stasqueryStatement;
                stasqueryStatement = conn.prepareStatement(stsql);
                stasqueryStatement.setString(1, fn);
                stasqueryStatement.setString(2, l);
                stasqueryStatement.executeQuery();
                stasqueryStatement.getResultSet();


                break;
        }

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

       PreparedStatement queryStatement;

            sql = "SELECT * FROM accounts a  \n" +
                    "WHERE account_id LIKE ?;";
        queryStatement = conn.prepareStatement(sql);
        queryStatement.setString(1, z+ee+l);
        queryStatement.getResultSet();
        ResultSet rs = queryStatement.executeQuery();


        List<dataAccessObj> resultList = new ArrayList<>();

        while (rs.next()) {
            dataAccessObj temp = new dataAccessObj(conn);
            System.out.println("===============ACCOUNT NUMBER==============");
            System.out.println("================="+z+ee+l+ "===============");//Prints GUI
            System.out.println("======INTEREST ACCOUNT BALANCE=============");

            temp.setName(rs.getString(1));
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
    public List<dataAccessObj> savePrintS(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException {


        Connection conn = ConnectionManager.getConnection();

        // String sql = "INSERT INTO customers (customer_id, firstname, middlename, lastname) VALUES ( ? , ? , ? , ?)";
//        String sql = "SELECT * FROM accounts WHERE account_id = ? ";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.getResultSet();
//        PreparedStatement insertStatement = conn.prepareStatement(sql);
//        insertStatement.setString(1, ee+s);



        //This was for testing, but is no longer needed? Results still used below.
        String lql = "SELECT SUM(balance) as balance FROM savings WHERE account_s = ? ";

        PreparedStatement queryStatement1 = conn.prepareStatement(lql);
        queryStatement1.setString(1, ee+s);
        queryStatement1.getResultSet();

        ResultSet ls = queryStatement1.executeQuery();

        List<dataAccessObj>resultList = new ArrayList();

        while (ls.next()) {
            dataAccessObj temp = new dataAccessObj(conn);
            System.out.println("=============ACCOUNT ID==================");//Prints GUI
            System.out.println(ee+s);

            System.out.println("=========CHECKING BALANCE================");//Prints GUI
            temp.setName(ls.getString(1));
            System.out.println("$" + ls.getString("balance"));

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
    public void addAccount(java.lang.String f, java.lang.String ln, java.lang.String n, java.lang.String e, Double b) throws SQLException, IOException {

    }

    @Override
    public void addNewaccount(java.lang.String f, java.lang.String ln, Integer z, java.lang.String e, Double b) throws SQLException, IOException {

    }


    public List<dataAccessObj> pwdUpdate(String username) throws SQLException {

        PreparedStatement queryStatement = conn.prepareStatement(sql);
        sql = "SELECT password FROM junction_ac  \n" +
                "WHERE customer_id = ?;";
        queryStatement = conn.prepareStatement(sql);
        queryStatement.setString(1, username);
        queryStatement.getResultSet();
        rs = queryStatement.executeQuery();

        List<dataAccessObj> resultList = new ArrayList<>();

        while (rs.next()) {
            dataAccessObj temp = new dataAccessObj(conn);
            System.out.println("======INTEREST ACCOUNT BALANCE=============");//Prints GUI
            temp.setName(rs.getString(1));
            System.out.println("$" + rs.getString("password"));


            resultList.add(temp);

            return resultList;

        }

        for (dataAccessObjTransf tm : resultList) {
            System.out.println(tm);
        }


        return resultList;

    }




    @Override
    public List<dataAccessObj> saveCustomer(String fn, String m, String l, String ad, String c, String s, String ee, String p, Integer z, Double b) throws SQLException, badUserInput, IOException {


        Connection conn = ConnectionManager.getConnection();

            String sql = "INSERT INTO customers (customer_id, firstname, middlename, lastname) VALUES ( ? , ? , ? , ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, ee+s);
            stmt.setString(2, fn);
            stmt.setString(3, m);
            stmt.setString(4, l);
            stmt.getResultSet();


            //Insert
            // UPDATE - item already exists in table
            String lql = "INSERT INTO address (address_id, address, city, state, zip) VALUES ( ? , ? , ? , ?, ?)";
        PreparedStatement updateStatement = conn.prepareStatement(lql);
            updateStatement.setString(1, ee+s);
            updateStatement.setString(2, ad);
            updateStatement.setString(3, c);
            updateStatement.setString(4, s);
            updateStatement.setString(5, java.lang.String.valueOf(z));
            updateStatement.getResultSet();



            String jql = "INSERT INTO accounts (account_id, account_num, balance ) VALUES ( ? , ? , ? )";
            PreparedStatement updateStatement1 = conn.prepareStatement(jql);
        updateStatement1.setString(1, z+ee+l);
        updateStatement1.setString(2, ee+z);
        updateStatement1.setString(3, java.lang.String.valueOf(b));


        updateStatement1.getResultSet();


                  String nsql = "INSERT INTO junction_ac (email, password, address_id, account_id, customer_id) VALUES ( ? , ? , ? , ?, ?)";

        PreparedStatement updateStatement2 = conn.prepareStatement(nsql);
                    updateStatement2.setObject(1, ee);
                    updateStatement2.setObject(2, p);
                    updateStatement2.setObject(3, ee+s);
                    updateStatement2.setObject(4, z+ee+l);
                    updateStatement2.setObject(5, ee+s);



                   updateStatement.getResultSet();

            System.out.println("COMPLETE!");





           System.out.println("UNABLE TO LOAD DATA PLEASE ADD A CHECKING ACCOUNT");







      List<dataAccessObj> resultList = new ArrayList<>();
//
//

        ResultSet rs = stmt.executeQuery();
        updateStatement.executeQuery();
        updateStatement1.executeQuery();
        updateStatement2.executeQuery();




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
    public void addNewaccount(String f, String ln, Integer z, String e, String s, Double b) throws SQLException, IOException {


        String updateStatement =  "INSERT savings (account_s, balance) VALUES (?, ?)";
        PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
        preparedUpdateStatement.setString(1, e+s);
        preparedUpdateStatement.setDouble(2, b);



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
    public void save(java.lang.String ee, java.lang.String s) throws SQLException {

    }

    @Override
    public void save(String e, String ln, Integer z) throws SQLException {


        String sql = "update accounts a join junction_ac j on a.account_id = j.account_id " +
                "join customers c on c.customer_id = j.customer_id " +
                "set balance = (balance * 1.3) WHERE account_num = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e+z);
        stmt.getResultSet();
        dataAccessObj temp = new dataAccessObj(conn);
        ResultSet rs = stmt.executeQuery();










            ///add print


    }

    @Override
    public void addAccount(int to, Integer z, java.lang.String ee, java.lang.String l, java.lang.String s, Double bal) throws SQLException, IOException {

    }

    @Override
    public void deposits(int to, java.lang.String fn, java.lang.String ln, Double bal) throws SQLException, IOException {

    }

    @Override
    public void deposits(int to, java.lang.String ee, Integer z, Double bal) throws SQLException, IOException {

    }

    @Override
    public void deposits(int to, java.lang.String ee, java.lang.String l, Integer z, Double bal) throws SQLException, IOException {

    }

    @Override
    public void deposits(String s, String ee, String l, Integer z, Double bal) throws SQLException, IOException {

        String updateStatement =  "INSERT savings (account_s, balance) VALUES (?, ?)";
        PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
        preparedUpdateStatement.setString(1, ee+s);
        preparedUpdateStatement.setDouble(2, bal);



        preparedUpdateStatement.executeUpdate();

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

    public List<dataAccessObj> savePrintLog(String em, String ln,String st, Integer z) throws SQLException, IOException {

        Connection conn = ConnectionManager.getConnection();


        sql = "SELECT * FROM accounts a  \n" +
                "WHERE account_id LIKE ?;";
        PreparedStatement queryStatement = conn.prepareStatement(sql);
        queryStatement.setNString(1, z+em+ln);
        queryStatement.getResultSet();
        rs = queryStatement.executeQuery();

        List<dataAccessObj> resultList = new ArrayList<>();





        for (dataAccessObjTransf tm : resultList) {
            System.out.println(tm);
        }


        return resultList;



    }
}




