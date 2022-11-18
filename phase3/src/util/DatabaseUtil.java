package util;

import java.sql.*;

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
}
