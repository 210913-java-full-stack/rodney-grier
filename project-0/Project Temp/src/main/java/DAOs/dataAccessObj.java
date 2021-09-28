package DAOs;

import interfaces.dataAccess;
import models.getMessages;

import java.sql.*;


public class dataAccessObj implements dataAccess {

        private Connection conn;
        private Integer r;

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public void dataAccObj(Connection conn) {
            this.conn = conn;
        }


        public void save(dataAccess row) throws SQLException {
            String sql = "SELECT * FROM to_do_items WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, getR());

            ResultSet rs = pstmt.executeQuery();


            if(rs.next()) {
                //UPDATE - item already exists in table
                String updateStatement = "UPDATE to_do_items SET message = ?, complete = ? WHERE id = ?";
                PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
                preparedUpdateStatement.setString(1, toString());
                preparedUpdateStatement.setBoolean(2, rs.getBoolean(2));
                preparedUpdateStatement.setInt(3, rs.getInt(3));

                preparedUpdateStatement.executeUpdate();

            } else {
                //INSERT - Item doesn't already exist in table
                String insertStatement = "INSERT INTO to_do_items (message, complete) VALUES (?, ?)";
                PreparedStatement preparedInsertStatement = conn.prepareStatement(insertStatement);
                preparedInsertStatement.setString(1, rs.getString(1));
                preparedInsertStatement.setBoolean(2, rs.getBoolean(2));

                preparedInsertStatement.executeUpdate();

            }



        }








    @Override
    public getMessages getItemByID(int id) {
        return null;
    }

    @Override
    public void pull(models.getMessages row) {

    }


    @Override
    public void deleteByID(int id) {

    }

    @Override
    public void addAccount(String s, String e, Double bal) throws SQLException {

    }

    @Override
    public void save(getMessages row) throws SQLException {
        String sql = "SELECT * FROM accounts id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, row.getId());

        ResultSet rs = pstmt.executeQuery();
    }

    public dataAccessObj(Connection conn) {
        this.conn = conn;
    }


}

        /*
        String fname = "my";
        String mname = "test";
        String lname = "Name";
        String sql = "INSERT INTO customers (firstname, middlename, lastname) VALUES (\"" + fname + "\", \"" + mname + "\", \"" +lname +"\");";
        PreparedStatement pstmt = conn.prepareStatement(sql);


        ResultSet rs = pstmt.executeQuery();


        if(rs.next()) {
            //UPDATE - item already exists in table
            String updateStatement = "UPDATE customers SET firstname = ?, WHERE id = ?";
            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
            preparedUpdateStatement.setString(1, row.getMessage());
            preparedUpdateStatement.setBoolean(2, row.isComplete());
            preparedUpdateStatement.setInt(3, row.getId());

            preparedUpdateStatement.executeUpdate();

        } else {
            //INSERT - Item doesn't already exist in table
            String insertStatement = "INSERT INTO customers (firstname, middlename, lastname) VALUES (\"" + fname + "\", \"" + mname + "\", \"" +lname +"\");";
            PreparedStatement preparedInsertStatement = conn.prepareStatement(insertStatement);

            preparedInsertStatement.executeUpdate();

        }
            */




