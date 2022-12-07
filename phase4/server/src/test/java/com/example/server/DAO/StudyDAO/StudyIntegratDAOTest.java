package com.example.server.DAO.StudyDAO;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudyIntegratDAOTest {

    @Test
    public void isParticipate() {

        StudyIntegratDAO studyIntegratDAO = new StudyIntegratDAO();
        boolean participate = studyIntegratDAO.isParticipate("1", "1");
        Assertions.assertThat(participate).isEqualTo(true);
    }
}