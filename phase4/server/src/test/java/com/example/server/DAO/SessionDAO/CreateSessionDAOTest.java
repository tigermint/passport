package com.example.server.DAO.SessionDAO;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CreateSessionDAOTest {

    @Test
    public void joinSessionDAO() throws ParseException {
        CreateSessionDAO createSessionDAO = new CreateSessionDAO();
        Date date = new Date();
        int result = createSessionDAO.joinSessionDAO(5, "2020-01-01");
        assertEquals(1, result);
    }

}