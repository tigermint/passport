package util;

import java.sql.*;
import java.util.logging.Logger;

public class DatabaseUtil {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER_UNIVERSITY = "university";
    public static final String USER_PASSWD = "comp322";


    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USER_UNIVERSITY, USER_PASSWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean ReleaseDataBase(Connection conn, Statement stmt) {
        Logger Log = Logger.getGlobal();

        try {
            // Close the Statement object.
            stmt.close();
            Log.info("close stmt success");
            // Close the Connection object.
            conn.close();
            Log.info("close conn success");
            return true;

        } catch (SQLException e) {
            Log.warning("close conn or stmt failed");
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
