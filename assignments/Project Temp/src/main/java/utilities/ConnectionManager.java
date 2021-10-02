package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static Connection conn; //sets connection name to conn

    private ConnectionManager() {

    }

    /*
  This is a static method for returning a connection
  */
    public static Connection getConnection() throws SQLException, IOException {
        if(conn == null) {
            Properties props = new Properties();
            FileReader connectionProperties = new FileReader("src/main/resources/conn.properties");
            props.load(connectionProperties);

            //This is for connection to mariaDb
            //"jdbc:mariadb://hostname:port/databaseName?user=username&password=password"
            String connString = "jdbc:mariadb://" +
                    props.getProperty("hostname") + ":" +
                    props.getProperty("port") + "/" +
                    props.getProperty("databaseName") + "?user=" +
                    props.getProperty("user") + "&password=" +
                    props.getProperty("password");


            conn = DriverManager.getConnection(connString);
        }
        return conn;
    }

}
