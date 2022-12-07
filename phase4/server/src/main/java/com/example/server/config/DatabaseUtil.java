package com.example.server.config;

import java.sql.*;
import java.util.logging.Logger;

public class DatabaseUtil {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER_ID = "project";
    public static final String USER_PASSWD = "1234";


    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(URL, USER_ID, USER_PASSWD);
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

    public static void commit(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection conn) {
        try {
            if(conn != null && !conn.isClosed())
                conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
