package com.example.server.util;

import org.apache.juli.logging.Log;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import static com.example.server.util.DatabaseUtil.getConnection;
import static org.junit.Assert.*;

public class DatabaseUtilTest {

    @Test
    public void getConnectionTest() {
        //given

        //when

        //then
        assertNotNull(getConnection());
    }

    @Test
    public void ReleaseDataBaseTest() {
        //given
        Statement stmt = null;

        //when
        try {
            stmt = getConnection().createStatement();
            Logger.getGlobal().info("create stmt success");
        } catch (SQLException e) {
            Logger.getGlobal().warning("create stmt failed");
        }

        //then
        assertTrue(DatabaseUtil.ReleaseDataBase(getConnection(), stmt));
    }

//    @Test
//    public void commitTest() {
//        //given
//
//        //when
//
//        //then
//        DatabaseUtil.commit(getConnection());
//    }

//    @Test
//    public void rollbackTest() {
//        //given
//
//        //when
//
//        //then
//        DatabaseUtil.rollback(getConnection());
//    }

}